package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static tests.BaseTest.driver;
import static tests.BaseTest.wdWait;

public class DemoQA {

    public static String searchFor = "demoqa.com";

    public static void goToDemoQA(){
        BaseHelper.google();
        driver.findElement(By.name("q")).sendKeys(searchFor, Keys.ENTER);
        BaseHelper.loggerMethod(driver.getCurrentUrl());
        driver.findElements(By.tagName("h3")).get(0).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void droppableLink(){
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[5]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[5]/div/ul/li[4]/span")).click();


        //Drag&Drop
        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();

        //Printing required text from droppable element
        System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/p")).getText());

        //Calling method to take a screenshot
        BaseHelper.takeScreenshot("Drag&Drop");
    }

    public static void toolTips() {
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[4]/span/div")).click();

        //Scroll to element so it can be clicked
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[7]/span")));

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[7]/span")).click();

        //Hover action over input field making tooltip visible
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("toolTipTextField"))).perform();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("textFieldToolTip")));

        //Printing out tooltip text
        System.out.println(driver.findElement(By.id("textFieldToolTip")).getText());

    }
}
