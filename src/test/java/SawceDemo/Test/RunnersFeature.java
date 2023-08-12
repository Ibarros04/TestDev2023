package SawceDemo.Test;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = { "src/test/resources/features" }
                , glue = { "SawceDemo.Definitions" }
        //       ,tags = "@tag1"  //Quitar comentario si se desea ejecutar unicamente un caso en especifico
)

public class RunnersFeature {

}
