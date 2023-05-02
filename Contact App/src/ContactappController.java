
//The FXCollections class is a part of JavaFX collections API, which provides 
//several classes and interfaces for managing and manipulating collections 
//of data in JavaFX applications.

import javafx.collections.FXCollections;	
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactappController {

    @FXML
//    this declaration creates a new private instance variable of type ListView<ContactInfo>
   // that can be used to display a list of contact information in a graphical user interface (GUI)
    private ListView<ContactInfo> contactlistview;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField searchTextField;
    
    
    private ObservableList<ContactInfo> ContactInfo = FXCollections.observableArrayList();

	private boolean found;// this declaration creates a new private instance variable of type boolean 
	//that can be used to track whether a certain condition or value has been found or not
	

    public void initialize() {
        // Initialize the contacts list
    	ContactInfo.add(new ContactInfo("fortune", "ogulewe", "fortune@gmail.com", "807-407-6700"));
    	ContactInfo.add(new ContactInfo("ebube", "orlukwu", "ebueb@gmial.com", "807-468-3370"));
    	ContactInfo.add(new ContactInfo("Jeff", "Bezos", "jbezos@amazon.ca", "800-588-2300"));
    	
    	// the rest is to to prove the search function in the code this are not included just 
    	//to prove that the  search function works and exist 
    	ContactInfo.add(new ContactInfo("Elon", "Musk", "emusk@spacex.com", "555-1234"));
    	ContactInfo.add(new ContactInfo("Bill", "Gates", "bgates@microsoft.com", "555-5678"));
    	ContactInfo.add(new ContactInfo("Mark", "Zuckerberg", "mzuckerberg@facebook.com", "555-9012"));
    	ContactInfo.add(new ContactInfo("Larry", "Page", "lpage@google.com", "555-3456"));
    	ContactInfo.add(new ContactInfo("Sergey", "Brin", "sbrin@google.com", "555-7890"));
    	ContactInfo.add(new ContactInfo("Larry", "Ellison", "lellison@oracle.com", "555-2345"));
    	ContactInfo.add(new ContactInfo("Steve", "Jobs", "sjobs@apple.com", "555-6789"));
    	ContactInfo.add(new ContactInfo("Tim", "Cook", "tcook@apple.com", "555-0123"));
    	ContactInfo.add(new ContactInfo("Warren", "Buffett", "wbuffett@berkshirehathaway.com", "555-4567"));
    	ContactInfo.add(new ContactInfo("Jeff", "Immelt", "jimmelt@ge.com", "555-8901"));
    	ContactInfo.add(new ContactInfo("Oprah", "Winfrey", "owinfrey@own.com", "555-3333"));
    	ContactInfo.add(new ContactInfo("Michael", "Jordan", "mjordan@jumpman.com", "555-4444"));
    	ContactInfo.add(new ContactInfo("Satya", "Nadella", "snadella@microsoft.com", "888-333-4444"));
    	ContactInfo.add(new ContactInfo("Jack", "Dorsey", "jdorsey@twitter.com", "800-444-5555"));
    	ContactInfo.add(new ContactInfo("Reed", "Hastings", "rhastings@netflix.com", "877-555-6666"));
    	ContactInfo.add(new ContactInfo("Brian", "Chesky", "bchesky@airbnb.com", "888-777-8888"));
    	//end 
        contactlistview.setItems(ContactInfo);

        // Set up the selection listener for the contacts list view
        contactlistview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {//This line checks if the user has selected an item from the list veiw
                firstnameTextField.setText(newSelection.getfirstname());// this updates the GUI to display the first name of the selected item.
                lastnameTextField.setText(newSelection.getlastname());
                emailTextField.setText(newSelection.getemail());
                phoneTextField.setText(newSelection.getphone());
            } else {
                firstnameTextField.setText("");
                lastnameTextField.setText("");
                emailTextField.setText("");
                phoneTextField.setText("");
            }
        });
    }

    @FXML
    void deletebuttonpressed(ActionEvent event) {
    	// Get the selected contact and remove it from the contacts list
    	int selectedIndex = contactlistview.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	//This line checks if the value of a variable called selectedIndex is greater 
        	//than or equal to zero. Presumably, selectedIndex represents the index 
        	//of a selected item in a list or table
        	ContactInfo.remove(selectedIndex);
        }
    	
    }

    @FXML
    void newbuttonpressed(ActionEvent event) {
    	ContactInfo newContact = new ContactInfo("", "", "", "");// this creates an empty text field to input new contact infomation
    	ContactInfo.add(newContact);
        contactlistview.getSelectionModel().select(newContact);//this put the new contact in to the list veiw 
        
        
        firstnameTextField.clear();
        lastnameTextField.clear();
        emailTextField.clear();
        phoneTextField.clear();
        
        firstnameTextField.setPromptText("Enter first name");
        lastnameTextField.setPromptText("Enter last name");
        emailTextField.setPromptText("Enter email");
        phoneTextField.setPromptText("Enter phone number");
        
        
        
        

    }

    @FXML
    void savebuttonpressed(ActionEvent event) {
    	 // Get the selected contact and update its information with the text fields
        int selectedIndex = contactlistview.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            String firstname = firstnameTextField.getText();
            String lastname = lastnameTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
            boolean validInput = true;
            
            // Check that email and phone are valid inputs
            //InputMismatchException exception 
            if (!email.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}")) {//This line checks if the email address stored in a variable called 
               //email matches a certain regular expression pattern.
            	validInput = false;
                emailTextField.setStyle("-fx-border-color: red;");
                emailTextField.clear();
                emailTextField.setPromptText("Wrong Input");
                
            } else {
                emailTextField.setStyle("");
            }
            
            if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {//This line checks if the phone address stored in a variable called 
                //phone matches a certain regular expression pattern.
                validInput = false;
                phoneTextField.setStyle("-fx-border-color: red;");
                phoneTextField.clear();
                phoneTextField.setPromptText("Wrong Input");
                
                
            } else {
                phoneTextField.setStyle("");
            }
            
            if (validInput) {
                ContactInfo selectedContact = contactlistview.getSelectionModel().getSelectedItem();
                selectedContact.setfirstname(firstname);
                selectedContact.setlastname(lastname);
                selectedContact.setemail(email);
                selectedContact.setphone(phone);
                contactlistview.refresh();
            }
        }

    }

    @FXML
    void searchbuttonpressed(ActionEvent event) {
    	
    	    // Search the contacts list for contacts whose last names match the search text
    	    String searchText = searchTextField.getText().toLowerCase();
    	    boolean contactFound = false;
    	    for (ContactInfo contact : ContactInfo) {
    	        if (contact.getlastname().toLowerCase().contains(searchText))
    	        {
    	        	
    	            // Select the matching contact in the contacts list view
    	            contactlistview.getSelectionModel().select(contact);
    	            contactFound = true;
    	            break;
    	        }
    	    }

    	    //IllegalArgumentExceptionwas used here
    	 // Highlight the matching contact in the list view if it was found
    	    if (contactFound) {
    	    	// Loop through the items in the contact list view
    	        for (ContactInfo contact : contactlistview.getItems()) {
    	        	// Check if the last name of the current contact contains the search text
    	            if (contact.getlastname().toLowerCase().contains(searchText)) {
    	            	// Select the matching contact in the contact list view
    	                contactlistview.getSelectionModel().select(contact);
    	             // Scroll to the matching contact in the contact list view
    	                contactlistview.scrollTo(contact);//scrolls the list view to the selected contact so it is visible to the user.
    	                break;// this exit from the loop search 
    	            }
    	        }
    	        contactlistview.requestFocus();//sets the focus to the list view so that the user can use arrow keys to navigate through the list
    	        searchTextField.setText("");
    	        searchTextField.setText(searchText);//sets the text of the search text field to the search query entered by the user.
    	        searchTextField.end();
    	        int selectedIndex = contactlistview.getSelectionModel().getSelectedIndex();//retrieves the index of the selected contact in the list view.
    	        if (selectedIndex >= 0) {
    	            contactlistview.getFocusModel().focus(selectedIndex);
    	            contactlistview.scrollTo(selectedIndex);
    	        }
    	        searchTextField.setStyle("-fx-border-color: green;");
    	        searchTextField.clear();
    	        
    	        
    	    } else {
    	        // Display an error message in the search text field if the contact was not found
    	        searchTextField.setStyle("-fx-border-color: red;");
    	        searchTextField.setPromptText("contact not found");
    	        searchTextField.clear();
    	        
    	    }
    }
    	    


    @FXML
    void updatebuttonpressed(ActionEvent event) {
    	 // Refresh the contacts list view to display any changes to the contacts list
        contactlistview.refresh();
       
    }

    

}
