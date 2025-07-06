package model;

import java.util.Objects;

public class Affectation {
    private static int nbAffectation;
    private final int idAffectation;
    private final Professeur professeur;
    private final Classe classe;

    public Affectation(Professeur professeur, Classe classe) {
        this.idAffectation = ++nbAffectation;
        this.professeur = professeur;
        this.classe = classe;
    }

    public int getIdAffectation() {
        return idAffectation;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public Classe getClasse() {
        return classe;
    }


    @Override
    public String toString() {
        return "Affectation{" +
                "idAffectation=" + idAffectation +
                ", professeur=" + professeur +
                ", classe=" + classe +
                '}';
    }

    // deux affectations sont équivalents si ils ont le même prof et la même classe
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Affectation that = (Affectation) o;
        return Objects.equals(professeur, that.professeur) && Objects.equals(classe, that.classe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professeur, classe);
    }
}
