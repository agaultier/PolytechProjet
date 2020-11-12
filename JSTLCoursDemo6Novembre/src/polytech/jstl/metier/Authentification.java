package polytech.jstl.metier;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class Authentification implements Serializable{

private boolean connexion;

public void access(HttpServletRequest request) {
	String login = request.getParameter("login");
	String pass = request.getParameter("pass");
	if (pass.equals((login+"321"))){
		this.connexion=true;
	}else {
		this.connexion=false;
	}
	}

public Authentification() {
	super();
}
public boolean isConnexion() {
	return connexion;
}

public void setConnexion(boolean connexion) {
	this.connexion = connexion;
}

@Override
public String toString() {
	return "Authentification [connexion=" + connexion + ", isConnexion()=" + isConnexion() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
}
