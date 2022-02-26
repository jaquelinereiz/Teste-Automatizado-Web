package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProtutoTeste extends BaseTest {
    
    private static final String String = null;
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controlleProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controlleProdutoPage = new ControleDeProdutoPO(driver);

        assertEquals(controlleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controlleProdutoPage.buttonAdicionar.click();
        // TODO: Remover este segundo click assim que o sistema for corrigido.
        controlleProdutoPage.buttonAdicionar.click();

        String titulo = controlleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);

        controlleProdutoPage.buttonSair.click();
        controlleProdutoPage.buttonSair.click();
    }


    @Test
    public void TC002_naoDeveSerPossivelCadatrarUmProdutoSemPreencherTodosOsCampos(){
        
        //mensagem de erro
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";

        //Comando para entrar na página de cadastrar produtos.
        controlleProdutoPage.buttonAdicionar.click();


        //Aqui é criado o objeto para adicionar na tela(produto para cadastrar).
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);

        //Aqui realmente é adicionado as informações do objeto(produto) na tela.
        //Aqui estamos testando se o produto é adicionado sem código.

        produtoBuilder
        .adicionarCodigo("")
        .builder();

        //Aqui será capturado a mensagem de erro
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é adicionado sem nome.
        produtoBuilder
        .adicionarQuantidade(2)
        .adicionarNome("")
        .builder();

        //Aqui será capturado a mensagem de erro
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());


        //Aqui estamos testando se o produto é adicionado sem quantidade.
        produtoBuilder
        .adicionarCodigo("00005")
        .adicionarQuantidade(null)
        .builder();

        //Aqui será capturado a mensagem de erro
        //String mensagem = controlleProdutoPage.spanMensagem.getText();

        //assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é adicionado sem valor.
        produtoBuilder
        .adicionarNome("Borracha")
        .adicionarValor(null)
        .builder();

        //Aqui será capturado a mensagem de erro
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());


        //Aqui estamos testando se o produto é adicionado sem data.
        produtoBuilder
        .adicionarValor(54.90)
        .adicionarData("")
        .builder();

        //Aqui será capturado a mensagem de erro
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

        //Comando para sair da página de cadastro dos produtos.
        controlleProdutoPage.buttonSair.click();
    }

}
