package W5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {
	private WebDriver driver;
	private static String url;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chorme.driver","D:\\Game\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		url= "http://demo.guru99.com/test/web-table-element.php";
		driver.get(url);
		driver.manage().window().maximize();
		
		//getTotalRowNumber(driver);
		
		//getTotalColNumber(driver);
		
		//getRowNumberByValue(driver, "REC");
		
		getTableCellValue(driver,19, 3);
	}
	public static void getTotalRowNumber(WebDriver driver) {
		List <WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.print("Rows: "+rows.size());
        driver.close();
	}
	public static void getTotalColNumber(WebDriver driver) {
		List <WebElement> cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.print("Columns: "+cols.size());
        driver.close();
	}
	public static void getRowNumberByValue(WebDriver driver,String value) {
		 List <WebElement> listElement= driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
	        for (int i=0; i< listElement.size() ; i++) {
	            if (listElement.get(i).getText().equals(value)) {
	                System.out.print("Found item at row "+i);
	            }
	            else {
	                System.out.println("Items " + value +" was not found"); 
	            }
	        }
	}
	public static void getTableCellValue(WebDriver driver,int row,int col) {
		 List <WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
	        WebElement SelectedRow = rows.get(row);
	        List <WebElement> cols = SelectedRow.findElements(By.xpath("//td"));
	        System.out.println(cols.get(col).getText());
	}
}