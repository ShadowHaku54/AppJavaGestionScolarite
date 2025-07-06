package view;

import java.util.Scanner;

public abstract class ConsoleView {
    protected static final Scanner SC = new Scanner(System.in);

    public void print(String msg) {
        System.out.print(msg);
    }

    public void println(String msg) {
        System.out.println(msg);
    }

    public int readInt(String sms) {
        while (true) {
            print(sms + " ");
            String line = SC.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                println("Nombre entier invalide !");
            }
        }
    }

    public double readDouble(String sms) {
        while (true) {
            print(sms + " ");
            String line = SC.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                println("Nombre décimal invalide !");
            }
        }
    }

    public String readString(String sms) {
        while (true) {
            print(sms + " ");
            String line = SC.nextLine();
            if (!line.trim().isEmpty()) {
                return line;
            }
            println("Texte vide !");
        }
    }

    public String readWord(String sms) {
        while (true) {
            print(sms + " ");
            String line = SC.nextLine().trim();
            if (!line.isEmpty() && !line.contains(" ")) {
                return line;
            }
            println("Mot invalide !");
        }
    }

    public boolean readConfirm(String sms) {
        while (true) {
            print(sms + " (y/n) ");
            String resp = SC.nextLine().trim().toLowerCase();
            if (resp.startsWith("y")) return true;
            if (resp.startsWith("n")) return false;
            println("Réponse invalide !");
        }
    }
}
