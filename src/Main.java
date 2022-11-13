import exception.ElementAlreadyExistsException;
import model.Passport;
import model.Product;
import model.Recipe;
import myLikeRaces.driver.DriverCategoryA;
import myLikeRaces.driver.DriverCategoryB;
import myLikeRaces.driver.DriverCategoryD;
import myLikeRaces.mechanic.Mechanic;
import myLikeRaces.sponsor.Sponsor;
import myLikeRaces.sponsor.TypeSponsor;
import myLikeRaces.station.ServiceStation;
import myLikeRaces.transport.Bus;
import myLikeRaces.transport.Car;
import myLikeRaces.transport.PassengerCar;
import myLikeRaces.transport.Truck;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        task12();
        System.out.println("--------------------------------------");
        task3();
        System.out.println("--------------------------------------");
        try {
            task4();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------------------------------");
        task5();
        System.out.println("--------------------------------------");
        task6();
    }

    private static void task12() {
        Set<Product> allProducts = new HashSet<>();
        Product product1 = new Product("Бананы", 1200, 2.1f);
        Product product2 = new Product("Яблоки", 400, 3f);
        Product product3 = new Product("Помидоры", 500, 1.2f);
        addNewProduct(allProducts, product1);
        addNewProduct(allProducts, product2);
        addNewProduct(allProducts, product3);

        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe("Фруктовый салат");
        Recipe recipe2 = new Recipe("Овощная нарезка");

        Set<Product> productsForRecipe1 = new HashSet<>();
        addNewProduct(productsForRecipe1, product1);
        addNewProduct(productsForRecipe1, product2);
        recipe1.setProducts(productsForRecipe1);

        Set<Product> productsForRecipe2 = new HashSet<>();
        addNewProduct(productsForRecipe2, product3);
        recipe2.setProducts(productsForRecipe2);

        addNewRecipe(recipes, recipe1);
        addNewRecipe(recipes, recipe2);

        System.out.println(recipes);
    }

    private static void task3() {
        Set<Integer> integers = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            integers.add(random.nextInt(1000));
        }
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer digit = iterator.next();
            if (digit % 2 == 1) {
                iterator.remove();
            }
        }
        System.out.println(integers);
    }

    private static void task4() throws Exception {
        PassengerCar passengerCar = new PassengerCar("bmw", "b2");
        Bus bus = new Bus("bus", "t1");
        Truck truck = new Truck("truck", "d2");

        Sponsor sponsor1 = new Sponsor("Sponsor1", TypeSponsor.COMPANY, 313131);
        Sponsor sponsor2 = new Sponsor("Sponsor2", TypeSponsor.HUMAN, 13141);
        Sponsor sponsor3 = new Sponsor("Sponsor3", TypeSponsor.COMPANY, 1454);
        Sponsor sponsor4 = new Sponsor("Sponsor4", TypeSponsor.COMPANY, 39);

        passengerCar.getSponsorList().add(sponsor1);
        passengerCar.getSponsorList().add(sponsor2);
        passengerCar.getSponsorList().add(sponsor3);

        bus.getSponsorList().add(sponsor4);

        truck.getSponsorList().add(sponsor1);
        truck.getSponsorList().add(sponsor4);

        DriverCategoryA driverCategoryA = new DriverCategoryA("Водитель легковужки", true, 31);
        DriverCategoryB driverCategoryB = new DriverCategoryB("Водитель грузовика", true, 3);
        DriverCategoryD driverCategoryD = new DriverCategoryD("Водитель автобуса", true, 123);

        passengerCar.setDriverCategoryA(driverCategoryA);
        truck.setDriverCategoryB(driverCategoryB);
        bus.setDriverCategoryD(driverCategoryD);

        Mechanic<Car> mechanic = new Mechanic<>("test", "test", "test");
        Mechanic<Bus> mechanic1 = new Mechanic<>("bus", "bus", "BIG BUS");
        passengerCar.getMechanicList().add(mechanic);
        bus.getMechanicList().add(mechanic1);
        bus.getMechanicList().add(mechanic);

        List<Car> listCar = new ArrayList<>();
        listCar.add(passengerCar);
        listCar.add(bus);
        listCar.add(truck);

        Set<Car> carSet = new HashSet<>();
        carSet.addAll(listCar);

        for (Car car : carSet) {
            car.printInfo();
        }

        ServiceStation station = new ServiceStation();
        station.addToQueue(passengerCar);
        station.addToQueue(truck);
        station.carryOutTechnicalInspection();
        station.carryOutTechnicalInspection();
        station.carryOutTechnicalInspection();
    }

    private static void task5() {
        Set<String> solutions = new HashSet<>();
        while (solutions.size() != 15) {
            solutions.add(getRandomSolution());
        }
        System.out.println(solutions);
    }

    private static void task6() {
        Set<Passport> passports = new HashSet<>();
        Passport passport1 = new Passport(8017, "Фамилия", "Имя", "Отчество", "19.08.2003");
        Passport passport2 = new Passport(8017, "ИзменилФамилия", "ИзменилИмя", "Отчество", "19.08.2004");
        Passport passport3 = new Passport(1000, "Иванов", "Иван", "Иванович", "20.01.2001");

        addNewPassport(passport1, passports);
        addNewPassport(passport2, passports);
        addNewPassport(passport3, passports);

        System.out.println(findPassportByNumber(8017, passports));
        System.out.println(findPassportByNumber(1000, passports));
        System.out.println(findPassportByNumber(1001, passports));

        System.out.println(passports);

    }

    private static void addNewPassport(Passport passport, Set<Passport> passports) {
        for (Passport el : passports) {
            if (el.equals(passport)) {
                el.setDateBoth(passport.getDateBoth());
                el.setLastName(passport.getLastName());
                el.setFirstName(passport.getFirstName());
                el.setMiddleName(passport.getMiddleName());
                break;
            }
        }
        passports.add(passport);
    }

    private static Passport findPassportByNumber(int number, Set<Passport> passports) {
        for (Passport passport : passports) {
            if (passport.getNumber() == number) {
                return passport;
            }
        }
        return null;
    }

    private static String getRandomSolution() {
        final int[] digits = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        int first = random.nextInt(8);
        int second = first + random.nextInt(8 - first);
        return digits[first] + "*" + digits[second];
    }

    private static void addNewProduct(Set<Product> allProducts, Product product) {
        if (!allProducts.add(product)) {
            throw new ElementAlreadyExistsException("Нельзя добавлять одинаковые товары");
        }
    }

    private static void addNewRecipe(Set<Recipe> recipes, Recipe recipe) {
        if (!recipes.add(recipe)) {
            throw new ElementAlreadyExistsException("Нельзя добавлять одинаковые товары");
        }
    }
}