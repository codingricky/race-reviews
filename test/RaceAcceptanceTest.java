import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;
import static play.test.Helpers.*;

public class RaceAcceptanceTest {

    private static final int PORT = 3333;
    private static final String LOCALHOST = "http://localhost:" + PORT;

    @Test
    public void createRace() {
        runTest(new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo(LOCALHOST);
                browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                assertThat(browser.title()).contains("Race Reviews");

                browser.$("#plus").click();
                browser.fill("#name").with("Marathon");
                browser.click("#state", withText("VIC"));
                browser.submit("#form");

                assertThat(browser.title()).contains("Race Reviews");
                assertThat(browser.$("#state").getText()).contains("VIC");
            }
        });
    }


    private void runTest(Callback<TestBrowser> callback) {
        running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, callback);
    }

}
