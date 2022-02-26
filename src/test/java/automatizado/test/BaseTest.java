package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Esta pasta serve como base do teste, todo teste passa por esta pasta//
//É uma class base onde as outras classes irão herdar dela usando conceito de Herança//
//Uma classe "abstract" significa que ela não pode ser instanciada, apenas herdada//

/**
 * Classe base que serve de herança para todas as classes de teste.
 */
public abstract class BaseTest {
    
    /** Driver do navegador da página atual. */
    protected static WebDriver driver;

    /** Caminho base da URL do sistema a ser testado. */
    private static final String URL_BASE = "file:///C:/Users/Relliaze/Documents/Curso%20Udemy/Testes%20Automatizados%20Web/sistema/login.html";

    /** Caminho relativo do driver ao projeto referente ao path(é o caminho relativo do driver dentro do projeto referente ao path(o path é a pasta "src" que se encontra dentro da página automatizado)). */
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-versao-96.0.4664.45.exe";

    /**
     * Método para iniciar o driver do navegador ANTES de qualquer classe de teste.
     */
    //o "@beforeClass" faz com que seja o primeiro comando/metodo a ser rodado, ou seja, ANTES de todo o resto//
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Método para finalizar o driver do navegador DEPOIS de qualquer classe de teste.
     */
    //o "@AfterClass" faz com que seja o ultimo comando/metodo a ser rodado, ou seja, DEPOIS de todo o resto//
    @AfterClass
    public static void finalizar(){
        //comando fechar o navegador
        driver.quit();
    }
}
