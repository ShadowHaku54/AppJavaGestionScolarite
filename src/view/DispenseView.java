package view;

import model.Dispense;
import model.Professeur;
import model.Module;
import service.ProfesseurService;
import service.ModuleService;
import java.util.ArrayList;

public class DispenseView extends ConsoleView {

    public Dispense saisirDispense() {
        int idProf = readInt("ID du professeur");
        Professeur prof = ProfesseurService.getById(idProf);
        if (prof == null) {
            println("Professeur introuvable");
            return null;
        }
        int idMod = readInt("ID du module");
        Module mod = ModuleService.getById(idMod);
        if (mod == null) {
            println("Module introuvable");
            return null;
        }
        Dispense disp = new Dispense(prof, mod);
        println("Dispense créée : " + disp);
        return disp;
    }


    public void afficherDispenses(ArrayList<Dispense> list) {
        if (list.isEmpty()) {
            println("Aucune dispense.");
            return;
        }
        println("Liste des dispenses :");
        int compteur = 0;
        for (Dispense d : list) {
            compteur++;
            println("Dispense " +  compteur + " - " + d);
        }
    }
}
