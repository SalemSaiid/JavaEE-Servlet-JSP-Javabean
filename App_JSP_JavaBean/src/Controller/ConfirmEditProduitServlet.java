package Controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConfirmEditProduitServlet extends HttpServlet{

	
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
		String nom = req.getParameter("nom");
		String description = req.getParameter("description");
		String prix = req.getParameter("prix");
		String image = req.getParameter("image");
		
		System.out.println(id);
		System.out.println(nom);
		System.out.println(description);
		System.out.println(prix);
		System.out.println(image);
		
		try {
			
		       Class.forName("com.mysql.jdbc.Driver");
			   Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jeegeti","root","");
            String sql = "UPDATE produit SET nom=?, description=?, prix=?, image=?" +
        " WHERE id=?";
        PreparedStatement ps = (PreparedStatement) cnx .prepareStatement(sql);
        ps.setString(1, nom );
        ps.setString(2, description );            
        ps.setString(3, prix);
        ps.setString(4, image);
        ps.setString(5, id);
       
        ps.executeUpdate();            

    } catch (Exception e) {
        e.printStackTrace();
    }
		req.getRequestDispatcher("listProduit.jsp").forward(req, resp);
	}
	
}
