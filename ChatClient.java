package application;


import ocsf.client.*;
import java.io.*;
import java.util.ArrayList;

import entities.Customer;

public class ChatClient extends AbstractClient
{
  ChatIF clientUI; 
  ArrayList<String> PlacesNames;
  ArrayList<String> cityNames;
  ArrayList<String> cityReport;
  ArrayList<String> MapsNames;
  
/////////////////////////////////////////////////getters&setters//////////////////////////////////  
  public ArrayList<String> getCityNames() {
	return cityNames;
}

public ArrayList<String> getMapsNames() {
	return MapsNames;
}

public void setMapsNames(ArrayList<String> mapsNames) {
	MapsNames = mapsNames;
}

public void setCityNames(ArrayList<String> cityNames) {
	this.cityNames = cityNames;
}

public ArrayList<String> getCityReport() {
	return cityReport;
}

public void setCityReport(ArrayList<String> cityReport) {
	this.cityReport = cityReport;
}

public ChatClient(String host, int port, ChatIF clientUI)  throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
    PlacesNames=new ArrayList<String>();
    cityNames=new ArrayList<String>();
    cityReport=new ArrayList<String>();
    MapsNames=new ArrayList<String>();
  }

  public ArrayList<String> getPlacesNames() {
	return PlacesNames;
}
 
public void setPlacesNames(ArrayList<String> placesNames) {
	PlacesNames = placesNames;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////

public void handleMessageFromServer(Object obj) 
  {
	if(((ArrayList<String>)obj).get(0).equals("PlacesNames")) 
	{
		((ArrayList<String>)obj).remove(0);
		setPlacesNames((ArrayList<String>)obj);
	}
	else if(((ArrayList<String>)obj).get(0).equals("CityNames"))
	{
		((ArrayList<String>)obj).remove(0);
		setCityNames((ArrayList<String>)obj);
		
	}
	else if(((ArrayList<String>)obj).get(0).equals("ReportNames"))
	{
		((ArrayList<String>)obj).remove(0);
		setCityReport((ArrayList<String>)obj);
	}
	else if(((ArrayList<String>)obj).get(0).equals("MapsNames"))
	{
		((ArrayList<String>)obj).remove(0);
		setMapsNames((ArrayList<String>)obj);
	}
	 
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  public void AddingNewData(Object obj) throws IOException
  {
	  
	  sendToServer(obj);
	   
  }
  
///////////////////////////////////////////////////////////////////////////////////////////////////////////// 
  public void StringsToServer(ArrayList<String> strings) throws IOException
  {
	  sendToServer(strings);
	  
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public void handleMessageFromClientUI(String message)  
  {
    try
    {
    	if(message.equals("GetPlacesForNewTour")) //incase the job is to get city names for combobox
    	{
    		ArrayList<String> toGetCities=new ArrayList<String>();
    		toGetCities.add("GetPlacesNames"); //fill the first slot with the job name for the next method to work right
    		toGetCities.add("SELECT Name FROM project.place;");//the query to be executed in the next method 
    		sendToServer(toGetCities);
    	}
    	else if(message.equals("GetCitiesForComboBox")) //incase the job is to get city names for combobox
        	{
        		ArrayList<String> toGetCities=new ArrayList<String>();
        		toGetCities.add("GetCityNames"); //fill the first slot with the job name for the next method to work right
        		toGetCities.add("SELECT CityName FROM project.city;");//the query to be executed in the next method 
        		sendToServer(toGetCities);
        	}
    	
    }
    catch(IOException e)
    {
      clientUI.display ("Could not send message to server.  Terminating client.");
      quit();
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
}

