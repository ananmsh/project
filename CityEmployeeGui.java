package Gui;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.CityController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CityEmployeeGui {
	 
	@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ImageView GcmImage;

	    @FXML
	    private TextField SearchTXT;

	    @FXML
	    private Button SerchButton;

	    @FXML
	    private RadioButton CitySearch;

	    @FXML
	    private RadioButton PlaceSearch;

	    @FXML
	    private RadioButton DescriptionSearch;

	    @FXML
	    private ListView<String> MapList;

	    @FXML
	    private Button ShowProfile;

	    @FXML
	    private Button AddTour;

	    @FXML
	    private Button AddMap;

	    @FXML
	    private ListView<String> TourList;

	    @FXML
	    private Label CityName;

	    @FXML
	    private Button EditCity;

	    @FXML
	    private Button LogOut;

	    @FXML
	    private Button BuyCity;

	    @FXML
	    void initialize() {
	        assert GcmImage != null : "fx:id=\"GcmImage\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert SearchTXT != null : "fx:id=\"SearchTXT\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert SerchButton != null : "fx:id=\"SerchButton\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert CitySearch != null : "fx:id=\"CitySearch\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert PlaceSearch != null : "fx:id=\"PlaceSearch\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert DescriptionSearch != null : "fx:id=\"DescriptionSearch\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert MapList != null : "fx:id=\"MapList\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert ShowProfile != null : "fx:id=\"ShowProfile\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert AddTour != null : "fx:id=\"AddTour\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert AddMap != null : "fx:id=\"AddMap\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert TourList != null : "fx:id=\"TourList\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert CityName != null : "fx:id=\"CityName\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        CityName.setText(CityController.getCityName());
	        assert EditCity != null : "fx:id=\"EditCity\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert LogOut != null : "fx:id=\"LogOut\" was not injected: check your FXML file 'CityEmployee.fxml'.";
	        assert BuyCity != null : "fx:id=\"BuyCity\" was not injected: check your FXML file 'CityEmployee.fxml'.";

	    }
	}
