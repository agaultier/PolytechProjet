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
		
		/*java.util.List<Etudiant> etudiants = new ArrayList <Etudiant>();
		etudiants.add(new Etudiant(1,"A","B"));
		etudiants.add(new Etudiant(1,"C","D"));
		etudiants.add(new Etudiant(1,"E","F"));
		etudiants.add(new Etudiant(1,"G","H"));
		*/
		//créer un objet de la classe métier
		//dans cette classe étudiant, on va avoir une méthode qui permet de renvoyer
		// une liste d'étudiants (on renvoit un objet métier)
		
		//request.setAttribute("etudiants", etudiants);
		
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
		if(request.getParameter("genre")!=null) {
			
		}
		
		
		doGet(request, response);
	}
	
}
