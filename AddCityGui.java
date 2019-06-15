package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.AddCityController;
import application.Main;
import entities.City;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCityGui {
     
	String cityToAdd;
	 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CityName;

    @FXML
    private Button AddCityBtn;

    @FXML
    private Label CityNameLbl;

    @FXML
    private Button CancelBtn;

    @FXML
    void AddCityBtn(ActionEvent event) throws IOException {

    	   cityToAdd=new String();
    	    cityToAdd=(String)this.CityName.getText();
    	   AddCityController newCity=new AddCityController();
    	   newCity.AddCity(cityToAdd);
    }

   @FXML
    void btnCancel(ActionEvent event) {
     
    	try {
			((Node) event.getSource()).getScene().getWindow().hide(); 
			Pane root = FXMLLoader.load(getClass().getResource("/Fxml/CatalogEmployee.fxml"));//build the gui
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert CityName != null : "fx:id=\"CityName\" was not injected: check your FXML file 'AddCity.fxml'.";
        assert AddCityBtn != null : "fx:id=\"AddCityBtn\" was not injected: check your FXML file 'AddCity.fxml'.";
        assert CityNameLbl != null : "fx:id=\"CityNameLbl\" was not injected: check your FXML file 'AddCity.fxml'.";
        assert CancelBtn != null : "fx:id=\"CancelBtn\" was not injected: check your FXML file 'AddCity.fxml'.";

    }
}

