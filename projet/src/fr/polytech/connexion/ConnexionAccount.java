package fr.polytech.connexion;

import java.sql.Connection;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;


//ici je défini la couche métier de notre application

public class ConnexionAccount {
	//cette classe contient une seule méthode qui permet de récupérer la liste d'étudiants.
	
	private Connection connection;
	private boolean connexion = true;


	
	public void seConnecter() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //exception surveillée ...
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("le serveur n'est pas chargé");
		}
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/projet_musique?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
	

	
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public void createAccount (Account account) throws NoSuchAlgorithmException {
		this.seConnecter();
		//faille d'injection SQL
		try {
			PreparedStatement preparedStatement;
			preparedStatement = this.connection.prepareStatement("INSERT INTO `password`(`identifiant`, `password`) VALUES (?,?);");			
			
			
			String plaintext = account.getPassword();
			
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(plaintext.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			String hashtext = bigInt.toString(16);
			while(hashtext.length() < 32 ){
			  hashtext = "0"+hashtext;
			}
			preparedStatement.setString(1, account.getIdentifiant());
			preparedStatement.setString(2, hashtext);
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	

	
	
	public void deleteAccount (Account account) throws NoSuchAlgorithmException {
		this.seConnecter();
		
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM `password` WHERE identifiant = ? AND password = ?  ;");
			preparedStatement.setString(1,account.getIdentifiant());			

			String plaintext = account.getPassword();
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(plaintext.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			String hashtext = bigInt.toString(16);
			while(hashtext.length() < 32 ){
			  hashtext = "0"+hashtext;
			}
			preparedStatement.setString(2,hashtext);
			preparedStatement.executeUpdate();
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean connectAccount (HttpServletRequest request) throws NoSuchAlgorithmException {
		ResultSet resultSet = null;
		this.seConnecter();
		String passwordCompare = null;
		String id = request.getParameter("login");
		String plaintext = request.getParameter("pass");
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(plaintext.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		try {
			Statement statement =connection.createStatement();	
			resultSet = statement.executeQuery("SELECT * FROM `password`");
			while(resultSet.next()) {
				if(resultSet.getString("identifiant").equals(id)) {
					if(resultSet.getString("password").equals(hashtext)) {
						return true;
					}
				}
			}
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
				e.getStackTrace();
				
		}
		return false;
		}

public boolean isConnexion() {
	return true;
}
	
	
}
