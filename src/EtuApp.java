import model.*;
import service.DemandeService;
import service.EtudiantService;
import view.*;

import java.util.ArrayList;

public class EtuApp extends ConsoleView {
    private final Etudiant etu;
    private final EnumView enumView = new EnumView();
    private final DemandeView demandeView = new DemandeView();

    public EtuApp(Utilisateur user){
        this.etu = EtudiantService.getEtudiant(user);
    }

    private enum MenuETU {
        SOUMETTRE_DEMANDE("Soumettre une demande"),
        CONSULTER_DEMANDES("Lister mes demandes"),
        CONSULTER_DEMANDES_FILTRE("Filtrer les demandes par Statut"),
        SHOW_CURRENT_YEAR("Afficher l’année courante"),
        QUITTER("Quitter");

        private final String description;

        MenuETU(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public void run() {
        while (true) {
            MenuETU choix = (MenuETU) enumView.chooseEnum(MenuETU.class, "Menu Étudiant");
            switch (choix) {
                case SOUMETTRE_DEMANDE -> soumettreDemande();
                case CONSULTER_DEMANDES -> consulterDemandes();
                case CONSULTER_DEMANDES_FILTRE -> consulterDemandesFiltre();
                case SHOW_CURRENT_YEAR -> showCurrentYear();
                case QUITTER -> {
                    println("Aurevoir");
                    return;
                }
            }
        }
    }

    private void soumettreDemande() {
        Demande d = demandeView.saisirDemande();

        if(DemandeService.addDemande(d)){
            println(SuccessMsgView.ENREGISTREMENT.toString() + " de la demande");
        }
        else{
            println(ErrorMsgView.ENREGISTREMENT.toString() + " de la demande");
        }
    }

    private void consulterDemandes() {
        ArrayList<Demande> sesDemandes = DemandeService.getDemandesByEtudiant(etu.getMatricule());
        demandeView.afficherDemandes(sesDemandes);
    }

    private void consulterDemandesFiltre() {
        StatutDemande sd = (StatutDemande) enumView.chooseEnum(StatutDemande.class, "Choisir le statut à filtrer");
        ArrayList<Demande> sesDemandes = DemandeService.getDemandesByEtudiant(etu.getMatricule());
        demandeView.afficherDemandes(DemandeService.getDemandeByStatut(sesDemandes, sd));
    }

    private void showCurrentYear() {
        println("Annee scolaire actuelle : " + CurrentAnneeScolaire.getCurrent());
    }
}
