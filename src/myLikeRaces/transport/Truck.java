package myLikeRaces.transport;

import myLikeRaces.driver.DriverCategoryB;
import myLikeRaces.mechanic.Mechanic;
import myLikeRaces.sponsor.Sponsor;

import java.util.*;

public class Truck extends Car implements Competitor {
    public enum TypeLoadCapacity {
        N1("с полной массой до 3,5 тонн"), N2("с полной массой свыше 3,5 до 12 тонн"), N3("с полной массой свыше 12 тонн");
        private String description;

        TypeLoadCapacity(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private List<Mechanic<? super Truck>> mechanicList = new ArrayList<>();
    private DriverCategoryB driverCategoryB;
    private boolean hasDiagnostic = false;
    private float maxSpeed;
    private float bestLapTime;

    private TypeLoadCapacity typeLoadCapacity;

    public Truck(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void hasDiagnostic() throws Exception {
        if (hasDiagnostic) {
            System.out.println(getBrand() + " " + getModel() + " прошел диагностику");
        } else {
            throw new Exception(getBrand() + " " + getModel() + "не прошел диагностику");
        }
    }

    public DriverCategoryB getDriverCategoryB() {
        return driverCategoryB;
    }

    public List<Mechanic<? super Truck>> getMechanicList() {
        return mechanicList;
    }

    public void setMechanicList(List<Mechanic<? super Truck>> mechanicList) {
        this.mechanicList = mechanicList;
    }

    public void setDriverCategoryB(DriverCategoryB driverCategoryB) {
        if (driverCategoryB != null) {
            this.driverCategoryB = driverCategoryB;
            driverCategoryB.setCar(this);
        }
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed < 0 ? 0 : maxSpeed;
    }

    public float getBestLapTime() {
        return bestLapTime;
    }

    public void setBestLapTime(float bestLapTime) {
        this.bestLapTime = bestLapTime < 0 ? 0 : bestLapTime;
    }

    public TypeLoadCapacity getTypeLoadCapacity() {
        return typeLoadCapacity;
    }

    public void setTypeLoadCapacity(TypeLoadCapacity typeLoadCapacity) {
        this.typeLoadCapacity = typeLoadCapacity;
    }

    @Override
    public void pitStop() {
        System.out.println("Чистим копот и ремонтируемся");
    }

    @Override
    public void startMove() {
        System.out.println("Смотрим на дорогу и стартуем");
    }

    @Override
    public void endMove() {
        System.out.println("Дрифтом завершаем движение");
    }

    @Override
    public void runDiagnostic() {
        hasDiagnostic = true;
        System.out.println("Пройти диагностику у грузовика");
    }

    @Override
    public void printInfo() {
        String result = "Имя водителя " + driverCategoryB.getFullName() + ", спонсоры: ";
        Set<Sponsor> sponsors=new HashSet<>();
        sponsors.addAll(getSponsorList());
        for (Sponsor sponsor : sponsors
        ) {
            result += sponsor.getName() + ", ";
        }
        result += "механики: ";
        Set<Mechanic> mechanics=new HashSet<>();
        mechanics.addAll(getMechanicList());
        for (Mechanic mechanic : mechanics) {
            result += mechanic.getName() + (getMechanicList().lastIndexOf(mechanic) == getMechanicList().size() - 1 ? "." : ",");
        }
        System.out.println(result);
    }
}
