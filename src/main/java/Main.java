import managerDB.DBFridgeParameterManager;
import util.Password;
import managerDB.DBFridgeManager;

public class Main {
    public static void main(String[] args) {

        DBFridgeManager dbFridgeManager = new DBFridgeManager();
        /*System.out.println(dbFridgeManager.getAllList());

        System.out.println();
        System.out.println();
        System.out.println();

        //dbFridgeManager.add(4436, "Yaroslav", "smart", "yaroslav@nure.ua", Password.encodePassword("pass"));

        System.out.println();

        System.out.println(dbFridgeManager.getAllList());

        dbFridgeManager.edit(4436, "Yaroslav Poliakov", "yaroslav", "yaroslav@nure.ua", Password.encodePassword("pass"));

        System.out.println();

        System.out.println(dbFridgeManager.getAllList());
*/

        //dbFridgeManager.editPassword("pass", "vyvyvjh", "ibubub@d");
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        /*DBFoodManager dbFoodManager = new DBFoodManager();

        dbFoodManager.add("apple", "", "", "e");

        dbFoodManager.getAllList();*/

        /*Smart smart = new Smart(3748, 4);
        System.out.println(smart);*/

        dbFridgeManager.getAllList();

        dbFridgeManager.editPassword("pass", "yaroslav","poliakov.yaroslav@gmail.com");
        //dbFridgeManager.editProfile("vyvyvjh", "name", "name@n", "pass");

        DBFridgeParameterManager dbFridgeParameterManager = new DBFridgeParameterManager();
        //dbFridgeParameterManager.fridgeID(44);
    }
}