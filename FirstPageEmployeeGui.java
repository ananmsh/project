package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Controller.CityController;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FirstPageEmployeeGui {
	ArrayList<String> cities;
	ArrayList<String> mapsNotRelated;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView GcmImage;

	@FXML
	private TextField SearchTxt;

	@FXML
	private Label WelcomeLBL;

	@FXML
	private Button SearchBtn;

	@FXML
	private ListView<String> CityList;

	@FXML
	private ListView<String> MapsNotRelatedList;

	@FXML
	private Label CityLbl;

	@FXML
	private Button LogOut;

	@FXML
	private Button Profile;

	@FXML
	private Button Home;

	@FXML
	void CityListFunc(MouseEvent event) {
		if(CityList.getSelectionModel().getSelectedItem()!=null)
		{
			CityController chosenCity = new CityController();
			chosenCity.setCityName(CityList.getSelectionModel().getSelectedItem());
			try {

				Pane root = FXMLLoader.load(getClass().getResource("/Fxml/CityEmployee.fxml"));//build the gui
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				Stage stage = new Stage();
				stage.setScene(scene);
				((Node) event.getSource()).getScene().getWindow().hide(); 
				stage.show();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}


	}

	@FXML
	void Home(ActionEvent event) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/Fxml/FirstPageEmployee.fxml"));//build the gui
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			((Node) event.getSource()).getScene().getWindow().hide(); 
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}



	@FXML
	void LogOut(ActionEvent event) {
		try {
			
			Pane root = FXMLLoader.load(getClass().getResource("/Fxml/Login.fxml"));//build the gui
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			((Node) event.getSource()).getScene().getWindow().hide(); 
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

	@FXML
	void MapsNotRelatedList(MouseEvent event) {
		System.out.println("qw");
	}

	@FXML
	void Profile(ActionEvent event) {
		System.out.println("qw");
	}

	@FXML
	void SearchButton(ActionEvent event) {

		if(cities.contains((String)SearchTxt.getText()))
		{
			CityList.setItems(null);
			ObservableList<String> list1;
			list1 = FXCollections.observableArrayList((String)SearchTxt.getText());
			CityList.setItems(list1);
		}

	}

	@FXML
	void initialize() {
		assert GcmImage != null : "fx:id=\"GcmImage\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";
		Image logo= new Image(getClass().getResourceAsStream("/Img/Logo.png"));
		GcmImage.setImage(logo);
		
		assert SearchTxt != null : "fx:id=\"SearchTxt\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";
		assert WelcomeLBL != null : "fx:id=\"WelcomeLBL\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";
		assert SearchBtn != null : "fx:id=\"SearchBtn\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";
		assert CityList != null : "fx:id=\"CityList\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";
		cities= new ArrayList<String>();
		try {
			Main.getClient().sendToMyCLient("GetCitiesForComboBox");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//incase the job is to get city names for combobox
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObservableList<String> list;
		list = FXCollections.observableArrayList(Main.getClient().getClient().getCityNames());
		CityList.setItems(list);
		cities= Main.getClient().getClient().getCityNames();
		
		
		
		
		assert MapsNotRelatedList != null : "fx:id=\"MapsNotRelatedList\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";
		mapsNotRelated = new ArrayList<String>();
		try {
			Main.getClient().sendToMyCLient("GetNotRelatedMaps");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//incase the job is to get city names for combobox
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObservableList<String> list2;
		list2 = FXCollections.observableArrayList(Main.getClient().getClient().getMapsNames());
		MapsNotRelatedList.setItems(list2);
		
		assert CityLbl != null : "fx:id=\"CityLbl\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";
		assert LogOut != null : "fx:id=\"LogOut\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";
		assert Profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";
		assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'FirstPageEmployee.fxml'.";

	}
}
