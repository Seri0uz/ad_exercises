package ch.hslu.ad.exercise.n1.balls;

public class DemoBallsVirtualThreads {

    public static void main(final String[] args) throws InterruptedException {
        Canvas canvas = Canvas.getCanvas();
        Ball ball = new Ball();

        while(canvas.) {
            Thread.startVirtualThread(ball);
            Thread.sleep(1000);
        }
    }

}
