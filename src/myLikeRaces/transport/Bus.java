package myLikeRaces.transport;

import myLikeRaces.driver.DriverCategoryD;
import myLikeRaces.mechanic.Mechanic;
import myLikeRaces.sponsor.Sponsor;

import java.lang.invoke.WrongMethodTypeException;
import java.util.*;

public class Bus extends Car implements Competitor {
    public enum TypeCapacity {
        ExtraSmall("до 10 мест"), Small("до 25 мест"), Medium("40-50 мест"), Large("60-80 мест"), EspeciallyLarge("100-120 мест");

        private String description;

        TypeCapacity(String description) {
            this.description = description;
        }

        public String getNameType() {
            return description;
        }
    }

    private List<Mechanic<? super Bus>> mechanicList = new ArrayList<>();


    private DriverCategoryD driverCategoryD;

    private float maxSpeed;
    private float bestLapTime;

    private TypeCapacity typeCapacity;

    public Bus(String brand, String model) {
        super(brand, model);
    }

    public DriverCategoryD getDriverCategoryD() {
        return driverCategoryD;
    }

    public void setDriverCategoryD(DriverCategoryD driverCategoryD) {
        if (driverCategoryD != null) {
            this.driverCategoryD = driverCategoryD;
            driverCategoryD.setCar(this);
        }
    }

    public List<Mechanic<? super Bus>> getMechanicList() {
        return mechanicList;
    }

    public void setMechanicList(List<Mechanic<? super Bus>> mechanicList) {
        this.mechanicList = mechanicList;
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

    public TypeCapacity getTypeCapacity() {
        return typeCapacity;
    }

    public void setTypeCapacity(TypeCapacity typeCapacity) {
        this.typeCapacity = typeCapacity;
    }

    @Override
    public void pitStop() {
        System.out.println("Высаживаем всех и на боковую");
    }

    @Override
    public void startMove() {
        System.out.println("Закрыть двери и погнали");
    }

    @Override
    public void endMove() {
        System.out.println("Остановится и открыть двери");
    }

    @Override
    public void hasDiagnostic() throws Exception {
        throw new Exception("Автобус " + getBrand() + " " + getModel() + " в диагностике не требуется");
    }

    @Override
    public void runDiagnostic() {
        throw new WrongMethodTypeException("Автобусы не могут проходить диагностику");
    }

    @Override
    public void printInfo() {
        String result = "Имя водителя " + driverCategoryD.getFullName() + ", спонсоры: ";
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
