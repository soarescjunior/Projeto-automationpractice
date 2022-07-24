package buscarItens;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class buscarItensSteps {
    WebDriver driver;
    buscarItensPage buscarItensPage;

    @Before
    public void iniciarTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        buscarItensPage = new buscarItensPage(driver);
    }

    @Given("estou no site {string}")
    public void estou_no_site(String url) {
    driver.get(url);
    }

    @When("buscar primeiro produto")
    public void buscar_primeiro_produto(List<Map<String,String>>dataTable) throws InterruptedException {
        String produto = dataTable.get(0).get("produto");
        String quantidade = dataTable.get(0).get("quantidade");
        buscarItensPage.clicarRegistrar();
        buscarItensPage.digitarProduto(produto);
        buscarItensPage.btnBuscar();
        buscarItensPage.selecaoproduto();
        buscarItensPage.selecaoCor();
        buscarItensPage.comboTamanhoProduto();
        buscarItensPage.selecaoTamanhoM();
        buscarItensPage.quantidadeProduto(quantidade);
        buscarItensPage.adicionarAoCarrinho();
        buscarItensPage.continuarComprando();
    }

    @And("buscar segundo produto")
    public void buscar_segundo_produto(List<Map<String,String>>dataTable) {
        String produto = dataTable.get(0).get("produto");
        buscarItensPage.campobuscarProduto();
        buscarItensPage.limparCampo();
        buscarItensPage.digitarProduto(produto);
        buscarItensPage.btnBuscar();
    }
    @And("adicionar ao carrinho")
    public void adicionar_ao_carrinho() {
        buscarItensPage.selecaoSegundoProduto();
        buscarItensPage.adicionarAoCarrinho();
        buscarItensPage.fazerCheckout();
    }
    @And("alterar a quantidade do primeiro produto")
    public void alterar_a_quantidade_do_primeiro_produto() {
        buscarItensPage.diminuirQuantidade();
    }
    @And("remover a um item do carrinho")
    public void remover_a_um_item_do_carrinho() {
        buscarItensPage.removerProduto();
        buscarItensPage.btnConcluirCompra();
    }
    @And("informar dados do usuario")
    public void informar_dados_do_usuario(List<Map<String,String>>dataTable) {
        String usuario = dataTable.get(0).get("usuario");
        String senha = dataTable.get(0).get("senha");
        buscarItensPage.informar_dados_do_usuario(usuario,senha);
    }
    @Then("concluir a compra")
    public void concluir_a_compra() {
        buscarItensPage.finalizarCompra();
    }

    @After
    public void fimTest(){
        driver.quit();
    }

}
