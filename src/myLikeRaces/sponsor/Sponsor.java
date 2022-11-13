package myLikeRaces.sponsor;

public class Sponsor {
    private String name;

    private TypeSponsor typeSponsor;

    private double moneySponsor;

    public Sponsor(String name, TypeSponsor typeSponsor, int moneySponsor) {
        this.name = name;
        this.typeSponsor = typeSponsor;
        this.moneySponsor = moneySponsor;
    }

    public String getName() {
        return name;
    }

    public TypeSponsor getTypeSponsor() {
        return typeSponsor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeSponsor(TypeSponsor typeSponsor) {
        this.typeSponsor = typeSponsor;
    }

    public void sponsorRace() {
        System.out.println("Я спонсирую этот заезд");
    }
}
