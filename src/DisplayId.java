import java.io.IOException;
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


@WebServlet("/DisplayId")
public class DisplayId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayId() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream out = response.getOutputStream();
		response.setContentType("text/html");
		
		String reg_id = request.getParameter("id");
		
		try {
				out.print("<!doctype html>\n" + 
		
				"<html lang='en' class='no-js'>\n" + 
				"<head>\n" + 
				"	<title>Event Admin</title>\n" + 
				"	<!-- Required meta tags -->\n" + 
				"	<meta charset='UTF-8'>\n" + 
				"	<meta name='viewport' content='width=device-width, initial-scale=1'>\n" + 
				"	<link rel='stylesheet' href='css/style.css'>\n" + 
				"	<!-- font used -->\n" + 
				"	<link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700' rel='stylesheet' type='text/css'>\n" + 
				"	<!-- CSS reset -->\n" + 
				"	<link rel='stylesheet' href='css1/reset.css'>\n" + 
				"	<!-- themify CSS -->\n" + 
				"    <link rel='stylesheet' href='assets1/themify-icons/themify-icons.css'>\n" + 
				"	<!-- Bootstrap CSS -->\n" + 
				"    <link rel='stylesheet' href='assets1/bootstrap/css/bootstrap.min.css'>\n" + 
				"\n" + 
				"		<script type='text/javascript' src='assets1/bootstrap/css/bootstrap.min.js'></script>	\n" + 
				"\n" + 
				"    <!-- fontawsesome CSS -->\n" + 
				"    <link rel='stylesheet' href='../../../use.fontawesome.com/releases/v5.0.10/css/all.css'>\n" + 
				"	<!-- dashboard style --> \n" + 
				"	<link rel='stylesheet' href='css/style.css'>\n" + 
				"      \n" + 
				"	<link rel='stylesheet' href='css1/style.css'>\n" + 
				"	<!-- dashboard responsive style --> \n" + 
				"	<link rel='stylesheet' href='css1/responsive.css'>\n" + 
				"	<!-- Modernizr js -->\n" + 
				"	<script src='../js1/modernizr.html'></script>\n" + 
				"\n" +
				"	<style>" +
				"		img{ box-shadow: 10px 10px 5px grey;" +
				"			 margin-top: 50px;" +
				"			 margin-left: 500px;" +
				"		   }" +
				"	</style>" +
				"</head>\n" + 
				"<body>\n" +
				"<!-- ===================================\n" + 
				"	 header \n" + 
				"	 ===================================-->\n" + 
				"	<header class='cd-main-header'>\n" + 
				"		<a href='#0' class='cd-logo'>\n" + 
				"			Event&nbspAdmin\n" + 
				"		</a>\n" + 
				"	</header>");
			
				out.print("<h3 style='margin-top: 100px; margin-left: 100px'>Details of "+reg_id+"</h3>");
				out.print("<img src='Displayimg?id="+reg_id+"' height='200' width='300'>");
				
				out.print("<div class='table table-hover'>");
				out.print("<table style='margin-left: 300px'>\n" + 
						"  		<tbody>\n");
				
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Event", "vishal", "Dhvs@12345");
					String query = "select reg_id, ful_name, email, mobile, Rtype, tickets, dt from event where reg_id=?";
					PreparedStatement p = c.prepareStatement(query);
					p.setString(1, reg_id);
					ResultSet rs = p.executeQuery();
					
					while(rs.next()) {
						out.print("<tr>\n" + 
								"						  <td><strong>Registration&nbspID:</strong></td>\n" + 
								"						  <td>"+rs.getString(1)+"</td>						\n" + 
								"						</tr>\n" + 
								"						<tr>\n" + 
								"						  <td><strong>Full Name:</strong></td>\n" + 
								"						  <td>"+rs.getString(2)+"</td>						\n" + 
								"						</tr>\n" + 
								"						<tr>\n" + 
								"						  <td><strong>Email&nbspID:</strong></td>\n" + 
								"						  <td>"+rs.getString(3)+"</td>						\n" + 
								"						</tr>\n" + 
								"						<tr>\n" + 
								"						  <td><strong>Mobile&nbspNumber:</strong></td>\n" + 
								"						  <td>"+rs.getString(4)+"</td>						\n" + 
								"						</tr>\n" + 
								"						<tr>\n" + 
								"						  <td><strong>Registration&nbspType:</strong></td>\n" + 
								"						  <td>"+rs.getString(5)+"</td>						\n" + 
								"						</tr>\n" + 
								"						<tr>\n" + 
								"						  <td><strong>No. of Ticket(s):</strong></td>\n" + 
								"						  <td>"+rs.getString(6)+"</td>						\n" + 
								"						</tr>\n" + 
								"						<tr>\n" + 
								"						  <td><strong>Registration&nbspDate&nbspTime:</strong></td>\n" + 
								"						  <td>"+rs.getString(7)+"</td>						\n" + 
								"						</tr>");
					}
					
					out.print("</tbody></table></div></body></html>");
					
					
				}catch(NullPointerException | ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			
	}

}
