package view;

import model.AnneeScolaire;

import java.util.ArrayList;

public class AnneeScolaireView extends ConsoleView {

    public AnneeScolaire saisirAnneeScolaire() {
        int debut = readInt("Entrer l'année de début (ex. 2025)");
        AnneeScolaire as = new AnneeScolaire(debut);
        println("Année scolaire créée : " + as);
        return as;
    }

    public void afficherAnnneesScolaire(ArrayList<AnneeScolaire> list) {
        if (list.isEmpty()) {
            println("Aucune année scolaire définie.");
            return;
        }
        println("Liste des années scolaires :");
        int compteur = 0;
        for (AnneeScolaire as : list) {
            compteur++;
            println("Année scolaire " + compteur + " : " + as);
        }
    }
}
