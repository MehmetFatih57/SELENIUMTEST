package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_relativeLocators {
    public static void main(String[] args) {

        /*
            i)Benzer ozelliklere sahip webelementler icin relative locator kullanabiliriz
           ii)Syntax ==> driver.findElement(with(By.tagname).below().above().to_left_of().to_right_of().near()) gibi
              methodlar ile benzer ozelliklere sahip webelementleri locatini almadan o webelemente ulasabiliriz
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazona gidelim
        driver.get("https://www.amazon.com");

        //city bike aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']"));
        aramaKutusu.sendKeys("city bike" , Keys.ENTER);

        //relative locator kullanarak hybrid bikes altindaki elemente tiklayalim
        WebElement hybridBike = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        WebElement electricBike = driver.findElement(with(By.tagName("a")).below(hybridBike));
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electricBike));
        completeBike.click();
    }
}
