public class Lõuend {
    private int[][] RMaatriks;
    private int[][] GMaatriks;
    private int[][] BMaatriks;


    public Lõuend(int[][] RMaatriks, int[][] GMaatriks, int[][] BMaatriks) { // Lõuendi konstruktor kui antud on 3 maatriksit
        this.RMaatriks = RMaatriks;
        this.GMaatriks = GMaatriks;
        this.BMaatriks = BMaatriks;
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




