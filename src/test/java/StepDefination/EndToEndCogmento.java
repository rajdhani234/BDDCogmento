package StepDefination;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EndToEndCogmento {

    static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(EndToEndCogmento.class);
    
    

    @Given("user is on login page")
    public void user_is_on_login_page() {
        logger.info("Initializing the WebDriver and navigating to the login page");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://ui.cogmento.com/");
        logger.info("Navigated to: https://ui.cogmento.com/");
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        logger.info("Entering valid username and password");
        driver.findElement(By.name("email")).sendKeys("pravinkadam23491@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Auric@1234");
    }

    @Then("user click on login button")
    public void user_click_on_login_button() throws InterruptedException {
        logger.info("Clicking on login button");
        driver.findElement(By.xpath("//div[text()='Login']")).click();
        Thread.sleep(5000);
    }

    @Then("user validate home page Title")
    public void user_validate_home_page_title() {
        logger.info("Validating home page title");
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Cogmento CRM");
        logger.info("Home page title validation successful: " + actualTitle);
    }

    @Then("user validate logo")
    public void user_validate_logo() {
        logger.info("Validating logo visibility");
        boolean actualLogoStatus = driver.findElement(By.xpath("//div[@class='header item']")).isDisplayed();
        assertEquals(actualLogoStatus, true);
        logger.info("Logo is displayed: " + actualLogoStatus);
    }

    @Then("user validate home page URL")
    public void user_validate_home_page_url() {
        logger.info("Validating home page URL");
        boolean actualURLResult = driver.getCurrentUrl().contains("cogmento");
        assertEquals(actualURLResult, true);
        logger.info("URL validation successful: " + driver.getCurrentUrl());
    }

    @When("user click on contact link")
    public void user_click_on_contact_link() {
        logger.info("Clicking on Contacts link");
        driver.findElement(By.xpath("//span[text()='Contacts']")).click();
    }

    @When("click on create button")
    public void click_on_create_button() {
        logger.info("Clicking on Create button");
        driver.findElement(By.xpath("//button[text()='Create']")).click();
    }

    @When("Enter first name, last name , email, select status")
    public void enter_first_name_last_name_email_select_status() {
        logger.info("Entering contact details: First name, Last name, Email, and selecting Status");
        driver.findElement(By.name("first_name")).sendKeys("Pravin");
        driver.findElement(By.name("last_name")).sendKeys("Kadam");
        driver.findElement(By.name("value")).sendKeys("pravinkadam23491@gmail.com");
        driver.findElement(By.name("status")).click();

        List<WebElement> ls = driver.findElements(By.xpath("//div[@name='status']"));
        for (WebElement statuslist : ls) {
            String status = statuslist.getText();
            if (status.equalsIgnoreCase("On Hold")) {
                statuslist.click();
                logger.info("Selected status: On Hold");
                break;
            }
        }
    }

    @Then("click on save button")
    public void click_on_save_button() {
        logger.info("Clicking on Save button");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    @Then("delete the contact")
    public void delete_the_contact() {
        logger.info("Deleting the contact");
        driver.findElement(By.xpath("//i[@class='trash icon']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        logger.info("Contact deleted successfully");
    }

    @When("user click on profile icon")
    public void user_click_on_profile_icon() {
        logger.info("Clicking on Profile icon");
        driver.findElement(By.xpath("//div[@role='listbox']")).click();
    }

    @When("click on logout")
    public void click_on_logout() {
        logger.info("Clicking on Log Out");
        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
    }

    @Then("user will logout from application")
    public void user_will_logout_from_application() {
        logger.info("User logged out from the application");
        System.out.println("user is logout");
    }
}
