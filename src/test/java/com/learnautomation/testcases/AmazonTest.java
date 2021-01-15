package com.learnautomation.testcases;

import com.learnautomation.pages.AmazonPage;
import com.learnautomation.pages.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class AmazonTest extends BaseClass {

    @Test
    public void amazonTest(){
        logger=reports.createTest("THe Amazon Application started");
        AmazonPage homePage=new AmazonPage();
        homePage= PageFactory.initElements(driver,AmazonPage.class);

        homePage.searchBooks("harry potter books");
        homePage.selectDropdownOption();
        homePage.selectBook();


        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);

        homePage.addToCart();
        homePage.openCart();
    }
}
