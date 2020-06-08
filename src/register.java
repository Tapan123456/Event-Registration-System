import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/register")
@MultipartConfig(maxFileSize = 16177215)
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L; 

    public register() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random random = new Random();
		
		String f_name = request.getParameter("f_name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mob");
		String tickets = request.getParameter("tickets");
		String Rtype = request.getParameter("Rtype");
		
		Part filepart = request.getPart("myfile");
		InputStream inputStream = null;
		
		
		if(filepart != null)
		{
			inputStream = filepart.getInputStream();
		}
		
		int random_no = random.nextInt(1000);
		String ID = "Evet_Reg" + Integer.toString(random_no);
	      
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Event", "root", "Dhvs@12345");
			String query = "insert into event (ful_name, email, mobile, Rtype, tickets, reg_id, photo) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement p = c.prepareStatement(query);
			p.setString(1, f_name);
			p.setString(2, email);
			p.setString(3, mobile);
			p.setString(4, Rtype);
			p.setString(5, tickets);
			p.setString(6, ID);	
			
			p.setBlob(7, inputStream);
			int count = p.executeUpdate();
			
			RequestDispatcher rd = request.getRequestDispatcher("register3.html");
			rd.include(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
	}

}