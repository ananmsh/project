package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	private static ClientConsole client;
	@Override
	public void start(Stage primaryStage) {
		setClient(new ClientConsole("localhost", 5555));
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/Fxml/Catalog.fxml"));//build the gui
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static ClientConsole getClient() {
		return client;
	}

	public static void setClient(ClientConsole client) {
		Main.client = client;
	}
}

