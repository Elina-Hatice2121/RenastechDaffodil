package students.hatice;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.control.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class lab4 {
    public static void main(String[] args) {
        //1. Open Chrome browser
//2. Go to https://demo.guru99.com/test/radio.html
//3. Verify all checkboxes are not selected (you can use findelements to store in list and use for loop to validate)
//4. Click to checkbox3
//5. Verify checkbox3 is selected

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/radio.html");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@id='vfb-7-2']"));

        for(WebElement each : checkBoxes){
            if(each.isSelected()){
                System.out.println( "is  selected and test failed");
            }else{
                System.out.println( "is not selected and test passed");
            }
          WebElement checkbox3= driver.findElement(By.xpath("//input[@value='checkbox3']"));
            checkbox3.click();

            if(checkbox3.isSelected()){
                System.out.println( "is  selected" );
            }else{
                System.out.println( "is not selected");
            }
          driver.quit();
        }

    }
}
