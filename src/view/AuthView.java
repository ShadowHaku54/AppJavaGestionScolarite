package view;

import model.Utilisateur;
import service.SecurityService;

public class AuthView extends ConsoleView {

    public Utilisateur connexion() {
        String email    = readString("Email institutionnel");
        String password = readString("Mot de passe");
        Utilisateur user = SecurityService.login(email, password);
        if (user == null) {
            println("Authentification échouée");
        } else {
            println("Bienvenue " + user.getPrenom());
        }
        return user;
    }
}
