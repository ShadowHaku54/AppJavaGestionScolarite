package view;

import model.Etudiant;
import model.Sexe;

import java.util.ArrayList;

public class EtudiantView extends ConsoleView {
    private final EnumView enumView = new EnumView();

    public Etudiant saisirEtudiant() {
        String nom = readString("Nom");
        String prenom = readString("Prénom");
        String password = readString("Mot de passe");
        String emailPerso = readString("Email personnel");
        String adresse = readString("Adresse");
        Sexe sexe = (Sexe) enumView.chooseEnum(Sexe.class, "Choisir le sexe");
        Etudiant etu = new Etudiant(nom, prenom, password, emailPerso, adresse, sexe);
        println("Étudiant créé : " + etu);
        return etu;
    }

    public void afficherEtudiants(ArrayList<Etudiant> list) {
        if (list.isEmpty()) {
            println("Aucun étudiant.");
            return;
        }
        println("Liste des étudiants :");
        int compteur  = 0;
        for (Etudiant e : list) {
            compteur++;
            println("Etudiant " + compteur + " - " + e);
        }
    }
}
