package org.tests;

import org.base.BaseTest;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.login("wrong_user", "wrong_pass");
        Assert.assertTrue(login.getErrorMessage().contains("Username and password"));
    }
}
