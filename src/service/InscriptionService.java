package service;

import java.util.ArrayList;
import java.util.HashMap;

import model.Inscription;
import model.Etudiant;
import model.Classe;
import model.AnneeScolaire;
import model.CurrentAnneeScolaire;
import model.Sexe;

public class InscriptionService {
    private static final ArrayList<Inscription> inscriptions = new ArrayList<>();

    private InscriptionService() {
    }

    public static boolean exists(Inscription inscr) {
        return inscriptions.contains(inscr);
    }

    public static boolean addInscription(Inscription inscr) {
        if (inscr != null && !exists(inscr)) {
            inscriptions.add(inscr);
            return true;
        }
        return false;
    }

    public static boolean inscriptionEnCours(Etudiant e) {
        if (e == null) return false;
        Inscription i = new Inscription(e, null, null);
        return exists(i);
    }


    public static Inscription getById(int idInscr) {
        for (Inscription i : inscriptions) {
            if (i.getIdInscription() == idInscr) {
                return i;
            }
        }
        return null;
    }

    public static ArrayList<Inscription> getAllInscriptions() {
        return inscriptions;
    }

    public static ArrayList<Inscription> getInscriptionsByClasse(int idClasse) {
        ArrayList<Inscription> result = new ArrayList<>();
        for (Inscription i : inscriptions) {
            if (i.getClasse().getIdClasse() == idClasse) {
                result.add(i);
            }
        }
        return result;
    }

    public static ArrayList<Inscription> getInscriptionsByClasse(String libelle) {
        return getInscriptionsByClasse(libelle, CurrentAnneeScolaire.getCurrent());
    }

    public static ArrayList<Inscription> getInscriptionsByClasse(String libelle, AnneeScolaire anneeScolaire) {
        ArrayList<Inscription> result = new ArrayList<>();
        for (Inscription i : inscriptions) {
            String iLibelle = i.getClasse().getLibelle();
            AnneeScolaire iac = i.getClasse().getAnneeScolaire();
            if (iLibelle.equals(libelle) && iac.equals(anneeScolaire)) {
                result.add(i);
            }
        }
        return result;
    }

    public static ArrayList<Inscription> getInscriptionsByEtudiant(int idEtu) {
        ArrayList<Inscription> result = new ArrayList<>();
        for (Inscription i : inscriptions) {
            if (i.getEtudiant().getIdPersonne() == idEtu) {
                result.add(i);
            }
        }
        return result;
    }

    public static ArrayList<Classe> getClassesOfEtudiant(String matEtu) {
        return getClassesOfEtudiant(matEtu, CurrentAnneeScolaire.getCurrent());
    }

    public static ArrayList<Classe> getClassesOfEtudiant(String matEtu, AnneeScolaire annee) {
        ArrayList<Classe> result = new ArrayList<>();
        for (Inscription i : inscriptions) {
            if (i.getEtudiant().getMatricule().equalsIgnoreCase(matEtu) &&
                    i.getAnneeScolaire() == annee) {
                result.add(i.getClasse());
            }
        }
        return result;
    }

    public static ArrayList<Etudiant> getEtudiantsOfClasse(int idClasse) {
        ArrayList<Etudiant> list = new ArrayList<>();
        for (Inscription i : inscriptions) {
            if (i.getClasse().getIdClasse() == idClasse) {
                list.add(i.getEtudiant());
            }
        }
        return list;
    }

    public static ArrayList<Etudiant> getEtudiantsOfClasse(String libelle) {
        return getEtudiantsOfClasse(libelle, CurrentAnneeScolaire.getCurrent());
    }

    public static ArrayList<Etudiant> getEtudiantsOfClasse(String libelle, AnneeScolaire annee) {
        ArrayList<Etudiant> list = new ArrayList<>();
        for (Inscription i : inscriptions) {
            if (i.getClasse().getLibelle().equalsIgnoreCase(libelle) && i.getAnneeScolaire() == annee) {
                list.add(i.getEtudiant());
            }
        }
        return list;
    }

    public static int getEffectifClasse(Classe cl) {
        int count = 0;
        for (Inscription i : inscriptions) {
            if (i.getClasse() == cl) {
                count++;
            }
        }
        return count;
    }

