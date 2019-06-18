package Gui;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import Controller.LoginController;
import Controller.ReportController;
import application.Main;
import entities.Purchase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;

public class PurchaseGui  {

	ReportController reportController;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboBoxCity;

    @FXML
    private RadioButton OneTimeRad;

    @FXML
    private DatePicker DatePicker;

    @FXML
    private Button PurchaseBtn;
    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Button cancelBTN;
    
    @FXML
    private TextField PriceText;

    @FXML
    private TextField discountText;
    @FXML
    private Label pricelbl;

    @FXML
    private Label discountlbl;
    
    @FXML
    void Cancel(ActionEvent event) {

    }
    


    @FXML
    void CmbCity(ActionEvent event) throws InterruptedException {
    	String id;
    	ArrayList<String> getprice=new ArrayList<String>();
    	getprice.add("getprice");
    	getprice.add((String)ComboBoxCity.getSelectionModel().getSelectedItem());
    	//id=LoginController.id; // HAS TO BE CUSTOMER ID
    	id="111";
    	getprice.add(id);
    	try {
    		Main.getClient().getClient().StringsToServer(getprice);
    	} catch (IOException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
      	try {
    			Thread.currentThread().sleep(150);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	double price=Main.getClient().getClient().getPrice();
    	String pricetxt = Double.toString(price);	
    	this.PriceText.setText(pricetxt);
    	if(OneTimeRad.isSelected()) {
        	this.discountText.setText("No Discount");
        	this.discountText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");}
    	else if(Main.getClient().getClient().isDiscount())
    	{
    	this.discountText.setText("Discount Applied");
    	this.discountText.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
    	}
    	else {
    		this.discountText.setText("No Discount");
    		this.discountText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
    		}
    }

    @FXML
    void OneTimePurchase(ActionEvent event) {
    	if(OneTimeRad.isSelected()) {
    		if(Main.getClient().getClient().isDiscount()) {
    			double price=Main.getClient().getClient().getPrice();
    		    price= price/90 * 100;
    		    String pricetxt = Double.toString(price);	
    	    	this.PriceText.setText(pricetxt);
    		}
    	DatePicker.setDisable(true);
    	endDatePicker.setDisable(true);
    	this.discountText.setText("No Discount");
    	this.discountText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
    	}
    	else {
    		DatePicker.setDisable(false);
    		endDatePicker.setDisable(false);
    		if(Main.getClient().getClient().isDiscount()) {
    	    	this.discountText.setText("Discount Applied");
    	    	this.discountText.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
    	    	double price=Main.getClient().getClient().getPrice();
    		    String pricetxt = Double.toString(price);	
    	    	this.PriceText.setText(pricetxt);
    		}
    	    	else {
    	    		this.discountText.setText("No Discount");
    	    		this.discountText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
    	    	}
    	}
    }

    @FXML
    void PickDate(ActionEvent event) {
    }
    @FXML
    void endDatePickerHandle(ActionEvent event) {
		if(DatePicker.getValue().compareTo(endDatePicker.getValue()) > 0)
    	{
    		Alert alert = new Alert(AlertType.ERROR);
	        alert.setContentText("End Date cannot earlier than start date!!!");
	        alert.setTitle("Failed" );
	        alert.setHeaderText(null);
	        alert.showAndWait();
	        endDatePicker.getEditor().clear();
    	}	    	
    }
    @FXML
    void PurchaseBtn(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Are you sure you wish to buy this city?!");
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		Optional<ButtonType> result=alert.showAndWait();
		if(result.get() == ButtonType.OK)
		{
    	if((!(OneTimeRad.isSelected())))
    	{
    		Purchase purchase = new Purchase();
    		purchase.setCityname((String)ComboBoxCity.getSelectionModel().getSelectedItem());
            //purchase.setCustomerid(LoginController.id);; // HAS TO BE CUSTOMER ID
    		purchase.setCustomerid("111");
            purchase.setDateStart(DatePicker.getValue());
            purchase.setDateEnd(endDatePicker.getValue());
            purchase.setPurchaseType("subscription");
            purchase.setPurchaseDate(LocalDate.now());
			try {
				Main.getClient().getClient().AddingNewData(purchase);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}        
    	else
    	{
    		Purchase purchase = new Purchase();
    		purchase.setCityname((String)ComboBoxCity.getSelectionModel().getSelectedItem());
    		purchase.setCustomerid("111");
    		//purchase.setCustomerid(LoginController.id);; // HAS TO BE CUSTOMER ID
            purchase.setPurchaseDate(LocalDate.now());
            purchase.setPurchaseType("OneTime");
            try {
				Main.getClient().getClient().AddingNewData(purchase);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		}
		else {
			alert.close();
		}
    }
    

    @FXML
    void initialize() {
        assert ComboBoxCity != null : "fx:id=\"ComboBoxCity\" was not injected: check your FXML file 'Purchase.fxml'.";
        reportController=new ReportController();
   	    reportController.GetCityComboBox();
        ObservableList<String> list;
        list = FXCollections.observableArrayList(Main.getClient().getClient().getCityNames());
		ComboBoxCity.setItems(list);//update the ComboxBox with the list of cities 
		new AutoCompleteComboBoxListener<>(ComboBoxCity);
		 assert PriceText != null : "fx:id=\"PriceText\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert OneTimeRad != null : "fx:id=\"OneTimeRad\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert DatePicker != null : "fx:id=\"DatePicker\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert PurchaseBtn != null : "fx:id=\"PurchaseBtn\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert cancelBTN != null : "fx:id=\"cancelBTN\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert discountText != null : "fx:id=\"discountText\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert endDatePicker != null : "fx:id=\"endDatePicker\" was not injected: check your FXML file 'Purchase.fxml'.";
        LocalDate in6months=LocalDate.now();
        in6months=in6months.plusMonths(6);
    	endDatePicker.setValue(in6months); // Max date available will be the date + 6 months
    	DatePicker.setValue(LocalDate.now());
    	final Callback<DatePicker, DateCell> dayCellFactory;

    	dayCellFactory = (final DatePicker datePicker) -> new DateCell() {
    	    @Override
    	    public void updateItem(LocalDate item, boolean empty) {
    	        super.updateItem(item, empty);
    	        if (item.isAfter(endDatePicker.getValue())) { //Disable all dates after required date
    	            setDisable(true);
    	            setStyle("-fx-background-color: #ffc0cb;"); //To set background on different color
    	        }
    	    }
    	};
    	LocalDate minDate;
    	LocalDate maxDate;
    	minDate = LocalDate.now();
    	maxDate = minDate.plusMonths(6);
    	DatePicker.setDayCellFactory(d ->
    	           new DateCell() {
    	               @Override public void updateItem(LocalDate item, boolean empty) {
    	                   super.updateItem(item, empty);
    	                   setDisable(item.isBefore(minDate));
    	               }});
    	endDatePicker.setDayCellFactory(d ->
        new DateCell() {
            @Override public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setDisable(item.isAfter(maxDate));
            }});
    }}

