package model;

public class Vehicle {
    private int id;
    private String userLogin;
    private int userId;
    private String brand;
    private String model;
    private String insertTime;

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Pojazd:{" +
                "id=" + id +
                ", userLogin='" + userLogin + '\'' +
                ", userId=" + userId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", insertTime='" + insertTime + '\'' +
                '}';
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Vehicle(int id, String userLogin, int userId, String brand, String model, String insertTime) {
        this.id = id;
        this.userLogin = userLogin;
        this.userId = userId;
        this.brand = brand;
        this.model = model;
        this.insertTime = insertTime;
    }
}
