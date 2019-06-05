package Controller;

import java.io.IOException;

import application.Main;

public class AddTourController {

	public void GetPlacesForTour() throws IOException
	{
		  Main.getClient().sendToMyCLient("GetPlacesForNewTour");//incase the job is to get city names for combobox
	        try {
				Thread.currentThread().sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	}
	
	
	
}
