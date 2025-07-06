package view;

public class EnumView extends ConsoleView {

    public Enum<?> chooseEnum(Class<? extends Enum<?>> enumClass, String titre) {
        Enum<?>[] values = enumClass.getEnumConstants();
        while (true) {
            println("\n" + titre);
            for (int i = 0; i < values.length; i++) {
                println((i + 1) + ". " + values[i]);
            }
            int choix = readInt("Votre choix");
            if (choix >= 1 && choix <= values.length) {
                return values[choix - 1];
            }
            println("Choix invalide !");
        }
    }
}
