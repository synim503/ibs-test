package org.ibs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String URL = "http://localhost:8080/food";
    private By buttonAddProduct = By.xpath("//button[@data-toggle='modal']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ProductPage openPage() {
        driver.get(URL);
        return this;
    }

    public PopupProductPage clickButtonAddProduct() {
        WebElement productLink = driver.findElement(buttonAddProduct);
        productLink.click();
        return new PopupProductPage(driver);
    }

    public boolean isProductAddedToTable(String productName, String productType, boolean isExotic) {

        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table']//tbody//tr")));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//td"));

            if (cells.get(1).getText().equals(productType) &&
                    cells.get(0).getText().equals(productName) &&
                    Boolean.parseBoolean(cells.get(2).getText()) == isExotic) {
                return true;
            }
        }


        return false;
    }
}
