public class Lõuend {
    private int[][] mustvalgeMaatriks;
    private int[][] RMaatriks;
    private int[][] GMaatriks;
    private int[][] BMaatriks;

    public Lõuend(int[][] mustvalgeMaatriks) { // Lõuendi konstruktor kui antud on ainult üks maatriks
        this.mustvalgeMaatriks = mustvalgeMaatriks;
    }

    public Lõuend(int[][] RMaatriks, int[][] GMaatriks, int[][] BMaatriks) { // Lõuendi konstruktor kui antud on 3 maatriksit
        this.RMaatriks = RMaatriks;
        this.GMaatriks = GMaatriks;
        this.BMaatriks = BMaatriks;
    }



    // värvitakse üle ainult üks piksel. Mustvalge jaoks
    public void piksel(int värv, int x, int y) {
        mustvalgeMaatriks[x][y] = värv;

    }

    // värvitakse üle ainult üks piksel. Värvilise jaoks
    // kasutasin r;g;b ja mitte Varvid klassi sest sellega oli kergem saada programmi tööle.
    // kasutaja mugavuse jaoks peaks ümber tegema nii et ta võtab Varvid tüüpi objekti kolme int'i asemel
    // vaata alumist
    public void piksel(int r, int g, int b, int x, int y) {
        RMaatriks[x][y] = r;
        GMaatriks[x][y] = g;
        BMaatriks[x][y] = b;
    }
/*
    public void piksel(Varvid värv, int x, int y) { // tekkis idee teha nii... kuid r, g ja b on privaatsed. Saaks luua get meetodid Varvid klassi. On sul mõni parem idee?
        RMaatriks[x][y] = värv.r;
        GMaatriks[x][y] = värv.g;
        BMaatriks[x][y] = värv.b;
    }
*/

    // värvitakse ristkülik. Mustvalge jaoks
    public void ristkülik(int värv, int algus_x, int algus_y, int lõpp_x, int lõpp_y) {
        for (int y = algus_y; y <= lõpp_y ; y++) {
            for (int x = algus_x; x <= lõpp_x; x++) {
                mustvalgeMaatriks[y][x] = värv;
            }
        }
    }
    // värvitakse ristkülik. Värvilise jaoks
    public void ristkülik(int r, int g, int b, int algus_x, int algus_y, int lõpp_x, int lõpp_y) {
        for (int y = algus_y; y <= lõpp_y ; y++) {
            for (int x = algus_x; x <= lõpp_x; x++) {
                RMaatriks[y][x] = r;
                GMaatriks[y][x] = g;
                BMaatriks[y][x] = b;
            }
        }
    }

}




