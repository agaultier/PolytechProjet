package fr.polytech;

public class Etudiant {
	private int numero;
	private String nom;
	private String prenom;
	public Etudiant(int numero, String nom, String prenom) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
	}
	//@Override
	//public String toString() {
	//	return "Etudiant [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + "]";
	//}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
