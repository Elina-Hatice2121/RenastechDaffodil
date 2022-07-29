package students.hatice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class lab3 {
    public static void main(String[] args) throws InterruptedException {
        //TASK: Google search
//1- Open a chrome browser
//2- Go to: https://google.com
//3- Write “apple” in search box
//4- Click google search button
//5- Verify title:
//Expected: Title should start with "apple" word
//6-navigate back
//7-write cherry in search box
//8-verify title contains cherry.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement searchBox=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBox.sendKeys("apple");
        WebElement searchButton= driver.findElement(By.xpath("//input[@class='gNO89b']"));
        searchButton.click();

        String expectTitle="apple";
        String actualTitle= driver.getTitle();

        if(actualTitle.contains(expectTitle)){
            System.out.println("Title has started with 'apple' word and test past");
        }else{
            System.out.println("Title has not  start with 'apple' word and test failed" );
        }


        driver.navigate().back();

        Thread.sleep(4000);
        searchBox.sendKeys("cherry");
        searchButton.click();

        String expectedTitle1="cherry";
        String actualTitle1=driver.getTitle();
        System.out.println(actualTitle1);

        if(actualTitle1.contains(expectedTitle1)){
            System.out.println("verify title contains cherry passed");
        }else {
            System.out.println("verify title contains cherry failed");
        }
        driver.quit();
    }
}
