package org.ibs.ui;

import org.ibs.manager.DriverManager;
import org.ibs.manager.PageManager;
import org.ibs.pages.PopupProductPage;
import org.ibs.pages.ProductPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPageTest {
    private PageManager pageManager;

    @BeforeEach
    void startBrowser() {
        this.pageManager = new PageManager(DriverManager.getDriverManager().getDriver());
    }
    @Test
    void addProductTestOne() {
        String productName = "Манго";
        PopupProductPage.TypeProduct typeProduct = PopupProductPage.TypeProduct.FRUIT;
        boolean isExotic = true;
        pageManager
                .getProductPage()
                .openPage()
                .clickButtonAddProduct()
                .setInFieldProductName(productName)
                .selectTypeProduct(typeProduct)
                .turnExoticCheckBox(isExotic)
                .clickButtonSaveProduct()
                .openPage();


        assertTrue(pageManager.getProductPage().isProductAddedToTable(productName,typeProduct.getDescr(),isExotic));

    }

    @Test
    void addProductTestTwo() {
        String productName = "Морковь";
        PopupProductPage.TypeProduct typeProduct = PopupProductPage.TypeProduct.VEGETABLE;
        boolean isExotic = false;
        pageManager
                .getProductPage()
                .openPage()
                .clickButtonAddProduct()
                .setInFieldProductName(productName)
                .selectTypeProduct(typeProduct)
                .turnExoticCheckBox(isExotic)
                .clickButtonSaveProduct()
                .openPage();


        assertTrue(pageManager.getProductPage().isProductAddedToTable(productName,typeProduct.getDescr(),isExotic));

    }
    @AfterEach
    void stopBrowser() {
       DriverManager.getDriverManager().quitDriver();
    }




}
