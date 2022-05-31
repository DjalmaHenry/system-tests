import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Tests {

    @Test
    public void testVerificaTelaDePrecos() {
        // setando a localização do chrome driver no arquivo local
        System.setProperty("webdriver.chrome.driver", "C:\\webDrivers\\chromedriver.exe");

        // instanciando web driver
        WebDriver navegador = new ChromeDriver();

        // abrindo a página web de preços
        navegador.get("https://trello.com/pricing");

        // pegando título da página
        String title = navegador.findElement(By.xpath("/html/body/div[1]/main/section[1]/div/div/div/div/h1")).getText();

        // Verificando se de fato o título da página está correto
        assertTrue(title.contains("Trello your way."));

        // Clicando na opção de Começar plano gratuito
        navegador.findElement(By.xpath("/html/body/div[1]/main/section[2]/div/div/div/div/div[4]/div/a")).click();

        // pegando título da página
        title = navegador.findElement(By.id("signup-password")).findElement(By.tagName("h1")).getText();

        // Verificando se de fato o título da página está correto
        assertEquals("Criar sua conta", title);

        // Fechando o navegador de ambiente de teste para finalizar
        navegador.quit();
    }

    @Test
    public void testVerificaTelaDeTimes() {
        // setando a localização do chrome driver no arquivo local
        System.setProperty("webdriver.chrome.driver", "C:\\webDrivers\\chromedriver.exe");

        // instanciando web driver
        WebDriver navegador = new ChromeDriver();

        // abrindo a página web de times
        navegador.get("https://trello.com/teams");

        // pegando título da página de times
        String title = navegador.findElement(By.xpath("/html/body/div[1]/main/section[1]/div/div/div[2]/div/h1")).getText();

        // Verificando se de fato o título da página está correto
        assertTrue(title.contains("Trello Solutions For All Teams"));

        // Acessando um time específico: Startups
        navegador.findElement(By.xpath("/html/body/div[1]/main/section[3]/div/div/div[9]/a")).click();

        // pegando título da página do time de startups
        title = navegador.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div[2]/h1")).getText();

        // Verificando se de fato o título da página está correto
        assertEquals("Trello For Startups", title);

        // Fechando o navegador de ambiente de teste para finalizar
        navegador.quit();
    }

    @Test
    public void testFazerLoginEVerificarBoard() {

        // setando a localização do chrome driver no arquivo local
        System.setProperty("webdriver.chrome.driver", "C:\\webDrivers\\chromedriver.exe");

        // instanciando web driver
        WebDriver navegador = new ChromeDriver();

        // abrindo a página web
        navegador.get("https://trello.com/");

        // clicando na opção de Fazer login
        navegador.findElement(By.linkText("Fazer login")).click();

        // inserindo email de login
        navegador.findElement(By.id("user")).sendKeys("contato@djalmahenry.com");

        // clicando em Fazer login com a Atlassian
        navegador.findElement(By.id("login")).click();

        // aguardando navegador carregar a próxima página
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // inserindo senha de login
        navegador.findElement(By.id("form-login")).findElement(By.id("password")).sendKeys("Test@1qazxsw2");

        // clicando em Entrar
        navegador.findElement(By.id("form-login")).findElement(By.id("login-submit")).click();

        // aguardando navegador carregar a próxima página
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Buscando nome do quadro de teste criado
        String frameName = navegador.findElement(By.className("board-tile-details-name")).getText();

        // Verificando se de fato o quadro de teste criado está lá e com o mesmo nome
        assertEquals("Teste", frameName);

        // Abrindo a página web do quadro de teste criado
        navegador.get("https://trello.com/b/730R8XgR/teste");

        // Buscando nome da task de teste criada
        String taskName = navegador.findElement(By.className("list-card-title")).getText();

        // Verificando se de fato a task de teste criada está lá e com o mesmo nome
        assertEquals("Testes de Sistema", taskName);

        // Fechando o navegador de ambiente de teste para finalizar
        navegador.quit();
    }
}
