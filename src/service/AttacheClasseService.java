package service;

import model.AttacheClasse;
import model.Utilisateur;

import java.util.ArrayList;

public class AttacheClasseService {
    private static final ArrayList<AttacheClasse> attacheClasses = new ArrayList<>();

    private AttacheClasseService() {
    }



    public static boolean exists(AttacheClasse ac) {
        return false;
    }

    public static boolean addAttacheClasse(AttacheClasse ac) {
        if (!UtilisateurService.addUser(ac) && ac != null && !exists(ac)) {
            attacheClasses.add(ac);
            return true;
        }
        return false;
    }

    public static AttacheClasse getAttacheClasse(Utilisateur user) {
        for (AttacheClasse ac : attacheClasses) {
            if (ac.getIdPersonne() == user.getIdPersonne()) {
                return ac;
            }
        }
        return null;
    }
}
