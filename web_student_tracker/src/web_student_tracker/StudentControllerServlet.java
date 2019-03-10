package web_student_tracker;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDBUtil studentDBUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;

	public void init(ServletConfig config) throws ServletException {
		super.init();
		try {
			studentDBUtil = new StudentDBUtil(dataSource);
			
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command=request.getParameter("command");
			if(command==null) {
				command="LIST";
			}
			switch(command) {
			
			case "add" : addStudents(request,response);
						break;
			case "load": loadStudent(request,response);
						break;
			case "update": updateStudent(request,response);
							break;
			case "delete": deleteStudent(request,response);
							break;
			default: listStudents(request,response); 
			}
			
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String id=request.getParameter("id");
		studentDBUtil.deleteStudent(id);
		listStudents(request,response);
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int id=Integer.parseInt(request.getParameter("id"));
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		studentDBUtil.updateStudent(new Student(id,firstName,lastName,email));
		
		listStudents(request,response);
		
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String id=request.getParameter("id");
		
		Student student=studentDBUtil.getStudent(id);
		
		request.setAttribute("student", student);
		
		RequestDispatcher rd=request.getRequestDispatcher("/update_content.jsp");
		rd.forward(request, response);
		
	}

	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		studentDBUtil.addStudent(new Student(firstName,lastName,email));
		
		listStudents(request,response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Student> students=studentDBUtil.getStudents();
			
		request.setAttribute("STUDENT_LIST", students);
			
		RequestDispatcher rd=request.getRequestDispatcher("/list_students.jsp");
		rd.forward(request, response);	
		
	}

}
