package ch.hslu.sw5;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import static ch.hslu.sw5.Ball.colourList;

public class DemoBallsVirtualThreads implements MouseListener {

    private Canvas canvas = Canvas.getCanvas();

    public static final int MIN_DIAMETER = 20;
    public static final int MAX_DIAMETER = 50;

    private static Random random = new Random();

    private int xPos;
    private int yPos;

    public DemoBallsVirtualThreads() {
        canvas.getFrame().addMouseListener(this); // Attach the listener to the JFrame
    }

    public static void main(final String[] args) throws InterruptedException {
        DemoBallsVirtualThreads demoballs = new DemoBallsVirtualThreads();
    }


    public static int randomRangeInteger(int min, int max){
        if(random == null){
            random = new Random();
        }
        return random.nextInt(min+max)+min;
    }

    public static String randomColourString(){
        return colourList[randomRangeInteger(0,colourList.length)];
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Thread.startVirtualThread(new Ball(randomRangeInteger(MIN_DIAMETER,MAX_DIAMETER),e.getX(),e.getY(),randomColourString()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

