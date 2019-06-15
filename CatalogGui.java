package Gui;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.javafx.cursor.CursorType;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CatalogGui {

	ArrayList<String> cities;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView GcmImage;

    @FXML
    private TextField SearchTxt;

    @FXML
    private RadioButton CityRadio;

    @FXML
    private RadioButton PlaceRadio;

    @FXML
    private RadioButton DescriptionRadio;

    @FXML
    private Label WelcomeLBL;

    @FXML
    private Button LogInBtn;

    @FXML
    private Button SearchBtn;

    @FXML
    private ListView<String> CityList;

    @FXML
    private ListView<String> MapList;

    @FXML
    private ListView<String> PlaceList;

    @FXML
    private Label CityLbl;

    @FXML
    private Label MapLbl;

    @FXML
    private Label PlaceLbl;
///////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void CityListFunc(MouseEvent event) {
    	if(CityList.getSelectionModel().getSelectedItem()!=null)
    	{
    	MapList.setItems(null);
    	PlaceList.setItems(null);
    	ArrayList<String> toServer= new ArrayList<String>();
    	toServer.add("GetMapsForList");
    	toServer.add(CityList.getSelectionModel().getSelectedItem());
    	try {
         	Main.getClient().getClient().StringsToServer(toServer);
         } catch (IOException e1) {
         	// TODO Auto-generated catch block
         	e1.printStackTrace();
         }//incase the job is to get city names for combobox
          try {
         		Thread.currentThread().sleep(200);
         	} catch (InterruptedException e) {
         		// TODO Auto-generated catch block
         		e.printStackTrace();
         	}
         ObservableList<String> list;
         list = FXCollections.observableArrayList(Main.getClient().getClient().getMapsNames());
         MapList.setItems(list);	
    	}
    }
    //////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void PlaceRadioBtn(ActionEvent event) {

    	DescriptionRadio.setSelected(false);
    	CityRadio.setSelected(false);
    }

    @FXML
    void CityRadioBtn(ActionEvent event) {
    	PlaceRadio.setSelected(false);
    	DescriptionRadio.setSelected(false);

    }

    @FXML
    void DescriptionRadioBtn(ActionEvent event) {
    	CityRadio.setSelected(false);
    	PlaceRadio.setSelected(false);

    }
    
