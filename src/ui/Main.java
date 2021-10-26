package ui;

//import java.io.IOException;
//import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//import model.Store;
import model.FIBA;

public class Main extends Application{

	private FIBA fiba;
	
	private FIBA_GUI fibaUI;
	
	public Main() {
		
		fiba = new FIBA();
		fibaUI = new FIBA_GUI(fiba);
	}
	
	
	public static void main(String[]args) {
			launch(args);
	}	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPaneV2.fxml"));
		fxmlLoader.setController(fibaUI);
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FIBA");
		primaryStage.show();
		
		
	}
		
	
	
}
