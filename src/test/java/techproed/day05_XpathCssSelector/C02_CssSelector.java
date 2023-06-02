package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /*
            i)cssSelector de @ isareti ve // isaretleri kullanilmaz
           ii)xpath ile index alabiliriz ama cssSelector ile index alamayiz
          iii)xpath ile text olarak locate edebiliriz ama cssSelector ile bunu yapamayiz
         iiii)cssSelector xpath'e gore daha hizli calisir



         */

       //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

       //Add Element butonuna basin
        WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        Thread.sleep(3000);
        addElementButton.click();

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //Delete tusuna basin
        deleteButton.click();
        Thread.sleep(2000);

       //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElements = driver.findElement(By.cssSelector("h3"));
        if(addRemoveElements.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //Sayfayi Kapatiniz
        driver.close();

    }
}
