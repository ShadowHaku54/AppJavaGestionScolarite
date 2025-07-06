package view;

import model.Module;

import java.util.ArrayList;

public class ModuleView extends ConsoleView {

    public Module saisirModule() {
        String nom = readString("Nom du module");
        int nbHeure = readInt("Nombre d'heures");
        Module module = new Module(nom, nbHeure);
        println("Module créé : " + module);
        return module;
    }


    public void afficherModules(ArrayList<Module> list) {
        if (list.isEmpty()) {
            println("Aucun module.");
            return;
        }
        println("Liste des modules :");
        int compteur = 0;
        for (Module m : list) {
            compteur++;
            println("Module " + compteur + " - " + m);
        }
    }
}
