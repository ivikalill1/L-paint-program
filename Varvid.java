
public class Varvid {
    private String color;
    private int r;
    private int g;
    private int b;

    public Varvid(String color, int r, int g, int b) {
        this.color = color;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public String getColor() { //vajalik selleks, et hiljem võrrelda kasutaja poolt antud värvi
        return color;
    }
    public int getR() {return r;}
    public int getG() {return g;}
    public int getB() {return b;}

    public int[][][] looTaustaPilt(int laius, int pikkus) {
        int[][][] rgb = ImageFromMatrix.loo_maatriksid(laius, pikkus, r, g, b); // loome rgb kolmemõõtmelise järjendi, kasutades meie teist klassi

        int[][] R = rgb[0]; // loome RGB maatriksid, kasutased seda järjendit
        int[][] G = rgb[1];
        int[][] B = rgb[2];

        ImageFromMatrix.PiltVarviline("Varviline.png", R,G,B); //loob pildi
        return rgb;
    }

    @Override
    public String toString() {
        return "värv: " + color +
                ", r: " + r +
                ", g: " + g +
                ", b: " + b;
    }
}
