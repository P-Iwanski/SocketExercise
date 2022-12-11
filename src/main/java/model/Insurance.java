package model;

public class Insurance {
    private int id;
    private int vehicleId;
    private String insurer;
    private float price;
    private String insertTime;

    public Insurance(int id, int vehicleId, String insurer, float price, String insertTime) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.insurer = insurer;
        this.price = price;
        this.insertTime = insertTime;
    }

    public Insurance() {
    }

    @Override
    public String toString() {
        return "Oferta Ubezpieczenia dla pojazdu " + "Id=" + vehicleId +"{" +
                "insurer='" + insurer + '\'' +
                ", price=" + price +
                ", insertTime='" + insertTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }
}
