package service;

import java.util.ArrayList;

import model.Affectation;
import model.Classe;
import model.Professeur;
import model.AnneeScolaire;
import model.CurrentAnneeScolaire;

public class AffectationService {
    private static final ArrayList<Affectation> affectations = new ArrayList<>();
    private static int nexId;

    private AffectationService() {
    }

    public static boolean existsAffectation(Affectation af) {
        return affectations.contains(af);
    }

    public static boolean addAffectation(Affectation af) {
        if (!existsAffectation(af)) {
            affectations.add(af);
            return true;
        }
        return false;
    }

    public static Affectation getById(int idAffect) {
        for (Affectation af : affectations) {
            if (af.getIdAffectation() == idAffect) {
                return af;
            }
        }
        return null;
    }

    public static ArrayList<Classe> getClassesOfProf(int idProf) {
        ArrayList<Classe> classes = new ArrayList<>();
        for (Affectation af : affectations) {
            if (af.getProfesseur().getIdProfesseur() == idProf &&
                    !classes.contains(af.getClasse())) {
                classes.add(af.getClasse());
            }
        }
        return classes;
    }

    public static ArrayList<Professeur> getProfsOfClasse(int idClasse) {
        ArrayList<Professeur> profs = new ArrayList<>();
        for (Affectation af : affectations) {
            if (af.getClasse().getIdClasse() == idClasse &&
                    !profs.contains(af.getProfesseur())) {
                profs.add(af.getProfesseur());
            }
        }
        return profs;
    }

    public static ArrayList<Professeur> getProfsOfClasse(String libelle) {
        return getProfsOfClasse(libelle, CurrentAnneeScolaire.getCurrent());
    }

    public static ArrayList<Professeur> getProfsOfClasse(String libelle, AnneeScolaire annee) {
        ArrayList<Professeur> profs = new ArrayList<>();
        for (Affectation af : affectations) {
            if (af.getClasse().getLibelle().equalsIgnoreCase(libelle) &&
                    af.getClasse().getAnneeScolaire() == annee &&
                    !profs.contains(af.getProfesseur())) {
                profs.add(af.getProfesseur());
            }
        }
        return profs;
    }

    public static ArrayList<Affectation> getAllAffectation() {
        return affectations;
    }
}
