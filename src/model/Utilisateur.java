package model;

import java.util.Objects;

public abstract class Utilisateur extends Personne {
    protected final String emailOfSchool;
    protected String password;

    public Utilisateur(String nom, String prenom, String password) {
        super(nom, prenom);
        this.password = password;
        this.emailOfSchool = String.format(
                "%s-%s-%d@ism.%s.sn",
                prenom.toLowerCase(), nom.toLowerCase(),
                idPersonne, thisRole().name().toLowerCase()
        );
    }

    public String getEmailOfSchool() {
        return emailOfSchool;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", schoolEmail='" + emailOfSchool + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(emailOfSchool, that.emailOfSchool);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(emailOfSchool);
    }
}
