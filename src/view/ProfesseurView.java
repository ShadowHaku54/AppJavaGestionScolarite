package view;

import model.Professeur;
import model.GradeProfesseur;

import java.util.ArrayList;

public class ProfesseurView extends ConsoleView {
    private final EnumView enumView = new EnumView();

    public Professeur saisirProfesseur() {
        String nom = readString("Nom");
        String prenom = readString("Prénom");
        GradeProfesseur grade = (GradeProfesseur) enumView.chooseEnum(GradeProfesseur.class,"Choisir le grade");
        Professeur prof = new Professeur(nom, prenom, grade);
        println("Professeur créé : " + prof);
        return prof;
    }

    public void afficherProfesseurs(ArrayList<Professeur> list) {
        if (list.isEmpty()) {
            println("Aucun professeur.");
            return;
        }
        println("Liste des professeurs :");
        int compteur = 0;
        for (Professeur p : list) {
            compteur++;
            println("Professeur " + compteur + " - " + p);
        }
    }
}
