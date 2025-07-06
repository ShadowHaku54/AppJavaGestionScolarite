package service;

import java.util.ArrayList;
import java.util.HashMap;
import model.Demande;
import model.TypeDemande;
import model.StatutDemande;
import model.AnneeScolaire;

public class DemandeService {
    private static final ArrayList<Demande> demandes = new ArrayList<>();
    private static int nexId;

    private DemandeService() {}

    public static boolean exists(Demande demande) {
        return demandes.contains(demande);
    }

    public static boolean addDemande(Demande demande) {
        if (demande != null && !exists(demande)) {
            demandes.add(demande);
            return true;
        }
        return false;
    }

    public static Demande getById(int idDem) {
        for (Demande d : demandes) {
            if (d.getIdDemande() == idDem) {
                return d;
            }
        }
        return null;
    }

    public static ArrayList<Demande> getAllDemandes() {
        return demandes;
    }

    public static ArrayList<Demande> getDemandesEnAttente() {
        return getDemandeByStatut(StatutDemande.EN_ATTENTE);
    }

    public static ArrayList<Demande> getEnAttenteByTypeDemande(TypeDemande type) {
        ArrayList<Demande> result = new ArrayList<>();
        for (Demande d : demandes) {
            if (d.getStatut() == StatutDemande.EN_ATTENTE &&
                    d.getType() == type) {
                result.add(d);
            }
        }
        return result;
    }

    public static ArrayList<Demande> getDemandesByEtudiant(String matEtu) {
        ArrayList<Demande> result = new ArrayList<>();
        for (Demande d : demandes) {
            if (d.getEtudiant().getMatricule().equalsIgnoreCase(matEtu)) {
                result.add(d);
            }
        }
        return result;
    }

    public static ArrayList<Demande> getDemandeByStatut(StatutDemande statut) {
        ArrayList<Demande> result = new ArrayList<>();
        for (Demande d : demandes) {
            if (d.getStatut() == statut) {
                result.add(d);
            }
        }
        return result;
    }

    public static ArrayList<Demande> getDemandeByStatut(ArrayList<Demande> lesDemandes, StatutDemande statut) {
        ArrayList<Demande> result = new ArrayList<>();
        for (Demande d : lesDemandes) {
            if (d.getStatut() == statut) {
                result.add(d);
            }
        }
        return result;
    }



    public static HashMap<AnneeScolaire, HashMap<TypeDemande, Integer>> nbSuspAnnulByYear() {
        HashMap<AnneeScolaire, HashMap<TypeDemande, Integer>> result = new HashMap<>();
        for (Demande d : demandes) {
            AnneeScolaire annee = d.getAnneeScolaire();
            HashMap<TypeDemande, Integer> map = result.getOrDefault(annee, new HashMap<>());
            TypeDemande type = d.getType();
            map.put(type, map.getOrDefault(type, 0) + 1);
            result.put(annee, map);
        }
        return result;
    }
}
