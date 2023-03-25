
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

    public void looPilt() {
        int[][][] rgb = ImageFromMatrix.loo_maatriksid(r, g, b); // loome rgb kolmemõõtmelise järjendi, kasutades meie teist klassi

        int[][] R = rgb[0]; // loome RGB maatriksid, kasutased seda järjendit
        int[][] G = rgb[1];
        int[][] B = rgb[2];

        ImageFromMatrix.PiltVarviline("Varviline.png", R,G,B); //loob pildi
    }

    public int[][][] looMaatriksidVahendaja() { // see on vajalik, et oleks võimalik kasutada loo_maatriksid meetodit Varvid objektiga
        return ImageFromMatrix.loo_maatriksid(r, g, b);
    }

    @Override
    public String toString() {
        return "värv: " + color +
                ", r: " + r +
                ", g: " + g +
                ", b: " + b;
    }
}
