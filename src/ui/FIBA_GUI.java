package ui;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
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

    /*
    
	//**************** Others *********************
    @FXML
    private BorderPane othersMainPane;
    
    //**************** Search **********************
    @FXML
    private TextField nameSearchTextField;

    @FXML
    private TextField ageSearchTextField;

    @FXML
    private Label pointsSearchLabel;

    @FXML
    private Label bouncesSearchLabel;

    @FXML
    private Label assistencesSearchLabel;

    @FXML
    private Label stealsSearchLabel;

    @FXML
    private Label bloscksSearchLabel;

    @FXML
    private Label teamSearchLabel;
    */
    
    //******* Leak Pane **************
    @FXML
    private BorderPane leakerPane;

    @FXML
    private TextField conditionTextField;

    @FXML
    private RadioButton moreThanRadioButton;

    @FXML
    private ToggleGroup condition;

    @FXML
    private RadioButton lessThanRadioButton;
    
    @FXML
    private RadioButton equalsRadioButton;
    
    // *************** LeakTable Pane ************
    @FXML
    private BorderPane leakMainPane;

    @FXML
    private TableView<Player> leakTableView;
    						  
    @FXML
    private TableColumn<Player, String> nameLeakColumn;

    @FXML
    private TableColumn<Player, Integer> ageLeakColumn;

    @FXML
    private TableColumn<Player, String> teamLeakColumn;

    @FXML
    private TableColumn<Player, Double> pointsLeakColumn;

    @FXML
    private TableColumn<Player, Double> bouncesLeakColumn;

    @FXML
    private TableColumn<Player, Double> assistencesLeakColumn;

    @FXML
    private TableColumn<Player, Double> blocksLeaksColumn;

    @FXML
    private TableColumn<Player, Double> stealsLeakColumn;
    
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
		
    
    
    //This Open others instead of Modify
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
    @FXML
    void openClasifyPane(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("leakerPane.fxml"));
		fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.setPrefHeight(400);
    	mainPane.setPrefWidth(600);
    	mainPane.getChildren().setAll(menuPane); 
    	
    	
    }
    @FXML
    public void LeakByAssistences(MouseEvent event) throws IOException {

double condition = Double.parseDouble(conditionTextField.getText());
    	
    	if(lessThanRadioButton.isSelected()||moreThanRadioButton.isSelected()||equalsRadioButton.isSelected()) {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("leakPaneTable.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.initModality(Modality.WINDOW_MODAL);
    	stage.initOwner(mainPane.getScene().getWindow());
    	stage.setScene(scene);
    	stage.show();
    	if(lessThanRadioButton.isSelected()==true) {
    		
    		//fiba.searchLess(1, condition);
    		
        	
    		initializeLeakTableview(3, condition, 1);
    	
    	}else if(moreThanRadioButton.isSelected()) {
    		
        	
    		initializeLeakTableview(3, condition, 2);
    		
    		
    		}else {
    			
    		initializeLeakTableview(3, condition, 3);	
    			
    		}
    	}
    	
    	
    }

    @FXML
    public void LeakByBlocks(MouseEvent event) throws IOException {
    	
double condition = Double.parseDouble(conditionTextField.getText());
    	
    	if(lessThanRadioButton.isSelected()||moreThanRadioButton.isSelected()||equalsRadioButton.isSelected()) {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("leakPaneTable.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.initModality(Modality.WINDOW_MODAL);
    	stage.initOwner(mainPane.getScene().getWindow());
    	stage.setScene(scene);
    	stage.show();
    	if(lessThanRadioButton.isSelected()==true) {
    		
    		//fiba.searchLess(1, condition);
    		
        	
    		initializeLeakTableview(4, condition, 1);
    	
    	}else if(moreThanRadioButton.isSelected()) {
    		
        	
    		initializeLeakTableview(4, condition, 2);
    		
    		
    		}else {
    			
    		initializeLeakTableview(4, condition, 3);	
    			
    		}
    	}
    	
    	
    }

    @FXML
    public void LeakByBounces(MouseEvent event) throws IOException {
    	
double condition = Double.parseDouble(conditionTextField.getText());
    	
    	if(lessThanRadioButton.isSelected()||moreThanRadioButton.isSelected()||equalsRadioButton.isSelected()) {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("leakPaneTable.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.initModality(Modality.WINDOW_MODAL);
    	stage.initOwner(mainPane.getScene().getWindow());
    	stage.setScene(scene);
    	stage.show();
    	if(lessThanRadioButton.isSelected()==true) {
    		
    		//fiba.searchLess(1, condition);
    		
        	
    		initializeLeakTableview(2, condition, 1);
    	
    	}else if(moreThanRadioButton.isSelected()) {
    		
        	
    		initializeLeakTableview(2, condition, 2);
    		
    		
    		}else {
    			
    		initializeLeakTableview(2, condition, 3);	
    			
    		}
    	}
    	
    }

    @FXML
    public void LeakByPoints(MouseEvent event) throws IOException {

    	double condition = Double.parseDouble(conditionTextField.getText());
    	
    	if(lessThanRadioButton.isSelected()||moreThanRadioButton.isSelected()||equalsRadioButton.isSelected()) {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("leakPaneTable.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.initModality(Modality.WINDOW_MODAL);
    	stage.initOwner(mainPane.getScene().getWindow());
    	stage.setScene(scene);
    	stage.show();
    	if(lessThanRadioButton.isSelected()==true) {
    		
    		//fiba.searchLess(1, condition);
    		
        	
    		initializeLeakTableview(1, condition, 1);
    	
    	}else if(moreThanRadioButton.isSelected()) {
    		
        	
    		initializeLeakTableview(1, condition, 2);
    		
    		
    		}else {
    			
    		initializeLeakTableview(1, condition, 3);	
    			
    		}
    	}
    	
    }

    @FXML
    public void leakBySteals(MouseEvent event) throws IOException {
    	
double condition = Double.parseDouble(conditionTextField.getText());
    	
    	if(lessThanRadioButton.isSelected()||moreThanRadioButton.isSelected()||equalsRadioButton.isSelected()) {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("leakPaneTable.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.initModality(Modality.WINDOW_MODAL);
    	stage.initOwner(mainPane.getScene().getWindow());
    	stage.setScene(scene);
    	stage.show();
    	if(lessThanRadioButton.isSelected()==true) {
    		
    		//fiba.searchLess(1, condition);
    		
        	
    		initializeLeakTableview(5, condition, 1);
    	
    	}else if(moreThanRadioButton.isSelected()) {
    		
        	
    		initializeLeakTableview(5, condition, 2);
    		
    		
    		}else {
    			
    		initializeLeakTableview(5, condition, 3);	
    			
    		}
    	}
    	
    	
    }
    public void initializeLeakTableview(int tree, double condition, int choose) {
    	
    	System.out.println(choose);
    	
    	ObservableList<Player> observableList;
    	
    	if(choose==1) {	
    	observableList = FXCollections.observableArrayList(fiba.searchLess(tree, condition));
    	}else if(choose==2){
    	observableList = FXCollections.observableArrayList(fiba.searchMore(tree, condition));
    	
    	//System.out.println("Es Nulo aqui");
    	}else {
    	observableList = FXCollections.observableArrayList(fiba.searchEquals(tree, condition));
    		
    	}
    	if(leakTableView==null) {
    		System.out.println("ObservableList es null");
    		
    	}else {
    		
    	leakTableView.setItems(observableList);
    	}
    	nameLeakColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
    	ageLeakColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("Age"));
    	teamLeakColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("team"));
    	bouncesLeakColumn.setCellValueFactory(new PropertyValueFactory<Player,Double>("bouncesPerGame"));
    	blocksLeaksColumn.setCellValueFactory(new PropertyValueFactory<Player,Double>("blocksPerGame"));
    	pointsLeakColumn.setCellValueFactory(new PropertyValueFactory<Player,Double>("pointsPerGame"));
    	assistencesLeakColumn.setCellValueFactory(new PropertyValueFactory<Player,Double>("assistencesPerGame"));
    	stealsLeakColumn.setCellValueFactory(new PropertyValueFactory<Player, Double>("stealsPerGame"));
    	
    }
    @FXML
    public void returnToMainPane(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPaneV2.fxml"));
		fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.setPrefHeight(324);
    	mainPane.setPrefWidth(1200);
    	mainPane.getChildren().setAll(menuPane); 
    	
    	
    	
    }
    
}

