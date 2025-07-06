package view;

import model.Classe;
import model.Niveau;
import model.Filiere;
import model.Periode;

import java.util.ArrayList;

public class ClasseView extends ConsoleView {
    private final EnumView enumView = new EnumView();
    private final PeriodeView periodeView = new PeriodeView();

    public Classe saisirClasse() {
        String libelle = readWord("Libellé de la classe");
        Niveau niveau = (Niveau) enumView.chooseEnum(Niveau.class, "Choisir un niveau");
        Filiere filiere = (Filiere) enumView.chooseEnum(Filiere.class, "Choisir une filière");
        println("Saisir la période d'inscription");
        Periode periode = periodeView.saisirPeriode();
        Classe cl = new Classe(libelle, niveau, filiere, periode);
        println("Classe créée : " + cl);
        return cl;
    }

    public void afficherClasses(ArrayList<Classe> list) {
        if (list.isEmpty()) {
            println("Aucune classe.");
            return;
        }
        println("Liste des classes :");
        int compteur = 0;
        for (Classe c : list) {
            compteur++;
            println("Classe " + compteur + " - " + c);
        }
    }
}
