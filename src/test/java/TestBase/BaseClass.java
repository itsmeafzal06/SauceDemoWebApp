package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//confi.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("environment").equalsIgnoreCase("remote")){
			DesiredCapabilities dc = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("linux")) {
				dc.setPlatform(Platform.LINUX);
			}
			if(os.equalsIgnoreCase("windows")) {
				dc.setPlatform(Platform.WIN11);
			}
			if(os.equalsIgnoreCase("mac")) {
				dc.setPlatform(Platform.MAC);
			}
			
			if(br.equalsIgnoreCase("chrome")) {
				dc.setBrowserName("chrome");
			}
			if(br.equalsIgnoreCase("firefox")) {
				dc.setBrowserName("firefox");
			}
			
			
		}
		
		if(p.getProperty("environment").equalsIgnoreCase("Local")) {
			switch (br.toLowerCase()) {
			case "chrome":driver=new ChromeDriver();break;
			case "firefox":driver=new FirefoxDriver(); break;
			case "edge":driver= new EdgeDriver();break;
			
			default:System.out.println("invalid browser");break;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get(p.getProperty("url"));
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
 public String captureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp + ".png";
		File targetFile= new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
 
 
 	public String randonString() {
 		String st=RandomStringUtils.randomAlphabetic(6);
 		return st;
 	}
 	
 	public String randomNum() {
 		String num=RandomStringUtils.randomNumeric(10);
 		return num;
 	}
 
 	public String randomAlfaNum() {
 		String alfaNum=RandomStringUtils.randomAlphanumeric(10);
 		return alfaNum;
 	}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
