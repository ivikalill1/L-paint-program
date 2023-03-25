public class Joonistamine {
    // värvitakse üle ainult üks piksel. Mustvalge jaoks
    public static void piksel(int[][] maatriks,int värv, int x, int y) {
        maatriks[x][y] = värv;

    }

    // värvitakse üle ainult üks piksel. Värvilise jaoks
    public static void piksel(int[][][] maatriks, int[] värv, int x, int y) {
        maatriks[0][x][y] = värv[0];
        maatriks[1][x][y] = värv[1];
        maatriks[2][x][y] = värv[2];
    }
    // värvitakse ristkülik. Mustvalge jaoks
    public void ristkülik(int[][] maatriks, int värv, int algus_x, int algus_y, int lõpp_x, int lõpp_y) {
        for (int y = algus_y; y <= lõpp_y ; y++) {
            for (int x = algus_x; x < lõpp_y; x++) {
                maatriks[y][x] = värv;
            }
        }
    }
    // värvitakse ristkülik. Värvilise jaoks
    public void ristkülik(int[][][] maatriks, int[] värv, int algus_x, int algus_y, int lõpp_x, int lõpp_y) {
        for (int y = algus_y; y <= lõpp_y ; y++) {
            for (int x = algus_x; x < lõpp_y; x++) {
                maatriks[0][y][x] = värv[0];
                maatriks[1][y][x] = värv[1];
                maatriks[2][y][x] = värv[2];
            }
        }
    }
}
