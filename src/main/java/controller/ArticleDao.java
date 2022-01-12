package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Article;

public class ArticleDao {

	private Connection connect = GetConnection.getConnectionWindows();
	
	public boolean creerArticle(String titre, int auteur, String contenu, String resume, String image) {
		
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO `article` (`id_article`,"+
					"`titre`, `id_utilisateur`, `date`, `contenu`, `resume`, `image`, `isVisible`)"+
					"VALUES (NULL, ?, ?, NOW(), ?, ?, ?, '1') ");
			//titre
			sql.setString(1, titre);
			//utilisateur
			sql.setInt(2, auteur);
			//contenu
			sql.setString(3, contenu);
			//resume - null
			sql.setString(4, resume);
			//image - null
			sql.setString(5, image);
			
			sql.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public ArrayList<Article> listArticle() {
		ArrayList<Article> listArticle = new ArrayList<Article>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM article");
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				if(rs.getBoolean("isVisible") == true) {
					listArticle.add(new Article(rs.getInt("id_article"), rs.getDate("date"),
						rs.getString("titre"), idArticleToAuteur(rs.getInt("id_utilisateur")), rs.getString("resume"),
						rs.getString("contenu"), rs.getString("image"), rs.getBoolean("isVisible")));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listArticle;
	}
	
	public Article findById(int idArt) {
		Article art = null;
		
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM article WHERE id_article = ?");
			sql.setInt(1, idArt);
			
			ResultSet rs = sql.executeQuery();
			/*
			 * Date date, String titre, String auteur, String resume, String contenu, String image
			 */
			while(rs.next()) {
				art = new Article(rs.getInt("id_article"), rs.getDate("date"), rs.getString("titre"), idArticleToAuteur(rs.getInt("id_utilisateur")),
					rs.getString("resume"), rs.getString("contenu"), rs.getString("image"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}
	
	private String idArticleToAuteur(int idUser) {
		String nom = null;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT nom FROM utilisateur WHERE id_user = ?");
			sql.setInt(1, idUser);
			
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				nom = rs.getString("nom");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nom;
	}
	
	public boolean compareIdUserWithIdArticle(int idUser, int idArt) {
		ArrayList<Integer> listIdArticle = new ArrayList<Integer>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT id_article FROM article WHERE id_utilisateur = ?");
			sql.setInt(1, idUser);
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				listIdArticle.add(rs.getInt("id_article"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < listIdArticle.size(); i++) {
			if(idArt == listIdArticle.get(i)) {
				return true;
			}
		}
		return false;
	}
	
	public void updateArticle(String titre, String contenu, String resume, String urlImage, int idArt) {
		try {
			PreparedStatement sql = connect.prepareStatement("UPDATE `article` SET `titre` = ?,"+
				" `contenu` = ?, `resume` = ?, `image` = ? WHERE `article`.`id_article` = ? ");
			sql.setString(1, titre);
			sql.setString(2, contenu);
			sql.setString(3, resume);
			sql.setString(4, urlImage);
			sql.setInt(5, idArt);
			
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int idArt) {
		try {
			PreparedStatement sql = connect.prepareStatement("UPDATE `article` SET `isVisible` = 0 WHERE id_article = ?");
			sql.setInt(1, idArt);
			
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
