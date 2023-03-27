import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImagePeaklassLõuendiga {
    public static void main(String[] args) throws Exception {
        List<Varvid> list = loeFailist("colors.txt");  // LOOME LISTI, KASUTADES MEETODIT loeFailist


        //KÜSIME INPUTTI KASUTAJA KÄEST, ET SAADA TEADA, MILLIST VÄRVI TA TAHAB
        Scanner object2 = new Scanner(System.in); // loob objekti värvi jaoks
        System.out.println("Sisesta üks värv (punane, kollane, sinine, roheline, roosa, lilla, oranz, valge, must)");
        String värv = object2.nextLine(); // loeb selle rea, mida kirjutasid muutuja väärtusena
        System.out.println("Valitud värv on: " + värv); // väljastab selle

        int[][][] LõuendiMaatriks = {{{}}}; // tühi maatriks selle jaoks et teda hiljem täita. Vajalik sest if statementi sees ei saa luua objekti.
        Lõuend maatriks = new Lõuend( new int[0][0] , new int[0][0], new int[0][0]);

        //KÄIME LISTI LÄBI JA LEIAME ÕIGE VÄRVI
        for (Varvid värvListis: list) {
            if (värvListis.getColor().equals(värv)) {
                System.out.println(värvListis);

                LõuendiMaatriks = värvListis.looMaatriksidVahendaja(); // luuakse pildi maatriks, mida hakatakse maalimisel kasutama.
                maatriks = new Lõuend(LõuendiMaatriks[0],LõuendiMaatriks[1],LõuendiMaatriks[2]);

                värvListis.looPilt();} //värvib pildi valitud värvi
        }

        System.out.println("kas soovid värvida ühe piksli [P] või ristküliku [R]");
        String sisend = object2.nextLine();
        while (!sisend.equals("")) { // kui ei tahta kumbagi, siis saab protsessi lõpetada vajutades ENTERit ehk mitte midagi sisestades.
            if (sisend.equals("P")) { // kui tahetakse pikslit muuta

                System.out.println("Kirjuta formaadis:  r;g;b;x;y");
                sisend = object2.nextLine();
                String[] jupid = sisend.split(";");


                // värvib piksli. jupid[0 kuni 2] on värvi väärtused. jupid[3 ja 4] on piksli koordinaadid
                // ja viimased kaks välja on piksli koordinaadid
                maatriks.piksel(Integer.parseInt(jupid[0]),Integer.parseInt(jupid[1]), Integer.parseInt(jupid[2]),Integer.parseInt(jupid[3]), Integer.parseInt(jupid[4]));
                ImageFromMatrix.PiltVarviline("Varviline.png", LõuendiMaatriks[0], LõuendiMaatriks[1], LõuendiMaatriks[2]); // update'ib pilti


            } else if (sisend.equals("R")) { //int r, int g, int b, int algus_x, int algus_y, int lõpp_x, int lõpp_y
                System.out.println("Kirjuta formaadis:  r;g;b;algusX;algusY;lõppX;lõppY");
                sisend = object2.nextLine();
                String[] jupid = sisend.split(";");


                // maalib lõuendile ristküliku. jupid[0 kuni 2] on värvi väärtused. jupid[3 ja 4] on ristküliku alguskoordinaadid,jupid[5 ja 6] on ristküliku lõppkoordinaadid
                maatriks.ristkülik(Integer.parseInt(jupid[0]),Integer.parseInt(jupid[1]), Integer.parseInt(jupid[2]),Integer.parseInt(jupid[3]), Integer.parseInt(jupid[4]),Integer.parseInt(jupid[5]),Integer.parseInt(jupid[6]));
                ImageFromMatrix.PiltVarviline("Varviline.png", LõuendiMaatriks[0], LõuendiMaatriks[1], LõuendiMaatriks[2]); // update'ib pilti

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

// copy-paste ristküliku jaoks 0;0;0;2;3;4;5 (Mugavuse jaoks. kommentaar mille pärast ära kustutada!)
