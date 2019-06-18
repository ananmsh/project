package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;


public class MyMessagesGui {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView LogoImg;

    @FXML
    private Button LogOutBtn;

    @FXML
    private Button ProfileBtn;

    @FXML
    private Button HomeBtn;

    @FXML
    private ListView<String> MessagesList;

    @FXML
    private Button BackBtn;

    @FXML
    private TextArea ReceivedMsg;

    @FXML
    private TextArea AnswerMsg;

    @FXML
    private Button SendBtn;

    @FXML
    void BackBtn(ActionEvent event) { // to do functionality for the previous page

    }

    @FXML
    void HomeBtn(ActionEvent event) {  ////// be careful that the Types are OK and the firstPage.fxml is OK 
    	if(LoginController.getType().equals("Employee")) {
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
    	else if (LoginController.getType().equals("Manager")) {
    		try {
    			Pane root = FXMLLoader.load(getClass().getResource("/Fxml/FirstPageManager.fxml"));//build the gui
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
    	else 
    	{
    		try {
    			Pane root = FXMLLoader.load(getClass().getResource("/Fxml/FirstPageCustomer.fxml"));//build the gui
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
    void LogOutBtn(ActionEvent event) {
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
    void MessagesList(MouseEvent event) {

    }

    @FXML
    void ProfileBtn(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert LogoImg != null : "fx:id=\"LogoImg\" was not injected: check your FXML file 'MyMessages.fxml'.";

		Image logo= new Image(getClass().getResourceAsStream("/Img/Logo.png"));
		LogoImg.setImage(logo);
        
		assert LogOutBtn != null : "fx:id=\"LogOutBtn\" was not injected: check your FXML file 'MyMessages.fxml'.";
        assert ProfileBtn != null : "fx:id=\"ProfileBtn\" was not injected: check your FXML file 'MyMessages.fxml'.";
        assert HomeBtn != null : "fx:id=\"HomeBtn\" was not injected: check your FXML file 'MyMessages.fxml'.";
        assert MessagesList != null : "fx:id=\"MessagesList\" was not injected: check your FXML file 'MyMessages.fxml'.";
        assert BackBtn != null : "fx:id=\"BackBtn\" was not injected: check your FXML file 'MyMessages.fxml'.";
        assert ReceivedMsg != null : "fx:id=\"ReceivedMsg\" was not injected: check your FXML file 'MyMessages.fxml'.";
        assert AnswerMsg != null : "fx:id=\"AnswerMsg\" was not injected: check your FXML file 'MyMessages.fxml'.";
        assert SendBtn != null : "fx:id=\"SendBtn\" was not injected: check your FXML file 'MyMessages.fxml'.";

    }
}
