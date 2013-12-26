import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

public class RaceAcceptanceTest {

    private static final int PORT = 3333;
    private static final String LOCALHOST = "http://localhost:" + PORT;

    public static final String EMAIL = "john@testing.com";
    public static final String FIRST_NAME = "John";
    public static final String SURNAME = "Smith";

    @Test
    public void createRace() {
        runTest(new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo(LOCALHOST);
                assertThat(browser.title()).contains("Race Reviews");
            }
        });
    }


    private void runTest(Callback<TestBrowser> callback) {
        running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, callback);
    }

}
