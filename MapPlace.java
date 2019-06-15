package entities;

import java.io.Serializable;

public class MapPlace implements Serializable {
 
	private String PlaceName;
	private double corX;
	private double corY;
	
	public MapPlace(String name,double x,double y)
	{
		this.PlaceName=name;
		this.corX=x;
		this.corY=y;	
	}

	public String getPlaceName() {
		return PlaceName;
	}

	public void setPlaceName(String placeName) {
		PlaceName = placeName;
	}

	public double getCorX() {
		return corX;
	}

	public void setCorX(double corX) {
		this.corX = corX;
	}

	public double getCorY() {
		return corY;
	}

	public void setCorY(double corY) {
		this.corY = corY;
	}
	 
	
	
	
	
}
