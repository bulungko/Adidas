package com.Adidas.pages;

import com.Adidas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdidasPage {
    public AdidasPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    String field = "";

    @FindBy(xpath = "//a[.='Laptops']")
    public WebElement laptops;

    @FindBy(xpath = "//a[.='Sony vaio i5']")
    public WebElement sony;

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCartSony;

    @FindBy(xpath = "//a[.='Dell i7 8gb']")
    public WebElement dell;

    @FindBy(xpath = "//a[@id='cartur']")
    public WebElement cart;

    @FindBy(xpath = "(//a[.='Delete'])[1]")
    public WebElement delete;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrder;



    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchase;

    @FindBy(xpath = "'//button[.=\'OK\']'")
    public WebElement ok;

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement home;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='country']")
    public WebElement country;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='card']")
    public WebElement card;

    @FindBy(xpath = "//input[@id='month']")
    public WebElement month;

    @FindBy(xpath = "//input[@id='year']")
    public WebElement year;

@FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement confirmation;

}
