package com.Adidas.step_definitions;

import com.Adidas.pages.AdidasPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.ConfigurationReader;
import com.Adidas.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;

// #Customer navigation through product categories: Phones, Laptops and Monitors
//    #• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
//    #• Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
//    #• Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
//    #• Click on "Place order".
//    #• Fill in all web form fields.
//    #• Click on "Purchase"
//    #• Capture and log purchase Id and Amount.
//    #• Assert purchase amount equals expected.
//    #• Click on "Ok"

public class Adidas_StepDefinition {
    AdidasPage adidas;

    @Given("user is on the Demobraze home page")
    public void user_is_on_the_demobraze_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("url"));
        BrowserUtils.sleep(1);
    }

    @When("user search Laptop to add Sony vaio i5 to cart")
    public void user_search_laptop_to_add_sony_vaio_i5_to_cart() {
        adidas = new AdidasPage();
        adidas.laptops.click();
        BrowserUtils.sleep(1);
        adidas.sony.click();
        BrowserUtils.sleep(1);
        adidas.addToCartSony.click();
        BrowserUtils.sleep(1);
    }

    @When("user accept pop up confirmation")
    public void user_accept_pop_up_confirmation() {

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(1);
    }

    @When("user search Laptop to add Dell i7 8gb to cart")
    public void user_search_laptop_to_add_dell_i7_8gb_to_cart() {
        adidas.home.click();
        BrowserUtils.sleep(1);
        adidas.laptops.click();
        BrowserUtils.sleep(1);
        adidas.dell.click();
        BrowserUtils.sleep(1);
        adidas.addToCartSony.click();
        BrowserUtils.sleep(2);



    }

    @When("user navigate to cart")
    public void user_navigate_to_cart() {
        adidas.cart.click();
        BrowserUtils.sleep(1);
    }

    @When("user should be able to delete Dell i7 8gb")
    public void user_should_be_able_to_delete_dell_i7_8gb() {
        adidas.delete.click();
        BrowserUtils.sleep(1);
    }


    @When("user click on place order")
    public void user_click_on_place_order() {
        adidas.placeOrder.click();
        BrowserUtils.sleep(1);

    }

    @When("user fill in all web form fields")
    public void user_fill_in_all_web_form_fields() {
        Faker faker = new Faker();
        adidas.name.sendKeys(faker.name().fullName());
        adidas.country.sendKeys(faker.country().name());
        adidas.city.sendKeys(faker.country().capital());
        adidas.card.sendKeys(faker.finance().creditCard());
        adidas.month.sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
        adidas.year.sendKeys(String.valueOf(faker.number().numberBetween(2022, 2030)));
        BrowserUtils.sleep(1);
    }

    @When("user click on purchase")
    public void user_click_on_purchase() {
        adidas.purchase.click();
        BrowserUtils.sleep(1);
    }

    @Then("user should see log purchase Id and Amount")
    public void user_should_see_log_purchase_id_and_amount() {
    String confirmation = adidas.confirmation.getText();
    String [] confirmationArr = confirmation.split("\n");
    String orderID = confirmationArr[0];
    int actualAmount = Integer.parseInt(confirmationArr[1].split(" ")[1]);

        Assert.assertEquals(actualAmount,790);
    }

}
