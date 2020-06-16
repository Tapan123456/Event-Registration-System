import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
		
		PrintWriter out = response.getWriter();
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
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Event", "vishal", "Dhvs@12345");
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
			System.out.println(count);
			if(count != 0)
			{
				out.print("<!doctype html>\n" + 
						"<html lang=\"en\">\n" + 
						"   <head>\n" + 
						"      <title>Event Registration</title>\n" + 
						"      <!-- Required meta tags -->\n" + 
						"\n" + 
						"		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" + 
						"		<link href=\"http://www.jqueryscript.net/css/jquerysctipttop.css\" rel=\"stylesheet\" type=\"text/css\">\n" + 
						"\n" + 
						"      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" + 
						"      <!-- Bootstrap CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\n" + 
						"      <!-- themify CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/themify-icons/themify-icons.css\">\n" + 
						"      <!-- fontawesome CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/font-awesome/css/font-awesome.min.css\">\n" + 
						"      <!-- ionicons CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/ionicons/css/ionicons.min.css\">\n" + 
						"      <!-- Lity CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/lity/lity.min.css\">\n" + 
						"      <!-- Lity CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/sweetalert/sweetalert.css\">\n" + 
						"      <!-- owlcarousal CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/owl-carousal/owl.carousel.min.css\">\n" + 
						"      <!-- tab CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/tab/bootstrap-responsive-tabs.css\">\n" + 
						"      <!-- animate CSS -->\n" + 
						"      <link rel=\"stylesheebt\" href=\"assets/animate/animate.css\">\n" + 
						"      <!-- swiper CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/swiper/swiper.min.css\">\n" + 
						"      <!-- aos CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"assets/aos/aos.css\">\n" + 
						"      <!-- style CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"css/style.css\">\n" + 
						"      <!-- media CSS -->\n" + 
						"      <link rel=\"stylesheet\" href=\"css/media.css\">\n" + 
						"      <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" + 
						"      <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" + 
						"      <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" + 
						"\n" + 
						"      <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n" + 
						"      \n" + 
						"	  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n" + 
						"	  <script src=\"assert1/bootstrap/bootstrap.min.js\"></script>\n" + 
						"      \n" + 
						"	  <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js\"></script>\n" + 
						"	  <link rel=\"stylesheet\" type=\"text/css\" href=\"previewForm/previewForm.css\" />\n" + 
						"	  <script src=\"previewForm/previewForm.js\"></script>\n" + 
						"      <script>\n" + 
						"         $(document).ready(function(){\n" + 
						"         //when the select changes:\n" + 
						"            \n" + 
						"            $('#u_country').on(\"change\", function(){\n" + 
						"               //set the value of the input to the value of the select.\n" + 
						"                     \n" + 
						"                  var mytext = $('#u_country :selected').text();\n" + 
						"                  if( mytext == \"Self\" ){\n" + 
						"                        $(\"#u_tickets\").val(\"1\");\n" + 
						"                  }\n" + 
						"            });\n" + 
						"      \n" + 
						"            function readURL(input) {\n" + 
						"               if (input.files && input.files[0]) {\n" + 
						"                  var reader = new FileReader();\n" + 
						"                  \n" + 
						"                  reader.onload = function(e) {\n" + 
						"                     $('#img').attr('src', e.target.result);\n" + 
						"                  }\n" + 
						"                  \n" + 
						"                  reader.readAsDataURL(input.files[0]); // convert to base64 string\n" + 
						"               }\n" + 
						"               }\n" + 
						"\n" + 
						"            $(\"#u_myfile\").change(function() {\n" + 
						"            readURL(this);\n" + 
						"            });\n" + 
						"\n" + 
						"         });\n" + 
						"         \n" + 
						"         document.getElementById(\"name1\").value=document.getElementById(\"u_name\").value;\n" + 
						"         function previewModel(){\n" + 
						"            document.getElementById(\"name1\").innerHTML=document.getElementById(\"u_name\").value;\n" + 
						"            document.getElementById(\"email1\").innerHTML=document.getElementById(\"u_mail\").value;\n" + 
						"            document.getElementById(\"mobile1\").innerHTML=document.getElementById(\"u_mob\").value;\n" + 
						"            document.getElementById(\"type\").innerHTML=document.getElementById(\"u_country\").value;\n" + 
						"            document.getElementById(\"tickets1\").innerHTML=document.getElementById(\"u_tickets\").value;\n" + 
						"         }  \n" + 
						"      </script>\n" + 
						"\n" + 
						"   </head>\n" + 
						"   <body>\n" +
						"   <strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + 
						" Registration Successfull!!! &nbsp&nbsp&nbspYour Registration ID is: "+ ID + "</strong>" +
						"<nav class=\"navbar navbar-expand-lg navbar-light blank-menu white-text-menu\">\n" + 
						"         <div class=\"container\">\n" + 
						"            <a class=\"navbar-brand\" href=\"Welcome.html\">\n" + 
						"               <div class=\"logo-brand md-logo\">\n" + 
						"                  <h3>Event&nbspRegistration.</h3>\n" + 
						"               </div>\n" + 
						"            </a><!-- end of navbar-brand -->\n" + 
						"            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" + 
						"            <span class=\"navbar-toggler-icon\"></span>\n" + 
						"            </button><!-- end of navbar-toggler -->\n" + 
						"            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" + 
						"               <div class=\"navbar-right\">\n" + 
						"                  <ul class=\"navbar-nav my-2 my-lg-0\">\n" + 
						"\n" + 
						"                    <li class=\"nav-item active\">\n" + 
						"                        <a class=\"nav-link\" href=\"Welcome.html\">Home </a>\n" + 
						"                     </li><!-- end of nav-item -->\n" + 
						"                     \n" + 
						"                     <li class=\"nav-item active\">\n" + 
						"                        <a class=\"nav-link \" href=\"about.html\" >About Us </a>\n" + 
						"                      </li><!-- end of nav-item -->\n" + 
						"                  \n" + 
						"                     <li class=\"nav-item active\">\n" + 
						"                        <a class=\"nav-link \" href=\"register3.html\" >Register </a>\n" + 
						"                     </li><!-- end of nav-item -->\n" + 
						"                     \n" + 
						"                  </ul><!-- end of navbar-nav -->\n" + 
						"               </div><!-- end of navbar-right -->\n" + 
						"            </div><!-- end of collapse -->\n" + 
						"         </div><!-- end of container -->\n" + 
						"         </div><!-- end of container -->\n" + 
						"      </nav><!-- end of nav -->\n" + 
						"      <section class=\"overview flush-bottom\">\n" + 
						"       <div class=\"main-container seo-slider-main-wrapper saas-slider-main-wrapper gradient-banner aos-box\">\n" + 
						"         <div class=\"first-slide slider-banner-inner parallex-banner-inner d-flex\" data-stellar-background-ratio=\"0.3\">\n" + 
						"            <div class=\"inner-carousal-1 text-left\">\n" + 
						"               <div class=\"containet\">\n" + 
						"                  <div class=\"row\">\n" + 
						"                    <div class=\"gradient-inner\">\n" + 
						"                        <div class=\"agency-entry-content text-center\">\n" + 
						"         <div class=\"container\">\n" + 
						"            <div class=\"seo-form-wrapper\">\n" + 
						"               <div class=\"intro text-center\">\n" + 
						"                  <h3>Register here.</h3>\n" + 
						"               </div>\n" + 
						"               <div class=\"saas-form-contact\">\n" + 
						"               <form class=\"mform\" class=\"myform\" action=\"register\" method=\"post\" enctype=\"multipart/form-data\">\n" + 
						"                  	<div class=\"clearfix\">\n" + 
						"                     	<div class=\"form-control sub-input-contact\">\n" + 
						"                     	<input type=\"text\" id=\"u_name\" name=\"f_name\" placeholder=\"Your Full Name\" pattern=\"[A-Za-z ]+\" autofocus required\n" + 
						"                        oninvalid=\"this.setCustomValidity('Only Text Allowed here')\"\n" + 
						"                        oninput=\"this.setCustomValidity('')\" />\n" + 
						"                     	</div>\n" + 
						"                  	</div>\n" + 
						"							<div class=\"clearfix\">\n" + 
						"                     	<div class=\"form-control sub-input-contact\">\n" + 
						"                     	<input type=\"email\" id=\"u_mail\" name=\"email\" placeholder=\"Enter Your Email\" required>\n" + 
						"                     	</div>\n" + 
						"                  	</div>\n" + 
						"                  	<div class=\"clearfix\">\n" + 
						"                     	<div class=\"form-control\">\n" + 
						"                     	<input type=\"text\" id=\"u_mob\" name=\"mob\" placeholder=\"Enter Your Mobile\" pattern=\"[0-9]{10}\" title=\"Only numbers Allowed\" required>\n" + 
						"                     	</div>\n" + 
						"                     	<div class=\"form-control\">\n" + 
						"                     	<select name=\"Rtype\" id=\"u_country\" required>\n" + 
						"									<option value=\"\" selected=\"selected\">Registration Type</option>\n" + 
						"									<option value=\"Self\">Self</option>\n" + 
						"									<option value=\"Group\">Group</option>\n" + 
						"									<option value=\"Corporate\">Corporate</option>\n" + 
						"									<option value=\"Other\">Other</option>									\n" + 
						"									</select>\n" + 
						"                     	</div>\n" + 
						"                  	</div>\n" + 
						"                  	\n" + 
						"                  <div class=\"clearfix\">\n" + 
						"                     <div class=\"form-control sub-input-contact\">\n" + 
						"                     <input type=\"text\" id=\"u_tickets\" name=\"tickets\" placeholder=\"Enter No. of Ticket(s)\" pattern=\"[0-9]+\" required>\n" + 
						"                     </div>\n" + 
						"					      <div> <img src=\"#\" alt=\"Preview Image\" id=\"img\"> </div>\n" + 
						"					      <div class=\"form-control sub-input-contact input_upload\">\n" + 
						"						      <input type=\"file\" id=\"u_myfile\" name=\"myfile\" required>\n" + 
						"					      </div>\n" + 
						"                  </div>\n" + 
						"                  <div class=\"text-center\">\n" + 
						"                	   <button class=\"btn seo-start-btn\" id=\"submit\" type=\"submit\">Submit</button>\n" + 
						"                      <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModal\" onclick=\"previewModel()\">\n" + 
						"                        Preview\n" + 
						"                      </button>\n" + 
						"                      \n" + 
						"                      <!-- Modal -->\n" + 
						"                      <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" + 
						"                        <div class=\"modal-dialog\" role=\"document\">\n" + 
						"                          <div class=\"modal-content\">\n" + 
						"                            <div class=\"modal-header\">\n" + 
						"                              <h5 class=\"modal-title\" id=\"exampleModalLabel\">Please Check Your Details Here</h5>\n" + 
						"                              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" + 
						"                                <span aria-hidden=\"true\">&times;</span>\n" + 
						"                              </button>\n" + 
						"                            </div>\n" + 
						"                            <div class=\"modal-body\">\n" + 
						"                              <b>Name : </b></label><label id=name1></label><br>\n" + 
						"                              <b>Email : </b><label id=email1></label><br>\n" + 
						"                              <b>Mobile No : </b><label id=mobile1></label><br>\n" + 
						"                              <b>Registration Type : </b><label id=type></label><br>\n" + 
						"                              <b>No of Tickets : </b><label id=tickets1></label><br>\n" + 
						"                            </div>\n" + 
						"                            <div class=\"modal-footer\">\n" + 
						"                              <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n" + 
						"                            </div>\n" + 
						"                          </div>\n" + 
						"                        </div>\n" + 
						"                      </div>\n" + 
						"                	</div>\n" + 
						"                  </form>\n" + 
						"                  </div>\n" + 
						"                  </div>\n" + 
						"                  </div>\n" + 
						"                  </div>\n" + 
						"                  </div>\n" + 
						"                  </div>\n" + 
						"                  </div>\n" + 
						"               </div><!-- end of saas-form-contact -->\n" + 
						"            </div><!-- end of seo-form-wrapper -->\n" + 
						"         </div><!-- end of container -->\n" + 
						"      </section><!-- end of saas-contact-main -->\n" + 
						"      <!-- =====================================\n" + 
						"         contact address\n" + 
						"         =====================================-->\n" + 
						"      <section class=\"feature-sec saas-contact-wrapper seo-contact-wrapper\">\n" + 
						"      \n" + 
						"         <div class=\"container\">\n" + 
						"            <div class=\"feature-type-5-inner\">\n" + 
						"               <ul class=\"clearfix\">\n" + 
						"                  <li class=\"card\">\n" + 
						"                     <div class=\"featutes-type-1 card-body clearfix\">\n" + 
						"                        <div class=\"feature-img\">\n" + 
						"                           <img src=\"images/seo-place.png\" alt=\"\" class=\"img-fluid\">\n" + 
						"                        </div>\n" + 
						"                        <div class=\"feature-desc\">\n" + 
						"                           <h5>Pune, Maharashtra</h5>\n" + 
						"                           <p>Tapan Mehta</p>\n" + 
						"                           <p>Vishal Parandwal</p>\n" + 
						"                        </div>\n" + 
						"                     </div>\n" + 
						"                  </li>\n" + 
						"                  <li class=\"card\">\n" + 
						"                     <div class=\"featutes-type-1 card-body clearfix\">\n" + 
						"                        <div class=\"feature-img\">\n" + 
						"                           <img src=\"images/email.png\" alt=\"\" class=\"img-fluid\">\n" + 
						"                        </div>\n" + 
						"                        <div class=\"feature-desc\">\n" + 
						"                           <h6>Tapanmanishmehta@gmail.com</h6>\n" + 
						"						   <h6>vparandwal042@gmail.com</h6>\n" + 
						"                        </div>\n" + 
						"                     </div>\n" + 
						"                  </li>\n" + 
						"                  <li class=\"card\">\n" + 
						"                     <div class=\"featutes-type-1 card-body clearfix\">\n" + 
						"                        <div class=\"feature-img\">\n" + 
						"                           <img src=\"images/telephone.png\" alt=\"\" class=\"img-fluid\">\n" + 
						"                        </div>\n" + 
						"                        <div class=\"feature-desc\">\n" + 
						"                           <h5>+91 82378 14313</h5>\n" + 
						"                           <p>Tapan Mehta</p>\n" + 
						"                           <h5>+91 7083080734</h5>\n" + 
						"                           <p>Vishal Parandwal</p>\n" + 
						"                        </div>\n" + 
						"                     </div>\n" + 
						"                  </li>\n" + 
						"               </ul>\n" + 
						"            </div><!-- end of feature-type-5-inner -->\n" + 
						"         </div><!-- end of container -->\n" + 
						"         </section>\n" + 
						"   </body>\n" + 
						"</html>\n" + 
						"");
				
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("errorpass.html");
				rd.include(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
	}

}