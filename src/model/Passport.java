package model;

public class Passport {
    private int number;
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateBoth;

    public Passport(int number, String lastName, String firstName, String middleName, String dateBoth) {
        this.number = number;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateBoth = dateBoth;
    }

    public int getNumber() {
        return number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateBoth() {
        return dateBoth;
    }

    public void setDateBoth(String dateBoth) {
        this.dateBoth = dateBoth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport)) return false;

        Passport passport = (Passport) o;

        return number == passport.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "number=" + number +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateBoth='" + dateBoth + '\'' +
                '}';
    }
}
