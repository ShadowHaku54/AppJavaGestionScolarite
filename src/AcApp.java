import model.*;
import service.*;
import view.*;

import java.util.ArrayList;


public class AcApp extends ConsoleView {
    private final AttacheClasse ac;

    private final EnumView enumView = new EnumView();
    private final InscriptionView inscriptionView = new InscriptionView();
    private final AnneeScolaireView anneeScolaireView = new AnneeScolaireView();
    private final DemandeView demandeView = new DemandeView();
    private final EtudiantView etudiantView = new EtudiantView();
    private final ClasseView classeView = new ClasseView();

    public AcApp(Utilisateur user){
        this.ac = AttacheClasseService.getAttacheClasse(user);
    }

    private enum MenuAC {
        INSCRIPTION("Inscrire un étudiant"),
        LIST_ETU_CLASSE("Lister les étudiants d’une classe pour une année"),
        LIST_DEMANDES_ETU("Lister les demandes d’un étudiant"),
        SHOW_CURRENT_YEAR("Afficher l’année courante"),
        QUITTER("Quitter");

        private final String description;

        MenuAC(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public void run() {
        while (true) {
            MenuAC choix = (MenuAC) enumView.chooseEnum(MenuAC.class, "Menu Attaché de classe");
            switch (choix) {
                case INSCRIPTION -> inscription();
                case LIST_ETU_CLASSE -> listEtuClasse();
                case LIST_DEMANDES_ETU -> listDemandesEtu();
                case SHOW_CURRENT_YEAR -> showCurrentYear();
                case QUITTER -> {
                    return;
                }
            }
        }
    }

    private void inscription() {
        Inscription i = inscriptionView.saisirInscription();
        if(InscriptionService.addInscription(i)){
            println(SuccessMsgView.ENREGISTREMENT + " de l'inscription");
        }
        else {
            println(ErrorMsgView.ENREGISTREMENT + " de l'inscription");
        }
    }


    private void listEtuClasse() {
        boolean ok = readConfirm("Voulez-vous lister les étudiants de l'année actuelle " + CurrentAnneeScolaire.getCurrent());
        AnneeScolaire anneeScolaire;
        if(ok){
            anneeScolaire = CurrentAnneeScolaire.getCurrent();
        }
        else {
            anneeScolaire = anneeScolaireView.saisirAnneeScolaire();
            if(!AnneeScolaireService.exists(anneeScolaire)){
                println("Cette année scolaire n'existe pas!");
                return;
            }
        }
        classeView.afficherClasses(ClasseService.getClassesByYear(anneeScolaire));
        String libelle = readWord("Saisir le libellé de la classe");
        ArrayList<Etudiant> etudiants = InscriptionService.getEtudiantsOfClasse(libelle, anneeScolaire);
        etudiantView.afficherEtudiants(etudiants);
    }

    private void listDemandesEtu() {
        String matricule = readWord("Entrer le matricule de l'édutiant:");
        ArrayList<Demande> demandes = DemandeService.getDemandesByEtudiant(matricule);
        demandeView.afficherDemandes(demandes);
    }

    private void showCurrentYear() {
        println("Annee scolaire actuelle : " + CurrentAnneeScolaire.getCurrent());
    }
}
