import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImagePeaklass  {
    public static void main(String[] args) throws Exception {
        List<Varvid> list = loeFailist("colors.txt");  // LOOME LISTI, KASUTADES MEETODIT loeFailist


        //KÜSIME INPUTTI KASUTAJA KÄEST, ET SAADA TEADA, MILLIST VÄRVI TA TAHAB
        Scanner object2 = new Scanner(System.in); // loob objekti värvi jaoks
        System.out.println("Sisesta üks värv (punane, kollane, sinine, roheline, roosa, lilla, oranz, valge, must)");
        String värv = object2.nextLine(); // loeb selle rea, mida kirjutasid muutuja väärtusena
        System.out.println("Valitud värv on: " + värv); // väljastab selle

        //KÄIME LISTI LÄBI JA LEIAME ÕIGE VÄRVI
        for (Varvid värvListis: list) {
            if (värvListis.getColor().equals(värv)) {
                System.out.println(värvListis);
                värvListis.looPilt();} //värvib pildi valitud värvi
        }
    }

    //KASUTAB värvid.txt FAILI JA LOOB LISTI
    public static List<Varvid> loeFailist(String failinimi) throws Exception {
        List<Varvid> list = new ArrayList<>();
        File file = new File(failinimi);

        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            while(scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                String[] jupid = rida.split(";");

                String color = jupid[0];
                int r = Integer.parseInt(jupid[1]);
                int g = Integer.parseInt(jupid[2]);
                int b = Integer.parseInt(jupid[3]);

                list.add(new Varvid(color, r, g, b));
            }
        }
        return list;
    }
}
