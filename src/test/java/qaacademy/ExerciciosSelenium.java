package qaacademy;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerciciosSelenium {
    static WebDriver driver;

    @Before
    public void before() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.automationtesting.in/Register.html");
        WebElement adToolbar = driver.findElement(By.cssSelector("body > ins:nth-child(8) > ins.ee > span > svg > path"));
        if (adToolbar.isDisplayed()) {
            adToolbar.click();
        }
        else{
            System.out.println("WebElement não esta presente");
        }
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
        // Selecionar uma lista do tipo <li>
        driver.findElement(By.xpath("//div[@id='msdd']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Portuguese')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();

    
        boolean linguagemPortuguesSelecionada = driver
                .findElement(
                        By.xpath("//div[contains(text(),'Portuguese') and @class='ui-autocomplete-multiselect-item']"))
                .isDisplayed();
        boolean linguagemEnglishSelecionada = driver
                .findElement(
                        By.xpath("//div[contains(text(),'English') and @class='ui-autocomplete-multiselect-item']"))
                .isDisplayed();
        Assert.assertTrue(linguagemPortuguesSelecionada && linguagemEnglishSelecionada);

        driver.findElement(By.xpath("//*[@class='select2-selection__arrow']")).click();
        driver.findElement(By.xpath("//li[contains(text(),'United States of America')]")).click();


     //Listas do tipo Option
        Select selectObject = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
        selectObject.selectByVisibleText("Java");

        Select selectAnoAniversario = new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
        selectAnoAniversario.selectByVisibleText("1988");

        Select selectMes = new Select(driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[11]/div[2]/select[1]")));
        selectMes.selectByVisibleText("April");

        Select selectDia = new Select(driver.findElement(By.xpath("//select[@id='daybox']")));
        selectDia.selectByVisibleText("15");


        driver.findElement(By.xpath("//*[@id='firstpassword']")).sendKeys("Teste");;
       

        driver.findElement(By.xpath("//*[@id='secondpassword']")).sendKeys("Teste");
        
        driver.findElement(By.cssSelector("#submitbtn")).click();

        String msgErroTelefone = "Portuguese";
        Assert.assertTrue("Linguagem não está presente", driver.getPageSource().contains(msgErroTelefone));
       

    }

 
    @AfterClass
    public static void after() throws InterruptedException {
        driver.quit();
    }
}
