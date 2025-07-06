package model;

public class Professeur extends Personne {
    static int nbProfesseur;
    private final int idProfesseur;
    private GradeProfesseur grade;

    public Professeur(String nom, String prenom, GradeProfesseur grade) {
        super(nom, prenom);
        this.idProfesseur = ++nbProfesseur;
        this.grade = grade;
    }

    public int getIdProfesseur() {
        return idProfesseur;
    }

    public GradeProfesseur getGrade() {
        return grade;
    }

    public void setGrade(GradeProfesseur grade) {
        this.grade = grade;
    }

    @Override
    public RolePersonne thisRole() {
        return RolePersonne.PROF;
    }

    @Override
    public String toString() {
        return "{" +
                "idProfesseur=" + idProfesseur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", grade=" + grade +
                '}';
    }

}
