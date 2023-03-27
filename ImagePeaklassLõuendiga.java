import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImagePeaklassLõuendiga {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in); // küsime pildi laiuse ja kõrguse
        System.out.println("Sisesta pildi laius");
        int PildiLaius = Integer.parseInt(scanner.nextLine());

        System.out.println("Sisesta pildi kõrgus");
        int PildiKõrgus = Integer.parseInt(scanner.nextLine());

        List<Varvid> värvid = loeFailist("colors.txt");  // LOOME LISTI, KASUTADES MEETODIT loeFailist
        int[][][] pildiMaatriks = ImageFromMatrix.loo_maatriksid(PildiLaius, PildiKõrgus, 0, 0, 0);


        // MAIN LOOP
        while (true) {

            //TEGEVUSE KÜSIMINE
            System.out.println("Vali üks tegevustest, mida teha: Tausta värvimine [Taustapilt] | Ühe piksli värvimine [P] | Ristküliku värvimine [R]) |  \nPildi pööramine teistpidi [Flip] | Pildi pööramine 90 kraadi paremale [PPööre] | Pildi pööramine 90 kraadi vasakule [VPööre]"); // \n alustab uuelt realt, sest tekst ei mahu ekraanile ühes reas ära
            String tegevus = scanner.nextLine(); // loeb selle rea, mida kirjutasid muutuja väärtusena

            //TÜHI EHK PROGRAMMI KINNI PANEK
            if (tegevus.equals(""))
                break;


            //TAUSTAPILT
            else if (tegevus.equals("Taustapilt")) {
                System.out.println("Sisesta üks taustapildi värv (punane, kollane, sinine, roheline, roosa, lilla, oranz, valge, must)");
                String valitudVärv = scanner.nextLine();

                Varvid värv = leiaLististOigeVarv(valitudVärv, värvid);
                pildiMaatriks = värv.looTaustaPilt(PildiLaius, PildiKõrgus);
            } // taustapilt if- lause


            //ÜHE PIKSLI VÄRVIMINE
            else if (tegevus.equals("P")) {
                System.out.println("Sisesta piksli värv (punane, kollane, sinine, roheline, roosa, lilla, oranz, valge, must)");
                String valitudVärv = scanner.nextLine();
                Varvid värv = leiaLististOigeVarv(valitudVärv, värvid);

                System.out.println("Sisesta piksli x-koordinaat");
                int X = Integer.parseInt(scanner.nextLine());

                System.out.println("Sisesta piksli y-koordinaat");
                int Y = Integer.parseInt(scanner.nextLine());

                //kohe alguses on loodud maatriks väärtustega 0,0,0, mida saame ka Lõuendis kasutada. Juhul, kui kuskil teises kohas on pildiMaatriksit muudetud, siis muudatused ei lähe kaduma
                Lõuend lõuendiMaatriks = new Lõuend(pildiMaatriks[0], pildiMaatriks[1], pildiMaatriks[2]);
                lõuendiMaatriks.piksel(värv.getR(), värv.getG(), värv.getB(), X, Y);
                ImageFromMatrix.PiltVarviline("Varviline.png", pildiMaatriks[0], pildiMaatriks[1], pildiMaatriks[2]);
            } //ühe piklsi if- lause


            //RISTKÜLIKU VÄRVIMINE
            else if (tegevus.equals("R")) {
                System.out.println("Sisesta ristküliku värv (punane, kollane, sinine, roheline, roosa, lilla, oranz, valge, must)");
                String valitudVärv = scanner.nextLine();
                Varvid värv = leiaLististOigeVarv(valitudVärv, värvid);

                System.out.println("Sisesta piksli x-alguskoordinaat");
                int algus_X = Integer.parseInt(scanner.nextLine());

                System.out.println("Sisesta piksli y-alguskoordinaat");
                int algus_Y = Integer.parseInt(scanner.nextLine());

                System.out.println("Sisesta piksli x-alguskoordinaat");
                int lõpp_X = Integer.parseInt(scanner.nextLine());

                System.out.println("Sisesta piksli y-alguskoordinaat");
                int lõpp_Y = Integer.parseInt(scanner.nextLine());

                //kohe alguses on loodud maatriks väärtustega 0,0,0, mida saame ka Lõuendis kasutada. Juhul, kui kuskil teises kohas on pildiMaatriksit muudetud, siis muudatused ei lähe kaduma
                Lõuend lõuendiMaatriks = new Lõuend(pildiMaatriks[0], pildiMaatriks[1], pildiMaatriks[2]);
                lõuendiMaatriks.ristkülik(värv.getR(), värv.getG(), värv.getB(), algus_X, algus_Y, lõpp_X, lõpp_Y);
                ImageFromMatrix.PiltVarviline("Varviline.png", pildiMaatriks[0], pildiMaatriks[1], pildiMaatriks[2]);
            } //ristküliku if- lause


            //PÖÖRAME TEISTPIDI
            else if (tegevus.equals("Flip")) {
                Flip flip = new Flip();
                pildiMaatriks = flip.pooraTeistPidi(pildiMaatriks);
                ImageFromMatrix.PiltVarviline("Varviline.png", pildiMaatriks[0], pildiMaatriks[1], pildiMaatriks[2]);
            } //pöörame teistpidi if-lause


            //PÖÖRE 90 KRAADI PAREMALE
            else if (tegevus.equals("PPööre")) {
                Flip flip = new Flip();
                pildiMaatriks = flip.poora90kraadiparemale(pildiMaatriks);
                ImageFromMatrix.PiltVarviline("Varviline.png", pildiMaatriks[0], pildiMaatriks[1], pildiMaatriks[2]);
            } // pööre 90 kraadi paremale if-lause


            //PÖÖRE 90 KRAADI VASAKULE
            else if (tegevus.equals("VPööre")) {
                Flip flip = new Flip();
                pildiMaatriks = flip.poora90kraadivasakule(pildiMaatriks);
                ImageFromMatrix.PiltVarviline("Varviline.png", pildiMaatriks[0], pildiMaatriks[1], pildiMaatriks[2]);
            } // pööre 90 kraadi vasakule if-lause


            else
                System.out.println("Sisestasid vist midagi valesti");


        } // while-main loop

    }// PEAKLASS

        /**
        //KÜSIME INPUTTI KASUTAJA KÄEST, ET SAADA TEADA, MILLIST VÄRVI TA TAHAB
        int[][][] LõuendiMaatriks = {{{}}}; // tühi maatriks selle jaoks et teda hiljem täita. Vajalik sest if statementi sees ei saa luua objekti.
        Lõuend maatriks = new Lõuend( new int[0][0] , new int[0][0], new int[0][0]);

        //KÄIME LISTI LÄBI JA LEIAME ÕIGE VÄRVI
        for (Varvid värvListis: list) {
            if (värvListis.getColor().equals(värv)) {
                System.out.println(värvListis);

                LõuendiMaatriks = värvListis.looMaatriksidVahendaja(); // luuakse pildi maatriks, mida hakatakse maalimisel kasutama.
                maatriks = new Lõuend(LõuendiMaatriks[0],LõuendiMaatriks[1],LõuendiMaatriks[2]);

                värvListis.looTaustaPilt();} //värvib pildi valitud värvi
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
    } **/

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

    // LEIAB VÄRVIDE LISTIST ÕIGE VÄRVI JA VÄLJASTAB SELLE, MIS ON KLASSI VARVID TÜÜPI
    public static Varvid leiaLististOigeVarv(String valitudVärv, List<Varvid> list) {
        for (Varvid värvListis: list) {
            if (värvListis.getColor().equals(valitudVärv)) {
                System.out.println(värvListis);
                return värvListis;
            }
        }
        System.out.println("Ei leidnud sellist värvi nagu soovisite.");
        return null;
    }
}

// copy-paste ristküliku jaoks 0;0;0;2;3;4;5 (Mugavuse jaoks. kommentaar mille pärast ära kustutada!)
