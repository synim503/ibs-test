package org.ibs.repository;

import org.ibs.pages.PopupProductPage;

import java.util.Objects;

public class Food {
    private Long id;
    private String foodName;
    private String typeProduct;
    private Integer foodExotic;

    public Food(Long id, String foodName, String typeProduct, Integer foodExotic) {
        this.id = id;
        this.foodName = foodName;
        this.typeProduct = typeProduct;
        this.foodExotic = foodExotic;
    }
    public Food( String foodName, String typeProduct) {
        this.foodName = foodName;
        this.typeProduct = typeProduct;
    }
    public Food(String foodName, String typeProduct, Integer foodExotic) {
        this.foodName = foodName;
        this.typeProduct = typeProduct;
        this.foodExotic = foodExotic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(foodName, food.foodName) &&
                Objects.equals(typeProduct, food.typeProduct) &&
                Objects.equals(foodExotic, food.foodExotic);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Integer getFoodExotic() {
        return foodExotic;
    }

    public void setFoodExotic(Integer foodExotic) {
        this.foodExotic = foodExotic;
    }
}
