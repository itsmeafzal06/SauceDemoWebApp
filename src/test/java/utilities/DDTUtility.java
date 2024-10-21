package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DDTUtility {
	@DataProvider(name="logindata")
	public String[][] getData() throws IOException{
		String path = ".//testData//SauceDemoWebApp.xlsx";
		ExcelUtility xlutils = new ExcelUtility(path);
		int totalrow=xlutils.getRowCount("loginCreds");
		int totalcell = xlutils.getCellCount("loginCreds", totalrow);
		
		String loginData[][]= new String[totalrow][totalcell];
		for(int r=1;r<=totalrow;r++) {
			for(int c=0;c<totalcell;c++) {
				loginData[r-1][c]=xlutils.getCellData("loginCreds", r, c);
			}
		}
		return loginData;
				
	}
}
