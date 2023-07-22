import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
  WebDriver driver;

  @BeforeClass
  public void beforeClass() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
  }

  @Test
  public void TC_01_Test() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    String loginPageUrl = driver.getCurrentUrl();
    Assert.assertEquals(loginPageUrl, "http://live.techpanda.org/index.php/customer/account/login/");
    driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
    String registerPageUrl = driver.getCurrentUrl();
    Assert.assertEquals(registerPageUrl, "http://live.techpanda.org/index.php/customer/account/create/");
  }

  @AfterClass
  public void afterClass() {
    driver.close();
  }
}
