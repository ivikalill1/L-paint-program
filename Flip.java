import java.util.Arrays;

public class Flip {
    public static int[][][] pooraTeistPidi(int[][][] pildiMaatriks) {
        // meil vaja teada saada, mitu korda me peame maatriksis arve ümber vahetama. Seda peame tegema selle maatriksi keskele
        int vahetusteArv = Math.round(pildiMaatriks[0][0].length / 2);

        for (int i = 0; i < 3; i++) { // läbime kõik kolm RGB maatriksit selles kolmemõõtmelises järjendis
            for (int rida = 0; rida < pildiMaatriks[0].length; rida++) {
                for (int veerg = 0; veerg < vahetusteArv; veerg++) { // nii mitu korda läbime seda tsüklit, kuni jõuame maatriksi keskele
                    int viimaneElement = pildiMaatriks[i][rida][pildiMaatriks[0][0].length-1-veerg]; // rea viimane element
                    int esimeneElement = pildiMaatriks[i][rida][veerg]; // rea esimene element

                    pildiMaatriks[i][rida][veerg] = viimaneElement; // muudame maatriksi sees esimese elemendi viimase elemendi väärtuseks
                    pildiMaatriks[i][rida][pildiMaatriks[0][0].length-1-veerg] = esimeneElement; // ning viimase elemendi esimese elemendi väärtuseks
                }
            }
        }
        return pildiMaatriks;
    }

    public static int[][][] poora90kraadiparemale(int[][][] pildiMaatriks) { // teeme seda nii, et loome uue maatriksi, mida hakkame täitma
        int[][][] tulemusMaatriks = new int[3][pildiMaatriks[0][0].length][pildiMaatriks[0].length]; // juhuslikult, kui tegemist pole ruutmaatriksiga, loome uue maatriksi pikkused vastupidiselt antud maatriksiga

        for (int i = 0; i < 3; i++) { // läbime kõik kolm RGB maatriksit selles kolmemõõtmelises järjendis
            for (int rida = 0; rida < pildiMaatriks[0].length; rida++) {
                for (int veerg = 0; veerg < pildiMaatriks[0][0].length; veerg++) {
                    tulemusMaatriks[i][veerg][tulemusMaatriks[0][0].length - rida-1] = pildiMaatriks[i][rida][veerg];
                }
            }
        }
        return tulemusMaatriks;
    }


    //TESTIMINE, VÕIB ÄRA KUSTUTADA.
    public static void main(String[] args) { // TESTIMISEKS
        int[][][] maatriks1 = {{{1,2,3}, {4,5,6}, {7,8,9}}, {{1,2,3}, {4,5,6}, {7,8,9}}, {{1,2,3}, {4,5,6}, {7,8,9}}
        };
        int[][][] maatriks2 = {{{1,2,3,4,5,6,7,8,9,10,11,12,13}, {1,2,3,4,5,6,7,8,9,10,11,12,13}, {1,2,3,4,5,6,7,8,9,10,11,12,13}}, {{1,2,3,4,5,6,7,8,9,10,11,12,13}, {1,2,3,4,5,6,7,8,9,10,11,12,13}, {1,2,3,4,5,6,7,8,9,10,11,12,13}}, {{1,2,3,4,5,6,7,8,9,10,11,12,13}, {1,2,3,4,5,6,7,8,9,10,11,12,13}, {1,2,3,4,5,6,7,8,9,10,11,12,13}}
        };
        int[][][] maatriks = {{{1,2,3}, {4,5,6}}, {{1,2,3}, {4,5,6}}, {{1,2,3}, {4,5,6}}
        };
        System.out.println(Arrays.deepToString(pooraTeistPidi(maatriks1)));
        System.out.println(Arrays.deepToString(poora90kraadiparemale(maatriks)));
    }
}
