package service;

import model.ResponsablePedagogique;
import model.Utilisateur;

import java.util.ArrayList;

public class ResponsablePedagogiqueService {
    private static final ArrayList<ResponsablePedagogique> responsablePedagogiques = new ArrayList<>();

    private ResponsablePedagogiqueService(){};

    public static boolean exists(ResponsablePedagogique rp){
        return false;
    }

    public static boolean addResponsablePedagogique(ResponsablePedagogique rp){
        if(!UtilisateurService.addUser(rp) && rp != null && !exists(rp)){
            responsablePedagogiques.add(rp);
            return true;
        }
        return false;
    }

    public static ResponsablePedagogique getResponsablePedagogique(Utilisateur user){
        for (ResponsablePedagogique rp : responsablePedagogiques){
            if(rp.getIdPersonne() == user.getIdPersonne()){
                return rp;
            }
        }
        return null;
    }
}
