package dao;

import java.awt.image.BufferedImage;

public class Utilisateur {
	
	private Long id;
	private String username,first_name,last_name,password,email,role,photo;
	
	
	
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	BufferedImage buffimg;

	public BufferedImage getBuffimg() {
		return buffimg;
	}

	public void setBuffimg(BufferedImage buffimg) {
		this.buffimg = buffimg;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utilisateur(Long id2, String username2, String password2, String role2, String photo2 ) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.username = username2;
		this.password = password2;
		this.role = role2;
		this.photo = photo2;
	}

	public Utilisateur() {
		
	}

	public String getPassword() {
		return password;
	}

	public void setId(long i) {
		this.id = i;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
