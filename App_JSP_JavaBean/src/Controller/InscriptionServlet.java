package Controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InscriptionServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String username = req.getParameter("login");
		   String first_name = req.getParameter("firstname");
		   String last_name = req.getParameter("lastname");
		   String password = req.getParameter("pass");
		   String email = req.getParameter("email");
		   String photo = req.getParameter("photo");
		   String role = "user";
		   
		
		   
		   try {
			   
				Class.forName("com.mysql.jdbc.Driver");
				Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
			    PreparedStatement pr =  (PreparedStatement) cnx.prepareStatement(
						"insert into utilisateur (id,username,first_name,last_name,password,email,role,photo) values (default,?,?,?,?,?,?,?)"
						);
				
				   pr.setString(1,username);
				   pr.setString(2,first_name );
				   pr.setString(3, last_name);
				   pr.setString(4,password );
				   pr.setString(5,email );
				   pr.setString(6,role );
				   pr.setString(7,photo );
				   
				   pr.executeUpdate();
				   pr.close();
					   
				   resp.sendRedirect("listUtilisateur.jsp");   
				   
				   
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
	
	
}
