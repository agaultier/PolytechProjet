package fr.polytech.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//ici je défini la couche métier de notre application

public class ConnexionAccount {
	//cette classe contient une seule méthode qui permet de récupérer la liste d'étudiants.
	
	private Connection connection;
	
	
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
	public void createAccount (Account account) {
		this.seConnecter();
		//faille d'injection SQL
		try {
			PreparedStatement preparedStatement =this.connection.prepareStatement("INSERT INTO `password`(`identifiant`, `password`) VALUES (?,?);");
			preparedStatement.setString(1, account.getIdentifiant());
			preparedStatement.setString(2, account.getPassword());
			//mettre a jour et executer la requête
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	public void modifyAccount (Account account) {
		this.seConnecter();
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("UPDATE `password` SET `password`=? WHERE identifiant=? ;");
			preparedStatement.setString(2, account.getIdentifiant());
			preparedStatement.setString(1, account.getPassword());
			preparedStatement.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public void supprimerUnEtudiant (Account account) {
		this.seConnecter();
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM `etudiant` WHERE identifiant = ? ;");
			preparedStatement.setString(1,account.getIdentifiant());			
			
			preparedStatement.executeUpdate();
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
}
