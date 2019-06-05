package entities;


public class Customer  extends Person {
	
	private String Password;
	private boolean Logged;
	private String CreditCard;

	public Customer()
	{
		
	}
	
	public Customer(String id, String firstName, String lastName, String eMail, String mobileNum,String password,String CreditCard)
	{
		super(id, firstName, lastName, eMail, mobileNum);
		this.Password = password;
		this.Logged=false;
		this.CreditCard=CreditCard;
	}
	
	public boolean isLogged() {
		return Logged;
	}

	public void setLogged(boolean logged) {
		this.Logged = logged;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
	
	public String getCreditCard() {
		return CreditCard;
	}

	public void setCreditCard(String creditCard) {
		CreditCard = creditCard;
	}

}
