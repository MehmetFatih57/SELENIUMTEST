package ODEVLER.Odev4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Odev {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrom.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        //2- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        //3- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //4-Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String sayfaBaslik = driver.getTitle();
        if (sayfaBaslik.contains("Spend less")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        Thread.sleep(2000);

        //5-Gift Cards sekmesine basin
        WebElement giftCard = driver.findElement(By.xpath("(//a[@class='nav-a  '])[4]"));
        giftCard.click();
        Thread.sleep(1000);

        //6-Birthday butonuna basin
        WebElement birthday = driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[29]"));
        birthday.click();
        Thread.sleep(2000);

        //7-Best Seller bolumunden ilk urunu tiklayin
       WebElement bestSeller = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
       bestSeller.click();
        Thread.sleep(1000);

        //8-Gift card details’den 25 $’i secin
        WebElement dolar = driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]"));
        dolar.click();
        Thread.sleep(2000);

        //9-Urun ucretinin 25$ oldugunu test edin
        WebElement fiyat = driver.findElement(By.xpath("//span[@class='gc-live-preview-amount']"));
        if(fiyat.getText().contains("$25.00")){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        Thread.sleep(2000);

        //10-Sayfayi kapatin
        driver.close();
    }
}
