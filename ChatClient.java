package application;

import ocsf.client.*;
import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import entities.Customer;
import entities.MapPlace;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChatClient extends AbstractClient
{
  ChatIF clientUI; 
  ArrayList<String> PlacesNames;
  ArrayList<String> cityNames;
  ArrayList<String> cityReport;
  ArrayList<String> MapsNames;
  Image image;
  String s;                            //
  ArrayList<MapPlace> MapPlaces; 
  String LoginAnswer;
  
//////////////////////////////////////////////////Constructor////////////////////////////////////
  
  public ChatClient(String host, int port, ChatIF clientUI)  throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
    PlacesNames=new ArrayList<String>();
    cityNames=new ArrayList<String>();
    cityReport=new ArrayList<String>();
    MapsNames=new ArrayList<String>();
    image=null;
    s= new String();                                    //
    MapPlaces=new ArrayList<MapPlace>();  
    LoginAnswer= new String();
  }
  
/////////////////////////////////////////////////getters&setters//////////////////////////////////  

  public ArrayList<MapPlace> getMapPlaces() {
	return MapPlaces;
}

public void setMapPlaces(ArrayList<MapPlace> mapPlaces) {
	MapPlaces = mapPlaces;
}
  
public String getLoginAnswer() {
	return LoginAnswer;
}

public void setLoginAnswer(String loginAnswer) {
	LoginAnswer = loginAnswer;
}
  
  public String getS() {
	return s;
}

public void setS(String s) {
	this.s = s;
}


public Image getImage() {
	return image;
}

public void setImage(Image image) {
	this.image = image;
}

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

public ArrayList<String> getPlacesNames() {
	return PlacesNames;
}

public void setPlacesNames(ArrayList<String> placesNames) {
	PlacesNames = placesNames;
}



//////////////////////////////////////////Returns from server!!!!!!!!/////////////////////////////////////////////////////

public void handleMessageFromServer(Object obj) 
  {
  	
	if(obj instanceof MyFile)
	{
		 MyFile file;
		  int fileSize =((MyFile)obj).getSize(); 
		  file=new MyFile(((MyFile)obj).getFileName());
		  File picfile=new File("src\\Images\\"+file.getFileName());
		  try { 
			  FileOutputStream fos = new FileOutputStream(picfile);
			   try {
				fos.write(((MyFile)obj).getMybytearray());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   FileInputStream input = new FileInputStream(picfile);
			   image= new Image(input);
		  } catch (FileNotFoundException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }		
	}

	else if(obj instanceof ArrayList)
	{
		if(((ArrayList<String>)obj).get(0) instanceof String )
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
			else if(((ArrayList<String>)obj).get(0).equals("LoginAnswer"))
			{
				((ArrayList<String>)obj).remove(0);
				if(((ArrayList<String>)obj).get(0).equals("LogCustomer")) 
				{
					setLoginAnswer("Customer");
				}
				else if (((ArrayList<String>)obj).get(0).equals("LogEmployee")) 
				{
					setLoginAnswer("Employee");
				}
				else if(((ArrayList<String>)obj).get(0).equals("LogFailed"))
					setLoginAnswer("Failed");
			}

		}
		else if(((ArrayList<MapPlace>)obj).get(0) instanceof MapPlace )
		{
			
			if(((ArrayList<MapPlace>)obj).get(0).getPlaceName().equals("returnedMapPlaces"))       //////////
			{
				((ArrayList<MapPlace>)obj).remove(0);
				setMapPlaces((ArrayList<MapPlace>)obj);

			}
		}
	}

	
	
  }

  //////////////////////////////////////////Sending To server ///////////////////////////////////////////////////////////////
  public void AddingNewData(Object obj) throws IOException
  {
	  
	  sendToServer(obj);
	   
  }
  
 
  public void StringsToServer(ArrayList<String> strings) throws IOException
  {

	  sendToServer(strings);
	  
  }
  
    public void MapToUpdate(MapPlace x) throws IOException         
  {
	  
    	sendToServer(x);
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
