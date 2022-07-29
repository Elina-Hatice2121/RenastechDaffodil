package students.hatice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class lab5 {
WebDriver driver;

@BeforeMethod
        public void setup() {

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    System.out.println("before method past");
}

@Test
    public void test1(){

    driver.get("https://www.amazon.ca/");
    WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("Desks"+ Keys.ENTER);
    System.out.println("test1 passed");
}
    @AfterMethod
    public void close(){
        System.out.println("after method past");
     driver.quit();


    }
}
