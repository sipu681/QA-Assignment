package Utility;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	    
	    public static String url = "http://automationexercise.com";
        public static WebDriver driver;
        public static  WebDriverWait wait ;	    @BeforeClass
	    public static void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get(url);
	    }

	    @AfterClass
	    public static void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


