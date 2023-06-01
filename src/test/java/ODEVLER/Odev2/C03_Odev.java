package ODEVLER.Odev2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Odev {
        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrom.driver" , "src/resources/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            //https://id.heroku.com/login sayfasina gidin.
            driver.get("https://id.heroku.com/login");

            //Bir mail adersi giriniz
            WebElement email = driver.findElement(By.xpath("//input[@class='form-control']"));
            email.sendKeys("mehmet.fatihh57@gmail.com");
            Thread.sleep(2000);

            //Bir password giriniz
            WebElement password = driver.findElement(By.xpath("//input[@class='form-control password']"));
            password.sendKeys("MFY5757.");
            Thread.sleep(2000);

            //Login butonuna tiklayiniz
            WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));
            login.click();
            Thread.sleep(1000);

            //"There was a problem with your login." texti gorunur ise
            //"kayit yapilamadi" yazdiriniz
            //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
            WebElement sonuc = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
            System.out.println(sonuc.getText());
            if(!sonuc.isDisplayed()){
                System.out.println("Kayit Yapildi");
            }else{
                System.out.println("Kayit Yapilamadi");
            }

            //sayfayı kapatiniz
            driver.close();

            }
        }




