package admin_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class home {
	WebDriver wb;
	@Test
	@Parameters("browser")
	public void driverpage(String l) { // open page Ptconnect
		if (l.equals("chrome")) {
			String path = System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			wb = new ChromeDriver();
			wb.get("http://172.16.0.45/PTCONNECT/ADMIN/");
		} else if (l.equals("mozila")) {
			String path =System.getProperty("user.dir")+ "\\driver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			wb = new FirefoxDriver();
			wb.get("http://172.16.0.45/PTCONNECT/ADMIN/");
		} else {
			System.out.println("....hello PTCONNECT user!....");

		}
	}

	@Test(priority = 1, enabled = true) // valid data entry for admin login
	public void loginid() throws InterruptedException {
		Select op = new Select(wb.findElement(By.xpath("//select[@class='form-control']")));
		op.selectByValue("admin");

		wb.findElement(By.xpath("//input[@class='form-control']")).sendKeys("admin@gmail.com");

		wb.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");

		wb.findElement(By.xpath("//button[@name='login']")).click();

	}

	
	@Test(priority=3)
	public void homed() throws InterruptedException{
	
		wb.findElement(By.xpath("//span[@class='fa fa-chevron-down']")).click(); //home click
		Thread.sleep(2000);
		wb.findElement(By.xpath("//a[@href='dash.php']")).click();   //dashboard click
		System.out.println("home display");
		
	}
		
	}
