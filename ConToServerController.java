package controllers;
sadfasdfasdf
import java.net.URL;
import java.util.ResourceBundle;

import application.ClientConsole;
import application.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ConToServerController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ConnectLabel;

    @FXML
    private Label IPadderssLabel;

    @FXML
    private TextField IPAddresstxt;

    @FXML
    private Button Connectbtn;

    @FXML
    void ConnectBtnToCon(ActionEvent event) {
    	Stage primaryStage= new Stage();
    	String str= new String();
        str=this.IPAddresstxt.getText();  
        Main.client=new ClientConsole(str, 5555);
        ((Node) event.getSource()).getScene().getWindow().hide(); //hiding primary window
        try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("/Fxml/ClientGui.fxml"));//build the gui
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void IPAddresstxtF(ActionEvent event) {
    
        
    }

    @FXML
    void initialize() {
        assert ConnectLabel != null : "fx:id=\"ConnectLabel\" was not injected: check your FXML file 'Untitled'.";
        assert IPadderssLabel != null : "fx:id=\"IPadderssLabel\" was not injected: check your FXML file 'Untitled'.";
        assert IPAddresstxt != null : "fx:id=\"IPAddresstxt\" was not injected: check your FXML file 'Untitled'.";
        assert Connectbtn != null : "fx:id=\"Connectbtn\" was not injected: check your FXML file 'Untitled'.";
        
    }
}

