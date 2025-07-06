package model;

public class AttacheClasse extends Utilisateur {
    public AttacheClasse(String nom, String prenom, String password) {
        super(nom, prenom, password);
    }

    @Override
    public RolePersonne thisRole() {
        return RolePersonne.AC;
    }
}
