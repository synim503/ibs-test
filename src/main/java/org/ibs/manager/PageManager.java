package org.ibs.manager;

import org.ibs.pages.PopupProductPage;
import org.ibs.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
    private ProductPage productPage;
    private PopupProductPage popupProductPage;

    public PageManager(WebDriver webDriver) {
        this.productPage = new ProductPage(webDriver);
        this.popupProductPage = new PopupProductPage(webDriver);
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public PopupProductPage getPopupProductPage() {
        return popupProductPage;
    }
}
