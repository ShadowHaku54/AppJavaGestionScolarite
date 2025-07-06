package service;

import java.util.ArrayList;
import model.Utilisateur;

public class UtilisateurService {
    private static final ArrayList<Utilisateur> users = new ArrayList<>();

    private UtilisateurService() {}

    public static boolean exists(Utilisateur user) {
        return users.contains(user);
    }

    public static boolean addUser(Utilisateur user) {
        if (user != null && !exists(user)) {
            users.add(user);
            return true;
        }
        return false;
    }

    public static Utilisateur getByEmail(String email) {
        for (Utilisateur u : users) {
            if (u.getEmailOfSchool().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    public static ArrayList<Utilisateur> getAllUsers() {
        return users;
    }
}
