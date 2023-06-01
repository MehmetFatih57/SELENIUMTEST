package Odev2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Odev {
        public static void main(String[] args) throws InterruptedException {


            //https://id.heroku.com/login sayfasina gidin
            //Bir mail adersi giriniz
            //Bir password giriniz
            //Login butonuna tiklayiniz
            //"There was a problem with your login." texti gorunur ise
            //"kayit yapilamadi" yazdiriniz
            //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
            //sayfayı kapatiniz

            System.setProperty("webdriver.chrom.driver" , "src/resources/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            //https://id.heroku.com/login sayfasina gidin.
            driver.get("https://id.heroku.com/login");

            //Bir mail adersi giriniz
            WebElement mail = driver.findElement(By.id("email"));
            mail.sendKeys("mehmet.fatihh57@gmail.com");

            //Bir password giriniz
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Sss230628.");

            //Login butonuna tiklayiniz
            WebElement login = driver.findElement(By.name("commit"));
            login.click();

            //"There was a problem with your login." texti gorunur ise
            //"kayit yapilamadi" yazdiriniz
            //eger yazi gorunur degilse "kayit yapildi" yazdiriniz


          String actualText = driver.getPageSource();
          String expectedText = "There was a problem with your login";
          if (actualText.contains(expectedText)){
              System.out.println("Kayıt yapılamadı");
          }else {
              System.out.println("Kayıt yapıldı");
          }
          Thread.sleep(3000);

            //sayfayı kapatiniz
            driver.close();

            }
        }




