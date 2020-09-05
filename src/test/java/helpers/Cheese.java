package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static tests.BaseTest.driver;

public class Cheese {
    public static int countCheese(){
        BaseHelper.google();
        driver.findElement(By.name("q")).sendKeys("cheese", Keys.ENTER);
        System.out.println(driver.findElements(By.className("s")).size());
        return driver.findElements(By.className("s")).size();
    }
}
