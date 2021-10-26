package ui;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.FIBA;
import model.Player;

public class FIBA_GUI {

	//********** First Pane **************
	@FXML
    private BorderPane mainPane;

    @FXML
    private TableView<Player> playerTable;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableColumn<Player, Integer> ageColumn;

    @FXML
    private TableColumn<Player, String> teamColumn;

    @FXML
    private TableColumn<Player, Double> pointsColumn;

    @FXML
    private TableColumn<Player, Double> bouncesColumn;

    @FXML
    private TableColumn<Player, Double> assistencesColumn;

    @FXML
    private TableColumn<Player, Double> stealsColumn;

    @FXML
    private TableColumn<Player, Double> blocksColumn;

	
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
				    initializeAllPlayersTableview();
				    alert.showAndWait();
				 
				    playerTable.refresh();
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
    public void initializeAllPlayersTableview() {
    	
    	ObservableList<Player> observableList;
    	observableList = FXCollections.observableArrayList(fiba.getAllPlayers());
    	playerTable.setItems(observableList);
    	 
    	nameColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
    	ageColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("Age"));
    	teamColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("team"));
    	bouncesColumn.setCellValueFactory(new PropertyValueFactory<Player,Double>("bouncesPerGame"));
    	blocksColumn.setCellValueFactory(new PropertyValueFactory<Player,Double>("blocksPerGame"));
    	pointsColumn.setCellValueFactory(new PropertyValueFactory<Player,Double>("pointsPerGame"));
    	assistencesColumn.setCellValueFactory(new PropertyValueFactory<Player,Double>("assistencesPerGame"));
    	stealsColumn.setCellValueFactory(new PropertyValueFactory<Player, Double>("stealsPerGame"));
    }
	
}
