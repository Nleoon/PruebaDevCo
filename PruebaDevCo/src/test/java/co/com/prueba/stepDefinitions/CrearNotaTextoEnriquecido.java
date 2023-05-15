package co.com.prueba.stepDefinitions;

import co.com.prueba.questions.GetText;
import co.com.prueba.taks.EscribirNotaNegrita;
import co.com.prueba.utils.MyScreenRecorder;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class CrearNotaTextoEnriquecido {

    //CREAR AVRIABLES DE NAVEGADOR Y ACTOR
    @Managed(driver= "chrome")
    WebDriver driver;

    @Before("@NotaNegritaScenario1")
    public void setThestage() throws Exception {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Global");
    }

    @Given("^el usuario ingresa en bloc de notas online$")
    public void elUsuarioIngresaEnBlocDeNotasOnline() throws Exception {
        // ALMACENAMOS EL NOMBRE DE LA CLASE
        String nomScenario = Thread.currentThread().getStackTrace()[1].getClassName();
        // CREAR CARPETA PARA ALMACENAMIENTO DE VIDEOS
        File rutaCarpeta = MyScreenRecorder.crearCarpeta(nomScenario);
        // INICIAMOS LA GRABACION
        MyScreenRecorder.startRecording(rutaCarpeta);

        // INGRESAMOS A LA URL
        theActorInTheSpotlight().wasAbleTo(Open.url("https://www.online-notepad.net/es/bloc-de-"));
    }

    @When("^ingresa en el apartado 'Nota de texto enriquecido' donde crea su nota (.*) en negrita$")
    public void ingresaEnElApartadoNotaDeTextoEnriquecidoDondeCreaSuNotaEnNegrita(String nota_usuario) {
        //CREAMOS LA NOTA EN NEGRITA
        theActorInTheSpotlight().attemptsTo(EscribirNotaNegrita.escribirNota(nota_usuario));
    }

    @Then("^la nota se ha creado con exito$")
    public void laNotaSeHaCreadoConExito() throws Exception {
        // VALIDACION
        theActorInTheSpotlight().should(seeThat("Validacion nota", GetText.getTextNota(),equalTo("Buen dia presento la prueba tecnica devCo by NicolasBolivarLeon")));

        // FINALIZA LA GRABACION DE EVIDENCIA
        MyScreenRecorder.stopRecording();
    }
}
