package Gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.text.IconView;

import application.Main;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.Pane;

public class MapPageGui {
	final DoubleProperty zoomProperty = new SimpleDoubleProperty(900);
	String PlaceName;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label zoomLBL;

    @FXML
    private ScrollPane ScrolPaneID;
    
    @FXML
    private Button ZoomOutBtn;
    
    @FXML
    private Icon locationIcon;

    @FXML
    private Slider ScrollZoom;

    @FXML
    private Button ZoomInBtn;
    
    @FXML
    private ImageView MapImage;

    @FXML
    private ListView<String> PlacesList;

    @FXML
    private Pane paneID;

    @FXML
    void MapClick(MouseEvent event) {
      double x=event.getSceneX();
      double y= event.getSceneY();
    }

    @FXML
    void PlaceClick(MouseEvent event) {
     PlaceName= new String(PlacesList.getSelectionModel().getSelectedItem());
     
    }

    @FXML
    void ScrollZoomIn(SwipeEvent event) {
          
    }

    @FXML
    void ScrollZoomOut(SwipeEvent event) {

    }

    @FXML
    void ZoomInButton(ActionEvent event) {
    	MapImage.setFitWidth(zoomProperty.get() * 1.1);
        MapImage.setFitHeight(zoomProperty.get() * 1.1);
    }

    @FXML
    void ZoomOutButton(ActionEvent event) {
    	
    	MapImage.setFitWidth(zoomProperty.get() /1.1);
        MapImage.setFitHeight(zoomProperty.get() /1.1 );
    }

    @FXML
    void initialize() {
        assert zoomLBL != null : "fx:id=\"zoomLBL\" was not injected: check your FXML file 'map1.fxml'.";
        assert ZoomOutBtn != null : "fx:id=\"ZoomOutBtn\" was not injected: check your FXML file 'map1.fxml'.";
        assert ScrollZoom != null : "fx:id=\"ScrollZoom\" was not injected: check your FXML file 'map1.fxml'.";
        assert ZoomInBtn != null : "fx:id=\"ZoomInBtn\" was not injected: check your FXML file 'map1.fxml'.";
        assert PlacesList != null : "fx:id=\"PlacesList\" was not injected: check your FXML file 'map1.fxml'.";
           
       ArrayList<String> MaptoServer= new ArrayList<String>();
    	MaptoServer.add("GetplacesForList");
    	MaptoServer.add("hadar");
    	try {
         	Main.getClient().getClient().StringsToServer(MaptoServer);
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
         ObservableList<String> list1;
         list1 = FXCollections.observableArrayList(Main.getClient().getClient().getPlacesNames());
         PlacesList.setItems(list1);
         assert ScrolPaneID != null : "fx:id=\"ScrolPaneID\" was not injected: check your FXML file 'Map.fxml'.";
         assert MapImage != null : "fx:id=\"MapImageView\" was not injected: check your FXML file 'Map.fxml'.";
       
         ArrayList<String> MapImageToServer= new ArrayList<String>();
         MapImageToServer.add("GetImageForMap");
         MapImageToServer.add("hadar");
     	try {
          	Main.getClient().getClient().StringsToServer(MapImageToServer);
          } catch (IOException e1) {
          	// TODO Auto-generated catch block
          	e1.printStackTrace();
          }//incase the job is to get city names for combobox
           try {
          		Thread.currentThread().sleep(1000);
          	} catch (InterruptedException e) {
          		// TODO Auto-generated catch block
          		e.printStackTrace();
          	}
           MapImage.setImage(Main.getClient().getClient().getImage());
  
           assert locationIcon != null : "fx:id=\"locationIcon\" was not injected: check your FXML file 'Map.fxml'.";
    }
}


	
