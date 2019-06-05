package application;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.util.ArrayList;


public class ClientConsole implements ChatIF 
{

  final public static int DEFAULT_PORT = 5555;
  
  ChatClient client;

  public ChatClient getClient() {
	return client;
}

public void sendToMyCLient(String str) throws IOException {
	this.client.handleMessageFromClientUI(str);
}


  public ClientConsole(String host, int port) 
  {
    try 
    {
      client= new ChatClient(host, port, this);
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
      System.exit(1);
    }
  }


  public void display(String message) 
  {
    System.out.println("> " + message);
  } 
  //Class methods ***************************************************
  
  
 /* public void toConnect(String IP) //gets the ip entered in the connecting gui
  {
    String host = "";
    int port = 0;  //The port number

    try
    {
      host = arg[0];
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      host = "localhost";
    	
    }
    ClientConsole chat= new ClientConsole(host, DEFAULT_PORT);

  }*/
  
  public static void main(String[] args) 
  {
	  String host = "";
	    int port = 0;  //The port number

	    try
	    {
	      host = args[0];
	    }
	    catch(ArrayIndexOutOfBoundsException e)
	    {
	      host = "localhost";
	    	
	    }
	    ClientConsole chat= new ClientConsole(host, DEFAULT_PORT);
  }
  
}
//End of ConsoleChat class
