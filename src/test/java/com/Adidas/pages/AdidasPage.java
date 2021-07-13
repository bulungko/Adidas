package com.Adidas.pages;

import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdidasPage {
    AdidasPage adidas;
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


public void addSony() {
    adidas = new AdidasPage();
    adidas.laptops.click();
    BrowserUtils.sleep(1);
    adidas.sony.click();
    BrowserUtils.sleep(1);
    adidas.addToCartSony.click();
    BrowserUtils.sleep(1);
}

public void  acceptAlert(){
    Alert alert = Driver.getDriver().switchTo().alert();
    alert.accept();
    BrowserUtils.sleep(1);
    }

    public void addDell() {
        adidas.home.click();
        BrowserUtils.sleep(1);
        adidas.laptops.click();
        BrowserUtils.sleep(1);
        adidas.dell.click();
        BrowserUtils.sleep(1);
        adidas.addToCartSony.click();
        BrowserUtils.sleep(2);
    }

    public void fillWithJavaFaker() {
        Faker faker = new Faker();
        adidas.name.sendKeys(faker.name().fullName());
        adidas.country.sendKeys(faker.country().name());
        adidas.city.sendKeys(faker.country().capital());
        adidas.card.sendKeys(faker.finance().creditCard());
        adidas.month.sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
        adidas.year.sendKeys(String.valueOf(faker.number().numberBetween(2022, 2030)));
        BrowserUtils.sleep(1);
    }

    public void confirmIDAndAmount() {
        String confirmation = adidas.confirmation.getText();
        String [] confirmationArr = confirmation.split("\n");
        String orderID = confirmationArr[0];
        int actualAmount = Integer.parseInt(confirmationArr[1].split(" ")[1]);

        Assert.assertEquals(actualAmount,790);
    }

}
