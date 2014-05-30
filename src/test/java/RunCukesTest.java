import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by muhammadqureshi on 26/05/2014.
 */

@RunWith(Cucumber.class)

@Cucumber.Options
        (
                tags = {"@run"},
                format = {},
                glue = {"stepDefs"}

        )

public class RunCukesTest {
}
