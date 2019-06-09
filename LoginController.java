package Controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import entities.Place;

public class LoginController {
	
	public void login(ArrayList<String> Strings) throws IOException
	{
	   	 Main.getClient().getClient().StringsToServer(Strings);
	}
}
