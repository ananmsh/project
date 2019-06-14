package entities;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import application.MyFile;

public class Map implements Serializable {
	
	private String MapName;
	private String MapDescription;
	private ArrayList<String> Places;
	private int price;
	private int NoOfTours;
	private String CityName;
	private String version;

	public Map(String name,String description,String CityName)
	{
	    this.MapName=name;
	    MapDescription=description;
	    Places= new ArrayList<String>();
	    price=0;
	    NoOfTours=0;
	    this.CityName=CityName;
		this.version= "0";
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNoOfTours() {
		return NoOfTours;
	}

	public void setNoOfTours(int noOfTours) {
		NoOfTours = noOfTours;
	}

	
	public String getMapName() {
		return MapName;
	}

	public void setMapName(String mapName) {
		MapName = mapName;
	}

	public String getMapDescription() {
		return MapDescription;
	}
	
	public void setMapDescription(String mapDescription) {
		MapDescription = mapDescription;
	}

  
	public ArrayList<String> getLocations() {
		return Places;
	}
	
	public void setLocations(ArrayList<String> locations) {
		Places = locations;
	}
	
	
	
	

}
