import model.*;
import model.Module;
import service.*;
import view.*;

import java.util.HashMap;

public class RpApp extends ConsoleView {
    private final ResponsablePedagogique rp;

    private final EnumView enumView = new EnumView();
    private final ClasseView classeView = new ClasseView();
    private final AnneeScolaireView anneeScolaireView = new AnneeScolaireView();
    private final ModuleView moduleView = new ModuleView();
    private final DispenseView dispenseView = new DispenseView();
    private final ProfesseurView professeurView = new ProfesseurView();
    private final AffectationView affectationView = new AffectationView();
    private final DemandeView demandeView = new DemandeView();

    public RpApp(Utilisateur user){
        this.rp = ResponsablePedagogiqueService.getResponsablePedagogique(user);
    }

    private enum MenuRP {
        AJOUTER_CLASSE("Ajouter une classe"),
        LIST_CLASSES_COURANTE("Lister les classes courante"),
        LIST_CLASSES_CURRENT_ANNEE("Lister les classes de l'année"),
        INFO_CLASSE("Afficher les informations d’une classe"),
        AJOUTER_MODULE("Ajouter un module"),
        LIST_MODULES("Lister les module"),
        LIST_PROFS_MODULE("Lister les modules d’un prof"),
        AJOUTER_PROF("Ajouter un professeur"),
        ASSOCIER_MODULES("Associer un ou plusieurs modules à un prof"),
        AFFECTER_CLASSES("Affecter un ou plusieurs classe(s) à un prof"),
        LIST_PROFS("Lister les professeurs"),
        INFO_PROF("Afficher les informations d’un professeur"),
        LIST_CLASSES_PROF("Lister les classes d’un professeur"),
        LIST_MODULES_PROF("Lister les modules d’un professeur"),
        LIST_DEMANDES_EN_ATTENTE("Lister les demandes en attente"),
        FILTER_DEMANDES_PAR_TYPE("Filtrer les demandes en attente par type"),
        TRAITER_DEMANDE("Traiter une demande"),
        STATS_GLOBAL_ANNEE("Afficher l’effectif de l’école par année"),
        STATS_FH_ANNEE("Afficher la répartition de fille ou de garçon par année"),
        STATS_EFFECTIF_CLASSE("Afficher l’effectif par classe pour une année"),
        STATS_FH_CLASSE("Afficher la répartition de fille ou de garçon pour une année"),
        STATS_SUSP_ANNUL_ANNEE("Afficher le nombre suspensions / annulations par année"),
        SHOW_CURRENT_YEAR("Afficher l’année scolaire actuelle"),
        LIST_OLD_YEARS("Lister les anciennes années déjà définie"),
        DEFINE_NEW_YEAR("Définir une nouvelle année scolaire"),
        QUITTER("Quitter");

        private final String description;

