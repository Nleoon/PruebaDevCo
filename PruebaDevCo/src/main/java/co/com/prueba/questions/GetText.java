package co.com.prueba.questions;

import co.com.prueba.userInterfaces.RichTextNotePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class GetText {

    public static Question<String> getTextNota(){
        return actor -> TextContent.of(RichTextNotePage.TXT_EDITOR).viewedBy(actor).asString().trim();
    }


}
