package baseClass;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import readXLFile.ReadDataFromXL;

public class ProjectSpecificMethods {
		
		public RemoteWebDriver driver;
		public String xlfileName;
		
		@Parameters ({"url"})
		
		@BeforeMethod
		public void testcaseBegins(String url) {
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
			Set<String> windowHandles = driver.getWindowHandles();
			ArrayList<String> list = new ArrayList<String>(windowHandles);
			driver.switchTo().window(list.get(1));
			
			driver.manage().window().maximize();
			
			driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
		
		@AfterMethod
		public void testcaseend() {
			driver.quit();
		}
		
		@DataProvider
		public String[][] sendData() throws IOException
		{
			String[][] data = ReadDataFromXL.getdata(xlfileName);
			return data;
		}

	}