        MenuRP(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public void run() {
        while (true) {
            MenuRP choix = (MenuRP) enumView.chooseEnum(MenuRP.class, "Menu Responsable Pédagogique");
            switch (choix) {
                case AJOUTER_CLASSE -> ajouterClasse();
                case LIST_CLASSES_COURANTE -> listClasseCourante();
                case LIST_CLASSES_CURRENT_ANNEE -> listClasseCurrentAnnee();
                case INFO_CLASSE -> infoClasse();
                case AJOUTER_MODULE -> ajouterModule();
                case LIST_MODULES -> listModule();
                case LIST_PROFS_MODULE -> listProfsModule();
                case AJOUTER_PROF -> ajouterProf();
                case ASSOCIER_MODULES -> associerModules();
                case AFFECTER_CLASSES -> affecterClasses();
                case LIST_PROFS -> listProfs();
                case INFO_PROF -> infoProf();
                case LIST_CLASSES_PROF -> listClassesProf();
                case LIST_MODULES_PROF -> listModulesProf();
                case LIST_DEMANDES_EN_ATTENTE -> listDemandeEnAttente();
                case FILTER_DEMANDES_PAR_TYPE -> filtrerDemandesParType();
                case TRAITER_DEMANDE -> traiterDemande();
                case STATS_GLOBAL_ANNEE -> statsGlobalAnnee();
                case STATS_FH_ANNEE -> statsFHAnnee();
                case STATS_EFFECTIF_CLASSE -> statsEffectifClasse();
                case STATS_FH_CLASSE -> statsFHClasse();
                case STATS_SUSP_ANNUL_ANNEE -> statsSuspAnnulAnnee();
                case SHOW_CURRENT_YEAR -> showCurrentYear();
                case LIST_OLD_YEARS -> listOldYears();
                case DEFINE_NEW_YEAR -> defineNewYear();
                case QUITTER -> {
                    return;
                }
            }
        }
    }

    private void ajouterClasse() {
        Classe cl = classeView.saisirClasse();
        if(ClasseService.addClasse(cl)){
            println(SuccessMsgView.ENREGISTREMENT + " de la classe");
        }
        else {
            println(ErrorMsgView.ENREGISTREMENT + " de la classe");
        }
    }

    private void listClasseCourante() {
        classeView.afficherClasses(ClasseService.getClassesByYear());
    }

    private void listClasseCurrentAnnee() {
        classeView.afficherClasses(ClasseService.getClassesByYear());
    }

    private void infoClasse() {
        int idClasse = readInt("Entrer l'id de la classe: ");
        Classe c = ClasseService.getById(idClasse);
        if (c != null){
            println("Classe :" + c);
        }
        else {
            println("Aucune classe trouvé");
        }
    }

    private void ajouterModule() {
        Module m = moduleView.saisirModule();
        if(ModuleService.addModule(m)){
            println(SuccessMsgView.ENREGISTREMENT + " du module");
        }
        else {
            println(ErrorMsgView.ENREGISTREMENT + " du module");
        }
    }

    private void listModule() {
        moduleView.afficherModules(ModuleService.getAllModules());
    }

    private void listProfsModule() {
        int idProf = readInt("Saisir l'id du prof");
        dispenseView.afficherDispenses(DispenseService.getDispensesByProf(idProf));
    }

    private void ajouterProf() {
        Professeur m = professeurView.saisirProfesseur();
        if(ProfesseurService.addProfesseur(m)){
            println(SuccessMsgView.ENREGISTREMENT + " du professeur");
        }
        else {
            println(ErrorMsgView.ENREGISTREMENT + " du professeur");
        }
    }

    private void associerModules() {
        Dispense dispense = dispenseView.saisirDispense();
        if(DispenseService.addDispense(dispense)){
            println(SuccessMsgView.ENREGISTREMENT + " du dispense");
        }
        else {
            println(ErrorMsgView.ENREGISTREMENT + " du dispense");
        }
    }

    private void affecterClasses() {
        Affectation affectation = affectationView.saisirAffectation();
        if(AffectationService.addAffectation(affectation)){
            println(SuccessMsgView.ENREGISTREMENT + " du affectation");
        }
        else {
            println(ErrorMsgView.ENREGISTREMENT + " du affectation");
        }
    }

    private void listProfs() {
        professeurView.afficherProfesseurs(ProfesseurService.getAllProfesseurs());
    }


    private void infoProf() {
        int idProf = readInt("Saisir l'id du prof");
        Professeur pr = ProfesseurService.getById(idProf);
        if(pr != null){
            println("Le professeur :" + pr);
        }
        else{
            println("Cet professeur n'existe pas");
        }
    }

    private void listClassesProf() {
        int idProf = readInt("Saisir l'id du prof");
        classeView.afficherClasses(AffectationService.getClassesOfProf(idProf));
    }

    private void listModulesProf() {
        int idProf = readInt("Saisir l'id du prof");
        classeView.afficherClasses(AffectationService.getClassesOfProf(idProf));
    }

    private void listDemandeEnAttente() {
        demandeView.afficherDemandes(DemandeService.getDemandesEnAttente());
    }

    private void filtrerDemandesParType() {
        TypeDemande td = (TypeDemande) enumView.chooseEnum(TypeDemande.class, "Selectionner le type");
        demandeView.afficherDemandes(DemandeService.getEnAttenteByTypeDemande(td));
    }

    private void traiterDemande() {
        int id = readInt("Entrer l'id de la demande:");
        Demande d = DemandeService.getById(id);
        if(d != null){
            d.setType((TypeDemande) enumView.chooseEnum(TypeDemande.class, "Sélectionner une demande:"));
        }
    }

    private void statsGlobalAnnee() {
        HashMap<AnneeScolaire, Integer> effectifParAnneeScolaire = InscriptionService.effectifGlobalByYear();
        if(effectifParAnneeScolaire.isEmpty()){
            println("Aucune donnée");
        }
        else {
            println("Effectif global par année:");
            effectifParAnneeScolaire.forEach((anneeScolaire, effectif)->{
                println("Année scolaire: " + anneeScolaire + " ; effectif : " + effectif);
            });
        }
    }

    private void statsFHAnnee() {
        HashMap<AnneeScolaire, HashMap<Sexe, Integer>> rep = InscriptionService.getRepartitionFHByYear();
        if(rep.isEmpty()){
            print("Aucune donnée");
        }
        else{
            println("Répartition garçons/filles pat année:");
            rep.forEach((anneeScolaire, ebs)->{
                println("Année scolaire: " + anneeScolaire + " ; garçons : " + ebs.get(Sexe.M) + " ; filles : " + ebs.get(Sexe.F));
            });
        }
    }

    private void statsEffectifClasse() {
        AnneeScolaire a = anneeScolaireView.saisirAnneeScolaire();
        HashMap<Classe, Integer> eff = InscriptionService.effectifOfClasseByYear(a);
        if(eff.isEmpty()){
            println("Aucune donnée");
        }
        else {
            println("Effectif par classe pour l'année " + a + " :");
            eff.forEach((cl, effectif)->{
                println("Classe : " + cl + " ; effectif : " + effectif);
            });
        }
    }

    private void statsFHClasse() {
        AnneeScolaire a = anneeScolaireView.saisirAnneeScolaire();
        HashMap<Classe, HashMap<Sexe, Integer>> rep = InscriptionService.getRepartitionFHByClasse(a);
        if(rep.isEmpty()){
            print("Aucune donnée");
        }
        else{
            println("Répartition filles/gracons pour l'année " + a + ":");
            rep.forEach((cl, eff)->{
                println("Classe : " + cl + " ; garçons : " + eff.get(Sexe.M) + " ; filles : " + eff.get(Sexe.F));
            });
        }
    }

    private void statsSuspAnnulAnnee() {
        HashMap<AnneeScolaire, HashMap<TypeDemande, Integer>> rep = DemandeService.nbSuspAnnulByYear();
        if(rep.isEmpty()){
            print("Aucune donnée");
        }
        else{
            println("Effectif global par année:");
            rep.forEach((a, eff)->{
                println("Année : " + a + " ; garçons : " + eff.get(Sexe.M) + " ; filles : " + eff.get(Sexe.F));
            });
        }
    }

    private void showCurrentYear() {
        println("Annee scolaire actuelle : " + CurrentAnneeScolaire.getCurrent());
    }

    private void listOldYears() {
        anneeScolaireView.afficherAnnneesScolaire(AnneeScolaireService.getAllYears());
    }

    private void defineNewYear() {
        AnneeScolaire a = anneeScolaireView.saisirAnneeScolaire();
        if(AnneeScolaireService.defineNewYear(a)){
            println(SuccessMsgView.ENREGISTREMENT + " de l'année scolaire");
        }
        else{
            println(ErrorMsgView.ENREGISTREMENT + " de l'année scolaire");
        }
    }
}
