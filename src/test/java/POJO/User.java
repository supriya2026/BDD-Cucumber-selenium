package POJO;

public class User {
       private String Email;
       private String Password;
       public User(String Email, String Password) {
    	   this.Email = Email;
    	   this.Password = Password;
       }
       
       
       public String getEmail() {
    	   return Email;
       }
       public String getPassword() {
    	   return Password;
       }
}
