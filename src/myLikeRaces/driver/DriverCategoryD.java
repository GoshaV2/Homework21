package myLikeRaces.driver;

import myLikeRaces.transport.Bus;

public class DriverCategoryD extends Driver<Bus> {
    public DriverCategoryD(String fullName, boolean hasDriverLicense, int drivingExperienceYears) throws Exception {
        super(fullName, hasDriverLicense, drivingExperienceYears);
    }

    @Override
    public void startMove() {
        car.startMove();
    }

    @Override
    public void endMove() {
        car.endMove();
    }

    @Override
    public void refill() {
        System.out.println("Заправить " + car.getBrand() + " " + car.getModel());
    }

}
