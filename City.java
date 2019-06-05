package entities;

import java.io.Serializable;
import java.util.ArrayList;


public class City implements Serializable {
	private String CityName;
	private ArrayList<Map> Maps;
	private int NumOfMaps;
	private ArrayList<Tour> RecommendedTours;
	private int NumOfTours;
	
public City(String name)
{
	this.CityName=name;
	NumOfMaps=0;
	NumOfTours=0;
	Maps=new ArrayList<>();
	RecommendedTours=new ArrayList<>();
}


	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public ArrayList<Map> getMaps() {
		return Maps;
	}
	public void setMaps(ArrayList<Map> maps) {
		Maps = maps;
	}
	public int getNumOfMaps() {
		return NumOfMaps;
	}
	public void setNumOfMaps(int numOfMaps) {
		NumOfMaps = numOfMaps;
	}
	public ArrayList<Tour> getRecommendedTours() {
		return RecommendedTours;
	}
	public void setRecommendedTours(ArrayList<Tour> recommendedTours) {
		RecommendedTours = recommendedTours;
	}
	public int getNumOfTours() {
		return NumOfTours;
	}
	public void setNumOfTours(int numOfTours) {
		NumOfTours = numOfTours;
	}
}
