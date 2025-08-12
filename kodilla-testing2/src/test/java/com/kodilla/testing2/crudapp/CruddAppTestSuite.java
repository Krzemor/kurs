package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CruddAppTestSuite {
    private static final String BASE_URL = "https://krzemor.github.io";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(2);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]")); // [12]
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present");
        }
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driverTrello.get(TRELLO_URL);
        Thread.sleep(3000);

        driverTrello.findElement(By.id("username-uid1")).sendKeys("xxx@gmail.com");
        WebElement el = driverTrello.findElement(By.id("login-submit"));
        el.submit();
        Thread.sleep(2000);

        driverTrello.findElement(By.id("password")).sendKeys("xxx");
        driverTrello.findElement(By.id("login-submit")).submit();

        Thread.sleep(4000);

        driverTrello.findElements(By.xpath("//a"))
                .stream()
                .filter(aHref -> driverTrello.findElements(
                        By.xpath("//a[.//span[text()='Kodilla application']]")
                ).contains(aHref))
                .forEach(WebElement::click);

        Thread.sleep(3000);

        result = driverTrello.findElements(By.xpath("//a[@data-testid='card-name']"))
                .stream()
                .anyMatch(theA -> theA.getText().equals(taskName));

        driverTrello.close();

        return result;
    }

    private void cleanUp(String taskName) throws InterruptedException {
        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(2);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[text()='Delete']"));
                    buttonCreateCard.click();
                });
        Thread.sleep(1000);
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        cleanUp(taskName);
    }
}
