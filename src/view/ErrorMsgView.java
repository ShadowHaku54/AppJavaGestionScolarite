package view;

public enum ErrorMsgView {
    INSCRIPTION_INVALIDE("Un même étudiant est inscrit avec cet email pour la même année"),
    ETUDIANT_INVALIDE("Un même étudiant existe avec cet email"),
    ENREGISTREMENT("Echec ou annulation de l'ajout"),

    ;

    private final String msg;
    ErrorMsgView(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return msg;
    }
}
