import java.util.Arrays;

public class Flip {
    //PILDI PÖÖRAMINE TEISTPIDI. VÕTAB VASTU int[][][] TÜÜPI PILDIMAATRIKSI
    public int[][][] pooraTeistPidi(int[][][] pildiMaatriks) {
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
    //PILDI PÖÖRAMINE 90 KRAADI PAREMALE. VÕTAB VASTU int[][][] TÜÜPI PILDIMAATRIKSI
    public int[][][] poora90kraadiparemale(int[][][] pildiMaatriks) { // teeme seda nii, et loome uue maatriksi, mida hakkame täitma
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

    //PILDI PÖÖRAMINE 90 KRAADI VASAKULE. VÕTAB VASTU int[][][] TÜÜPI PILDIMAATRIKSI
    public int[][][] poora90kraadivasakule(int[][][] pildiMaatriks) { // teeme seda nii, et loome uue maatriksi, mida hakkame täitma
        int[][][] tulemusMaatriks = new int[3][pildiMaatriks[0][0].length][pildiMaatriks[0].length]; // juhuslikult, kui tegemist pole ruutmaatriksiga, loome uue maatriksi pikkused vastupidiselt antud maatriksiga

        for (int i = 0; i < 3; i++) { // läbime kõik kolm RGB maatriksit selles kolmemõõtmelises järjendis
            for (int rida = 0; rida < pildiMaatriks[0].length; rida++) {
                for (int veerg = 0; veerg < pildiMaatriks[0][0].length; veerg++) {
                    tulemusMaatriks[i][tulemusMaatriks[0].length - veerg-1][rida] = pildiMaatriks[i][rida][veerg];
                }
            }
        }
        return tulemusMaatriks;
    }
}
