package polytech.jstl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polytech.jstl.metier.Authentification;

/**
 * Servlet implementation class JstlDemo
 */
@WebServlet("/JstlDemo")
public class JstlDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JstlDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
				request.setAttribute("nom", nom);
		Etudiant e = new Etudiant(1, "Antoine", "Gaultier");
		request.setAttribute("etudiant", e);
		Etudiant e2 = new Etudiant(2, "Robin", "Martineau");
		request.setAttribute("etudiant2", e2);
;		this.getServletContext().getRequestDispatcher("/WEB-INF/jstlJSP.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String login = request.getParameter("login");
		request.setAttribute("login", login);
		String pass = request.getParameter("pass");
		request.setAttribute("pass", pass);
		*/
		Authentification authentification = new Authentification();
		authentification.access(request);
		request.setAttribute("authenfitication", authentification);
		
		doGet(request, response);
		
		
	}
	

}
