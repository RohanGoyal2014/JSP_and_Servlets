package datapack;

public class Student {
	
	String firstName;
	boolean isGood;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public boolean getIsGood() {
		return isGood;
	}
	public void setIsGood(boolean isGood) {
		this.isGood = isGood;
	}
	public Student(String firstName, boolean isGood) {
		super();
		this.firstName = firstName;
		this.isGood = isGood;
	}
	
	

}
