package web_student_tracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtil {

	private DataSource dataSource;

	public StudentDBUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		
		ArrayList<Student> students = new ArrayList<>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			
			conn=dataSource.getConnection();
			
			String sql="select * from student order by last_name";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String firstName=rs.getString("first_name");
				String lastName=rs.getString("last_name");
				String email= rs.getString("email");
				int id=Integer.parseInt(rs.getString("id"));
				
				students.add(new Student(id,firstName,lastName,email));
				
			}
			return students;
			
		} finally {
			close(conn,stmt,rs);
		}
		
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) {
		
		try {
			/*
			 * Does not actually close
			 * Rather puts back into connection pool
			 * */
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void addStudent(Student student) throws Exception{
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=dataSource.getConnection();
			
			String sql="insert into student(first_name,last_name,email) values (?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getEmail());
			
			ps.execute();
		} finally {
			close(conn,ps,null);
		}
		
	}
	
	public Student getStudent(String id) throws Exception{
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Integer id_=Integer.parseInt(id);
			String sql="select * from student where id=?";
			conn=dataSource.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id_);
			rs=ps.executeQuery();
			if(rs.next()) {
				String firstName=rs.getString("first_name");
				String lastName=rs.getString("last_name");
				String email=rs.getString("email");
				Student student=new Student(id_,firstName,lastName,email);
				return student;
			} else {
				throw new Exception("Could not find student:"+id);
			}
			
		} finally {
			close(conn,ps,rs);
		}
		
		
	}

	public void updateStudent(Student student) throws Exception{
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			String sql="update student set first_name=?,last_name=?,email=? "
					+ " where id=?" ;
			conn=dataSource.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getEmail());
			ps.setInt(4, student.getId());
			
			ps.execute();
		} finally {
			close(conn,ps,null);
		}
		
	}

	public void deleteStudent(String id) throws Exception {
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			int id_=Integer.parseInt(id);
			String sql="delete from student where id=?";
			conn=dataSource.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id_);
			ps.execute();
			
			
		} finally {
			close(conn,ps,null);
			
		}
		
	}
	
}
