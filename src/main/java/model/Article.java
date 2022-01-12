package model;

import java.sql.Date;

public class Article {

	//attributs
	private int idArticle;
	private Date date;
	private String titre, resume, auteur, contenu, image;
	private boolean isVisible;
	
	//constructor
	public Article(int idArticle, Date date, String titre, String auteur, String resume, String contenu,
			String image, boolean isVisible) {
		super();
		this.idArticle = idArticle;
		this.date = date;
		this.titre = titre;
		this.auteur = auteur;
		this.resume = resume;
		this.contenu = contenu;
		this.image = image;
		this.isVisible = isVisible;
	}
	public Article(int idArticle, Date date, String titre, String auteur, String resume, String contenu,
			String image) {
		super();
		this.idArticle = idArticle;
		this.date = date;
		this.titre = titre;
		this.auteur = auteur;
		this.resume = resume;
		this.contenu = contenu;
		this.image = image;
	}
	public Article(Date date, String titre, String auteur, String resume, String contenu, String image) {
		this.date = date;
		this.titre = titre;
		this.auteur = auteur;
		this.resume = resume;
		this.contenu = contenu;
		this.image = image;
	}
	
	//getter
	public int getIdArticle() {
		return idArticle;
	}
	public Date getDate() {
		return date;
	}
	public String getTitre() {
		return titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public String getResume() {
		return resume;
	}
	public String getContenu() {
		return contenu;
	}
	public String getImage() {
		return image;
	}
	public boolean isVisible() {
		return isVisible;
	}
	
}
