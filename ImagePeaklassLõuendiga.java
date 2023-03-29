import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImagePeaklassLõuendiga {
    public static void main(String[] args) throws Exception {
        List<Varvid> värvid = loeFailist("colors.txt");  // LOOME LISTI, KASUTADES MEETODIT loeFailist

        // KIRJELDUS
        System.out.println("MAATRIKS-MAALER");
        Thread.sleep(2000); // teeb pausi
        System.out.println("Maatriks-Maaler on joonistamisprogramm, millega on võimalik lihtsa pildi joonistada.");
        Thread.sleep(4000); // teeb pausi
        System.out.println("Sinu kasutada on " + värvid.size() + " värvi ja hetkel on programmi sisse ehitatud 6 erinevat tegeust.");
        Thread.sleep(4000); // teeb pausi
        System.out.println("Võimalik on pilti pöörata teistpidi kui ka pöörata 90 kraadi nii paremale kui ka vasakule.");
        Thread.sleep(5000); // teeb pausi
        System.out.println("Lisaks saad muuta pildi tausta (soovitatav on teha seda alguses, kuna see värvib kõik üle) ja joonistada ristküliku.");
        Thread.sleep(5000); // teeb pausi
        System.out.println("Kui aga tahad rohkem kontrolli, võid olla nagu tõeline kunstnik ja piksli haaval joonistada pildi valmis.");
        Thread.sleep(5000); // teeb pausi

        Scanner scanner = new Scanner(System.in); // küsime pildi laiuse ja kõrguse
        System.out.println("Sisesta pildi laius");
        int PildiLaius = Integer.parseInt(scanner.nextLine());

        System.out.println("Sisesta pildi kõrgus");
        int PildiKõrgus = Integer.parseInt(scanner.nextLine());

        int[][][] pildiMaatriks = ImageFromMatrix.loo_maatriksid(PildiLaius, PildiKõrgus, 0, 0, 0);

        System.out.println("Kui tahad programmi lõpetada, siis ära sisesta midagi.");
        Thread.sleep(4000); // teeb pausi



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
                System.out.println("Sisesta üks taustapildi värv (punane, kollane, sinine, roheline, roosa, lilla, oranz, valge, must | vali suvaline värv [Random])");
                String valitudVärv = scanner.nextLine();

                Varvid värv;

                // KUI VALITI SUVALINE
                if (valitudVärv.equals("Random")) {
                    int suvalineArv =  (int) Math.random()*(värvid.size() - 1) + 0; //leiame suvalise värvi, kasutades math.randomit
                    värv = värvid.get(suvalineArv);
                }
                else { // KUI VALITI VÄRV
                    värv = leiaLististOigeVarv(valitudVärv, värvid);}
                pildiMaatriks = värv.looTaustaPilt(PildiLaius, PildiKõrgus);
            } // taustapilt if- lause


            //ÜHE PIKSLI VÄRVIMINE
            else if (tegevus.equals("P")) {
                System.out.println("Sisesta piksli värv (punane, kollane, sinine, roheline, roosa, lilla, oranz, valge, must | vali suvaline värv [Random]))");
                String valitudVärv = scanner.nextLine();

                Varvid värv;
                // KUI VALITI SUVALINE
                if (valitudVärv.equals("Random")) {
                    int suvalineArv =  (int) Math.random()*(värvid.size() - 1) + 0; //leiame suvalise värvi, kasutades math.randomit
                    värv = värvid.get(suvalineArv);
                }
                else { // KUI VALITI VÄRV
                    värv = leiaLististOigeVarv(valitudVärv, värvid);}

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
                System.out.println("Sisesta ristküliku värv (punane, kollane, sinine, roheline, roosa, lilla, oranz, valge, must | vali suvaline värv [Random]))");
                String valitudVärv = scanner.nextLine();

                Varvid värv;
                // KUI VALITI SUVALINE
                if (valitudVärv.equals("Random")) {
                    int suvalineArv =  (int) Math.random()*(värvid.size() - 1) + 0; //leiame suvalise värvi, kasutades math.randomit
                    värv = värvid.get(suvalineArv);
                }
                else { // KUI VALITI VÄRV
                    värv = leiaLististOigeVarv(valitudVärv, värvid);}

                System.out.println("Sisesta piksli x-alguskoordinaat");
                int algus_X = Integer.parseInt(scanner.nextLine());

                System.out.println("Sisesta piksli y-alguskoordinaat");
                int algus_Y = Integer.parseInt(scanner.nextLine());

                System.out.println("Sisesta piksli x-lõppkoordinaat");
                int lõpp_X = Integer.parseInt(scanner.nextLine());

                System.out.println("Sisesta piksli y-lõppkoordinaat");
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

