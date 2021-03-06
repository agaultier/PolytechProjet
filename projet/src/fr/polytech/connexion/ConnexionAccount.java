package fr.polytech.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;


//ici je d�fini la couche m�tier de notre application

public class ConnexionAccount {
	//cette classe contient une seule m�thode qui permet de r�cup�rer la liste d'�tudiants.
	
	private Connection connection;
	private boolean connexion = true;


	
	public void seConnecter() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //exception surveill�e ...
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("le serveur n'est pas charg�");
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
			//mettre a jour et executer la requ�te
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

	public boolean access(HttpServletRequest request) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		if (pass.equals((login))){
			return true;
		}else {
			return false;
		}
		}
	public boolean connectAccount (HttpServletRequest request) {
		ResultSet resultSet = null;
		this.seConnecter();
		String passwordCompare = null;
		String id = request.getParameter("login");
		String pass = request.getParameter("pass");
		try {
			Statement statement =connection.createStatement();	
			resultSet = statement.executeQuery("SELECT * FROM `password`");
			while(resultSet.next()) {
				if(resultSet.getString("identifiant").equals(id)) {
					if(resultSet.getString("password").equals(pass)) {
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
