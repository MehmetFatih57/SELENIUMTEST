package techproed.day01_ilkTest;

public class Deneme {

        public static void main(String[] args) {
            System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
            //Java uygulamarinda system ozelliklerini ayarlamak icin setProperty methodu ile kullaniriz.
            //setProperty methodu ile class'imiza driver'in fiziki yolunu belirtiriz
            System.out.println(System.getProperty("chromeDriver"));
            //getProperty ile "Key" degerini girerek "value"ya ulasabilirim
        }

    }

