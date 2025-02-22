package ch.hslu.sw1;

public class Color {


    public static void colorArea(int x,int y) {
        System.out.println(x+","+y);
        if (x<10 && x>0 && y<10 && y>0) {
            colorArea(x+1, y);
            colorArea(x, y+1);
            colorArea(x-1, y);
            colorArea(x, y-1);
        }
    }
    public static void main(String[] args) {
        colorArea(4,3);
    }
}
