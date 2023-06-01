package ODEVLER.Odev2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Odev {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrom.driver" , "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");

        //Cikan reklami locate edip kapatalim
        WebElement reklamKapatma = driver.findElement(By.xpath("(//i[@class='eicon-close'])"));
        Thread.sleep(2000);
        reklamKapatma.click();

        //Arama bolumunde QA aratalim
        Thread.sleep(2000);
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        aramaKutusu.sendKeys("QA");
        aramaKutusu.submit();

        //Sayfa basliginin QA icerdigini dogrulayalim
        String sayfaBasligi = driver.getTitle();
        if(sayfaBasligi.contains("QA")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        //Carrer Opportunities in QA linkinin gorunur oldugunu ve eriselebilir oldugunu dogrulayalim
        WebElement linkGorunur = driver.findElement(By.xpath("(//a[@class='elementor-post__thumbnail__link'])"));
        System.out.println(linkGorunur.isDisplayed());
        System.out.println(linkGorunur.isEnabled());

        //Carrer Opportunities in QA linkine tiklayalim
        linkGorunur.click();

        //Basligin Opportunities icerdigini test edelim
        String baslik = driver.getTitle();
        if(baslik.contains("Opportunities")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        driver.navigate().back();
        //Tekrar anasayfaya donelimve url'in https://techproeducation.com/ odlugunu dogrulayalim
        driver.navigate().back();
        String url = driver.getCurrentUrl();
        if(url.equals("https://techproeducation.com/")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        driver.navigate().forward();
        driver.navigate().back();
        Thread.sleep(2000);
        //Sayfayi kapatin
        driver.close();
    }
}