///////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void LogInButton(ActionEvent event) {

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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void MapListFunc(MouseEvent event) {
     	if(MapList.getSelectionModel().getSelectedItem()!=null)
       	{
    	PlaceList.setItems(null);
       	ArrayList<String> toServer= new ArrayList<String>();
    	toServer.add("GetplacesForList");
    	toServer.add(MapList.getSelectionModel().getSelectedItem());
    	try {
         	Main.getClient().getClient().StringsToServer(toServer);
         } catch (IOException e1) {
         	// TODO Auto-generated catch block
         	e1.printStackTrace();
         }//incase the job is to get city names for combobox
          try {
         		Thread.currentThread().sleep(200);
         	} catch (InterruptedException e) {
         		// TODO Auto-generated catch block
         		e.printStackTrace();
         	}
         ObservableList<String> list;
         list = FXCollections.observableArrayList(Main.getClient().getClient().getPlacesNames());
         PlaceList.setItems(list);	
       	}
    	
    }

    @FXML
    void SearchButton(ActionEvent event) {

    	if(CityRadio.isSelected())
    	{
    		if(cities.contains((String)SearchTxt.getText()))
    		{
    			CityList.setItems(null);
    			 ObservableList<String> list1;
    		      list1 = FXCollections.observableArrayList((String)SearchTxt.getText());
    		      CityList.setItems(list1);
    		      
    		      MapList.setItems(null);
    		    	PlaceList.setItems(null);
    		    	ArrayList<String> toServer= new ArrayList<String>();
    		    	toServer.add("GetMapsForList");
    		    	toServer.add(SearchTxt.getText());
    		    	try {
    		         	Main.getClient().getClient().StringsToServer(toServer);
    		         } catch (IOException e1) {
    		         	// TODO Auto-generated catch block
    		         	e1.printStackTrace();
    		         }//incase the job is to get city names for combobox
    		          try {
    		         		Thread.currentThread().sleep(200);
    		         	} catch (InterruptedException e) {
    		         		// TODO Auto-generated catch block
    		         		e.printStackTrace();
    		         	}
    		          ObservableList<String> list2;
    		         list2 = FXCollections.observableArrayList(Main.getClient().getClient().getMapsNames());
    		         MapList.setItems(list2);
    		}


    	}
    	else if(PlaceRadio.isSelected())
    	{
    		CityList.setItems(null);
			 ObservableList<String> list1;
			 ArrayList<String> MapstoServer= new ArrayList<String>();
		      list1 = FXCollections.observableArrayList((String)SearchTxt.getText());
		      PlaceList.setItems(list1);
		  	MapstoServer.add("GetMapsForCatalogList");
	    	MapstoServer.add((String)SearchTxt.getText());
	    	try {
	         	Main.getClient().getClient().StringsToServer(MapstoServer);
	         } catch (IOException e1) {
	         	// TODO Auto-generated catch block
	         	e1.printStackTrace();
	         }//incase the job is to get city names for combobox
	    	  try {
	        		Thread.currentThread().sleep(200);
	        	} catch (InterruptedException e) {
	        		// TODO Auto-generated catch block
	        		e.printStackTrace();
	        	}
	    	 ObservableList<String> list2;  
	         list2 = FXCollections.observableArrayList(Main.getClient().getClient().getMapsNames());
	         MapList.setItems(list2);
	         
	         ArrayList<String> CitytoServer= new ArrayList<String>();
	       	CitytoServer.add("GetCityForCatalogList");
	    	CitytoServer.add(Main.getClient().getClient().getMapsNames().get(0));
	    	try {
	         	Main.getClient().getClient().StringsToServer(CitytoServer);
	         } catch (IOException e1) {
	         	// TODO Auto-generated catch block
	         	e1.printStackTrace();
	         }//incase the job is to get city names for combobox
	    	  try {
	        		Thread.currentThread().sleep(200);
	        	} catch (InterruptedException e) {
	        		// TODO Auto-generated catch block
	        		e.printStackTrace();
	        	}
	         ObservableList<String> list3;
	         list3 = FXCollections.observableArrayList(Main.getClient().getClient().getCityNames());
	         CityList.setItems(list3);
    		
    	}
    	else if(DescriptionRadio.isSelected())
    	{
    		CityList.setItems(null);
    		PlaceList.setItems(null);
    		ArrayList<String> DescriptiontoFindMap= new ArrayList<String>();
    		DescriptiontoFindMap.add("DescriptionToFindMap");
    		DescriptiontoFindMap.add((String)SearchTxt.getText());
    		try {
	         	Main.getClient().getClient().StringsToServer(DescriptiontoFindMap);
	         } catch (IOException e1) {
	         	// TODO Auto-generated catch block
	         	e1.printStackTrace();
	         }//incase the job is to get city names for combobox
	    	  try {
	        		Thread.currentThread().sleep(200);
	        	} catch (InterruptedException e) {
	        		// TODO Auto-generated catch block
	        		e.printStackTrace();
	        	}
    		  
	    	  ObservableList<String> list2;  
		         list2 = FXCollections.observableArrayList(Main.getClient().getClient().getMapsNames());
		         MapList.setItems(list2);
    		
    	}	
    	
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void initialize() {
        assert GcmImage != null : "fx:id=\"GcmImage\" was not injected: check your FXML file 'Catalog.fxml'.";
        Image logo= new Image(getClass().getResourceAsStream("/Images/Logo.png"));
	GcmImage.setImage(logo);
		
	assert SearchTxt != null : "fx:id=\"SearchTxt\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert CityRadio != null : "fx:id=\"CityRadio\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert PlaceRadio != null : "fx:id=\"PlaceRadio\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert DescriptionRadio != null : "fx:id=\"DescriptionRadio\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert WelcomeLBL != null : "fx:id=\"WelcomeLBL\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert LogInBtn != null : "fx:id=\"LogInBtn\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert SearchBtn != null : "fx:id=\"SearchBtn\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert CityList != null : "fx:id=\"CityList\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert MapList != null : "fx:id=\"MapList\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert PlaceList != null : "fx:id=\"PlaceList\" was not injected: check your FXML file 'Catalog.fxml'.";
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
        assert CityLbl != null : "fx:id=\"CityLbl\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert MapLbl != null : "fx:id=\"MapLbl\" was not injected: check your FXML file 'Catalog.fxml'.";
        assert PlaceLbl != null : "fx:id=\"PlaceLbl\" was not injected: check your FXML file 'Catalog.fxml'.";

    }
}




