package view;

import model.Demande;
import model.TypeDemande;
import model.Etudiant;
import model.Inscription;
import service.EtudiantService;
import service.InscriptionService;

import java.util.ArrayList;

public class DemandeView extends ConsoleView {
    private final EnumView enumView = new EnumView();

    public Demande saisirDemande() {
        String mat = readString("Matricule étudiant");
        Etudiant etu = EtudiantService.getByMat(mat);
        if (etu == null) {
            println("Étudiant introuvable");
            return null;
        }
        int idIns = readInt("ID de l'inscription concernée");
        Inscription insc = InscriptionService.getById(idIns);
        if (insc == null) {
            println("Inscription introuvable");
            return null;
        }
        TypeDemande type = (TypeDemande) enumView.chooseEnum(TypeDemande.class, "Choisir le type de demande");
        String motif = readString("Motif");
        Demande dem = new Demande(etu, insc, type, motif);
        println("Demande créée : " + dem);
        return dem;
    }

    public void afficherDemandes(ArrayList<Demande> list) {
        if (list.isEmpty()) {
            println("Aucune demande.");
            return;
        }
        println("Liste des demandes :");
        int compteur = 0;
        for (Demande d : list) {
            compteur++;
            println("Demande " + compteur + " - " + d);
        }
    }
}
