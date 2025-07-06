package model;

import java.util.Objects;

public class Module {
    private static int nbModule;
    private final int idModule;
    private String nom;
    private int nbHeure;

    public Module(String nom, int nbHeure) {
        this.idModule = ++nbModule;
        this.nom = nom;
        this.nbHeure = nbHeure;
    }

    public int getIdModule() {
        return idModule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbHeure() {
        return nbHeure;
    }

    public void setNbHeure(int nbHeure) {
        this.nbHeure = nbHeure;
    }

    @Override
    public String toString() {
        return nom + " (" + nbHeure + "h)";
    }

    // rêgle d'equivalence: Deux modules doivent pas avoir le même nom
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(nom, module.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nom);
    }
}
