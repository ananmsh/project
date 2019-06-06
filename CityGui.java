package news;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public abstract class CityGui implements Initializable{
	 
	    @FXML private ResourceBundle resources;
	    @FXML private URL location;
	    @FXML private TextField SearchTXT;
	    @FXML private Button SerchButton;
	    @FXML private RadioButton CitySearch;
	    @FXML private RadioButton PlaceSearch;
	    @FXML private RadioButton DescriptionSearch;
	    @FXML private ListView<String> MapList;
	    @FXML private Button ShowProfile;
	    @FXML private Button AddTour;
	    @FXML private Button AddMap;
	    @FXML private ListView<String> TourList;
	    @FXML private Button EditCity;
	    @FXML private Button LogOut;
	    @FXML private Button BuyCity;
	    
	    @FXML
	    void AddManHandler(MouseEvent event) {
	    	
	    }

	    @FXML
	    void AddTourHandler(MouseEvent event) {

	    }

	    @FXML
	    void BuyCityHandler(MouseEvent event) {

	    }

	    @FXML
	    void EditCityHandler(MouseEvent event) {

	    }

	    @FXML
	    void LogOutHandler(MouseEvent event) {

	    }

	    @FXML
	    void ShowProfileHandler(MouseEvent event) {

	    }

	    @FXML
	    void initialize() {
	        assert SearchTXT != null : "fx:id=\"SearchTXT\" was not injected: check your FXML file '123.fxml'.";
	        assert SerchButton != null : "fx:id=\"SerchButton\" was not injected: check your FXML file '123.fxml'.";
	        assert CitySearch != null : "fx:id=\"CitySearch\" was not injected: check your FXML file '123.fxml'.";
	        assert PlaceSearch != null : "fx:id=\"PlaceSearch\" was not injected: check your FXML file '123.fxml'.";
	        assert DescriptionSearch != null : "fx:id=\"DescriptionSearch\" was not injected: check your FXML file '123.fxml'.";
	        assert MapList != null : "fx:id=\"MapList\" was not injected: check your FXML file '123.fxml'.";
	        assert ShowProfile != null : "fx:id=\"ShowProfile\" was not injected: check your FXML file '123.fxml'.";
	        assert AddTour != null : "fx:id=\"AddTour\" was not injected: check your FXML file '123.fxml'.";
	        assert AddMap != null : "fx:id=\"AddMap\" was not injected: check your FXML file '123.fxml'.";
	        assert TourList != null : "fx:id=\"TourList\" was not injected: check your FXML file '123.fxml'.";
	        assert EditCity != null : "fx:id=\"EditCity\" was not injected: check your FXML file '123.fxml'.";
	        assert LogOut != null : "fx:id=\"LogOut\" was not injected: check your FXML file '123.fxml'.";
	        assert BuyCity != null : "fx:id=\"BuyCity\" was not injected: check your FXML file '123.fxml'.";

	    }
	}
