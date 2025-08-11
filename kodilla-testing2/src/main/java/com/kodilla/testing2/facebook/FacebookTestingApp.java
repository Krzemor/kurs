package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "/html/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]";
    public static final String XPATH_CREATE_ACC = "//*[@data-testid=\"open-registration-form-button\"]";
    public static final String XPATH_NAME = "//*[@aria-label=\"Imię\"]";
    public static final String XPATH_SURNAME = "//*[@aria-label=\"Nazwisko\"]";
    public static final String XPATH_DAY = "//*[@id=\"day\"]";
    public static final String XPATH_MONTH = "//*[@id=\"month\"]";
    public static final String XPATH_YEAR = "//*[@id=\"year\"]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://facebook.com/");

        driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(XPATH_CREATE_ACC)).click();

        WebElement nameField = driver.findElement(By.xpath(XPATH_NAME));
        nameField.sendKeys("Janusz");

        WebElement surnameField = driver.findElement(By.xpath(XPATH_SURNAME));
        surnameField.sendKeys("Kowalski");

        WebElement selectDay = driver.findElement(By.xpath(XPATH_DAY));
        Select daySelect = new Select(selectDay);
        daySelect.selectByValue("5");

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select monthSelect = new Select(selectMonth);
        monthSelect.selectByValue("12");

        WebElement selectYear = driver.findElement(By.xpath(XPATH_YEAR));
        Select yearSelect = new Select(selectYear);
        yearSelect.selectByValue("1970");

    }
}
