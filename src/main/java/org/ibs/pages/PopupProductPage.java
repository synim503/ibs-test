package org.ibs.pages;

import org.ibs.manager.PageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopupProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PopupProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public enum TypeProduct{
        FRUIT("Фрукт"), VEGETABLE("Овощ");
        private String descr;
        TypeProduct(String name) {
            this.descr = name;
        }

        public String getDescr() {
            return descr;
        }
    }
    public PopupProductPage setInFieldProductName(String productName){
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        nameField.sendKeys(productName);
        return this;
    }

    public PopupProductPage selectTypeProduct(TypeProduct typeProduct){
        WebElement typeDropdown = driver.findElement(By.id("type"));
        Select selectType = new Select(typeDropdown);
        selectType.selectByValue(typeProduct.name());
        return this;
    }

    public PopupProductPage turnExoticCheckBox(Boolean isExotic){
        if(isExotic){
            WebElement checkBoxExotic = driver.findElement(By.id("exotic"));
            checkBoxExotic.click();
        }
        return this;
    }

    public ProductPage clickButtonSaveProduct() {
        WebElement productLink = driver.findElement(By.id("save"));
        productLink.click();
        return new ProductPage(driver);
    }


}
