package helpers;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.Logger;

import static tests.BaseTest.driver;

public class BaseHelper {
    public static String googleURL = "https://www.google.com/";
    private static Logger logger = LogManager.getLogger(BaseHelper.class);

    public static void google(){
        driver.get(googleURL);
    }

    public static void takeScreenshot(String fileName){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(file, new File("C:\\Users\\Nikola\\Desktop\\DefaultProjectTest\\src\\main\\screenshots\\"+fileName+".jpg"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void loggerMethod( String msg){
        logger.info(msg);
    }
}
