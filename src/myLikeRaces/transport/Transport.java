package myLikeRaces.transport;

public abstract class Transport {
    private String brand;
    private String model;

    private float maxSpeed;
    private float bestLapTime;

    public Transport(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }


    protected String valueOrDefault(String el) {
        if (el == null || el.isBlank()) {
            return "default";
        } else {
            return el;
        }
    }

    protected float valueOrDefault(float el) {
        if (el < 1) {
            return 5;
        } else {
            return el;
        }
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}