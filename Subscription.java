package entities;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Subscription {
	
	public Timestamp DateStart;
	public Timestamp DateEnd;
	public Timestamp OneTimeDate;

	public enum PurchaseType {
		OneTime , ALimitedPeriod
	};
	public PurchaseType purchaseType;
	private City city;
	
	
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Timestamp getDateStart() {
		return DateStart;
	}
	public void setDateStart(Timestamp dateStart) {
		DateStart = dateStart;
	}
	public Timestamp getDateEnd() {
		return DateEnd;
	}
	public void setDateEnd(Timestamp dateEnd) {
		DateEnd = dateEnd;
	}
	public Timestamp getOneTimeDate() {
		return OneTimeDate;
	}
	public void setOneTimeDate(Timestamp oneTimeDate) {
		OneTimeDate = oneTimeDate;
	}
	public PurchaseType getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(PurchaseType purchaseType) {
		this.purchaseType = purchaseType;
	}
	
	
	

	

	
}
