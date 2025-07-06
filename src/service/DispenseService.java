package service;

import java.util.ArrayList;
import model.Dispense;
import model.Module;

public class DispenseService {
    private static final ArrayList<Dispense> dispenses = new ArrayList<>();

    private DispenseService() {}

    public static boolean exists(Dispense disp) {
        return dispenses.contains(disp);
    }

    public static boolean addDispense(Dispense disp) {
        if (disp != null && !exists(disp)) {
            dispenses.add(disp);
            return true;
        }
        return false;
    }

    public static Dispense getById(int idDisp) {
        for (Dispense d : dispenses) {
            if (d.getIdDispense() == idDisp) {
                return d;
            }
        }
        return null;
    }

    public static ArrayList<Dispense> getDispensesByProf(int idProf) {
        ArrayList<Dispense> result = new ArrayList<>();
        for (Dispense d : dispenses) {
            if (d.getProfesseur().getIdProfesseur() == idProf) {
                result.add(d);
            }
        }
        return result;
    }

    public static ArrayList<Dispense> getDispensesByModule(int idModule) {
        ArrayList<Dispense> result = new ArrayList<>();
        for (Dispense d : dispenses) {
            if (d.getModule().getIdModule() == idModule) {
                result.add(d);
            }
        }
        return result;
    }

    public static ArrayList<Module> getModulesOfProf(int idProf) {
        ArrayList<Module> modules = new ArrayList<>();
        for (Dispense d : dispenses) {
            if (d.getProfesseur().getIdProfesseur() == idProf) {
                modules.add(d.getModule());
            }
        }
        return modules;
    }
}
