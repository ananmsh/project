package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


import application.Main;
import entities.MapPlace;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

public class MapPageGui {
	String PlaceName;
	ArrayList<MapPlace> mapPlaces; 
	MapPlace PlaceToUpdate;
	int temp=0;
	int flag=0;
	 Group zoomGroup;
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
    private Pane paneId;
       
    @FXML
    private Slider ScrollZoom;
    
    @FXML
    private Button HomeId;

    @FXML
    private Button ProfileId;

    @FXML
    private Button LogOutID;

    @FXML
    private Button ZoomInBtn;
    
    @FXML
    private ImageView MapImage;

    @FXML
    private ListView<String> PlacesList;
    
 


    @FXML
    void MapClick(MouseEvent event) {
    	if(flag==1)
    	{
	   double x=event.getX();
	   double y= event.getY();
	   for(int i=0;i<mapPlaces.size();i++)
	     {
	    	 if(mapPlaces.get(i).getPlaceName().equals(PlaceName));
	    	 {
	    		 
	    		 if(mapPlaces.get(i).getCorX()==0&&mapPlaces.get(i).getCorY()==0)
	    		 {			 
	    		      ImageView s = new ImageView();
	    		      s.setLayoutX(x);
	    		      s.setLayoutY(y);
	    		      s.setFitHeight(25.0);
	    		      s.setFitWidth(25.0);
	    		      
	    		      s.setPickOnBounds(true);
	    		      s.setPreserveRatio(true);
	    		      s.setSmooth(true);
	    		   
	    		    Image image=new Image(getClass().getResourceAsStream("../Img/iconLoc.png"));
	    		    s.setImage(image);
	    		   
	    		    paneId.getChildren().add(s);
	    		
	    		   
	    		 }
	    		 else
	    		 {
	    			 
	    			 Alert alert = new Alert(AlertType.CONFIRMATION);
	    			 alert.setTitle("Confirmation");
	    			 alert.setHeaderText(null);
	    			 alert.setContentText("Are you sure?");

	    			 Optional<ButtonType> result = alert.showAndWait();
	    			 if (result.get() == ButtonType.OK){
	    				 ImageView s = new ImageView();
		    		      s.setLayoutX(x);
		    		      s.setLayoutY(y);
		    		      s.setFitHeight(25.0);
		    		      s.setFitWidth(25.0);
		    		      
		    		      s.setPickOnBounds(true);
		    		      s.setPreserveRatio(true);
		    		      s.setSmooth(true);
		    		     
		    		    Image image=new Image(getClass().getResourceAsStream("../Img/iconLoc.png"));
		    		    s.setImage(image);
		    		    paneId.getChildren().add(s);
		    		   
		    		    
	    			 } 
	    		     
	    		   
	    			 
	    		 }
	    		 
	    	 }
	     
	     }
    
  //  MapImage.setDisable(true);
    for(int i=0;i<mapPlaces.size();i++) 
    {
    	if(mapPlaces.get(i).getPlaceName().equals(PlaceName))
    	{
    		mapPlaces.get(i).setCorX(x);
    		mapPlaces.get(i).setCorY(y);
    		PlaceToUpdate=mapPlaces.get(i);
    	}
    }
    try {
		Main.getClient().getClient().MapToUpdate(PlaceToUpdate);
		flag=0;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	}
   }
 

    @FXML
    void PlaceClick(MouseEvent event) {
  // MapImage.setDisable(true);
    	 PlaceName= new String(PlacesList.getSelectionModel().getSelectedItem());
    flag=1;
     for(int i=0;i<mapPlaces.size();i++)
     {
    	 if(mapPlaces.get(i).getPlaceName().equals(PlaceName));
    	 {
    		 
    		 if(mapPlaces.get(i).getCorX()==0&&mapPlaces.get(i).getCorY()==0)
    		 {
    			 Alert alert = new Alert(AlertType.INFORMATION);
    			 alert.setContentText("Place Pin does not apear on the map!\n please choose location on the map.");
    			 alert.setTitle("Note");
    			 alert.setHeaderText(null);
    			 alert.showAndWait();
    			 
    			 
    		 }
    		 else
    		 {
    			 ImageView s = new ImageView();
    		      s.setLayoutX(mapPlaces.get(i).getCorX());
    		      s.setLayoutY(mapPlaces.get(i).getCorY());
    		      s.setFitHeight(25.0);
    		      s.setFitWidth(25.0);
    		      s.setPickOnBounds(true);
    		      s.setPreserveRatio(true);
    		      s.setSmooth(true);
    		      
    		    Image image=new Image(getClass().getResourceAsStream("../Img/iconLoc.png"));
    		    s.setImage(image);
    		    paneId.getChildren().add(s);
    		    Alert alert = new Alert(AlertType.INFORMATION);
    		     alert.setContentText("PlaceName="+PlaceName+"\nCordinate X= "+ s.getLayoutX()+"\nCordinate Y= "+s.getLayoutY());
    		     alert.setTitle("Information");
    		     alert.getDialogPane().setPrefSize(300, 150);
    		     alert.setHeaderText(null);
    		     alert.setX(620);
    		     alert.setY(120);
    		     alert.showAndWait();
    		   
    		   
    			 
    		 }
    		 
    	 }
     }
     
    }


    @FXML
    void ZoomInButton(ActionEvent event) {
    	double sliderValue= ScrollZoom.getValue();
    	ScrollZoom.setValue(sliderValue+=0.1);
    }

    @FXML
    void ZoomOutButton(ActionEvent event) {
    	
    	double sliderValue= ScrollZoom.getValue();
    	ScrollZoom.setValue(sliderValue-=0.1);
    }
    
    @FXML
    void HomeFunc(ActionEvent event) {

    }

    @FXML
    void LogOutFunc(ActionEvent event) {

    }
    

    @FXML
    void toProfile(ActionEvent event) {

    }
    
    ZoomingPane zoomingPane;

    @FXML
    void initialize() {
        assert zoomLBL != null : "fx:id=\"zoomLBL\" was not injected: check your FXML file 'map1.fxml'.";
        assert ZoomOutBtn != null : "fx:id=\"ZoomOutBtn\" was not injected: check your FXML file 'map1.fxml'.";
        assert ScrollZoom != null : "fx:id=\"ScrollZoom\" was not injected: check your FXML file 'map1.fxml'.";
       ScrollZoom.setMin(0.5);
       ScrollZoom.setMax(1.5);
       ScrollZoom.setValue(1.0);
   
      
         
        assert ZoomInBtn != null : "fx:id=\"ZoomInBtn\" was not injected: check your FXML file 'map1.fxml'.";
        assert HomeId != null : "fx:id=\"HomeId\" was not injected: check your FXML file 'Map.fxml'.";
        assert ProfileId != null : "fx:id=\"ProfileId\" was not injected: check your FXML file 'Map.fxml'.";
        assert LogOutID != null : "fx:id=\"LogOutID\" was not injected: check your FXML file 'Map.fxml'.";
        assert PlacesList != null : "fx:id=\"PlacesList\" was not injected: check your FXML file 'map1.fxml'.";
        mapPlaces= new ArrayList<MapPlace>();
       ArrayList<String> MaptoServer= new ArrayList<String>();
    	MaptoServer.add("GetplacesWithCordinatesForList");
    	MaptoServer.add("braude");
    	try {
         	Main.getClient().getClient().StringsToServer(MaptoServer);
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
          mapPlaces= Main.getClient().getClient().getMapPlaces();
          ArrayList<String> placesNames= new ArrayList<String>();
         ObservableList<String> list1;
         for(int i=0;i<mapPlaces.size();i++)
         {
        	 placesNames.add(Main.getClient().getClient().getMapPlaces().get(i).getPlaceName());
         }
         list1 = FXCollections.observableArrayList(placesNames);
         PlacesList.setItems(list1);
         assert ScrolPaneID != null : "fx:id=\"ScrolPaneID\" was not injected: check your FXML file 'Map.fxml'.";
         assert paneId != null : "fx:id=\"paneId\" was not injected: check your FXML file 'Map.fxml'.";
         zoomingPane = new ZoomingPane(paneId);
         zoomingPane.zoomFactorProperty().bind(ScrollZoom.valueProperty());
         
         assert MapImage != null : "fx:id=\"MapImageView\" was not injected: check your FXML file 'Map.fxml'.";
       
         ArrayList<String> MapImageToServer= new ArrayList<String>();
         MapImageToServer.add("GetImageForMap");
         MapImageToServer.add("braude");
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
    
         
       
      
      
     
    
    }   
}


	
