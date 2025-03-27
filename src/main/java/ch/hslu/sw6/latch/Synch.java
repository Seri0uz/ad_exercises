package ch.hslu.sw6.latch;

public interface Synch {

    /**
     * Eintritt in einen geschützten Bereich erlangen, falls kein Zutritt möglich ist warten.
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     */
    public void acquire() throws InterruptedException;

    /**
     * Freigabe des geschützten Bereiches beim Austritt.
     */
    public void release();
}


