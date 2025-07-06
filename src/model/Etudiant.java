package model;

import java.util.Objects;

public class Etudiant extends Utilisateur {
    private static int nbEtudiant;
    private final String matricule;
    private String personalEmail;
    private String adresse;
    private Sexe sexe;

    public Etudiant(String nom, String prenom, String password, String personalEmail, String adresse, Sexe sexe) {
        super(nom, prenom, password);
        this.matricule = "ISM-2425/DK-" + (++nbEtudiant);
        this.personalEmail = personalEmail;
        this.adresse = adresse;
        this.sexe = sexe;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String email) {
        this.personalEmail = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    @Override
    public RolePersonne thisRole() {
        return RolePersonne.ETU;
    }

    @Override
    public String toString() {
        return "{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", emailOfSchool='" + emailOfSchool + '\'' +
                ", personalEmail='" + personalEmail + '\'' +
                ", adresse='" + adresse + '\'' +
                ", sexe=" + sexe +
                '}';
    }


    // rêgle d'aquivalence: 2 étudiants doivent pas avoir le même mail personnel
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(personalEmail, etudiant.personalEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personalEmail);
    }
}
