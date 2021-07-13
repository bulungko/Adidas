package com.Adidas.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /**
     * Creating private constructor so this class's object is not reachable from outside
     */
    private Driver() {

    }

    /**
     * Making our 'driver' instance private so that it is not reachable from outside of the class.
     * We make it static, because we want it run before everything else. and also we will use it in a static method
     */
    private static WebDriver driver;

    /**
     *Creating re-usable utility method that will return same'driver' instance everytime we call it.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigurationReader.getProperties("browser");

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    // driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        }
        return driver;
    }

    /*
    This method makes sure we have some form of driver session or driver id has. Either null or not null it must exist.
     */
    public static void closeDriver() {
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}




