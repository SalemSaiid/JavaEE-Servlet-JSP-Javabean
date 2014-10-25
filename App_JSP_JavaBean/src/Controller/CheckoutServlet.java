package Controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CheckoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idUser =  req.getParameter("idUser");
		System.out.println(idUser);
		String commande =  req.getParameter("commande");
		System.out.println(commande);
		String totale =  req.getParameter("totale");
		System.out.println(totale);
		
		try {
			   
			Class.forName("com.mysql.jdbc.Driver");
			Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
		    PreparedStatement pr =  (PreparedStatement) cnx.prepareStatement(
					"insert into commande (id,idUser,commande,totale) values (default,?,?,?)"
					);
			
			   pr.setString(1,idUser);
			   pr.setString(2,commande );
			   pr.setString(3, totale);
			  
			  
			   
			   pr.executeUpdate();
			   pr.close();
				   
			   resp.sendRedirect("Home");   
			   
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
	}

}
