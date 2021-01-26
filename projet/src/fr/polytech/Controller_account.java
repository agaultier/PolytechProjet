package fr.polytech;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.polytech.connexion.Account;
import fr.polytech.connexion.ConnexionAccount;

/**
 * Servlet implementation class Controller_account
 */
@WebServlet("/Controller_account")
public class Controller_account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				if(request.getParameter("login")!=null) {
					HttpSession session = request.getSession(true);
				
		        // Recuperer les identifiants et les stocker dans la variable de session
		        String Pseudonyme = request.getParameter("login");
		        session.setAttribute(Pseudonyme, "login");
		        ConnexionAccount connexionAccount= new ConnexionAccount();		
		        
		        //Utilisation et redirectiondes identifiants dans l'autre Servlet
		        try {
					if(connexionAccount.connectAccount(request)) {
					getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
					}else{
					    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
					    }
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getParameter("idCreate")!=null){
			Account account = new Account();
		
			account.setIdentifiant(request.getParameter("idCreate"));
			account.setPassword(request.getParameter("passwordCreate"));
		ConnexionAccount newAccount= new ConnexionAccount();
			try {
				newAccount.createAccount(account);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		if (request.getParameter("idSuppr")!=null){
			Account account = new Account();
		
			account.setIdentifiant(request.getParameter("idSuppr"));
			account.setPassword(request.getParameter("passwordSuppr"));
		ConnexionAccount DelAccount= new ConnexionAccount();
		try {
			DelAccount.deleteAccount(account);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		}
		
		
		doGet(request, response);
	}

}
