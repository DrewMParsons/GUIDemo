
package guidemo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Drew
 */
public class PersonViewController implements Initializable {
    
    //create local variable of type Person to hold the data
    private Person selectedPerson;
    
    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label birthdayLabel;
    @FXML private Label ageLabel;
    
    /**
     * 
     * this method accepts a person to initialize the view 
     */
    
    public void initData(Person person){
        
        selectedPerson = person;
        firstNameLabel.setText(selectedPerson.getFirstName());
        lastNameLabel.setText(selectedPerson.getLastName());
        birthdayLabel.setText(selectedPerson.getBirthday().toString());
        ageLabel.setText(Integer.toString(selectedPerson.getAge()));
                
        
        
    }
    
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
        // TODO
    }    
    
}
