package Controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;

public class ReportController {

	
	public void GetCityComboBox()
	{
	    try {
				Main.getClient().sendToMyCLient("GetCitiesForComboBox");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//incase the job is to get city names for combobox
	         try {
	 			Thread.currentThread().sleep(3000);
	 		} catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
		
	}
	
	public void GetCityReport(String cityName)
	{
		ArrayList<String> CityForReport=new ArrayList<String>();
		CityForReport.add("GetCityReport");
    	CityForReport.add(cityName);//gets the selected city
    	
    	try {
    		Main.getClient().getClient().StringsToServer(CityForReport);
    	} catch (IOException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	try {
    		Thread.currentThread().sleep(500);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
	
	
	
	
}
