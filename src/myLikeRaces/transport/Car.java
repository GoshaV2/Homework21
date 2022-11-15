package myLikeRaces.transport;

import myLikeRaces.sponsor.Sponsor;

import java.util.ArrayList;
import java.util.List;

public abstract class Car extends Transport {
    private float volumeEngine;
    private List<Sponsor> sponsorList = new ArrayList<>();


    public Car(String brand, String model) {
        super(brand, model);
    }

    public float getVolumeEngine() {
        return volumeEngine;
    }

    public void setVolumeEngine(float volumeEngine) {
        this.volumeEngine = valueOrDefault(volumeEngine);
    }

    public List<Sponsor> getSponsorList() {
        return sponsorList;
    }

    public void setSponsorList(List<Sponsor> sponsorList) {
        this.sponsorList = sponsorList;
    }

    public abstract void startMove();

    public abstract void endMove();

    public abstract void hasDiagnostic() throws Exception;

    public abstract void runDiagnostic();

    public abstract void printInfo();

    @Override
    public String toString() {
        return "Car{" +
                "volumeEngine='" + getBrand() + '\'' +
                "volumeEngine=" + getModel() + '\'' +
                "volumeEngine=" + volumeEngine + '\'' +
                '}';
    }
}