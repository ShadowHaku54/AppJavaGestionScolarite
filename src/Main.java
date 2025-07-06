import model.*;
import service.AnneeScolaireService;
import service.AttacheClasseService;
import service.ResponsablePedagogiqueService;
import view.*;

public class Main extends ConsoleView {
    private static final EnumView enumView = new EnumView();
    private static final AuthView authView = new AuthView();

    static {
        AnneeScolaireService.defineNewYear(new AnneeScolaire(2024));

        AttacheClasse ac = new AttacheClasse("attache", "classe", "pass");
        ResponsablePedagogique rp = new ResponsablePedagogique("responsable", "pedagogique", "pass");
        AttacheClasseService.addAttacheClasse(ac);
        ResponsablePedagogiqueService.addResponsablePedagogique(rp);

        // test
        enumView.println("Email ac: " + ac.getEmailOfSchool());
        enumView.println("Email rp: " + rp.getEmailOfSchool());
    }

    private enum MenuMain{
        CONNECTION("Se connecter"),
        QUITTER("Quitter");

        private final String description;
        MenuMain(String description){
            this.description = description;
        }

        @Override
        public String toString(){
            return description;
        }
    }

    public static void main(String[] args) {
        while (true){
            MenuMain m = (MenuMain) enumView.chooseEnum(MenuMain.class, "Choisir une option");
            switch (m){
                case CONNECTION -> {
                    Utilisateur user = authView.connexion();
                    if (user != null) {
                        switch (user.thisRole()){
                            case RolePersonne.ETU -> new EtuApp(user).run();
                            case RolePersonne.AC -> new AcApp(user).run();
                            case RolePersonne.RP -> new RpApp(user).run();
                        }
                    }
                }
                case QUITTER -> {return;}
            }
        }
    }
}