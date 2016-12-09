package entity;

public class Food {
    private int id;
    private String foodName;
    private String currentlyDate;
    private String endDate;
    private String note;

    public Food(){}

    public Food(int id, String nameFood, String currentlyDate, String endDate, String note) {
        this.id = id;
        this.foodName = nameFood;
        this.currentlyDate = currentlyDate;
        this.endDate = endDate;
        this.note = note;
    }

    public Food(String nameFood, String currentlyDate, String endDate, String note) {
        this.foodName = nameFood;
        this.currentlyDate = currentlyDate;
        this.endDate = endDate;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getCurrentlyDate() {
        return currentlyDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getNote() {
        return note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setCurrentlyDate(String currentlyDate) {
        this.currentlyDate = currentlyDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", currentlyDate='" + currentlyDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}