package entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;

public class Tour implements  Serializable {
	private String TourName;
	private String TourDescription;
	private ArrayList<String> Locations;
	private String SumRecommendedTime;
	
	
	
	public Tour(String name,String description,String time)
	{
		TourName=name;
		TourDescription=description;
		SumRecommendedTime=time;
		Locations= new ArrayList<String>();
		
	}
	
	

	public String getTourName() {
		return TourName;
	}

	public void setTourName(String tourName) {
		TourName = tourName;
	}

	public String getTourDescription() {
		return TourDescription;
	}

	public void setTourDescription(String tourDescription) {
		TourDescription = tourDescription;
	}

	public ArrayList<String> getLocations() {
		return Locations;
	}

	public void setLocations(ArrayList<String> locations) {
		Locations = locations;
	}

	public Time getRecommendedTime() {
		return getRecommendedTime();
	}
	
	public void setRecommendedTime(String recommendedTime) {
		SumRecommendedTime = recommendedTime;
	}

	public String getSumRecommendedTime() {
		return SumRecommendedTime;
	}

	public void setSumRecommendedTime(String sumRecommendedTime) {
		SumRecommendedTime = sumRecommendedTime;
	}

	
	
	
	
	
	
	
}
