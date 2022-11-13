package myLikeRaces.transport;

import myLikeRaces.driver.DriverCategoryA;
import myLikeRaces.mechanic.Mechanic;
import myLikeRaces.sponsor.Sponsor;

import java.util.*;

public class PassengerCar extends Car implements Competitor {

    public enum TypeBody {
        Sedan, Hatchback, Coupe, Universal, SUV, crossover, pickup, Van, Minivan;

        public static void printTypeBody(PassengerCar car) {
            if (car == null || car.getTypeBody() == null) {
                System.out.println("Данных по авто недостаточно.");
                return;
            }
            System.out.println("Тип кузова: " + car.getTypeBody().name());
        }
    }

    private List<Mechanic<? super PassengerCar>> mechanicList = new ArrayList<>();

    private DriverCategoryA driverCategoryA;
    private boolean hasDiagnostic = false;

    private float maxSpeed;
    private float bestLapTime;

    private TypeBody typeBody;

    public PassengerCar(String brand, String model) {
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

    public List<Mechanic<? super PassengerCar>> getMechanicList() {
        return mechanicList;
    }

    public void setMechanicList(List<Mechanic<? super PassengerCar>> mechanicList) {
        this.mechanicList = mechanicList;
    }

    public DriverCategoryA getDriverCategoryA() {
        return driverCategoryA;
    }

    public void setDriverCategoryA(DriverCategoryA driverCategoryA) {
        if (driverCategoryA != null) {
            this.driverCategoryA = driverCategoryA;
            driverCategoryA.setCar(this);
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

    public TypeBody getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(TypeBody typeBody) {
        this.typeBody = typeBody;
    }

    @Override
    public void pitStop() {
        System.out.println("Уходим на отдых");
    }

    @Override
    public void startMove() {
        System.out.println("Быстро стартуем");
    }

    @Override
    public void endMove() {
        System.out.println("Жмем сцепление и тормозим");
    }

    @Override
    public void runDiagnostic() {
        hasDiagnostic = true;
        System.out.println("Пройти диагностику для легкового автомобиля");
    }

    @Override
    public void printInfo() {
        String result = "Имя водителя " + driverCategoryA.getFullName() + ", спонсоры: ";
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
