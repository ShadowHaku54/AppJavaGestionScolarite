package service;

import model.Utilisateur;

public class SecurityService {
    private SecurityService() {}

    public static Utilisateur login(String email, String password) {
        Utilisateur user = UtilisateurService.getByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
