import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

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

    //Loob png tüüpi mustvalge pildi
    public void PiltMustValge(String failinimi) {

        int width = mustvalgeMaatriks[0].length;
        int height = mustvalgeMaatriks.length;
        try {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // uus 'tühi' pilt
            for (int i = 0; i < mustvalgeMaatriks.length; i++) {
                for (int j = 0; j < mustvalgeMaatriks[i].length; j++) { // käib maatriksi läbi
                    int a = mustvalgeMaatriks[i][j];
                    Color newColor = new Color(a, a, a);
                    image.setRGB(j, i, newColor.getRGB()); // määrab pildi pikslitele maatriksist saadud värvi väärtused
                }
            }
            File output = new File(failinimi); // loob faili
            ImageIO.write(image, "png", output);
        } catch (Exception e) {

        }
    }
    //Loob png tüüpi värvilise pildi
    public void PiltVarviline(String failinimi) {
        // kui maatriksid pole samade mõõtmetega siis lõpetab töö
        if (RMaatriks.length!= GMaatriks.length || GMaatriks.length != BMaatriks.length ||
                RMaatriks[0].length!= GMaatriks[0].length || GMaatriks[0].length != BMaatriks[0].length) {
            System.out.println("RGB maatriksid pole samade mõõtmetega");
            return;
        }
        int width = RMaatriks[0].length;
        int height = RMaatriks.length;
        try {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // uus 'tühi' pilt
            for (int i = 0; i < RMaatriks.length; i++) {
                for (int j = 0; j < RMaatriks[i].length; j++) { // käib maatriksi läbi
                    int r = RMaatriks[i][j];
                    int g = GMaatriks[i][j];
                    int b = BMaatriks[i][j];
                    Color newColor = new Color(r, g, b);
                    image.setRGB(j, i, newColor.getRGB());  // määrab pildi pikslitele maatriksist saadud värvi väärtused
                }
            }
            File output = new File(failinimi);  // loob faili
            ImageIO.write(image, "png", output);
        } catch(Exception e)
        {
        }
    }


    // värvitakse üle ainult üks piksel. Mustvalge jaoks
    public void piksel(int värv, int x, int y) {
        mustvalgeMaatriks[x][y] = värv;

    }

    // värvitakse üle ainult üks piksel. Värvilise jaoks
    public void piksel(int r, int g, int b, int x, int y) {
        RMaatriks[x][y] = r;
        GMaatriks[x][y] = g;
        BMaatriks[x][y] = b;
    }
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




