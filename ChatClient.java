package application;


import ocsf.client.*;
import java.io.*;
import java.util.ArrayList;

import entities.Customer;

public class ChatClient extends AbstractClient
{
  ChatIF clientUI; 
  ArrayList<String> PlacesNames;
public ChatClient(String host, int port, ChatIF clientUI)  throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
    PlacesNames=new ArrayList<String>();
  }

  public ArrayList<String> getPlacesNames() {
	return PlacesNames;
}

public void setPlacesNames(ArrayList<String> placesNames) {
	PlacesNames = placesNames;
}

public void handleMessageFromServer(Object obj) 
  {
	 setPlacesNames((ArrayList<String>)obj);
  }

  
  public void AddingNewData(Object obj) throws IOException
  {
	  sendToServer(obj);
	   
  }
  
  
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
    	else
    	{
    		ArrayList<String> toGetVersion=new ArrayList<String>();
    		 toGetVersion.add("GetCityVersion");//fill the first slot with the job name for the next method to work right
    		 toGetVersion.add(message);//add the city name so the server can return the right version
    		sendToServer(toGetVersion);
    	}
    }
    catch(IOException e)
    {
      clientUI.display ("Could not send message to server.  Terminating client.");
      quit();
    }
  }

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

