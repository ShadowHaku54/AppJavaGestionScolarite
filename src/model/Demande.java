package model;

import java.time.LocalDate;
import java.util.Objects;

public class Demande {
    private static int nbDemande;
    private final int idDemande;
    private final LocalDate dateDemande;
    private final AnneeScolaire anneeScolaire;
    private final Etudiant etudiant;
    private final Inscription inscription;
    private TypeDemande type;
    private String motif;
    private StatutDemande statut;

    public Demande(Etudiant etudiant, Inscription inscription, TypeDemande type, String motif) {
        this.idDemande = ++nbDemande;
        this.dateDemande = LocalDate.now();
        this.anneeScolaire = CurrentAnneeScolaire.getCurrent();
        this.etudiant = etudiant;
        this.inscription = inscription;
        this.type = type;
        this.motif = motif;
        this.statut = StatutDemande.EN_ATTENTE;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public TypeDemande getType() {
        return type;
    }

    public void setType(TypeDemande type) {
        this.type = type;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public StatutDemande getStatut() {
        return statut;
    }

    public void setStatut(StatutDemande statut) {
        this.statut = statut;
    }


    @Override
    public String toString() {
        return "{" +
                "idDemande=" + idDemande +
                ", dateDemande=" + dateDemande +
                ", anneeScolaire=" + anneeScolaire +
                ", etudiant=" + etudiant +
                ", inscription=" + inscription +
                ", type=" + type +
                ", motif='" + motif + '\'' +
                ", statut=" + statut +
                '}';
    }

    // rêgle d'équivalence entre deux objets: aucune
    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idDemande);
    }
}
