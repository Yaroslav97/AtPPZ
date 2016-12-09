package entity;

public class Parameters {
    private int id;
    private int fridgeID;
    private int tFridge;
    private int tFreezer;
    private int defrost;
    private int power;

    public Parameters(int id, int fridgeID, int tFridge, int tFreezer, int defrost, int power) {
        this.id = id;
        this.fridgeID = fridgeID;
        this.tFridge = tFridge;
        this.tFreezer = tFreezer;
        this.defrost = defrost;
        this.power = power;
    }

    public Parameters(int fridgeID, int tFridge, int tFreezer, int defrost, int power) {
        this.fridgeID = fridgeID;
        this.tFridge = tFridge;
        this.tFreezer = tFreezer;
        this.defrost = defrost;
        this.power = power;
    }

    public Parameters() {
    }

    public int getId() {
        return id;
    }

    public int getFridgeID() {
        return fridgeID;
    }

    public int gettFridge() {
        return tFridge;
    }

    public int gettFreezer() {
        return tFreezer;
    }

    public int getDefrost() {
        return defrost;
    }

    public int getPower() {
        return power;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFridgeID(int fridgeID) {
        this.fridgeID = fridgeID;
    }

    public void settFridge(int tFridge) {
        this.tFridge = tFridge;
    }

    public void settFreezer(int tFreezer) {
        this.tFreezer = tFreezer;
    }

    public void setDefrost(int defrost) {
        this.defrost = defrost;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