    public static int effectifGlobal(AnneeScolaire annee) {
        int count = 0;
        for (Inscription i : inscriptions) {
            if (i.getAnneeScolaire() == annee) {
                count++;
            }
        }
        return count;
    }

    public static HashMap<AnneeScolaire, Integer> effectifGlobalByYear() {
        HashMap<AnneeScolaire, Integer> map = new HashMap<>();
        for (Inscription i : inscriptions) {
            AnneeScolaire a = i.getAnneeScolaire();
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return map;
    }

    public static HashMap<Classe, Integer> effectifOfClasseByYear(AnneeScolaire a) {
        HashMap<Classe, Integer> map = new HashMap<>();
        for (Inscription i : inscriptions) {
            if(i.getAnneeScolaire().equals(a)){
                Classe cl = i.getClasse();
                map.put(cl, map.getOrDefault(cl, 0) + 1);
            }
        }
        return map;
    }

    public static HashMap<Sexe, Integer> getRepartitionFHOfClasse(int idClasse) {
        HashMap<Sexe, Integer> map = new HashMap<>();
        for (Inscription i : inscriptions) {
            if (i.getClasse().getIdClasse() == idClasse) {
                Sexe s = i.getEtudiant().getSexe();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        return map;
    }

    public static HashMap<Sexe, Integer> getRepartitionFHOfClasse(String libelle) {
        return getRepartitionFHOfClasse(libelle, CurrentAnneeScolaire.getCurrent());
    }

    public static HashMap<Sexe, Integer> getRepartitionFHOfClasse(String libelle, AnneeScolaire annee) {
        HashMap<Sexe, Integer> map = new HashMap<>();
        for (Inscription i : inscriptions) {
            if (i.getClasse().getLibelle().equalsIgnoreCase(libelle) && i.getAnneeScolaire() == annee) {
                Sexe s = i.getEtudiant().getSexe();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        return map;
    }

    public static HashMap<AnneeScolaire, HashMap<Sexe, Integer>> getRepartitionFHByYear() {
        HashMap<AnneeScolaire, HashMap<Sexe, Integer>> result = new HashMap<>();
        for (Inscription i : inscriptions) {
            AnneeScolaire annee = i.getAnneeScolaire();
            HashMap<Sexe, Integer> map = result.getOrDefault(annee, new HashMap<>());
            Sexe s = i.getEtudiant().getSexe();
            map.put(s, map.getOrDefault(s, 0) + 1);
            result.put(annee, map);
        }
        return result;
    }


    public static HashMap<Classe, HashMap<Sexe, Integer>> getRepartitionFHByClasse() {
        return getRepartitionFHByClasse(CurrentAnneeScolaire.getCurrent());
    }

    public static HashMap<Classe, HashMap<Sexe, Integer>> getRepartitionFHByClasse(AnneeScolaire annee) {
        HashMap<Classe, HashMap<Sexe, Integer>> result = new HashMap<>();
        for (Inscription i : inscriptions) {
            if (i.getAnneeScolaire() == annee) {
                Classe cl = i.getClasse();
                HashMap<Sexe, Integer> map = result.getOrDefault(cl, new HashMap<>());
                Sexe s = i.getEtudiant().getSexe();
                map.put(s, map.getOrDefault(s, 0) + 1);
                result.put(cl, map);
            }
        }
        return result;
    }



    public static HashMap<Sexe, Integer> repartitionFHOfYear() {
        return repartitionFHOfYear(CurrentAnneeScolaire.getCurrent());
    }

    public static HashMap<Sexe, Integer> repartitionFHOfYear(AnneeScolaire annee) {
        HashMap<Sexe, Integer> map = new HashMap<>();
        for (Inscription i : inscriptions) {
            if (i.getAnneeScolaire() == annee) {
                Sexe s = i.getEtudiant().getSexe();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        return map;
    }

    public static HashMap<AnneeScolaire, HashMap<Sexe, Integer>> repartitionFHByYear() {
        HashMap<AnneeScolaire, HashMap<Sexe, Integer>> result = new HashMap<>();
        for (Inscription i : inscriptions) {
            AnneeScolaire annee = i.getAnneeScolaire();
            HashMap<Sexe, Integer> map = result.getOrDefault(annee, new HashMap<>());
            Sexe s = i.getEtudiant().getSexe();
            map.put(s, map.getOrDefault(s, 0) + 1);
            result.put(annee, map);
        }
        return result;
    }
}
