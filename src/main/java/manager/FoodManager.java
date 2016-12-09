package manager;

import entity.Food;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

public class FoodManager {

    private static final Map<String, Food> foods = new Hashtable<>();

    public void removeFood(String login) {
        foods.remove(login);
    }

    public Food getNameFood(String foodName) {
        return foods.get(foodName);
    }

    public void getListFullName() {
        for (Map.Entry<String, Food> item : foods.entrySet()) {
            System.out.printf("Value: %s \n", item.getValue().getFoodName());
        }
    }

    public String fullName(String foodName) {
        return foods.get(foodName).getFoodName();
    }

    public int fridgeID (String foodName){
        return foods.get(foodName).getId();
    }

    public boolean existUser(String login) {
        if (foods.containsKey(login)) {
            return true;
        }
        return false;
    }

    public Food setUser(String nameFood, String currentlyDate, String endDate, String note) {
        return foods.put(nameFood, new Food(nameFood, currentlyDate, endDate, note));
    }

    public Collection<Food> getList() {
        return foods.values();
    }
}