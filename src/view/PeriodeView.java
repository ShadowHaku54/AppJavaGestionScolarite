package view;

import model.Periode;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PeriodeView extends ConsoleView {

    public Periode saisirPeriode() {
        while (true) {
            try {
                String d1 = readWord("Date début (yyyy-MM-dd)");
                String d2 = readWord("Date fin   (yyyy-MM-dd)");
                LocalDate debut = LocalDate.parse(d1);
                LocalDate fin = LocalDate.parse(d2);
                if (!fin.isBefore(debut)) {
                    return new Periode(debut, fin);
                }
                println("Fin avant début !");
            } catch (DateTimeParseException e) {
                println("Format invalide !");
            }
        }
    }

}
