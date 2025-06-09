package POJO;

public class Guest1 {
   
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phone;
    public Guest1() {
    	
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
        return "Guest(" + address + "," + city + "," + state +"," + zipcode + "," + phone + ")";
    }
    
}
