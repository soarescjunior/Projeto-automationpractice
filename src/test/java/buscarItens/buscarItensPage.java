package buscarItens;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class buscarItensPage {

    WebDriver driver;

    String campoBuscar = "//input[@id ='search_query_top']";
    String itemParaCompra = "//li[@class='ac_odd ac_over']";
    String btnBuscar = "(//button[@type='submit'])[1]";
    String corPreta = "//a[@name='Black']";

    String SegundoProduto = "(//a[@class='color_pick'])[1]";

    String corAmerala = "//a[@name='Yellow']";
    String comboTamanho = "//select[@name='group_1']";
    String selecaoTamanhoM = "//option[@title='M']";

    String selecaoProduto = "(//a[contains(text(),'Printed Summer Dress')])[4]";

    String quantidadeProduto = "//div[@class='product_attributes clearfix']//input[@id='quantity_wanted']";

    String adicionarCarrinho = "//span[contains(text(),'Add to cart')]";

    String btnCOntinuarComprando = "//span[@class='continue btn btn-default button exclusive-medium']//span";

    String blouse = "(//a[@title='Blouse'])[1]";

    String finalizarCompra = "//span[contains(text(),'Proceed to checkout')]";

    String concluirCompra = "(//span[contains(text(),'Proceed to checkout')])[2]";

    String diminuirItem = "(//i[@class='icon-minus'])[1]";

    String removerItem = "(//i[@class='icon-trash'])[2]";

    String email = "(//input[@name='email'])[1]";

    String senhaUsuario = "(//input[@name='passwd'])[1]";

    String btnSingIn = "(//button[@name='SubmitLogin'])[1]";

    String chekTermo = "//div[@class='checker']";

    String pagamentoCartao = "//a[@class='bankwire']";

    String btnConfirmarFormaDePagamento = "//span[contains(text(),'I confirm my order')]";

    public buscarItensPage(WebDriver driver) {
        this.driver = driver;

    }


    public void clicarRegistrar(){
        driver.findElement(By.xpath(campoBuscar)).click();
    }

    public void digitarProduto(String produto){
        driver.findElement(By.xpath(campoBuscar)).sendKeys(produto);
    }
    public void btnBuscar(){
        driver.findElement(By.xpath(btnBuscar)).click();
    }

    public void selecaoproduto() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,500)");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selecaoProduto))).click();

    }
    public void selecaoCor(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,350)");
        escolhaCorPreta();
    }

    public void comboTamanhoProduto(){
        driver.findElement(By.xpath(comboTamanho)).click();
    }

    public void selecaoTamanhoM(){
        driver.findElement(By.xpath(selecaoTamanhoM)).click();
    }

    public void escolhaCorPreta() {
        if (driver.findElement(By.xpath(corAmerala)).isDisplayed()) {
            driver.findElement(By.xpath(corAmerala)).click();
        }else{
            driver.findElement(By.xpath(corPreta)).click();
        }
    }

    public void quantidadeProduto(String quantidade){
        driver.findElement(By.xpath(quantidadeProduto)).clear();
        driver.findElement(By.xpath(quantidadeProduto)).sendKeys(quantidade);
    }

    public void adicionarAoCarrinho(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,350)");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(adicionarCarrinho))).click();
    }

    public void continuarComprando() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnCOntinuarComprando))).click();
    }

    public void campobuscarProduto(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,-350)");
    }

    public void limparCampo(){
        driver.findElement(By.xpath(campoBuscar)).clear();
    }

    public void selecaoSegundoProduto(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,500)");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SegundoProduto))).click();
        jse.executeScript("scroll(0,500)");
    }

    public void fazerCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(finalizarCompra))).click();
    }

    public void diminuirQuantidade(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,500)");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(diminuirItem))).click();
    }

    public void removerProduto(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(removerItem))).click();
    }

    public void btnConcluirCompra(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,500)");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(concluirCompra))).click();
    }

    public void  informar_dados_do_usuario(String usuario, String senha){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,500)");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(email))).sendKeys(usuario);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(senhaUsuario))).sendKeys(senha);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnSingIn))).click();
    }

    public void  finalizarCompra(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,500)");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(concluirCompra))).click();
        jse.executeScript("scroll(0,500)");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(chekTermo))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(concluirCompra))).click();
    }

    public void  formaDePagamento(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,500)");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pagamentoCartao))).click();
        jse.executeScript("scroll(0,500)");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnConfirmarFormaDePagamento))).click();
        jse.executeScript("scroll(0,500)");
    }

}
