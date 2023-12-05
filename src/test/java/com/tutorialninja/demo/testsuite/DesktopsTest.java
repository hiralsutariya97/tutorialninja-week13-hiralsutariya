package com.tutorialninja.demo.testsuite;

import com.tutorialninja.demo.pages.DesktopsPage;
import com.tutorialninja.demo.pages.TopMenuPage;
import com.tutorialninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {

    TopMenuPage topMenuPage = new TopMenuPage();
    DesktopsPage desktopsPage = new DesktopsPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        //1.1 Mouse Hover On desktops tab and click
        topMenuPage.mouseHoverOnDesktops();

        //1.2 click on "Show all desktops"
        topMenuPage.selectMenu("Show AllDesktops");

        //Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);

        //Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        //1.3 Select sort by position "Name: Z to A"
        desktopsPage.clickOnSortBy("Name(Z - A)");

        //After filter Z - A get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZtoAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZtoAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZtoAProductsName);

        //1.4 Verify the product will arrange in descending order
        Assert.assertEquals(originalProductsName, afterSortByZtoAProductsName);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //Select currency as £ Pound Sterling
        desktopsPage.clickOnCurrency();
        desktopsPage.selectPondSterling();

        //2.1 Mouse Hover on desktops tab and click
        topMenuPage.mouseHoverOnDesktops();

        //2.2 Click on  “Show AllDesktops”
        topMenuPage.selectMenu("Show AllDesktops");

        //2.3 select sort by position "Name : A to Z"
        Thread.sleep(2000);
        desktopsPage.clickOnSortBy("Name (A - Z)");

        //2.4 Select product “HP LP3065”
        desktopsPage.clickOnProduct();

        //2.5 Verify the Text "HP LP3065"
        String actualText = desktopsPage.verifyProductText();
        Assert.assertEquals(actualText, "HP LP3065", "text not match");

        //2.6 Select Delivery Date "2022-11-30"
        desktopsPage.datePicker();

        //2.7.Enter Qty "1” using Select class.

        //2.8 Click on “Add to Cart” button
        desktopsPage.clickOnAddToCart();

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(2000);
        String actualMessage = desktopsPage.verifyTheSuccessMessage();
        Assert.assertEquals(actualMessage, "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", "message not match");

        //2.10 click on link "Shopping Cart" display into success message
        desktopsPage.clickOnShoppingCart();

        //2.11 verify the text "Shopping Cart"
        String actualShoppingCartText = desktopsPage.verifyShoppingCartText();
        Assert.assertEquals(actualShoppingCartText, "Shopping Cart  (1.00kg)", "Text is not match");

        //2.12 verify the product name "HP LP3065"
        String actualProductName = desktopsPage.verifyProductName();
        Assert.assertEquals(actualProductName, "HP LP3065", "Product name is not match");

        //2.13 verify the delivery date "2022-11-30"
        Thread.sleep(2000);
        String actualDeliveryDate = desktopsPage.verifyTheDeliveryDate();
        Assert.assertEquals(actualDeliveryDate, "Delivery Date:2023-11-30", "Delivery date is not match");

        //2.14 verify the model "Product21"
        Thread.sleep(2000);
        String actualModelName = desktopsPage.verifyTheModelName();
        Assert.assertEquals(actualModelName, "Product 21", "Model name is not match");

        //2.15 verify the total "£74.73"
        String actualTotalAmount = desktopsPage.verifyTheTotalAmount();
        Assert.assertEquals(actualTotalAmount, "£74.73", "Total amount is not match");
    }
}
