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

        int[][][] maatriks = {{{}}};
        //KÄIME LISTI LÄBI JA LEIAME ÕIGE VÄRVI
        for (Varvid värvListis: list) {
            if (värvListis.getColor().equals(värv)) {
                System.out.println(värvListis);
                maatriks = värvListis.looMaatriksidVahendaja(); // luuakse pildi maatriks, mida hakatakse maalimisel kasutama.
                värvListis.looPilt();} //värvib pildi valitud värvi
        }

        // PRAEGU TÖÖTAB AINULT PIKSLI VÄRVIMINE VÄRVILISE PILDI PUHUL!!!
        System.out.println("kas soovid värvida ühe piksli [P] või ristküliku [R]");
        String sisend = object2.nextLine();
        while (!sisend.equals("")) { // kui ei tahta kumbagi, siis saab protsessi lõpetada vajutades ENTERit ehk mitte midagi sisestades.
            if (sisend.equals("P")) { // kui tahetakse pikslit muuta

                System.out.println("Kirjuta formaadis:  r,g,b;x;y");
                sisend = object2.nextLine();
                String[] jupid = sisend.split(";");

                // piksli värv
                String[] värviJupid = jupid[0].split(","); // teeb sisestatud värvi, mis koosneb kolmekohalisest String[]-st, int[] tüüpi.
                int[] värviJärjend = new int[3];
                for (int i = 0; i < värviJupid.length; i++) {
                    värviJärjend[i] = Integer.parseInt(värviJupid[i]);
                }
                // värvib piksli. Kasutatakse varem tehtud pildi maatriksit, äsja tehtud värvide järjendit, mis ütleb mis värvi piksel saab olema
                // ja viimased kaks välja on piksli koordinaadid
                Joonistamine.piksel(maatriks, värviJärjend,Integer.parseInt(jupid[1]),Integer.parseInt(jupid[2]));
                ImageFromMatrix.PiltVarviline("Varviline.png", maatriks[0], maatriks[1], maatriks[2]); // update'ib pilti
            }


            sisend = object2.nextLine();
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
