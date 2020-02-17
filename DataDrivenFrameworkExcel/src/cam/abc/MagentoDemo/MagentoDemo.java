package cam.abc.MagentoDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;

public class MagentoDemo {

		public static FileInputStream fis;
		public static XSSFWorkbook book;
		public static XSSFSheet sheet;
		public static int noOfRows;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static String data;
		public static WebDriver driver;
		
		
	public static String getSheets(int rownum,int cellnum)
	{
		 row = sheet.getRow(rownum);
		 cell = row.getCell(cellnum);
		 data=cell.getStringCellValue();
		 System.out.println(data);
		 return data;

	}
	public static void main(String[] args) throws IOException
	{
		fis = new FileInputStream("F:\\Selenium component\\DataDrivenFrameworkExcel\\src\\cam\\abc\\Utilities\\Book1.xlsx");
		book=new XSSFWorkbook(fis);
		sheet=book.getSheetAt(0);
		noOfRows=sheet.getPhysicalNumberOfRows();
		driver=new ChromeDriver();
		System.out.println(noOfRows);
		for (int i = 1; i <noOfRows; i++) 
		{
			String action =getSheets(i, 2);
			System.out.println(action);
		
		switch (action) {
		case "open":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			break;
		case "navigate":
			driver.get(getSheets(i, 3));
			break;
		case "click":
			driver.findElement(By.xpath(getSheets(i, 4))).click();
			break;
		case "type":
			driver.findElement(By.xpath(getSheets(i, 4))).sendKeys(getSheets(i, 3));
			break;
		case "close":
			driver.quit();
			break;
		default:
			break;
		}
		
		
		
		}
		
	}

}
