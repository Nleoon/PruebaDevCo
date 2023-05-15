package co.com.prueba.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RichTextNotePage {

    // RICH TEXT NOTE
    public static final Target BTN_NEGRITA = Target.the("BOTON NEGRITA").
            locatedBy("/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[3]/div[3]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]");

    public static final Target TXT_EDITOR = Target.the("EDITOR DE TEXTO").
            locatedBy("//div[@id='editor']");
}
