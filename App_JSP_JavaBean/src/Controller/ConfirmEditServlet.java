package Controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConfirmEditServlet extends HttpServlet{

	
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
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String firstname = req.getParameter("first_name");
		String lastname = req.getParameter("last_name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String role = req.getParameter("role");
		String photo = req.getParameter("photo");
		
		try {
			
		       Class.forName("com.mysql.jdbc.Driver");
			   Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
            String sql = "UPDATE utilisateur SET username=?, first_name=?, last_name=?, password=?, email=?, role=?, photo=?" +
        " WHERE id=?";
        PreparedStatement ps = (PreparedStatement) cnx .prepareStatement(sql);
        ps.setString(1, username );
        ps.setString(2, firstname );            
        ps.setString(3, lastname);
        ps.setString(4, password);
        ps.setString(5, email);
        ps.setString(6, role);
        ps.setString(7, photo);
        ps.setString(8, id);
        ps.executeUpdate();            

    } catch (Exception e) {
        e.printStackTrace();
    }
		req.getRequestDispatcher("listUtilisateur.jsp").forward(req, resp);
	}
	
}
