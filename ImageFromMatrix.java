import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.Scanner;

// To do : Create Canvas class and method
// Create matrix method



public class ImageFromMatrix {


    //Consider class and methods predefined. The following will be within a method
    public static void PiltMustValge(String failinimi, int[][] Maatriks) {
        int width = 10;
        int height = 10;
        try {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < Maatriks.length; i++) {
                for (int j = 0; j < Maatriks[i].length; j++) {
                    int a = Maatriks[i][j];
                    Color newColor = new Color(a, a, a);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }
            File output = new File(failinimi);
            ImageIO.write(image, "jpg", output);
        } catch(Exception e)
        {
        }
    }
    public static void PiltVarviline(String failinimi, int[][] RMaatriks, int[][] GMaatriks,int[][] BMaatriks) {
        int width = 10;
        int height = 10;
        try {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < RMaatriks.length; i++) {
                for (int j = 0; j < RMaatriks[i].length; j++) {
                    int r = RMaatriks[i][j];
                    int g = GMaatriks[i][j];
                    int b = BMaatriks[i][j];
                    Color newColor = new Color(r, g, b);
                    image.setRGB(j, i, newColor.getRGB());
                }
            }
            File output = new File(failinimi);
            ImageIO.write(image, "png", output);
        } catch(Exception e)
        {
        }
    }

    public static int[][][] loo_maatriksid(String värv, int r, int g, int b) {
        int[][][] järjend = new int[3][10][10];// loome kolme-mõõtmelise järjendi, milles saab olla 3 kahemõõtmelist maatriksit (RGB)
        int[] värvid = new int[]{r, g, b};

        for (int i = 0; i < järjend.length; i++) { // tsükkel käib kolm korda
            int väärtus = värvid[i]; // võtame värvide maatriksist õige numbri ja paneme selle õigesse maatriksisse
            for (int j = 0; j < järjend[0].length; j++) {
                for (int k = 0; k < järjend[0].length; k++) {
                    järjend[i][j][k] = väärtus;
                }
            }
        }
        return järjend;
    }

    public static void main(String[] args) {
        int[][] MustValgeMaatriks = {
                {255,1,1,0,0,0,1,1,255},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {255,1,1,0,0,0,1,1,255}};
        PiltMustValge("Mustvalge.jpg", MustValgeMaatriks);


        int[][] RMaatriks = {
                {34,34,34,34,34,243,243,243,243,243},
                {34,34,34,34,34,243,243,243,243,243},
                {34,34,34,34,34,243,243,243,243,243},
                {34,34,34,34,34,243,243,243,243,243},
                {34,34,34,34,34,243,243,243,243,243},
                {243,243,243,243,243,243,243,243,243,243},
                {243,243,243,243,243,243,243,243,243,243},
                {243,243,243,243,243,243,243,243,243,243},
                {243,243,243,243,243,243,243,243,243,243},
                {243,243,243,243,243,243,243,243,243,243}};
        int[][] GMaatriks = {
                {41,41,41,41,41,222,222,222,222,222},
                {41,41,41,41,41,222,222,222,222,222},
                {41,41,41,41,41,222,222,222,222,222},
                {41,41,41,41,41,222,222,222,222,222},
                {41,41,41,41,41,222,222,222,222,222},
                {222,222,222,222,222,222,222,222,222,222},
                {222,222,222,222,222,222,222,222,222,222},
                {222,222,222,222,222,222,222,222,222,222},
                {222,222,222,222,222,222,222,222,222,222},
                {222,222,222,222,222,222,222,222,222,222}};
        int[][] BMaatriks = {
                {243,243,243,243,243,34,34,34,34,34},
                {243,243,243,243,243,34,34,34,34,34},
                {243,243,243,243,243,34,34,34,34,34},
                {243,243,243,243,243,34,34,34,34,34},
                {243,243,243,243,243,34,34,34,34,34},
                {34,34,34,34,34,34,34,34,34,34},
                {34,34,34,34,34,34,34,34,34,34},
                {34,34,34,34,34,34,34,34,34,34},
                {34,34,34,34,34,34,34,34,34,34},
                {34,34,34,34,34,34,34,34,34,34}};
        PiltVarviline("Varviline.png", RMaatriks,GMaatriks,BMaatriks);


        // SIIN OLI KÕIK, MIDA MA OLIN TESTIMAS ENNE KLASSIDE LOOMIST. ENAM EI TÖÖTA, AGA JÄTSIN HETKEL SELLE SISSE IGAKS JUHUKS
        /** Scanner object2 = new Scanner(System.in); // loob objekti värvi jaoks
        System.out.println("Sisesta üks värv (punane, kollane, sinine)");
        String värv = object2.nextLine(); // loeb selle rea, mida kirjutasid muutuja väärtusena
        System.out.println("Valitud värv on: " + värv); // väljastab selle

        int[][][] rgb = loo_maatriksid(värv);
        int[][] R = rgb[0]; // loome maatriksid
        int[][] G = rgb[1];
        int[][] B = rgb[2];

        PiltVarviline("Varviline.png", R,G,B); **/

    }

}

