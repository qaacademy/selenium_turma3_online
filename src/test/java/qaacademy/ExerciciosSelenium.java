package qaacademy;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosSelenium {
    static WebDriver driver; 

    @Test
    public void testesFormularioSelenium() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Flavio");
        driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Dias");
        driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys("Av Paulista, 509");
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("contato@qaacademy.com.br");
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("11977413512");

    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}