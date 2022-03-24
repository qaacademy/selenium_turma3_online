package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosAlertas {
    WebDriver driver;

    @Before
    public void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Alerts.html");

    }

    @Test
    public void testesAlertaSimples() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText();
        String mensagemEsperada = "I am an alert box!";
        Thread.sleep(2000);
        alert.accept();
        Assert.assertEquals(mensagemEsperada, mensagemAlerta);
    }

    @After
    public void after(){
        driver.quit();
    }
}
