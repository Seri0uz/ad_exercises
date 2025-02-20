package ch.hslu.sw1;

import java.util.Objects;

public class Wagen implements ZugInterface {
    private String name;
    private int space;
    private Wagen nextWagen;

    public Wagen(String name, int space) {
        this.name = name;
        this.space = space;
    }

    public Wagen(String name, int space, Wagen nextWagen) {
        this.name = name;
        this.space = space;
        this.nextWagen = nextWagen;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSpace() {
        return space;
    }

    @Override
    public Wagen getNextWagen() {
        return nextWagen;
    }

    @Override
    public void setNextWagen(Wagen nextWagen) {
        this.nextWagen = nextWagen;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object)
            return true;
        return (object instanceof Wagen wagen)
                && Objects.equals(name, wagen.name)
                && this.space == wagen.space;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, space);
    }
}
