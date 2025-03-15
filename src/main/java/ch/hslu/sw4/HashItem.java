package ch.hslu.sw4;

public final class HashItem {
    private final Element element;
    private boolean isGraveStone;

    public HashItem(Element element) {
        this.element = element;
        this.isGraveStone = false;
    }
    public Element getElement() {
        return element;
    }

    public boolean isGraveStone() {
        return isGraveStone;
    }

    public void setIsGraveStone(boolean graveStone) {
        this.isGraveStone = graveStone;
    }

    @Override
    public String toString() {
        if (isGraveStone) {
            return "[✝]";
        }
        return "HashItem{" + "element=" + element + '}';
    }

}
