package fr.polytech;

import java.io.IOException;
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
				HttpSession session = request.getSession(true);
		        // Recuperer les identifiants et les stocker dans la variable de session
		        String Pseudonyme = request.getParameter("login");
		        
		        ConnexionAccount connexionAccount= new ConnexionAccount();		
		        session.setAttribute(Pseudonyme, connexionAccount.connectAccount(request));
		  
		        
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
		newAccount.createAccount(account);
		
		}
		
		
		doGet(request, response);
	}

}
