import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class Appointment {
	@Test
	void test() throws InterruptedException {
		  WebDriver driver = null;
	        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	        driver = new ChromeDriver();
	        
	          
	        
	        driver.get("https://katalon-demo-cura.herokuapp.com/");
	        driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
	        driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys("John Doe");
	        driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
	        Select option1 = new Select(driver.findElement(By.xpath("//*[@id=\"combo_facility\"]")));
	        option1.selectByVisibleText("Hongkong CURA Healthcare Center");
	        driver.findElement(By.xpath("//*[@id=\"chk_hospotal_readmission\"]")).click();
	        WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]/div/label[2]"));
	        radio1.click();
	        driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys("18012023");
	        driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Test");
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
	        
	        
	        //Add Validate
	        String result = driver.findElement(By.id("comment")).getText();
	        
	        if(result.equalsIgnoreCase("Heart"))
	        	System.out.println("Pass");
	        else
	        	System.out.println("Fail");
	        Thread.sleep(4000);
	         driver.quit();
	         driver = null;
	}

}

