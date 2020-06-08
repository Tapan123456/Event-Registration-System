import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Displayimg")
public class Displayimg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Displayimg() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletOutputStream out = response.getOutputStream();
		response.setContentType("text/html");
		
		String reg_id = request.getParameter("id");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Event", "vishal", "Dhvs@12345");
			String query = "select photo from event where reg_id=?";
			PreparedStatement p = c.prepareStatement(query);
			p.setString(1, reg_id);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				Blob blob = rs.getBlob("photo");
		        byte byteArray[] = blob.getBytes(1, (int)blob.length());
		 
		        response.setContentType("image/gif");
		        ServletOutputStream os = response.getOutputStream();
		        os.write(byteArray);
		        os.flush();
		        os.close();
			}
			
		}catch(NullPointerException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
