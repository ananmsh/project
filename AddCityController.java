package Controller;

import java.io.IOException;
import application.Main;
import entities.City;

public class AddCityController {
     
	public void AddCity(String name) throws IOException
	{
		City toAdd=new City(name);
	   	 Main.getClient().getClient().AddingNewData(toAdd);
	}
}
