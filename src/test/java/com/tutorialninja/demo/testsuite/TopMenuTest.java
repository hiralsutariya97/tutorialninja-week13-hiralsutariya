package com.tutorialninja.demo.testsuite;

import com.tutorialninja.demo.pages.TopMenuPage;
import com.tutorialninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    TopMenuPage homePage =new TopMenuPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){

        //1.1 Mouse hover on "Desktops" tab and click
        homePage.mouseHoverOnDesktops();

        //1.2 call selectMenu method and pass the menu = "Show all desktops"
        homePage.selectMenu("Show AllDesktops");

        //1.3 verify the text "Desktops"
        String actualDesktopsText = homePage.verifyDesktopsText();
        Assert.assertEquals(actualDesktopsText,"Desktops","Text not match");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){

        //2.1 Mouse hover on "Laptops & Notebooks" tab and click
        homePage.mouseHoverOnLaptopNotebooks();

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        // 2.3 Verify the text ‘Laptops & Notebooks’
        String actualLaptopNotebooksText = homePage.verifyLaptopNotebooksText();
        Assert.assertEquals(actualLaptopNotebooksText,"Laptops & Notebooks","Text not match");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

        //3.1 Mouse hover on "Components" tab and click
        homePage.mouseHoverOnComponents();

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show AllComponents");

        //3.3 verify the text "Components"
        String actualComponentsText = homePage.verifyComponentsText();
        Assert.assertEquals(actualComponentsText,"Components", "Text not match");
    }
}
