package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassHelp {
    public static String getEnv(String text) {
        try {
            String filename = "conf.properties";
            InputStream input = new FileInputStream(System.getProperty("user.dir") + File.separator + filename);
            Properties prop = new Properties();
            prop.load(input);
            return prop.get(text).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("unable to find conf.properties");
        return text;
    }
    public static boolean isElementPresent(WebDriver driver, WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
//    public static void waitUntilObjectIsPresent(WebDriver driver, WebElement objWebElement, int timeInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
//        wait.until(ExpectedConditions.visibilityOf(objWebElement));
//    }
    public static void moveHighLight(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].style.border='3px solid " + getEnv("highlightColor") + "'", element);
        highlight(driver, element);
    }
//    public static Boolean waitUntilObjectIsNotPresent(WebDriver driver, WebElement objWebElement) {
//        Boolean toReturn = false;
//        try {
//            if (isElementPresent(driver, objWebElement)) {
//                WebDriverWait wait = new WebDriverWait(driver, 60);
//                toReturn = wait.until(ExpectedConditions.invisibilityOf(objWebElement));
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            return toReturn;
//        }
//        return toReturn;
//    }
    public static void highlight(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}