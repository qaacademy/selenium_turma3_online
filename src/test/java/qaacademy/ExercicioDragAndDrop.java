package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ExercicioDragAndDrop {
    WebDriver driver;

    @Before
    public void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Static.html");

    }

    @Test
    public void testeDragAndDrop() {

        WebElement elementoIncial = driver.findElement(By.id("node")); // Elemento incicial
        WebElement areaDestino = driver.findElement(By.id("droparea")); // Area final
        Actions actionProvider = new Actions(driver); // Instancia do ActionProvider
        actionProvider.dragAndDrop(elementoIncial, areaDestino).build().perform();

    }

    @After
    public void after() {
        driver.quit();
    }
}
