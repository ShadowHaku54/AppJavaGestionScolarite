package model;

public abstract class Personne {
    private static int nbPersonne;
    protected final int idPersonne;
    protected String nom;
    protected String prenom;

    public Personne(String nom, String prenom) {
        this.idPersonne = ++nbPersonne;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public abstract RolePersonne thisRole();


    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
