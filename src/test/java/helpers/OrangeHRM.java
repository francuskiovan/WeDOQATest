package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static tests.BaseTest.driver;
import static tests.BaseTest.wdWait;

public class OrangeHRM {
    public static String url = "https://orangehrm-demo-6x.orangehrmlive.com/";
    public static int rowCount;
    public static int newRowCount;

    //Method used for counting rows of table/ candidates
    static int countCandidates(){
        return driver.findElements(By.cssSelector("tr.dataDefaultRaw")).size();
    }

    public static void logInOrangeHRM(){
        driver.get(url);
        driver.findElement(By.id("btnLogin")).click();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("right-side")));
    }

    public static void addCandidate() {
        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_recruitment_viewCandidates")));
        driver.findElement(By.id("menu_recruitment_viewCandidates")).click();

        //I had to switch the frame, otherwise Selenium couldn't find elements
        driver.switchTo().frame(0);

        //Count Candidates
        rowCount = countCandidates();
        System.out.println("Total Number of Rows = " + rowCount);

        //Click add btn
        driver.findElement(By.cssSelector("#list_item_add")).click();

        //Filling the Form
        wdWait.until(ExpectedConditions.visibilityOfElementLocated((By.id("modalAddCandidate"))));
        driver.findElement(By.id("addCandidate_resume")).sendKeys("C:\\Users\\Nikola\\Desktop\\CV.docx");
        driver.findElement(By.id("addCandidate_firstName")).sendKeys("QA");
        driver.findElement(By.id("addCandidate_lastName")).sendKeys("Automation");
        driver.findElement(By.id("addCandidate_email")).sendKeys("any@mail.com");
        driver.findElement(By.id("add-candidate-vacancy-widget-container")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[2]/form/div[5]/div[1]/div/div/ul/div/li[1]/a/p")).click();
        driver.findElement(By.id("saveCandidateButton")).click();

        //Variable for Assertion - Check if number of candidates is increased by 1
        newRowCount = countCandidates();
    }

    public static void deleteCandidate() {
        //Select candidate to delete
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[7]/div/div[2]/table/tbody/tr[1]/td[1]/label")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[7]/div/div[2]/table/thead/tr/th[1]/a/i")).click();

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deleteItemBtn")));
        driver.findElement(By.id("deleteItemBtn")).click();

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("candidate-delete-button")));
        driver.findElement(By.id("candidate-delete-button")).click();

        //Waiting for covering div to vanish
        wdWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloderDiv")));

        //Variables for assertion - Check if number of candidates is decreased by 1
        rowCount = newRowCount;
        newRowCount = countCandidates();
    }

    public static void logOut(){
        driver.findElement(By.id("user-dropdown")).click();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutLink"))).click();
    }
}
