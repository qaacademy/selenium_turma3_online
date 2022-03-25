package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosNovaTab {
    WebDriver driver;

    @Before
    public void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Windows.html");

    }

    @Test
    public void testeJanelasWindow() throws InterruptedException {
        driver.findElement(By.linkText("click")).click();
        Object[] janelas = driver.getWindowHandles().toArray();
        driver.switchTo().window(janelas[1].toString());
        Assert.assertTrue(driver.getPageSource().contains("Selenium automates"));
        driver.getCurrentUrl().equals("https://www.selenium.dev/");

    }

    @Test
    public void testesAlertaComOkCancela() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText();
        String mensagemEsperada = "Press a Button !";
        Thread.sleep(2000);
        alert.dismiss();
        Assert.assertEquals(mensagemEsperada, mensagemAlerta);
    }

    @After
    public void after() {
        driver.quit();
    }

}
