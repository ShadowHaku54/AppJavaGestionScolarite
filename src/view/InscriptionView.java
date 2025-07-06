package view;

import model.Etudiant;
import model.Classe;
import model.Inscription;
import model.TypeInscription;
import service.EtudiantService;
import service.ClasseService;

import java.util.ArrayList;

public class InscriptionView extends ConsoleView {
    private final EnumView enumView = new EnumView();
    private final EtudiantView etudiantView = new EtudiantView();
    private final ClasseView classeView = new ClasseView();

    public Inscription saisirInscription() {
        TypeInscription type = (TypeInscription) enumView.chooseEnum(TypeInscription.class, "Choisir le type d'inscription");
        Etudiant etu;
        if (type == TypeInscription.REINSCRIPTION){
            String mat = readString("Matricule étudiant");
            etu = EtudiantService.getByMat(mat);
            if (etu == null) {
                println("Étudiant introuvable");
                return null;
            }
        }
        else{
            etu = etudiantView.saisirEtudiant();
            if(EtudiantService.addEtudiant(etu)){
                println(SuccessMsgView.ENREGISTREMENT + " de l'étudiant");
                println("Informations étudiant: " + etu);
            }
            else {
                println(ErrorMsgView.ENREGISTREMENT + " de l'étudiant");
                return null;
            }
        }
        classeView.afficherClasses(ClasseService.getClassesByYear());
        int idClasse = readInt("ID de la classe");
        Classe cl = ClasseService.getById(idClasse);
        if (cl == null) {
            println("Classe introuvable");
            return null;
        }
        Inscription insc = new Inscription(etu, cl, type);
        println("Inscription créée : " + insc);
        return insc;
    }


    public void afficherInscriptions(ArrayList<Inscription> list) {
        if (list.isEmpty()) {
            println("Aucune inscription.");
            return;
        }
        println("Liste des inscriptions :");
        int compteur = 0;
        for (Inscription i : list) {
            compteur++;
            println("Inscriptions " + compteur + " - " + i);
        }
    }
}
