package model;

import java.time.LocalDate;
import java.util.Objects;

public class Inscription {
    private static int nbInscription;
    private final int idInscription;
    private final LocalDate dateInscription;
    private final AnneeScolaire anneeScolaire;
    private final Etudiant etudiant;
    private final Classe classe;
    private StatutInscription statut;
    private final TypeInscription type;

    public Inscription(Etudiant etudiant, Classe classe, TypeInscription type) {
        this.idInscription = ++nbInscription;
        this.dateInscription = LocalDate.now();
        this.anneeScolaire = CurrentAnneeScolaire.getCurrent();
        this.etudiant = etudiant;
        this.classe = classe;
        this.statut = StatutInscription.VALIDEE;
        this.type = type;
    }

    public int getIdInscription() {
        return idInscription;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Classe getClasse() {
        return classe;
    }

    public StatutInscription getStatut() {
        return statut;
    }

    public void setStatut(StatutInscription statut) {
        this.statut = statut;
    }

    public TypeInscription getType() {
        return type;
    }


    @Override
    public String toString() {
        return "{" +
                "idInscription=" + idInscription +
                ", dateInscription=" + dateInscription +
                ", anneeScolaire=" + anneeScolaire +
                ", etudiant=" + etudiant +
                ", classe=" + classe +
                ", statut=" + statut +
                ", type=" + type +
                '}';
    }

    // rêgle d'aquivalence: 2 inscription ne peuvent pas avoir le même étudiant dans la même année scolaire
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inscription that = (Inscription) o;
        return Objects.equals(anneeScolaire, that.anneeScolaire) && Objects.equals(etudiant, that.etudiant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anneeScolaire, etudiant);
    }
}
