package application;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;package application;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;

import entities.City;
import entities.Customer;
import entities.Map;
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
	 else if(obj instanceof City)
		 {
			 AddCity(obj);
		 }
		 else if(obj instanceof Place)
			 {
			    AddPlace(obj);
			 }
			 else if(obj instanceof Tour)
				 {
				    AddTour(obj);
				 }
			 else if(obj instanceof Map)
			 {
				 AddMap(obj);
			 }
				 else if(((ArrayList<String>)obj).get(0).equals("GetPlacesNames"))
					 {
					    try {
							GetPlacesList(obj,client);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				     }
				 else if(((ArrayList<String>)obj).get(0).equals("GetCityReport"))
				 {
					 try {
						GetCityReport(obj,client);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				 else if(((ArrayList<String>)obj).get(0).equals("GetCityNames"))
				 {
					 try {
						GetCityList(obj, client);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
				 }
				 else if(((ArrayList<String>)obj).get(0).equals("GetMapsForList"))
				 {	 
					 GetMapList(obj, client); 
					 
				 }
				 else if(((ArrayList<String>)obj).get(0).equals("GetplacesForList"))
				 {	 
					 try {
						GetPlacesForCatalogList(obj, client);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 			 
				 }
				 else if(((ArrayList<String>)obj).get(0).equals("GetMapsForCatalogList"))
				 {
					 try {
							GetMapsForCatalogSearch(obj, client);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 	
					 
				 }
				 else if(((ArrayList<String>)obj).get(0).equals("GetCityForCatalogList"))
				 {
					 GetCityForCatalogSearch(obj, client); 	
					 
				 }
				 

	 
	 

  }
  
  private void GetMapsForCatalogSearch(Object obj,ConnectionToClient client) throws IOException
  {
	  PreparedStatement stmt2;
			try {
				stmt2 = con1.prepareStatement("SELECT map_name FROM project.map_place WHERE place_name = ?");
			  stmt2.setString(1,((ArrayList<String>)obj).get(1));
			  rs=stmt2.executeQuery();
			  ArrayList<String> names=new ArrayList<String>();
			  names.add("MapsNames");//return the job name so we continue working right
			  while(rs.next()) {
				  names.add(rs.getString(1));
			  }
					try {
						client.sendToClient(names);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  
	  
	  
  }
  private void GetCityForCatalogSearch(Object obj,ConnectionToClient client)
  {
	  
	  PreparedStatement stmt2;
		try {
			stmt2 = con1.prepareStatement("SELECT city_name FROM project.city_map WHERE map_name = ?");
		  stmt2.setString(1,((ArrayList<String>)obj).get(1));
		  rs=stmt2.executeQuery();
		  ArrayList<String> names=new ArrayList<String>();
		  names.add("CityNames");//return the job name so we continue working right
		  while(rs.next()) {
			  names.add(rs.getString(1));
		  }
		  System.out.println(names.get(1));
				try {
					client.sendToClient(names);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	  
  }
  
  
  private void GetPlacesForCatalogList(Object obj,ConnectionToClient client) throws IOException
  {
	  PreparedStatement stmt2;
		try {
			stmt2 = con1.prepareStatement("SELECT place_name FROM project.map_place WHERE map_name = ?");
		  stmt2.setString(1,((ArrayList<String>)obj).get(1));
		  rs=stmt2.executeQuery();
		  ArrayList<String> names=new ArrayList<String>();
		  names.add("PlacesNames");//return the job name so we continue working right
		  while(rs.next()) {
			  names.add(rs.getString(1));
		  }
				try {
					client.sendToClient(names);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  }
	  
  
  public void GetMapList(Object obj,ConnectionToClient client)
  {
		PreparedStatement stmt2;
		try {
			stmt2 = con1.prepareStatement("SELECT map_name FROM project.city_map WHERE city_name = ?");
		  stmt2.setString(1,((ArrayList<String>)obj).get(1));
		  rs=stmt2.executeQuery();
		  ArrayList<String> names=new ArrayList<String>();
		  names.add("MapsNames");//return the job name so we continue working right
		  while(rs.next()) {
			  names.add(rs.getString(1));
		  }
				try {
					client.sendToClient(names);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
  }
  
  public void GetCityList(Object obj,ConnectionToClient client) throws SQLException
  {
	  stmt= con1.createStatement();
	  rs = stmt.executeQuery(((ArrayList<String>)obj).get(1));//executed the required query
	  ArrayList<String> names=new ArrayList<String>();
	  names.add("CityNames");//return the job name so we continue working right
	  while(rs.next()) {
		  names.add(rs.getString(1));
	  }
	  try {
		client.sendToClient(names);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
  
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  private void GetCityReport(Object obj,ConnectionToClient client) throws SQLException
  {
	  PreparedStatement stmt1=con1.prepareStatement("SELECT NumOfMaps,NumOfPurchases,NumOfSubscriptions,NumOfRenewals,NumOfViews,NumOfDownloads FROM project.report WHERE CityReport=?;");//to get city version for the selected city
	  stmt1.setString(1, ((ArrayList<String>)obj).get(1));
	  rs = stmt1.executeQuery();
	  rs.first();
	  ArrayList<String> KeyReport=new ArrayList<String>();
	  KeyReport.add("ReportNames"); //fill in the job name to continue the work correctly  
	  for(int i=1;i<7;i++)
	  KeyReport.add(rs.getString(i));//the required version
	  try {
		client.sendToClient(KeyReport);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  /////////////////////////////////////////////////getting places to add tours/////////////////////////////////
  private void GetPlacesList(Object obj,ConnectionToClient client) throws IOException
  {
	  try {
		
			stmt= con1.createStatement();
		  rs = stmt.executeQuery(((ArrayList<String>)obj).get(1));//executed the required query
		  ArrayList<String> names=new ArrayList<String>();
		  names.add("PlacesNames");//return the job name so we continue working right
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

private void AddMap(Object obj)
{
	PreparedStatement stmt2;
		try {
			stmt2 = con1.prepareStatement("INSERT INTO project.map VALUES (?,?,?,?,?,?)");
		  stmt2.setString(1, ((Map)obj).getMapName());
		  stmt2.setString(2, ((Map)obj).getMapDescription());
		  stmt2.setInt(3, ((Map)obj).getPrice());
		  stmt2.setInt(4, ((Map)obj).getNoOfTours());
		  stmt2.setString(5, ((Map)obj).getVersion());
		  File file = new File("src\\Images\\Map.jpg");
	        FileInputStream input = new FileInputStream(file);      
          stmt2.setBinaryStream(6, input);
		  stmt2.executeUpdate();
		} catch (SQLException | FileNotFoundException e) {
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
	 else if(obj instanceof City)
		 {
			 AddCity(obj);
		 }
		 else if(obj instanceof Place)
			 {
			    AddPlace(obj);
			 }
			 else if(obj instanceof Tour)
				 {
				    AddTour(obj);
				 }
				 else if(((ArrayList<String>)obj).get(0).equals("GetPlacesNames"))
					 {
					    try {
							GetPlacesList(obj,client);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				     }
				 else if(((ArrayList<String>)obj).get(0).equals("GetCityReport"))
				 {
					 try {
						GetCityReport(obj,client);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				 else if(((ArrayList<String>)obj).get(0).equals("GetCityNames"))
				 {
					 try {
						GetCityList(obj, client);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
				 }
				  else if(((ArrayList<String>)obj).get(0).equals("LoginCheck"))
				 {
					 try {
						 CheckLogin(obj,client);
					} 
					 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
				 }
				 

	 
	 

  }
  public void GetCityList(Object obj,ConnectionToClient client) throws SQLException
  {
	  stmt= con1.createStatement();
	  rs = stmt.executeQuery(((ArrayList<String>)obj).get(1));//executed the required query
	  ArrayList<String> names=new ArrayList<String>();
	  names.add("CityNames");//return the job name so we continue working right
	  while(rs.next()) {
		  names.add(rs.getString(1));
	  }
	  try {
		client.sendToClient(names);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   private void CheckLogin(Object obj, ConnectionToClient client) throws SQLException
  {
      String sql = "SELECT * FROM customer WHERE id = ? and password = ?";
      try{
    	  PreparedStatement stmt3 = con1.prepareStatement(sql);
          stmt3.setString(1, ((ArrayList<String>)obj).get(1));
          stmt3.setString(2, ((ArrayList<String>)obj).get(2));
          rs = stmt3.executeQuery();
          ArrayList<String> answer=new ArrayList<String>();
          answer.add("LoginAnswer");
          rs.beforeFirst();
          rs.beforeFirst();
          if(!rs.next())
          {
        	  answer.add("LogFailed");
        	  client.sendToClient(answer);
          }
          else
          {
        	  answer.add("LogSuccesfull");
        	  client.sendToClient(answer);
          }
      }
      catch(Exception e){
          e.printStackTrace();
      }
	
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  private void GetCityReport(Object obj,ConnectionToClient client) throws SQLException
  {
	  PreparedStatement stmt1=con1.prepareStatement("SELECT NumOfMaps,NumOfPurchases,NumOfSubscriptions,NumOfRenewals,NumOfViews,NumOfDownloads FROM project.report WHERE CityReport=?;");//to get city version for the selected city
	  stmt1.setString(1, ((ArrayList<String>)obj).get(1));
	  rs = stmt1.executeQuery();
	  rs.first();
	  ArrayList<String> KeyReport=new ArrayList<String>();
	  KeyReport.add("ReportNames"); //fill in the job name to continue the work correctly  
	  for(int i=1;i<7;i++)
	  KeyReport.add(rs.getString(i));//the required version
	  try {
		client.sendToClient(KeyReport);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  /////////////////////////////////////////////////getting places to add tours/////////////////////////////////
  private void GetPlacesList(Object obj,ConnectionToClient client) throws IOException
  {
	  try {
		
			stmt= con1.createStatement();
		  rs = stmt.executeQuery(((ArrayList<String>)obj).get(1));//executed the required query
		  ArrayList<String> names=new ArrayList<String>();
		  names.add("PlacesNames");//return the job name so we continue working right
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
