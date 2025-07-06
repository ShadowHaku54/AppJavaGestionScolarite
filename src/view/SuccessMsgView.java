package view;

public enum SuccessMsgView {
    INSCRIPTION_REUSSI("Ajout réussi de l'inscription"),
    ETUDIANT_REUSSI("Ajout réussi de l'étudiant"),
    ENREGISTREMENT("Enregistrement réussi"),
    ;

    private final String msg;
    SuccessMsgView(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return msg;
    }
}
