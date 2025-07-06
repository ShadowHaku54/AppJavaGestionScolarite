package model;

import java.util.Objects;
import java.time.LocalDate;

public class AnneeScolaire {
    private static int nbAnneeScolaire;
    private final int idAnneeScolaire;
    private final int debut;
    private final int fin;
    private final LocalDate dateDefinition;

    public AnneeScolaire(int debut) {
        this.idAnneeScolaire = ++nbAnneeScolaire;
        this.debut = debut;
        this.fin = debut + 1;
        this.dateDefinition = LocalDate.now();
    }

    public int getIdAnneeScolaire() {
        return idAnneeScolaire;
    }

    public int getDebut() {
        return debut;
    }

    public int getFin() {
        return fin;
    }

    public LocalDate getDateDefinition() {
        return dateDefinition;
    }

    public String deuxDernieres() {
        return String.format("%02d%02d", debut % 100, fin % 100);
    }

    @Override
    public String toString() {
        return "[" + debut + "-" + fin + "]";
    }

    // 2 anée scolaire sont équivalent si ils ont le même début.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AnneeScolaire that = (AnneeScolaire) o;
        return debut == that.debut;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(debut);
    }
}
