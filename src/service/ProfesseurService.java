package service;

import java.util.ArrayList;
import model.Professeur;

public class ProfesseurService {
    private static final ArrayList<Professeur> profs = new ArrayList<>();
    private static int nexId;

    private ProfesseurService() {}

    public static boolean exists(Professeur prof) {
        // return profs.contains(prof);
        return false; // aucune correspndance possible (rêgle d'équivalence)
    }

    public static boolean addProfesseur(Professeur prof) {
        if (prof != null && !exists(prof)) {
            profs.add(prof);
            return true;
        }
        return false;
    }

    public static Professeur getById(int id) {
        for (Professeur p : profs) {
            if (p.getIdProfesseur() == id) {
                return p;
            }
        }
        return null;
    }

    public static ArrayList<Professeur> getAllProfesseurs() {
        return profs;
    }
}
