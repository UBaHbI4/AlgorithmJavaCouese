package softing.UBaH4ukDev.HomeWorks.HomeWork7;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork7

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.24
 v1.0
 */
public class Vertex {
    private char label;
    private boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
