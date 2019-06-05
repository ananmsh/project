package entities;

import java.io.Serializable;
import java.sql.Time;

public class Place implements Serializable {

	private String LocName;
	private String LocType;
	private String LocDescription;
	private boolean accessible;
	private String SumRecommendedTime;
	
	public Place(String name,String type,String description,boolean accessible,String timeOfVisit)
	{
		LocName=name;
		LocType=type;
		LocDescription=description;
		this.accessible=accessible;
		SumRecommendedTime=timeOfVisit;
	}
	public String getLocName() {
		return LocName;
	}
	public void setLocName(String locName) {
		LocName = locName;
	}
	public String getLocType() {
		return LocType;
	}
	public void setLocType(String locType) {
		LocType = locType;
	}
	public String getLocDescription() {
		return LocDescription;
	}
	public void setLocDescription(String locDescription) {
		LocDescription = locDescription;
	}
	public String getSumRecommendedTime() {
		return SumRecommendedTime;
	}
	public void setSumRecommendedTime(String sumRecommendedTime) {
		SumRecommendedTime = sumRecommendedTime;
	}
	public boolean getSpecial() {
		return accessible;
	}
	public void setSpecial(boolean special) {
		this.accessible = special;
	}
	
	
	
}
