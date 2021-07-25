package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name="newarticledata")
	public Object[][] articleData(){
		
		Object[][] Data = new Object[2][4];
		
		Data [0][0]="Title1";
		Data [0][1]="Description1";
		Data [0][2]="Body1";
		Data [0][3]="tag1";
		
		
		Data [1][0]="Title2";
		Data [1][1]="Description2";
		Data [1][2]="Body2";
		Data [1][3]="tag2";
	return Data;
	
	}
}
