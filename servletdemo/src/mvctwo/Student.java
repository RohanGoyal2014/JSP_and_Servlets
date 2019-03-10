package mvctwo;

public class Student {

	
	public Student(String firstName, String email) {
		super();
		this.firstName = firstName;
		this.email = email;
	}
	
	String firstName;
	String email;

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
