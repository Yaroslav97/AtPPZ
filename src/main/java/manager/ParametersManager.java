package manager;

import entity.Parameters;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

public class ParametersManager {
    private static final Map<Integer, Parameters> fridgeParameters = new Hashtable<>();

    public void remove(Integer login) {
        fridgeParameters.remove(login);
    }

    public Parameters fridgeID(Integer login) {
        return fridgeParameters.get(login);
    }

    public int tFridge(int fridgeID){
        return fridgeParameters.get(fridgeID).gettFridge();
    }

    public int tFreezer(int fridgeID){
        return fridgeParameters.get(fridgeID).gettFreezer();
    }
    
    public boolean existFridgeID(Integer fridgeID) {
        if (fridgeParameters.containsKey(fridgeID)) {
            return true;
        }
        return false;
    }

    public boolean power(Integer login) {
        if (fridgeParameters.get(login).getPower() == 1) {
            return true;
        }
        return false;
    }

    public boolean defrost(Integer login) {
        if (fridgeParameters.get(login).getDefrost() == 1) {
            return true;
        }
        return false;
    }

    public Parameters setUser(int fridgeID, int tFridge, int tFreezer, int defrost, int power) {
        return fridgeParameters.put(fridgeID, new Parameters(fridgeID, tFridge, tFreezer, defrost, power));
    }

    public Collection<Parameters> getList() {
        return fridgeParameters.values();
    }
}