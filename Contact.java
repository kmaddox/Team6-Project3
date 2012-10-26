public class Contact{

		//Attributes
		private String emailAddress;
		private String firstName;
		private String lastName;
		
		// Constructor that sets the private attributes to empty strings
		public Contact(){
			emailAddress = "";
			firstName = "";
			lastName = "";
		}
		
		//Constructor that sets the private attributes to passed Strings
		Contact(String email, String first, String last) {
			emailAddress = email;
			firstName = first;
			lastName = last;
		}
		
		// "FirstName LastName", email@address.net
		public String toString(){
			String stringName = firstName + " " + lastName;
			String stringEmail = ", " + emailAddress;
			String contactInfo = stringName + stringEmail;
			return contactInfo;
		}
		
		public String getEmailAddress(){
			return emailAddress;
		}
		
		public void setEmailAddress(String email){
			emailAddress = email;
		}
		public String getFirstName(){
			return firstName;
		}
		
		public void setFirstName(String first){
			firstName = first;
		}
		
		public String getLastName(){
			return lastName;
		}
		
		public void setLastName(String last){
			lastName = last;
		}
}