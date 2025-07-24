package org.tests;

import org.base.BaseTest;
import org.pages.CartPage;
import org.pages.CheckoutPage;
import org.pages.LoginPage;
import org.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    @Test
    public void completeCheckoutFlow() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addProductToCart("Sauce Labs Bike Light");
        products.openCart();

        CartPage cart = new CartPage(driver);
        cart.proceedToCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterShippingDetails("John", "Doe", "12345");
        checkout.completeOrder();

        Assert.assertEquals(checkout.getConfirmationMessage(), "Thank you for your order!");
    }
}

