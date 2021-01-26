package fr.polytech;
/*
 * dernier cours
 */

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.DataBase.Data_Musique;
import fr.polytech.musique.Musique;



/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller_musique extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_musique() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		Data_Musique musiquesListe = new Data_Musique();
		ArrayList<Musique> ets = musiquesListe.afficherToutesLesMusiques();
		request.setAttribute("resultat", ets);
		this.getServletContext().getRequestDispatcher("/recherche.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//on définit un objet de la classe métier ... on fait appel a la méthode ajouterUnEtudiant 
	
		if (request.getParameter("genre")!=null){
			Musique musique = new Musique();
			musique.setAnnee(Integer.parseInt(request.getParameter("annee")));
			musique.setArtiste(request.getParameter("artiste"));
			musique.setGenre(request.getParameter("genre"));
			musique.setIdentifiant(Integer.parseInt(request.getParameter("id")));
		
		
		Data_Musique musiquesListe = new Data_Musique();
		musiquesListe.ajouterUneMusique(musique);
		}
		if (request.getParameter("idSuppr")!=null) {
			Musique musique = new Musique();
			musique.setIdentifiant(Integer.parseInt(request.getParameter("idSuppr")));
			
			Data_Musique musiquesListe = new Data_Musique();
			musiquesListe.supprimerUneMusique(musique);
		}
		
		if (request.getParameter("artisteModif")!=null) {
			Musique musique = new Musique();
			musique.setAnnee(Integer.parseInt(request.getParameter("anneeModif")));
			musique.setArtiste(request.getParameter("artisteModif"));
			musique.setGenre(request.getParameter("genreModif"));
			musique.setIdentifiant(Integer.parseInt(request.getParameter("idModif")));
		
		
			
			Data_Musique musiquesListe = new Data_Musique();
			musiquesListe.modifierUneMusique(musique);
			}
			
		
		doGet(request, response);
	}
	
}
