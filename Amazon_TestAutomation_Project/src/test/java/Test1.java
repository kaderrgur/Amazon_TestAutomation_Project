import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

    WebDriver driver;
    @BeforeTest
    public void chromeDriverRun() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchBarLooking() throws InterruptedException {

        driver.get("https://www.amazon.com/");

        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.click();
        searchBar.sendKeys("airpods");

        Thread.sleep(2000);

        WebElement searchBarClick = driver.findElement(By.id("nav-search-submit-button"));
        searchBarClick.click();

        Thread.sleep(2000);

        WebElement climatePledgeFriendly = driver.findElement(By.xpath("//li[@id='p_n_cpf_eligible/21512497011']//i[@class='a-icon a-icon-checkbox']"));
        climatePledgeFriendly.click();

        Thread.sleep(2000);

        WebElement selectBrand = driver.findElement(By.xpath("//li[@id='p_89/Apple']//i[@class='a-icon a-icon-checkbox']"));
        selectBrand.click();

        Thread.sleep(2000);

        WebElement selectOption = driver.findElement(By.xpath("//img[@alt='Apple AirPods with Wireless Charging Case - White (Renewed)']"));
        selectOption.click();

        Thread.sleep(2000);

        WebElement addToCard = driver.findElement(By.id("add-to-cart-button"));
        addToCard.click();

        Thread.sleep(5000);

        WebElement card = driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']"));
        card.click();

        Thread.sleep(2000);

        WebElement isDisplayElement = driver.findElement(By.xpath("//img[@alt='Apple AirPods with Wireless Charging Case - White (Renewed), Opens in a new tab']"));
        isDisplayElement.isDisplayed();

        Thread.sleep(3000);

    }


    @AfterTest
    public void chromeDriverClosed() {

        System.out.println("Test passed...");
        driver.close();
    }
}


