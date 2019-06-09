package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CityGuiCustomer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button HomeButton;

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
    private ListView<?> MapList;

    @FXML
    private Button ShowProfile;

    @FXML
    private ListView<?> TourList;

    @FXML
    private Label CityName;

    @FXML
    private Button LogOut;

    @FXML
    private Button BuyCity;

    @FXML
    void BuyCityHandler(MouseEvent event) {

    }

    @FXML
    void LogOutHandler(MouseEvent event) {

    }

    @FXML
    void ShowProfileHandler(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert HomeButton != null : "fx:id=\"HomeButton\" was not injected: check your FXML file '123.fxml'.";
        assert SearchTXT != null : "fx:id=\"SearchTXT\" was not injected: check your FXML file '123.fxml'.";
        assert SerchButton != null : "fx:id=\"SerchButton\" was not injected: check your FXML file '123.fxml'.";
        assert CitySearch != null : "fx:id=\"CitySearch\" was not injected: check your FXML file '123.fxml'.";
        assert PlaceSearch != null : "fx:id=\"PlaceSearch\" was not injected: check your FXML file '123.fxml'.";
        assert DescriptionSearch != null : "fx:id=\"DescriptionSearch\" was not injected: check your FXML file '123.fxml'.";
        assert MapList != null : "fx:id=\"MapList\" was not injected: check your FXML file '123.fxml'.";
        assert ShowProfile != null : "fx:id=\"ShowProfile\" was not injected: check your FXML file '123.fxml'.";
        assert TourList != null : "fx:id=\"TourList\" was not injected: check your FXML file '123.fxml'.";
        assert CityName != null : "fx:id=\"CityName\" was not injected: check your FXML file '123.fxml'.";
        assert LogOut != null : "fx:id=\"LogOut\" was not injected: check your FXML file '123.fxml'.";
        assert BuyCity != null : "fx:id=\"BuyCity\" was not injected: check your FXML file '123.fxml'.";

    }
}

