package org.tests;


import org.base.BaseTest;
import org.pages.CartPage;
import org.pages.CheckoutPage;
import org.pages.EdgePage;
import org.pages.LoginPage;
import org.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EdgeCaseTests extends BaseTest {
    @Test
    public void checkoutWithEmptyCart() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.openCart();

        CartPage cart = new CartPage(driver);
        cart.proceedToCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterShippingDetails("Test", "User", "00000");
        checkout.completeOrder();

        Assert.assertEquals(checkout.getConfirmationMessage(), "Thank you for your order!");
    }

    @Test
    public void responsiveUITest() {
        EdgePage edge = new EdgePage(driver);
        edge.resizeWindow(375, 667);
        Assert.assertTrue(edge.isLoginButtonVisible());
    }
}