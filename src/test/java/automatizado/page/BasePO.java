package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas PageObjects.
 * Toda as pages devem ser herdadas desta classe.
 */
public abstract class BasePO {

    public static Object input;
    /**Driver base que será usado pelas pages  */
    protected WebDriver driver;
    
    /**
     * Construtor base para criação da fabrica de elementos(PageFactory).
     * @param driver Driver da página atual.
    */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Método que retorna o título da página atual.
     * @return
     */

    public String obterTituloPagina(){
        return driver.getTitle();
    }

    /**
     * Mátodo que escreve em qualquer WebElement do tipo input e dá um TAB ao final.
     * @param input Input a qual será escrito.
     * @param Texto Texto que será escrito no input.
     */
    public void escrever(WebElement input, String Texto){
        input.clear();
        input.sendKeys(Texto + Keys.TAB);
    }
}
