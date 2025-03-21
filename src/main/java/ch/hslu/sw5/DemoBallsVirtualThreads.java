package ch.hslu.sw5;

public class DemoBallsVirtualThreads {

    public static void main(final String[] args) throws InterruptedException {
        Canvas canvas = Canvas.getCanvas();
        Ball ball = new Ball();
            Thread.startVirtualThread(ball);
            Thread.sleep(1000);
        }
}

