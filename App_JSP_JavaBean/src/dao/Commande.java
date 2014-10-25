package dao;

public class Commande {
	
	private int id,idUser;
	private String commande;
	private float totale;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(int idUser, String commande, float totale) {
		super();
		this.idUser = idUser;
		this.commande = commande;
		this.totale = totale;
	}
	public String getCommande() {
		return commande;
	}
	public void setCommande(String commande) {
		this.commande = commande;
	}
	public float getTotale() {
		return totale;
	}
	public void setTotale(float totale) {
		this.totale = totale;
	}

}
