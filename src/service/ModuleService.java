package service;

import java.util.ArrayList;

import model.Module;

public class ModuleService {
    private static final ArrayList<Module> modules = new ArrayList<>();
    private static int nexId;

    private ModuleService() {
    }

    public static boolean exists(Module module) {
        return modules.contains(module);
    }

    public static boolean addModule(Module module) {
        if (module != null && !exists(module)) {
            modules.add(module);
            return true;
        }
        return false;
    }

    public static Module getById(int id) {
        for (Module m : modules) {
            if (m.getIdModule() == id) {
                return m;
            }
        }
        return null;
    }

    public static ArrayList<Module> getAllModules() {
        return modules;
    }
}
