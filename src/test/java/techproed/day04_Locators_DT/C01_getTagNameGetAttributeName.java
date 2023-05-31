package techproed.day04_Locators_DT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_getTagNameGetAttributeName {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusunu locate ediniz
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));


        // arama kutusunun tagName'inin "input" oldugunu test edin
        String actuelTagName = aramaKutusu.getTagName();
        String expectedTagName = "input";

        if(actuelTagName.equals(expectedTagName)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        // arama kutusunun name attribute'nun degerinin "field-keywords" oldugunu test edin
        String actualAttribute = aramaKutusu.getAttribute("name");
        String expectedAttribute = "field-keywords";

        if(actualAttribute.equals(expectedAttribute)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        // sayfayı kapatın
        driver.close();








    }
}
