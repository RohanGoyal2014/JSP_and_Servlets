package mvctwo;

import java.util.ArrayList;
import java.util.List;


public class StudentDataUtil {

	public static List<Student> getStudents() {
		List<Student> students=new ArrayList<>();
		
		students.add(new Student("Rohan","rohan.me2014@gmail.com"));
		students.add(new Student("ABC","abc@a.com"));
		
		return students;
	}
	
}
