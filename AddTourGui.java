package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.AddTourController;
import application.Main;
import entities.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddTourGui {
 
	Tour newTour; 
	int temp;
	 ArrayList<String> placesNames;
	 ObservableList<String> items;
	 AddTourController addTourController;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AddTourLbl;

    @FXML
    private Label TourNameLbl;

    @FXML
    private TextField TourNameTxt;

    @FXML
    private Label DescriptionLbl;

    @FXML
    private TextField DescriptionTxt;

    @FXML
    private Label IncludedPlacesLbl;

    @FXML
    private ComboBox<String> PlacesCombo;

    @FXML
    private Button PlusForCombo;

    @FXML
    private ListView<String> PlacesList;

    @FXML
    private Label RecommendedTimeLbl;

    @FXML
    private TextField RecommendedTimeTxt;

    @FXML
    private Button FinishButton;

    @FXML
    private Button CancelButton;

    @FXML
    void CancelBtn(ActionEvent event) {
    	((Node) event.getSource()).getScene().getWindow().hide(); 
    }

    @FXML
    void FinishBtn(ActionEvent event) throws IOException {
         newTour=new Tour((String)this.TourNameTxt.getText(),(String)this.DescriptionTxt.getText(),(String)this.RecommendedTimeTxt.getText());
         newTour.setLocations(placesNames);
         Main.getClient().getClient().AddingNewData(newTour);
    }

    @FXML
    void PlusFunc(ActionEvent event) {
        placesNames=new ArrayList<String>();
        
        placesNames.add((String)this.PlacesCombo.getSelectionModel().getSelectedItem());
        if(temp==0)
        {
        items =FXCollections.observableArrayList ((String)this.PlacesCombo.getSelectionModel().getSelectedItem());
        temp=1;
        }
        else
        {
        	items.add((String)this.PlacesCombo.getSelectionModel().getSelectedItem());
        }
        this.PlacesList.setItems(items);
    	
    }

    @FXML
    void initialize() throws IOException {
        assert AddTourLbl != null : "fx:id=\"AddTourLbl\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert TourNameLbl != null : "fx:id=\"TourNameLbl\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert TourNameTxt != null : "fx:id=\"TourNameTxt\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert DescriptionLbl != null : "fx:id=\"DescriptionLbl\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert DescriptionTxt != null : "fx:id=\"DescriptionTxt\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert IncludedPlacesLbl != null : "fx:id=\"IncludedPlacesLbl\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert PlacesCombo != null : "fx:id=\"PlacesCombo\" was not injected: check your FXML file 'AddTour.fxml'.";
        addTourController= new AddTourController();
        addTourController.GetPlacesForTour();
        temp=0;
        ObservableList<String> list;
        list = FXCollections.observableArrayList(Main.getClient().getClient().getPlacesNames());
		PlacesCombo.setItems(list);//update the ComboxBox with the list of cities
        assert PlusForCombo != null : "fx:id=\"PlusForCombo\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert PlacesList != null : "fx:id=\"PlacesList\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert RecommendedTimeLbl != null : "fx:id=\"RecommendedTimeLbl\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert RecommendedTimeTxt != null : "fx:id=\"RecommendedTimeTxt\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert FinishButton != null : "fx:id=\"FinishButton\" was not injected: check your FXML file 'AddTour.fxml'.";
        assert CancelButton != null : "fx:id=\"CancelButton\" was not injected: check your FXML file 'AddTour.fxml'.";

    }
}
