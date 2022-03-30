package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExercicicosFrame {

    WebDriver driver;

    @Before
    public void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Frames.html");

    }

    @Test
    public void testeIframeSimples() {
        driver.switchTo().frame("singleframe");// Muda o contexto do driver para o frame
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Teste QA Academy");
        driver.switchTo().defaultContent(); // voltar para o contexto anterior
    }

    @After
    public void after() {
        driver.quit();
    }

}
