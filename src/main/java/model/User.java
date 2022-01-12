package model;

public class User {
	
	//attributs
	//je n'integre pas l'email ni le mot de passe dans l'objet pour eviter de trop donner d'info
	private int idUser;
	private String nom, prenom;
	
	//constructeur
	public User(int idUser, String nom, String prenom) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
	}
	public User(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	//getter
	public int getIdUser() {
		return idUser;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
}
