package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.AddCityController;
import Controller.ReportController;
import application.Main;
import entities.City;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AddCityGui {
     
	String cityToAdd;
	ReportController reportController;
	 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NewCityName;

    @FXML
    private Button AddCityBtn;

    @FXML
    private Label CityNameLbl;

    @FXML
    private Button CancelBtn;
    
    @FXML
    private ImageView GcmImage;

    @FXML
    private ComboBox<String> citiesCombo;
    
    @FXML
    private Button LogOutBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button profileBtn;
    
    @FXML
    void citiesCombo(ActionEvent event) {
    	String newCity= new String();
    	newCity=(String)citiesCombo.getSelectionModel().getSelectedItem();
    	if (newCity.equals("New City..."))
    	{
    		NewCityName.setVisible(true);
    		
    	}
    	
    }
    
    @FXML
    void AddCityBtn(ActionEvent event) throws IOException {

    	   cityToAdd=new String();
    	    cityToAdd=(String)this.NewCityName.getText();
    	   AddCityController newCity=new AddCityController();
    	   newCity.AddCity(cityToAdd);
    }
    
    @FXML
    void LogOutBtn(ActionEvent event) {
    	try {
			((Node) event.getSource()).getScene().getWindow().hide(); 
			Pane root = FXMLLoader.load(getClass().getResource("/Fxml/Login.fxml"));//build the gui
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
    void homeBtn(ActionEvent event) {
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
    void profileBtn(ActionEvent event) {

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
    	assert NewCityName != null : "fx:id=\"NewCityName\" was not injected: check your FXML file 'AddCity.fxml'.";
        assert AddCityBtn != null : "fx:id=\"AddCityBtn\" was not injected: check your FXML file 'AddCity.fxml'.";
        assert CityNameLbl != null : "fx:id=\"CityNameLbl\" was not injected: check your FXML file 'AddCity.fxml'.";
        assert CancelBtn != null : "fx:id=\"CancelBtn\" was not injected: check your FXML file 'AddCity.fxml'.";
        assert GcmImage != null : "fx:id=\"GcmImage\" was not injected: check your FXML file 'AddCity.fxml'.";
        Image logo= new Image(getClass().getResourceAsStream("/Img/Logo.png"));
		GcmImage.setImage(logo);
		
		assert citiesCombo != null : "fx:id=\"citiesCombo\" was not injected: check your FXML file 'AddCity.fxml'.";
		reportController=new ReportController();
		reportController.GetCityComboBox();
        ObservableList<String> list;
        list = FXCollections.observableArrayList(Main.getClient().getClient().getCityNames());
        String newCity=new String("New City...");
        list.add(newCity);
        citiesCombo.setItems(list);//update the ComboxBox with the list of cities 
		
		assert LogOutBtn != null : "fx:id=\"LogOutBtn\" was not injected: check your FXML file 'AddCity.fxml'.";
	    assert homeBtn != null : "fx:id=\"homeBtn\" was not injected: check your FXML file 'AddCity.fxml'.";
	    assert profileBtn != null : "fx:id=\"profileBtn\" was not injected: check your FXML file 'AddCity.fxml'.";
    }
}
