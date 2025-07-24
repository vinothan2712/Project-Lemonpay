package org.tests;

import org.base.BaseTest;
import org.pages.LoginPage;
import org.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductFilterTests extends BaseTest {
    @Test
    public void sortProductsLowToHigh() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        ProductsPage products = new ProductsPage(driver);
        products.sortByLowToHigh();
        Assert.assertTrue(products.isSortedLowToHigh());
    }
}
