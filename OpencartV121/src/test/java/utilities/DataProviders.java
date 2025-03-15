package utilities;

import java.io.IOException;

//import org.openqa.selenium.devtools.v129.io.IO;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		int totalrows=xlutil.getRowcount("Sheet1");
		int totalcols=xlutil.getcellCount("Sheet1",1);
		String logindata[][]=new String [totalrows][totalcols];
		for(int i=1;i<totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				logindata[i-1][j]=xlutil.getcellData("Sheet1", i, j);
			}
		}
		return logindata;
		

	}
}
