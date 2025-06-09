package POJO;

public class Guest {
    
	private String email;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phone;
    public Guest() {
    	
    }
    
    
   
    public String getEmail() {
 	   System.out.println(email);
 	   return email;
    }
    public void setEmail(String email) {
    	this.email=email;
    }
    public void setFirstname(String firstname) {
    	this.firstname=firstname;
    }
    public String getFirstname() {
 	   return firstname;
    }
    public String getLastname() {
 	   return lastname;
    }
    public void setLastname(String lastname) {
    	this.lastname=lastname;
    }
   
    public String getAddress() {
 	   return address;
    }
    public void setAddress(String address) {
    	this.address=address;
    }
    public String getCity() {
 	   return city;
    }
    public void setCity(String city) {
    	this.city=city;
    }
    public String getState() {
 	   return state;
    }
    public void setState(String state) {
    	this.state=state;
    }
    public String getZipcode() {
 	   return zipcode;
    }
    public void setZipcode(String zipcode) {
    	this.zipcode=zipcode;
    }
    public String getPhone() {
 	   return phone;
    }
    public void setPhone(String phone) {
    	this.phone=phone ;
    }
   
    
   
    
   
    
   
    
    @Override
    public String toString() {
        return "Guest(" + email + ", " + firstname + ", " + lastname + "," + address + "," + city + "," + state +"," + zipcode + "," + phone + ")";
    }
    
}
