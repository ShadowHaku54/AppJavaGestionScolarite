package service;

import java.util.ArrayList;

import model.Classe;
import model.AnneeScolaire;
import model.CurrentAnneeScolaire;

public class ClasseService {
    private static final ArrayList<Classe> classes = new ArrayList<>();

    private ClasseService() {
    }

    public static boolean exists(Classe classe) {
        return classes.contains(classe);
    }

    public static boolean addClasse(Classe classe) {
        if (classe != null && !exists(classe)) {
            classes.add(classe);
            return true;
        }
        return false;
    }

    public static Classe getById(int id) {
        for (Classe cl : classes) {
            if (cl.getIdClasse() == id) {
                return cl;
            }
        }
        return null;
    }

    public static Classe getByLibelle(String libelle) {
        return getByLibelle(libelle, CurrentAnneeScolaire.getCurrent());
    }

    public static Classe getByLibelle(String libelle, AnneeScolaire annee) {
        for (Classe cl : classes) {
            if (cl.getAnneeScolaire() == annee &&
                    cl.getLibelle().equalsIgnoreCase(libelle)) {
                return cl;
            }
        }
        return null;
    }

    public static ArrayList<Classe> getAllClasses() {
        return classes;
    }

    public static ArrayList<Classe> getClassesByYear() {
        return getClassesByYear(CurrentAnneeScolaire.getCurrent());
    }

    public static ArrayList<Classe> getClassesByYear(AnneeScolaire annee) {
        ArrayList<Classe> result = new ArrayList<>();
        for (Classe cl : classes) {
            if (cl.getAnneeScolaire() == annee) {
                result.add(cl);
            }
        }
        return result;
    }
}
