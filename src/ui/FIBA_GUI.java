package ui;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.FIBA;

public class FIBA_GUI {

	//********** First Pane **************
	@FXML
    private BorderPane mainPane;

    @FXML
    private TableView<?> playerTable;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> ageColumn;

    @FXML
    private TableColumn<?, ?> teamColumn;

    @FXML
    private TableColumn<?, ?> pointsColumn;

    @FXML
    private TableColumn<?, ?> bouncesColumn;

    @FXML
    private TableColumn<?, ?> assistencesColumn;

    @FXML
    private TableColumn<?, ?> stealsColumn;

    @FXML
    private TableColumn<?, ?> blocksColumn;

	
	private FIBA fiba;
	
	
	
	public FIBA_GUI(FIBA fiba) {
		
		this.fiba = fiba;
	}
	@FXML
    public void importData(ActionEvent event) {
		
		FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	File file = fileChooser.showOpenDialog(null);
    	if(file != null) {
    		try {
				 fiba.importData(file.getAbsolutePath());
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("FIBA");
				    alert.setHeaderText("Annoucement");
				    alert.setContentText("The Players Have been succesfully imported");
				
				    alert.showAndWait();
			} catch (IOException e) {
				 Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("FIBA");
				    alert.setHeaderText("Error");
				    alert.setContentText("The Players were not succesfully imported ");
				
				    alert.showAndWait();
			}
	  
	 
    }
  }		
		
		

    @FXML
    public void openDeletePane(ActionEvent event) {

    }

    @FXML
    public void openModify(ActionEvent event) {

    }
	
}
