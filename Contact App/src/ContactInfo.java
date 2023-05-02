
public class ContactInfo {
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	
	
	//defualt constructor
	public ContactInfo() {
		
		
	}
	//define a constructor method for a ContactInfo class that takes four parameters: firstname (a string), lastname (a string), email (a string), and phone (a string)
	public ContactInfo(String firstname, String lastname,String email,String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		
	}
	//a method that returns the value of a private member variable called "firstname and for all of them 
	public String getfirstname() {
		return firstname;
		
	}
	public void setfirstname(String firstname) {
		this.firstname= firstname;
		
	}
	
	public String getlastname() {
		return lastname;
		
	}

	public void setlastname(String lastname) {
		this.lastname= lastname;
	}
	
	public String getemail() {
		return email;
		
	}
	
	public void setemail(String email) {
		this.email= email;
	}
	
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return lastname;
	}
	
}
