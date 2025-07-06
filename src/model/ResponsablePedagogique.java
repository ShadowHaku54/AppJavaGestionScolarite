package model;

public class ResponsablePedagogique extends Utilisateur {
    public ResponsablePedagogique(String nom, String prenom, String password) {
        super(nom, prenom, password);
    }

    @Override
    public RolePersonne thisRole() {
        return RolePersonne.RP;
    }
}
