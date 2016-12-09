package manager;

import entity.Fridge;

import java.util.*;

public class FridgeManager {
    private static final Map<String, Fridge> fridges = new Hashtable<>();

    public void removeUser(String login) {
        fridges.remove(login);
    }

    public Fridge getLogin(String login) {
        return fridges.get(login);
    }

    public void getListFullName() {
        for (Map.Entry<String, Fridge> item : fridges.entrySet()) {
            System.out.printf("Value: %s \n", item.getValue().getFullName());
        }
    }

    public String fullName(String login) {
        return fridges.get(login).getFullName();
    }

    public int fridgeID (String login){
        return fridges.get(login).getIdFridge();
    }

    public boolean existLogin(String login) {
        if (fridges.containsKey(login)) {
            return true;
        }
        return false;
    }

    public String getEmail(String login) {
        return fridges.get(login).getEmail();
    }

    public Fridge setUser(int idFridge, String fullName, String login, String email, String password) {
        return fridges.put(login, new Fridge(idFridge, fullName, login, email, password));
    }

    public Collection<Fridge> getList() {
        return fridges.values();
    }
}