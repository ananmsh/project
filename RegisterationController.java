package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import entities.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class RegisterationController {

       public void newCustomer(Customer toAdd) throws IOException
       {
    	   Main.getClient().getClient().AddingNewData(toAdd);
    	   
       }
}

