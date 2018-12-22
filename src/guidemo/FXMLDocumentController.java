
package guidemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

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

     /**
     * This will update Label for Choicebox
     */
    
    public void choiceBoxButtonPushed(){
        choiceBoxLabel.setText("My Favorite fruit is:\n " +choiceBox.getValue().toString());
    }
     
    
    /**
     * This is for Checkbox
     */
     

    @FXML
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
    } 
    
}
