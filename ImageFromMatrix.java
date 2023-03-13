import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


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
            ImageIO.write(image, "jpg", output);
        } catch(Exception e)
        {
        }
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
                {255,255,255,255,255,255,255,255,255},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,60,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {255,1,1,0,0,0,1,1,255}};
        int[][] GMaatriks = {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {255,255,255,255,255,255,255,255,255},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,100,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {255,1,1,0,0,0,1,1,255}};
        int[][] BMaatriks = {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {255,255,255,255,255,255,255,255,255},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,130,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {255,1,1,0,0,0,1,1,255}};
        PiltVarviline("Varviline.png", RMaatriks,GMaatriks,BMaatriks);
    }

}

