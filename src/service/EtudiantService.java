package service;

import java.util.ArrayList;

import model.Etudiant;
import model.Utilisateur;

public class EtudiantService {
    private static final ArrayList<Etudiant> etudiants = new ArrayList<>();

    private EtudiantService() {
    }

    public static boolean exists(Etudiant etudiant) {
        return etudiants.contains(etudiant);
    }

    public static boolean addEtudiant(Etudiant etudiant) {
        if (!UtilisateurService.addUser(etudiant) && etudiant != null && !exists(etudiant)) {
            etudiants.add(etudiant);
            return true;
        }
        return false;
    }

    public static Etudiant getByMat(String matricule) {
        for (Etudiant e : etudiants) {
            if (e.getMatricule().equalsIgnoreCase(matricule)) {
                return e;
            }
        }
        return null;
    }

    public static Etudiant getEtudiant(Utilisateur user) {
        for (Etudiant e : etudiants) {
            if (e.getIdPersonne() == user.getIdPersonne()) {
                return e;
            }
        }
        return null;
    }

    public static ArrayList<Etudiant> getAllEtudiants() {
        return etudiants;
    }
}
