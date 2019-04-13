package pl.sda;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Stepdefs {
    private String URL = "http://automationpractice.com/index.php";
    private String CHROMEDRIVER = "C:\\soft\\web_drivers\\chromedriver.exe";
    private WebDriver driver;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("website loads")
    public void website_loads() {
        driver.get(URL);
    }

    @When("user clicks woman sub-page button")
    public void user_clicks_woman_sub_page_button() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
        element.click();
    }

    @Then("title exist in sub-page")
    public void title_exist_in_sub_page() {
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/span"));
        Assert.assertEquals(expectedElement.getText(), "Women");
    }

    @After
    public void cleanup() {
        driver.close();
    }
}
