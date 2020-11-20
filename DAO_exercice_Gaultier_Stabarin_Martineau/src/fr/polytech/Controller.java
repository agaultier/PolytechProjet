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



/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
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
		
		Etudiants etudiantsListe = new Etudiants();
		ArrayList<Etudiant> ets = etudiantsListe.afficherTousLesEtudiants();
		request.setAttribute("resultat", ets);
		
		ArrayList<Etudiant> ll= new ArrayList<>();
		ll.add(new Etudiant(1,"afr","b"));
		ll.add(new Etudiant(2,"Cee","D"));
		request.setAttribute("ll", ll);

		if (request.getParameter("nomRecherche")!=null || request.getParameter("prenomRecherche")!=null || request.getParameter("idRecherche")!=null) {
			Etudiant etudiant = new Etudiant();
			etudiant.setNom(request.getParameter("nomRecherche"));
			etudiant.setPrenom(request.getParameter("prenomRecherche"));
			etudiant.setNumero(Integer.parseInt(request.getParameter("idRecherche")));
			
			
			Etudiants etudiants = new Etudiants();
			etudiants.rechercheEtudiants(etudiant);
			}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/dao.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//on définit un objet de la classe métier ... on fait appel a la méthode ajouterUnEtudiant 
		
		if (request.getParameter("nom")!=null){
			Etudiant etudiant = new Etudiant();
		
		etudiant.setNom(request.getParameter("nom"));
		etudiant.setPrenom(request.getParameter("prenom"));
		etudiant.setNumero(Integer.parseInt(request.getParameter("id")));
		
		Etudiants etudiants = new Etudiants();
		etudiants.ajouterUnEtudiant(etudiant);
		
		}
		
		if (request.getParameter("nomModif")!=null) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom(request.getParameter("nomModif"));
		etudiant.setPrenom(request.getParameter("prenomModif"));
		etudiant.setNumero(Integer.parseInt(request.getParameter("idModif")));
		
		
		Etudiants etudiants = new Etudiants();
		etudiants.modifierUnEtudiant(etudiant);
		}
		
		if (request.getParameter("idSuppr")!=null) {
			Etudiant etudiant = new Etudiant();
			etudiant.setNumero(Integer.parseInt(request.getParameter("idSuppr")));
			
			Etudiants etudiants  = new Etudiants();
			etudiants.supprimerUnEtudiant(etudiant);
		}
		
		
		doGet(request, response);
	}
	
}
