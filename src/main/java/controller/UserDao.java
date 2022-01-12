package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.mysql.cj.protocol.Message;

import model.User;

public class UserDao {
	
	private Connection connect = GetConnection.getConnectionWindows();
	
	public boolean ajouterUser(User user, String email, String pwd) {
		
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO `utilisateur` (`id_user`,"
				+"`nom`, `prenom`, `email`, `password`) VALUES (NULL, ?, ?, ?, ?) ");
			sql.setString(1, user.getNom());
			sql.setString(2, user.getPrenom());
			if(!verifEmail(email)) {
				sql.setString(3, email);
			}else {
				return false;
			}

			try {
				sql.setString(4, encode(pwd));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sql.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public User checkLogin(String email, String password) {
		boolean verifEmail = false;
		boolean verifPwd = false;
		User user = null;

		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND password = ?");
			req.setString(1, email);
			try {
				req.setString(2, encode(password));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ResultSet result = req.executeQuery();
			//pour plus de securiter, je ne met pas l'email et le mot de passe du client
			while(result.next()) {
				user = new User(result.getInt("id_user"), result.getString("nom"), result.getString("prenom"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	private boolean verifEmail(String mail) {
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("SELECT COUNT(email) as countE FROM utilisateur WHERE email = ?");
			sql.setString(1, mail);
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("countE") == 1) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//crypto moneydepasse
	public static String encode(String value) throws NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
		return encoded;
	}
	
}//fin de classe
