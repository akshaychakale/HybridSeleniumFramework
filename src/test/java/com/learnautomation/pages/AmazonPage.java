package com.learnautomation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonPage {
    @FindBy(css="input[id='twotabsearchtextbox']")
    WebElement searchBox;

    @FindBy(css="[class='a-section a-spacing-none'] img")
    List<WebElement> bookList;

    @FindBy(css="input[id='add-to-cart-button']")
    WebElement addToCartButton;

    @FindBy(css="a[id='hlb-view-cart-announce']")
    WebElement cart;




    public void searchBooks(String bookName) {
        searchBox.sendKeys(bookName);
    }

    public void selectDropdownOption() {
        searchBox.sendKeys(Keys.ARROW_DOWN);
        searchBox.sendKeys(Keys.ENTER);

    }

    public void selectBook() {
        bookList.get(0).click();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void openCart() {
        cart.click();
    }
}
