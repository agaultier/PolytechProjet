package fr.polytech.connexion;

public class Account {
	private String identifiant;
	private String password;
	public Account(String identifiant, String password) {
		this.identifiant = identifiant;
		this.password = password;
	}
	//@Override
	//public String toString() {
	//	return "Etudiant [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + "]";
	//}
	public String getIdentifiant() {
		return identifiant;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
