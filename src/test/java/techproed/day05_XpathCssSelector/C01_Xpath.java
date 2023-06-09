package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_Xpath {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike"  yazıp aratın

        /*
            <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
            placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
            aria-label="Search Amazon" spellcheck="false">
            driver.findElement(By.id("twotabsearchtextbox"));
         */
        //WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']"));
        aramaKutusu.sendKeys("city bike" , Keys.ENTER);


        // Hybrid Bikes bölümüne tıklayın
        driver.findElement(By.xpath("//*[text()='Hybrid Bikes']")).click();// --> //*[.='Hybrid Bikes']

        // sonuc sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));//14 results for "city bike"
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = " + sonucSayisi[0]);

        // ilk ürününe tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        ilkUrun.click();

        // Sayfayı kapatınız
        driver.close();

    }
}
