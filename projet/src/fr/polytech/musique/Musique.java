package fr.polytech.musique;

public class Musique {
	private int Identifiant;
	private String Artiste;
	private String Genre;
	private int Annee;
	public Musique(String Genre, String Artiste,int Annee, int Identifiant) {
		this.Identifiant = Identifiant;
		this.Annee = Annee;
		this.Genre = Genre;
		this.Artiste = Artiste;
	}
	public Musique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAnnee() {
		return Annee;
	}
	public int getIdentifiant() {
		return Identifiant;
	}
	public void setIdentifiant(int identifiant) {
		Identifiant = identifiant;
	}
	public String getArtiste() {
		return Artiste;
	}
	public void setArtiste(String artiste) {
		Artiste = artiste;
	}
	public void setAnnee(int annee) {
		Annee = annee;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}

	
}