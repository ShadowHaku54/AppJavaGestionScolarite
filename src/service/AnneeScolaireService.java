package service;

import java.util.ArrayList;

import model.AnneeScolaire;
import model.CurrentAnneeScolaire;

public class AnneeScolaireService {
    private static final ArrayList<AnneeScolaire> annees = new ArrayList<>();

    private AnneeScolaireService() {
    }

    public static boolean exists(AnneeScolaire as) {
        return annees.contains(as);
    }

    public static boolean defineNewYear(AnneeScolaire as) {
        if (as != null && !exists(as)) {
            annees.add(as);
            CurrentAnneeScolaire.setCurrent(as);
            return true;
        }
        return false;
    }

    public static ArrayList<AnneeScolaire> getAllYears() {
        return annees;
    }

    public static AnneeScolaire getById(int id) {
        for (AnneeScolaire as : annees) {
            if (as.getIdAnneeScolaire() == id) {
                return as;
            }
        }
        return null;
    }
}
