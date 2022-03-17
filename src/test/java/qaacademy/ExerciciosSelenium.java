package qaacademy;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosSelenium {
    static WebDriver driver;

    @Before
    public static void before() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        Thread.sleep(2000);
    }

    @Test
    public void testesFormularioSelenium() throws InterruptedException {
        driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Flavio");
        driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Dias");
        driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys("Av Paulista, 509");
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("contato@qaacademy.com.br");
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("11977413512");
        // selecionando o radiobutton
        driver.findElement(By.xpath("//*[@ng-model='radiovalue' and @value='Male']")).click();
        // validação
        Assert.assertTrue("Elemento não selecionado",
                driver.findElement(By.xpath("//*[@ng-model='radiovalue' and @value='Male']")).isSelected());
        // Checkbox
        driver.findElement(By.xpath("//input[@value='Movies']")).click();
        Assert.assertTrue("Checkbox não selecionada",
                driver.findElement(By.xpath("//input[@value='Movies']")).isSelected());
        // Selecionar uma lista
        driver.findElement(By.xpath("//div[@id='msdd']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Portuguese')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
        boolean linguagemPortuguesSelecionada = driver
        .findElement(
                By.xpath("//div[contains(text(),'Portuguese') and @class='ui-autocomplete-multiselect-item']"))
        .isDisplayed(); 
        boolean linguagemEnglishSelecionada =driver
        .findElement(
                By.xpath("//div[contains(text(),'English') and @class='ui-autocomplete-multiselect-item']"))
        .isDisplayed();
        Assert.assertTrue(linguagemPortuguesSelecionada && linguagemEnglishSelecionada);
    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
