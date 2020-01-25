import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ui {

	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\eclipse\\java-2019-12\\chromedriver.exe");
		driver = new ChromeDriver();		
	}

	@Test
	public void test() {
		String url = "https://jobs.lever.co/centro";
		String location = "location=Toronto%2C%20ON";
		//String location = "location=Dallas%2C%20TX"; // to fail the test
		String team = "team=Engineering";
		driver.get(url + "?" + location + "&" + team);
		
		List<WebElement> postings = driver.findElements(By.className("posting"));
		assertTrue(!postings.isEmpty());
		
		for(WebElement p: postings)
		{
			System.out.println(p.findElement(By.tagName("h5")).getText());
		}
	}

}
