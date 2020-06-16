import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login_admin")
public class Login_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int self_cnt=0, grp_cnt=0, corp_cnt=0, oth_cnt=0;
		String user = request.getParameter("l_user");
		String pass = request.getParameter("l_password");
		
		try {
			
			if(user.equals("info@eventreg.com") && pass.equals("pass")) 
			{
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
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
			
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Event", "vishal", "Dhvs@12345");
				String query = "select reg_id, ful_name, email, mobile, Rtype, tickets, dt from event";
				PreparedStatement p = c.prepareStatement(query);

				ResultSet rs = p.executeQuery();
				
				
				out.print("<section><div class='table table-hover'>\n" + 
						"			<h3 style='margin-top: 100px; margin-left: 100px'>List of all Registrations</h3>\n" + 
						"				<table>\n" + 
						"					 <thead>\n" + 
						"						<tr>\n" + 
						"						  <th>Registration&nbspID</th>\n" + 
						"						  <th>Full&nbspName</th>\n" + 
						"						  <th>Email</th>\n" + 
						"						  <th>Mobile</th>\n" + 
						"						  <th>Registration&nbspType</th>\n" + 
						"						  <th>No.&nbspof&nbspTicket(s)</th>\n" + 
						"						  <th>Registration&nbspDate&nbspand&nbspTime</th>\n" + 
						"						</tr>\n" + 
						"					 </thead>\n" + 
						"					 <tbody>");
				
				String type = "";
				while(rs.next())
				{
					
					out.println("<tr><td><a href='DisplayId?id="+rs.getString(1)+"'>"+rs.getString(1)+"</a></td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>");
					type = rs.getString(5);
					if(type.equals("Self"))
						self_cnt++;
					else if(type.equals("Group"))
						grp_cnt++;
					else if(type.equals("Corporate"))
						corp_cnt++;
					else
						oth_cnt++;
				}

				out.print("</tbody>\n" + 
						"				  </table>\n" + 
						"			</div>\n" + 
						"			<h3 style='margin-top: 50px; margin-left: 100px'>Registration Count</h3>"+
						"			<div id='chartContainer' style='height: 300px; width: 50%; margin-top: 50px; margin-left: 100px'></div>\n" + 
						"			<script src='https://canvasjs.com/assets/script/canvasjs.min.js'></script>\n" + 
						"			<script>\n" + 
						"				window.onload = function () {\n" + 
						"\n" + 
						"				var chart = new CanvasJS.Chart('chartContainer', {\n" + 
						"					animationEnabled: true,\n" + 
						"					theme: 'light1', // , 'light2', 'dark1', 'dark2'\n"+
						"					axisY: {\n" + 
						"						title: 'Count'\n" + 
						"					},\n" + 
						"					data: [{        \n" + 
						"						type: 'column',  \n" + 
						"						showInLegend: true, \n" + 
						"						legendMarkerColor: 'grey',\n" + 
						"						legendText: 'Type of Registration',\n" + 
						"						dataPoints: [      \n" + 
						"							{ y:"+self_cnt+", label: 'Self' },\n" + 
						"							{ y:"+grp_cnt+", label: 'Group' },\n" + 
						"							{ y:"+corp_cnt+", label: 'Corporate' },\n" + 
						"							{ y:"+oth_cnt+",  label: 'Others' },\n" + 
						"						]\n" + 
						"					}]\n" + 
						"				});\n" + 
						"				chart.render();\n" + 
						"\n" + 
						"				}\n" + 
						"</script>\n" + 
						"			</section>\n" + 
						"</body>\n" + 
						"</html>");
			}
			else {
				response.sendRedirect("error.html");
			}
		}catch(NullPointerException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}