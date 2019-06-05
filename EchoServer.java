package application;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entities.City;
import entities.Customer;
import entities.Place;
import entities.Tour;
import ocsf.server.*;

public class EchoServer extends AbstractServer 
{

  final public static int DEFAULT_PORT = 5555;
  static Connection con1;
  ResultSet rs ;
  Statement stmt;

  public EchoServer(int port) 
  {
    super(port);
  }

  public void handleMessageFromClient(Object obj, ConnectionToClient client)
  {
	 if(obj instanceof Customer)
	 {
	    AddCustomer(obj);
	 }
	 else
	 {
		 if(obj instanceof City)
		 {
			 AddCity(obj);
		 }
		 else
		 {
			 if(obj instanceof Place)
			 {
			    AddPlace(obj);
			 }
			 else
			 {
				 if(obj instanceof Tour)
				 {
				    AddTour(obj);
				 }
				 else
				 {
					    try {
							GetPlacesList(obj,client);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				  }

				 
			 }
		 }
	 }
	 

  }
  /////////////////////////////////////////////////getting places to add tours/////////////////////////////////
  private void GetPlacesList(Object obj,ConnectionToClient client) throws IOException
  {
	  try {
			stmt= con1.createStatement();
		  rs = stmt.executeQuery(((ArrayList<String>)obj).get(1));//executed the required query
		  ArrayList<String> names=new ArrayList<String>();
		 // names.add("GetCityNames");//return the job name so we continue working right
		  while(rs.next()) {
			  names.add(rs.getString(1));
		  }

			client.sendToClient(names);
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
  }
	
////////////////////////////////////////////////////////Adding Data////////////////////////////////////////////////////////
  private void AddTour(Object obj) {
		PreparedStatement stmt2;
		try {
			stmt2 = con1.prepareStatement("INSERT INTO project.tour VALUES (?,?,?)");
		  stmt2.setString(1, ((Tour)obj).getTourName());
		  stmt2.setString(2, ((Tour)obj).getTourDescription());
		  stmt2.setString(3, ((Tour)obj).getSumRecommendedTime());
		  stmt2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//update the version of the selected city accordingly
	
}

private void AddPlace(Object obj) {
	PreparedStatement stmt2;
	try {
		stmt2 = con1.prepareStatement("INSERT INTO project.place VALUES (?,?,?,?,?,?)");
	  stmt2.setString(1, ((Place)obj).getLocName());
	  stmt2.setString(2, ((Place)obj).getLocDescription());
	  stmt2.setString(3, ("0"));
	  stmt2.setString(4 , ((Place)obj).getLocType());
	  stmt2.setBoolean(5 , ((Place)obj).getSpecial());
	  stmt2.setString(6 ,  ((Place)obj).getSumRecommendedTime());
	  stmt2.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//update the version of the selected city accordingly
	
}

private void AddCity(Object obj) {
	
	
	PreparedStatement stmt2;
	try {
		stmt2 = con1.prepareStatement("INSERT INTO project.city VALUES (?,?,?,?,?)");
		
	  stmt2.setString(1, ((City)obj).getCityName());
	  stmt2.setInt(2, ((City)obj).getNumOfMaps());
	  stmt2.setInt(3, 0);
	  stmt2.setInt(4, ((City)obj).getNumOfTours());
	  stmt2.setInt(5, 0);
	  stmt2.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//update the version of the selected city accordingly
	
}

private void AddCustomer(Object obj) {
	  PreparedStatement stmt2;
		try {
			stmt2 = con1.prepareStatement("INSERT INTO project.customer VALUES (?,?,?,?,?,?,?)");
		  stmt2.setString(1, ((Customer)obj).getFirstName());
		  stmt2.setString(2, ((Customer)obj).getLastName());
		  stmt2.setString(3, ((Customer)obj).getMobileNum());
		  stmt2.setString(4, ((Customer)obj).geteMail());
		  stmt2.setString(5, ((Customer)obj).getCreditCard());
		  stmt2.setString(6, ((Customer)obj).getID());
		  stmt2.setString(7, ((Customer)obj).getPassword());
		  stmt2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//update the version of the selected city accordingly
	
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


protected void serverStarted()
  {
    System.out.println ("Server listening for connections on port " + getPort());
  }
  

  protected void serverStopped()
  {
    System.out.println ("Server has stopped listening for connections.");
  }
  

  public static void main(String[] args) 
  {
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {/* handle the error*/}
        
        try 
        {
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?serverTimezone=IST","root","Aa123456");
            System.out.println("SQL connection succeed");
          
     	} catch (SQLException ex) 
     	    {/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
	    
	  int port = 0; //Port to listen on
  
    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
}
//End of EchoServer class
