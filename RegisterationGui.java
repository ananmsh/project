package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.RegisterationController;
import application.Main;
import entities.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class RegisterationGui {

	Customer ToAdd;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label FNameLbl;

    @FXML
    private Label LNameLbl;
    
    @FXML
    private Label CreditCardLbl;

    @FXML
    private TextField CreditCardTXT;

    @FXML
    private Label IDLbl;

    @FXML
    private Label EmailLbl;

    @FXML
    private Label MobileLbl;

    @FXML
    private Label PasswordLbl;

    @FXML
    private TextField FNametxt;

    @FXML
    private TextField LNameTxt;

    @FXML
    private TextField IDtxt;

    @FXML
    private TextField EmailTxt;

    @FXML
    private TextField MobileTxt;

    @FXML
    private TextField PasswordTxt;

    @FXML
    private Button CancelBtn;

    @FXML
    private Button FinishBtn;

    @FXML
    void CancelButton(ActionEvent event) {

     ((Node) event.getSource()).getScene().getWindow().hide(); 
    }

    @FXML
    void FinishButton(ActionEvent event) throws IOException {
         
    	ToAdd=new Customer((String)this.IDtxt.getText(),(String)this.FNametxt.getText(),(String)this.LNameTxt.getText(),
    			(String)this.EmailTxt.getText(),(String)this.MobileTxt.getText(),(String)this.PasswordTxt.getText(),(String)this.CreditCardTXT.getText());
    	RegisterationController newCust= new RegisterationController();
    	newCust.newCustomer(ToAdd);
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
    void initialize() {
        assert FNameLbl != null : "fx:id=\"FNameLbl\" was not injected: check your FXML file 'Untitled'.";
        assert LNameLbl != null : "fx:id=\"LNameLbl\" was not injected: check your FXML file 'Untitled'.";
        assert IDLbl != null : "fx:id=\"IDLbl\" was not injected: check your FXML file 'Untitled'.";
        assert EmailLbl != null : "fx:id=\"EmailLbl\" was not injected: check your FXML file 'Untitled'.";
        assert MobileLbl != null : "fx:id=\"MobileLbl\" was not injected: check your FXML file 'Untitled'.";
        assert PasswordLbl != null : "fx:id=\"PasswordLbl\" was not injected: check your FXML file 'Untitled'.";
        assert FNametxt != null : "fx:id=\"FNametxt\" was not injected: check your FXML file 'Untitled'.";
        assert LNameTxt != null : "fx:id=\"LNameTxt\" was not injected: check your FXML file 'Untitled'.";
        assert IDtxt != null : "fx:id=\"IDtxt\" was not injected: check your FXML file 'Untitled'.";
        assert EmailTxt != null : "fx:id=\"EmailTxt\" was not injected: check your FXML file 'Untitled'.";
        assert MobileTxt != null : "fx:id=\"MobileTxt\" was not injected: check your FXML file 'Untitled'.";
        assert PasswordTxt != null : "fx:id=\"PasswordTxt\" was not injected: check your FXML file 'Untitled'.";
        assert CreditCardLbl != null : "fx:id=\"CreditCardLbl\" was not injected: check your FXML file 'Untitled'.";
        assert CreditCardTXT != null : "fx:id=\"CreditCardTXT\" was not injected: check your FXML file 'Untitled'.";
        assert CancelBtn != null : "fx:id=\"CancelBtn\" was not injected: check your FXML file 'Untitled'.";
        assert FinishBtn != null : "fx:id=\"FinishBtn\" was not injected: check your FXML file 'Untitled'.";
        
    }
}

