package Utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class EdgeRunner {

    public WebDriver driver = null;
    @BeforeMethod
    public void openEdge(){
//        ესაა ვიზუალურად რო არ გვანახხოს ტესტი
//      ChromeOptions options = new ChromeOptions();
//      options.addArguments("--headless");
//      WebDriver driver = new ChromeDriver(options);
//        ესაა ვიზუალურად რო გვანახოს ტესტი
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://test-pirveli.com/");
    }

    @AfterMethod
    public void closeEdge(){
        driver.close();
    }
}
