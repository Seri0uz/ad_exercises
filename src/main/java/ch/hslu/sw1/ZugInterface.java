package ch.hslu.sw1;

public interface ZugInterface {

    Wagen getNextWagen();

    void setNextWagen(Wagen wagen);

    static int calculateTotalSpace(Wagen wagen) {
        int totalSpace = 0;
        while (wagen != null) {
            totalSpace += wagen.getSpace();
            wagen = wagen.getNextWagen();
        }

        return totalSpace;
    }
}
