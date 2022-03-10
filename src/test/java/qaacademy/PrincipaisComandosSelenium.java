package qaacademy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrincipaisComandosSelenium {

    @Test
    public void testeSeleniumClick() throws InterruptedException {

        WebDriver driver = new ChromeDriver(); //Abrir o browser
        driver.get("https://www.qaacademy.com.br/"); //
        Thread.sleep(3000);//espera de 3 segundos
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button[1]")).click();    // localiza o cookie e clica em aceitar  
        Thread.sleep(1000); //espera mais 1 s
        driver.findElement(By.xpath("//*[@id='img_1_comp-k0wqferu']/img")).click();//clica no linkedin  

    }

    @Test
    public void testeSeleniumEnviarTextosParaTela() throws InterruptedException {

        WebDriver driver = new ChromeDriver(); //Abrir o browser
        driver.get("https://www.qaacademy.com.br/"); //
        Thread.sleep(3000);//espera de 3 segundos
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button[1]")).click();    // localiza o cookie e clica em aceitar  
        Thread.sleep(1000); //espera mais 1 s
        driver.findElement(By.xpath("//*[@placeholder='Nome']")).click();//Seleciona o nome
        driver.findElement(By.xpath("//*[@placeholder='Nome']")).sendKeys("Flavio Dias");// Envia informações para a tela
        driver.findElement(By.xpath("//*[@placeholder='Email']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("qaacademybr@gmail.com");
        driver.findElement(By.xpath("//*[@id='comp-k37gdiro']/button")).click();


    }
    
}
