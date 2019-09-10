package Step_Definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    //create a WebDriver variable named "driver"
    WebDriver driver;

    //************************* <begin>Hooks *************************
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\Programming\\[Cucumber]\\Gianni Bruno - Cucumber Selenium Java\\Section06\\Section06_lecture35\\src\\test\\java\\Resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000); //holding the page 3 seconds before it's tearing down
        this.driver.manage().deleteAllCookies();
        this.driver.quit();
        this.driver = null;
    }
    //************************* <end>Hooks *************************

    @Given("^User navigate to stackoverflow website$")
    public void user_navigate_to_stackoverflow_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://stackoverflow.com");
    }

    @And("^User clicks on the login button on homepage$")
    public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);
        //class='login-link s-btn btn-topbar-clear py8 js-gps-track'
        WebElement btnLonIn = driver.findElement(By.xpath("//a[contains(@class, 'login-link')]"));
        btnLonIn.click();
    }

    @And("^User enters a valid username$")
    public void user_enters_a_valid_username() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement emailTextfield = driver.findElement(By.id("email"));
        emailTextfield.sendKeys("autotestudemy@mail.com");
    }

    @And("^User enters a valid password$")
    public void user_enters_a_valid_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement pwdTextfield = driver.findElement(By.id("password"));
        pwdTextfield.sendKeys("Password321!");
    }

    @When("^User clicks on the login button$")
    public void user_clicks_on_the_login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement btnSubmit = driver.findElement(By.id("submit-button"));
        btnSubmit.click();
        Thread.sleep(7000);
    }

    @Then("^User should be taken to the successful login page$")
    public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement btnAskQuestion = driver.findElement(By.xpath("//a[contains(@class,'ws-nowrap')]"));
        Assert.assertEquals(true, btnAskQuestion.isDisplayed());
        btnAskQuestion.click();
        Thread.sleep(3000);
    }
}
