package model;

import exception.NotFieldOutCompletelyException;

public class Product {
    private String name;
    private float cost;
    private float weight;

    private boolean isBought;

    public Product(String name, float cost, float weight){
        if (name == null || name.isBlank() || cost <= 0 || weight <= 0) {
            throw new NotFieldOutCompletelyException("Заполните карточку товара полностью");
        }
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        if (name == null || name.isBlank()) {
            throw new NotFieldOutCompletelyException("Заполните карточку товара полностью");
        }
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost){
        if (cost <= 0) {
            throw new NotFieldOutCompletelyException("Заполните карточку товара полностью");
        }
        this.cost = cost;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight){
        if (weight <= 0) {
            throw new NotFieldOutCompletelyException("Заполните карточку товара полностью");
        }
        this.weight = weight;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", isBought=" + isBought +
                '}';
    }
}
