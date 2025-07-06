package model;

import java.time.LocalDate;

public class Periode {
    private LocalDate debut;
    private LocalDate fin;

    public Periode(LocalDate debut, LocalDate fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "[" + debut + "; " + fin + "]";
    }


}
