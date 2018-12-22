/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Drew
 */
public class TableViewExampleController implements Initializable {
    
    //configure the table
    
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;
    
    //used to create new person objects
    @FXML private TextField firstNameTextField;    
    @FXML private TextField lastNameTextField;
    @FXML private DatePicker birthdayDatePicker;
    
    /**
     * 
     * Method allows user to double click on the cell and update the firstname
     */
    
    public void changeFirstNameCellEvent(CellEditEvent edittedCell){
        
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setFirstName(edittedCell.getNewValue().toString());
        
    }
    
    /**
     * 
     * Method allows user to double click on the cell and update the Lastname
     */
    
    public void changeLastNameCellEvent(CellEditEvent edittedCell){
        
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setLastName(edittedCell.getNewValue().toString());
      
    
    }
    
    public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
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
        
        //sets up the columns
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person,LocalDate>("birthday"));
        
        //load dummt data
        tableView.setItems(getPeople());
        
        //Update the table to allow for first and last name fields to be editable
        tableView.setEditable(true);
        
        
        
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //Allows user to select multiple rows at a time
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }   
    
    /**
     * this method will remove selected row(s) from the table
     */
    public void deleteButtonPushed(){
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();
        
        //gets the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        //loop over the List and remove any from selectedrows
        
      
            
         allPeople.removeAll(selectedRows);
        
        
    }
    
    /**
     *  this method returns ObservableList of People objects
     */
    
    public ObservableList<Person> getPeople(){
        
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Frank", "Sinatra", LocalDate.of(1915, Month.DECEMBER, 12)));
        people.add(new Person("Reb", "Finatra", LocalDate.of(1986, Month.JULY, 21)));
        people.add(new Person("Mr", "T", LocalDate.of(1915, Month.MAY, 12)));
       
        return people;
    }
    
    /**
     *  add new person to table
     */
    
    public void newPersonButtonPushed(){
        
        Person newPerson = new Person(firstNameTextField.getText(),
                                      lastNameTextField.getText(),
                                      birthdayDatePicker.getValue());
        
        //ask table to give us the entire list
        //add new person to the list
        tableView.getItems().add(newPerson);
        
        
    }
}  

