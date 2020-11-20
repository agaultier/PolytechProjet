package fr.polytech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//ici je défini la couche métier de notre application

public class Etudiants {
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
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cm13novembre?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
	

	public ArrayList<Etudiant> afficherTousLesEtudiants(){

		ArrayList<Etudiant> resultat = new ArrayList<Etudiant>();
		//chargement du driver my sql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //exception surveillée ...
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("le serveur n'est pas chargé");
		}
		
		//se connecter a la base de donnée
		this.seConnecter();
		Connection connection = null;
		Statement	statement=null;
		ResultSet resultSet = null;
		
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/cm13novembre?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			statement = connection.createStatement();
			//executer une requête et récupérer le contenu dans l'objet resultSet
			resultSet = statement.executeQuery("SELECT * FROM `etudiant`");
			
			//parcourir resultSet pour récuperer les données
			
			while(resultSet.next()) {
				int identifiant = resultSet.getInt("identifiant");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				resultat.add(new Etudiant(identifiant, nom, prenom));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		finally {
			if (connection != null) {try {
				connection.close();
				if(statement != null) {statement.close();}
				if(resultSet != null) {resultSet.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
		return resultat;
	}

	
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public void ajouterUnEtudiant (Etudiant etudiant) {
		this.seConnecter();
		//faille d'injection SQL
		try {
			PreparedStatement preparedStatement =this.connection.prepareStatement("INSERT INTO `etudiant`(`identifiant`, `nom`, `prenom`) VALUES (?,?,?);");
			preparedStatement.setInt(1, etudiant.getNumero());
			preparedStatement.setString(2, etudiant.getNom());
			preparedStatement.setString(3, etudiant.getPrenom());

			//mettre a jour et executer la requête
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	public void modifierUnEtudiant (Etudiant etudiant) {
		this.seConnecter();
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("UPDATE `etudiant` SET `nom`=?,`prenom`=? WHERE identifiant=? ;");
			preparedStatement.setString(1,etudiant.getNom());
			preparedStatement.setString(2,etudiant.getPrenom());
			preparedStatement.setInt(3,etudiant.getNumero());
			
			preparedStatement.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void supprimerUnEtudiant (Etudiant etudiant) {
		this.seConnecter();
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM `etudiant` WHERE identifiant = ? ;");
			preparedStatement.setInt(1,etudiant.getNumero());			
			
			preparedStatement.executeUpdate();
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void rechercheEtudiants(Etudiant etudiant) {
		try {
			PreparedStatement preparedStatement =this.connection.prepareStatement("SELECT * FROM `etudiant` WHERE nom LIKE ?% or prenom LIKE ?% or identifiant like ?");
			preparedStatement.setString(1,etudiant.getNom());
			preparedStatement.setString(2,etudiant.getPrenom());
			preparedStatement.setInt(3,etudiant.getNumero());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
