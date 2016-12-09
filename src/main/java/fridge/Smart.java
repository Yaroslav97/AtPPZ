package fridge;

public class Smart {
    private String id;
    private String power;
    private String defrost;
    private String temperatureFridge;
    private String temperatureFreezer;

    public Smart(String id, String power, String defrost, String temperatureFridge, String temperatureFreezer) {
        this.id = id;
        this.power = power;
        this.defrost = defrost;
        this.temperatureFridge = temperatureFridge;
        this.temperatureFreezer = temperatureFreezer;
    }

    public String getId() {
        return id;
    }

    public String getPower() {
        return power;
    }

    public String getDefrost() {
        return defrost;
    }

    public String getTemperatureFridge() {
        return temperatureFridge;
    }

    public String getTemperatureFreezer() {
        return temperatureFreezer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setDefrost(String defrost) {
        this.defrost = defrost;
    }

    public void setTemperatureFridge(String temperatureFridge) {
        this.temperatureFridge = temperatureFridge;
    }

    public void setTemperatureFreezer(String temperatureFreezer) {
        this.temperatureFreezer = temperatureFreezer;
    }

    @Override
    public String toString() {
        return "Smart{" +
                "id='" + id + '\'' +
                ", power='" + power + '\'' +
                ", defrost='" + defrost + '\'' +
                ", temperatureFridge='" + temperatureFridge + '\'' +
                ", temperatureFreezer='" + temperatureFreezer + '\'' +
                '}';
    }
}