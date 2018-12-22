
package guidemo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Drew
 */
public class FXMLDocumentController implements Initializable {

    //Items for CheckBox
    @FXML
    private CheckBox pepperoniCheckBox;
    @FXML
    private CheckBox pineappleCheckBox;
    @FXML
    private CheckBox baconCheckBox;
    @FXML
    private Label pizzaOrderLabel;
    
    //Items for Choice Box
    @FXML 
    private ChoiceBox choiceBox;
    @FXML
    private Label choiceBoxLabel;
    
    //Itmes for Combo BOx
    @FXML 
    private ComboBox comboBox;
    @FXML
    private Label comboBoxLabel;
    
    //Items for Radio Button Boc
    @FXML
    private RadioButton phpRadioButton;
    
    @FXML
    private RadioButton javaRadioButton;
    
    @FXML
    private RadioButton cSharpRadioButton;
    
    @FXML
    private RadioButton cPlusPlusRadioButton;
    
    @FXML 
    private Label radioButtonLabel;
    
    private ToggleGroup favLangToggleGroup;
     /**
     * This will update Label for Choicebox
     */
    
    //items for listview
    @FXML
    private ListView listView;
    
    @FXML
    private TextArea golfTextArea;
    
    
    public void choiceBoxButtonPushed(){
        choiceBoxLabel.setText("My Favorite fruit is:\n " +choiceBox.getValue().toString());
    }
     
    
    /**
     * This is for Checkbox
     */
     
    
    public void pizzaOrderButtonPushed() {
        
        String order = "Toppings are:";
        
        if(pineappleCheckBox.isSelected())
            order += "\npineapple";
        
        if(pepperoniCheckBox.isSelected())
            order += "\npepperoni";
            
            if(baconCheckBox.isSelected())
            order += "\nbacon";
        pizzaOrderLabel.setText(order);
        
    }
    
    /**
     * This will update comboboxlabel when combobox is changed
     */
  
    
    public void comboBoxWasUpdated(){
        this.comboBoxLabel.setText("Course selected:  \n" + comboBox.getValue().toString());
    }
    /**
     *  Method to update radiobutton label
     */
    public void radioButtonChanged(){
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.phpRadioButton))
            radioButtonLabel.setText("The item selected is PHP");
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.javaRadioButton))
            radioButtonLabel.setText("The item selected is Java");
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.cSharpRadioButton))
            radioButtonLabel.setText("The item selected is C#");
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.cPlusPlusRadioButton))
            radioButtonLabel.setText("The item selected is C++");
        
    }
    
    /**
     *  Method to copy Strings from ListView and populate textArea
     */
    
    public void listViewButtonPushed(){
        
        String textAreaString = "";
        
        ObservableList listOfItems = listView.getSelectionModel().getSelectedItems();
        
        for (Object item : listOfItems){
            textAreaString += String.format("%s%n", (String) item);
        } 
        
        this.golfTextArea.setText(textAreaString);
            
    }
    /**
     * 
     * When this method is called, the scene will change to tableView example 
     */
    
    public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TableViewExample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent); 
        
        //This line gets the Stage information
        //In Start, the stage is passed through as a param.  here we need to get it
        //the action event(event) doesnt know what type of object is returned, so we tell it the return is of type node
        //BCS its a Node, we cam then get the scene and window, 
        //Then cast that as a Stage, and assign to our Stage(window)
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
      /**
     * Initializes the controller class.
     */
    
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        pizzaOrderLabel.setText("");
        
        //These items are for configuring the ChoiceBox 
        choiceBoxLabel.setText("");
        
        //getItems will return items currently in (choicebox). returns empty list if no items are there
        choiceBox.getItems().add("apples");
        choiceBox.getItems().add("bananas");
        choiceBox.getItems().addAll("oranges","pears","strawberries");
        choiceBox.setValue("apples");
        
        //Thse items are for configuring the ComboBox
        comboBoxLabel.setText("");
        comboBox.getItems().addAll("COMP1030","COMP1008","MGMT2010","MGMT2030");
        
        //Thes configure Radio Buttons
        radioButtonLabel.setText("");
        favLangToggleGroup = new ToggleGroup();
        this.phpRadioButton.setToggleGroup(favLangToggleGroup);
        this.javaRadioButton.setToggleGroup(favLangToggleGroup);
        this.cSharpRadioButton.setToggleGroup(favLangToggleGroup);
        this.cPlusPlusRadioButton.setToggleGroup(favLangToggleGroup);
        
        
        //COnfigure ListView
        listView.getItems().addAll("Golf Balls","Wedges","Irons","Drivers","Putter");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        
    } 
    
}
