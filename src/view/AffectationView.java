package view;

import model.Affectation;
import model.Professeur;
import model.Classe;
import service.ProfesseurService;
import service.ClasseService;

import java.util.ArrayList;

public class AffectationView extends ConsoleView {
    public Affectation saisirAffectation() {
        int idProf = readInt("ID du professeur");
        Professeur prof = ProfesseurService.getById(idProf);
        if (prof == null) {
            println("Professeur introuvable");
            return null;
        }
        int idClasse = readInt("ID de la classe");
        Classe cl = ClasseService.getById(idClasse);
        if (cl == null) {
            println("Classe introuvable");
            return null;
        }
        Affectation aff = new Affectation(prof, cl);
        println("Affectation créée : " + aff);
        return aff;
    }

    public void afficherAffectations(ArrayList<Affectation> list) {
        if (list.isEmpty()) {
            println("Aucune affectation.");
            return;
        }
        int compteur = 0;
        println("Liste des affectations :");
        for (Affectation a : list) {
            compteur++;
            println("Affectation " + compteur + " : " + a);
        }
    }
}
