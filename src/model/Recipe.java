package model;

import exception.NotFieldOutCompletelyException;

import java.util.Set;

public class Recipe {
    private Set<Product> products;
    private float totalAmount;
    private String nameRecipe;

    public Recipe(String nameRecipe) {
        if(nameRecipe==null && nameRecipe.isBlank()){
            throw new NotFieldOutCompletelyException("Укажите корректное название");
        }
        this.nameRecipe = nameRecipe;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public float getTotalAmount() {
        totalAmount = 0;
        for (Product product :
                products) {
            totalAmount += product.getCost();
        }
        return totalAmount;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;

        Recipe recipe = (Recipe) o;

        return nameRecipe.equals(recipe.nameRecipe);
    }

    @Override
    public int hashCode() {
        return nameRecipe.hashCode();
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "products=" + products +
                ", totalAmount=" + totalAmount +
                ", nameRecipe='" + nameRecipe + '\'' +
                '}';
    }
}
