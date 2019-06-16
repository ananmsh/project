package Gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.glass.ui.GestureSupport;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import Controller.LoginController;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginGui {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button button;

	@FXML
	private Label label;

	@FXML
	private TextField textID;

	@FXML
	private PasswordField textPassword;

	@FXML
	private Label RegesterationID;

	@FXML
	private ImageView ImageLogo;

	
	
	@FXML
	void CancelButton(ActionEvent event) {
		try {
			((Node) event.getSource()).getScene().getWindow().hide(); 
			Pane root = FXMLLoader.load(getClass().getResource("/Fxml/Catalog.fxml"));//build the gui
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
	void LoginButton(ActionEvent event) {
		ArrayList<String> Strings=new ArrayList<String>();
		String check;
		Strings.add("LoginCheck");
		String ID = textID.getText().toString();
		String password = textPassword.getText().toString();
		Strings.add(ID);
		Strings.add(password);
		LoginController logger=new LoginController();
		try {
			logger.login(Strings);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		check = (String)Main.getClient().getClient().getLoginAnswer();
		if(check == "Customer")						//receiving answer customer from the server  
		{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Login Successfull");
			alert.setTitle("Success");
			alert.setHeaderText(null);
			alert.showAndWait();
			try {
				((Node) event.getSource()).getScene().getWindow().hide(); 
				Pane root = FXMLLoader.load(getClass().getResource("/Fxml/Catalog.fxml"));//build the gui
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
		else if (check == "Employee")  				//receiving answer Employee from the server 
		{	
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Login Successfull");
			alert.setTitle("Success");
			alert.setHeaderText(null);
			alert.showAndWait();
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
		else if (check == "Manager")				//receiving answer Manager from the server 
		{	
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Login Successfull");
			alert.setTitle("Success");
			alert.setHeaderText(null);
			alert.showAndWait();
		try {
				((Node) event.getSource()).getScene().getWindow().hide(); 
				Pane root = FXMLLoader.load(getClass().getResource("/Fxml/Catalog.fxml"));//build the gui
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
		else {									//receiving answer Failed from the server 
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Please enter correct ID and Password");
			alert.setTitle("Failed" );
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		}

		@FXML
		void Regesteration(MouseEvent event) {		
			try {
				((Node) event.getSource()).getScene().getWindow().hide(); 
				Pane root = FXMLLoader.load(getClass().getResource("/Fxml/Registeration.fxml"));//build the gui
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
			assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'Login.fxml'.";
			assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
			assert textID != null : "fx:id=\"textEmail\" was not injected: check your FXML file 'Login.fxml'.";
			assert textPassword != null : "fx:id=\"textPassword\" was not injected: check your FXML file 'Login.fxml'.";
			assert ImageLogo != null : "fx:id=\"ImageLogo\" was not injected: check your FXML file 'Login.fxml'.";
			assert RegesterationID != null : "fx:id=\"RegesterationID\" was not injected: check your FXML file 'Login.fxml'.";
			RegesterationID.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					RegesterationID.setStyle("-fx-font-weight: bold;");
				}
			});
			RegesterationID.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					RegesterationID.setStyle("-fx-font-weight: regular;");
				}
			});
			Image logo= new Image(getClass().getResourceAsStream("/Img/Logo.png"));
			ImageLogo.setImage(logo);
		}
	}
