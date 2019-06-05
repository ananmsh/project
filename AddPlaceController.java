package Controller;

import java.io.IOException;

import application.Main;
import entities.City;
import entities.Place;

public class AddPlaceController {

	public void addPlace(Place newP) throws IOException
	{
	   	 Main.getClient().getClient().AddingNewData(newP);
		
	}
	
	
	
}
