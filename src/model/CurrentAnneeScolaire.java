package model;

public final class CurrentAnneeScolaire {
    private static AnneeScolaire current;

    private CurrentAnneeScolaire() {}

    public static AnneeScolaire getCurrent() {
        return current;
    }

    public static void setCurrent(AnneeScolaire current) {
        CurrentAnneeScolaire.current = current;
    }
}
