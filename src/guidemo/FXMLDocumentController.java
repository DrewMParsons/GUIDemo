
package guidemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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
    /**
     * Initializes the controller class.
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
        
        
    } 
    
}
