import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SignTest {
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

        // Informando ao usuário que todos os testes passaram com sucesso !
        System.out.println("Testes concluidos com sucesso !!!");
    }
}
