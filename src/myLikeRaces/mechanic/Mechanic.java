package myLikeRaces.mechanic;

import myLikeRaces.transport.Car;

public class Mechanic<T extends Car> {
    private String name;
    private String surname;
    private String companyName;

    public Mechanic(String name, String surname, String companyName) {
        this.name = name;
        this.surname = surname;
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void carryOutMaintence(){
        System.out.println("Провожу техобслуживание");
    }
}
