import org.openqa.selenium.server.SeleniumServer;
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class testSchedulePage extends SeleneseTestCase {
	static SeleniumServer server = null;
	@Before
	public void setUp() throws Exception {
	try {
	if(server == null) {
	server = new SeleniumServer();
	server.start();
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	setUp("https://prodweb.rose-hulman.edu/regweb-cgi/reg-sched.pl", "*firefox");
	}

	@Test
	public void testUntitled() throws Exception {
		selenium.open("/regweb-cgi/reg-sched.pl");
		selenium.type("id1", "lapresga");
		selenium.click("bt1");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("CSSE376-01"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
