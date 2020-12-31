package PageObject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.*;
import org.openqa.selenium.WebDriver;

public class WebPageDefinition {
    WebDriver driver;
    TestData testData = new TestData();
    BasePage basePage = new BasePage();

    By labelList    = By.xpath(Elements.labelList);
    By inputGoogle  = By.xpath(Elements.inputGoogle);

    @When("initiate browser")
    public void initiate_Browser() throws Exception {
        System.out.println("open browser");
        testData.setIsHeadless(ClassHelp.getEnv("DontRunningBrowser"));
        testData.setCloseBrowserEveryScenario(ClassHelp.getEnv("CloseBrowser"));
        basePage = new BasePage();
        System.out.println("BasePage :" + basePage);
        driver = basePage.openBrowser(ClassHelp.getEnv("browser"));
        System.out.println("Driver : " + driver);
        driver.manage().window().maximize();
    }

    @When("navigates to the web page based on \"([^\"]*)\" data")
    public void navigatesToTheWebPage(String arg) throws Exception {
        if(arg.equals("1")){
            DefaultData.setTest1Data();
        } else if (arg.equals("all")){
            DefaultData.setTestMultiData();
        }
        driver.get(testData.getUrl().replace("\"", ""));
    }

    @When("navigates to another web page")
    public void navigatesToAnotherWebPage() throws Exception {
        DefaultData.setUrlAnother();
        driver.get(testData.getUrl().replace("\"", ""));
    }

    @Then("the list is displayed")
    public void theListIsDisplayed() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(labelList));
        driver.findElement(labelList).isDisplayed();
    }

    @Then("the element is displayed")
    public void theLogoIsDisplayed() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputGoogle));
        driver.findElement(inputGoogle).isDisplayed();
    }
}
