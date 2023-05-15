package co.com.prueba.taks;

import co.com.prueba.userInterfaces.HomePage;
import co.com.prueba.userInterfaces.RichTextNotePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import static co.com.prueba.utils.BaseClass.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirNotaNegrita implements Task {

    private String nota_usuario;

    public EscribirNotaNegrita(String nota_usuario){

        this.nota_usuario = nota_usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                click(HomePage.BTN_RICH_TEXT_NOTE),
                waitIsEnabled(RichTextNotePage.BTN_NEGRITA,60),
                scrollTop(RichTextNotePage.BTN_NEGRITA),
                click(RichTextNotePage.BTN_NEGRITA),
                scrollTop(RichTextNotePage.TXT_EDITOR),
                Clear.field(RichTextNotePage.TXT_EDITOR),
                Hit.the(Keys.ENTER).into(RichTextNotePage.TXT_EDITOR),
                sendKey(nota_usuario,RichTextNotePage.TXT_EDITOR)
        );
    }

    public static EscribirNotaNegrita escribirNota(String nota_usuario){
        return instrumented(EscribirNotaNegrita.class,nota_usuario);
    }
}

