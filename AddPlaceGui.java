package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.AddCityController;
import Controller.AddPlaceController;
import entities.Place;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AddPlaceGui {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AddPlaceLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label DescriptionLabel;

    @FXML
    private Label ClassificationLabel;

    @FXML
    private TextField Nametxt;

    @FXML
    private TextField DescriptionTxt;

    @FXML
    private TextField ClassificationTxt;

    @FXML
    private Label AccessibleLabel;

    @FXML
    private RadioButton YesRadio;

    @FXML
    private Label TimeOfVisitLabel;

    @FXML
    private TextField TimeOfVisittxt;

    @FXML
    private Button FinishBtn;

    @FXML
    private Button CancelBtn;

    @FXML
    void CancelButton(ActionEvent event) {
    	((Node) event.getSource()).getScene().getWindow().hide(); 
    }

    @FXML
    void FinishButton(ActionEvent event) throws IOException {
        Place newPlace=new Place((String)this.Nametxt.getText(),(String)this.ClassificationTxt.getText(),(String)this.DescriptionTxt.getText(),
        		(boolean)this.YesRadio.isSelected(),(String)this.TimeOfVisittxt.getText());
    	AddPlaceController placeToADD= new AddPlaceController();
    	placeToADD.addPlace(newPlace);
    }

    @FXML
    void initialize() {
        assert AddPlaceLabel != null : "fx:id=\"AddPlaceLabel\" was not injected: check your FXML file 'place.fxml'.";
        assert NameLabel != null : "fx:id=\"NameLabel\" was not injected: check your FXML file 'place.fxml'.";
        assert DescriptionLabel != null : "fx:id=\"DescriptionLabel\" was not injected: check your FXML file 'place.fxml'.";
        assert ClassificationLabel != null : "fx:id=\"ClassificationLabel\" was not injected: check your FXML file 'place.fxml'.";
        assert Nametxt != null : "fx:id=\"Nametxt\" was not injected: check your FXML file 'place.fxml'.";
        assert DescriptionTxt != null : "fx:id=\"DescriptionTxt\" was not injected: check your FXML file 'place.fxml'.";
        assert ClassificationTxt != null : "fx:id=\"ClassificationTxt\" was not injected: check your FXML file 'place.fxml'.";
        assert AccessibleLabel != null : "fx:id=\"AccessibleLabel\" was not injected: check your FXML file 'place.fxml'.";
        assert YesRadio != null : "fx:id=\"YesRadio\" was not injected: check your FXML file 'place.fxml'.";
        assert TimeOfVisitLabel != null : "fx:id=\"TimeOfVisitLabel\" was not injected: check your FXML file 'place.fxml'.";
        assert TimeOfVisittxt != null : "fx:id=\"TimeOfVisittxt\" was not injected: check your FXML file 'place.fxml'.";
        assert FinishBtn != null : "fx:id=\"FinishBtn\" was not injected: check your FXML file 'place.fxml'.";
        assert CancelBtn != null : "fx:id=\"CancelBtn\" was not injected: check your FXML file 'place.fxml'.";

    }
}

