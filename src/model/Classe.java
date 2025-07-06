package model;

import java.util.Objects;

public class Classe {
    private static int nbClasse;
    private final int idClasse;
    private String libelle;
    private Niveau niveau;
    private Filiere filiere;
    private Periode periodeInscription;
    private final AnneeScolaire anneeScolaire;

    public Classe(String libelle, Niveau niveau, Filiere filiere, Periode periodeInscription) {
        this.idClasse = ++nbClasse;
        this.libelle = libelle;
        this.niveau = niveau;
        this.filiere = filiere;
        this.periodeInscription = periodeInscription;
        this.anneeScolaire = CurrentAnneeScolaire.getCurrent();
    }

    public int getIdClasse() {
        return idClasse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Periode getPeriodeInscription() {
        return periodeInscription;
    }

    public void setPeriodeInscription(Periode periode) {
        this.periodeInscription = periode;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }


    @Override
    public String toString() {
        return "Classe{" +
                "idClasse=" + idClasse +
                ", libelle='" + libelle + '\'' +
                ", niveau=" + niveau +
                ", filiere=" + filiere +
                ", periodeInscription=" + periodeInscription +
                ", anneeScolaire=" + anneeScolaire +
                '}';
    }

    // rêgle d'équivalence: 2 classes ne doivent pas avoir le même libelle à la même année scolaire
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return Objects.equals(libelle, classe.libelle) && Objects.equals(anneeScolaire, classe.anneeScolaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle, anneeScolaire);
    }
}
