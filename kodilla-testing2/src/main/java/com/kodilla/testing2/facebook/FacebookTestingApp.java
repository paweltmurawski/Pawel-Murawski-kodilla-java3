package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_DAY = "//div[contains(@class, \"_5k\")]/span/span/select[1]";
    public static final String XPATH_MONTH= "//div[contains(@class, \"_5k\")]/span/span/select[2]";
    public static final String XPATH_YEAR = "//div[contains(@class, \"_5k\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com");

        while (!driver.findElement(By.xpath(XPATH_DAY)).isDisplayed());
        WebElement daySearch = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(daySearch);
        selectDay.selectByIndex(30);

        while (!driver.findElement(By.xpath(XPATH_MONTH)).isDisplayed());
        WebElement monthSearch = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(monthSearch);
        selectMonth.selectByIndex(6);

        while (!driver.findElement(By.xpath(XPATH_YEAR)).isDisplayed());
        WebElement yearSearch = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(yearSearch);
        selectYear.selectByValue("1985");
    }
}
