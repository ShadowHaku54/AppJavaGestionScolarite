package model;

import java.util.Objects;

public class Dispense {
    private static int nbDispense;
    private final int idDispense;
    private final Professeur professeur;
    private final Module module;

    public Dispense(Professeur professeur, Module module) {
        this.idDispense = ++nbDispense;
        this.professeur = professeur;
        this.module = module;
    }

    public int getIdDispense() {
        return idDispense;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public Module getModule() {
        return module;
    }


    @Override
    public String toString() {
        return "{" +
                "idDispense=" + idDispense +
                ", professeur=" + professeur +
                ", module=" + module +
                '}';
    }

    // rêgle d'aquivalence: Un professeur ne peux pas dispenser le même module 2 fois
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dispense dispense = (Dispense) o;
        return Objects.equals(professeur, dispense.professeur) && Objects.equals(module, dispense.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professeur, module);
    }
}
