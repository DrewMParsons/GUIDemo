
package guidemo;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * Use Property objects to make the table updatable.  Property has built
 * in Listeners
 */
public class Person {
    
    private SimpleStringProperty firstName, lastName;
    private LocalDate birthday;

    
    
    // Constructor 
    //accepts Strings, and converts to Properties
    
    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthday = birthday;
    }

    
    //Getters and Setters
    
    
    public String getFirstName(){
        return firstName.get();
    }

    public void setFirstName(SimpleStringProperty firstName) {
        this.firstName = firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }
    

    public void setLastName(SimpleStringProperty lastName) {
        this.lastName = lastName;
    }
    
    public void setLastName(String lastName) {
        this.firstName.set(lastName);
    }
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    
    
    
}
