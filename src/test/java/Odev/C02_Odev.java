package Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Odev {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrom.driver" , "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Techproeducation sayfasina gidiniz
        //Cikan reklami locate edip kapatalim
        //Arama bolumunde QA aratalim
        //Sayfa basliginin QA icerdigini dogrulayalim
        //Carrer Opportunities in QA linkinin gorunur oldugunu ve eriselebilir oldugunu dogrulayalim
        //Carrer Opportunities in QA linkine tiklayalim
        //Basligin Opportunities icerdigini test edelim
        //Tekrar anasayfaya donelimve url'in https://techproeducation.com/ odlugunu dogrulayalim
    }
}
