<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <% 
String Pseudonyme = request.getParameter("login");    
session.getAttribute("login");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Musique !</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/full-width-pics.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">En avant la musique</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">Connexion
              <span class="sr-only">(current)</span>
            </a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>

  <!-- Header - set the background image for the header in the line below -->
  <header class="py-5 bg-image-full" style="background-image: url('https://images.unsplash.com/photo-1510279410431-2d0808d69bf8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80');">
    <img class="img-fluid d-block mx-auto" src="https://images.unsplash.com/photo-1510279410431-2d0808d69bf8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80" alt="" width = 30%  >
  </header>

  <!-- Content section -->
  <section class="py-5">
    <div class="container">
      <h1>Musique maestro !</h1>
      <p class="lead">Bienvenu à tous, voici le début de notre page.
      </p>
      <p>Comme vous pouvez le voir, le thème principal est la musique. Cette page a été faite pour vous transmettre notre passion pour la musique et vous faire découvrir des groupes peu connus.</p>
 <p>Veuillez vous connecter : <%=Pseudonyme%></p>

 <form method="GET" name="Form" action="accueil"
              style="width:50%;margin:auto;background-color:whitesmoke;padding-bottom:15px;">
    
  <h2 style="text-align:center;color:black;background-color:wheat;">Formulaire HTML</h2>
  <p style="text-align:center;">Pseudonyme : <input type="text" name="login"  /></p>
  <p style="text-align:center;">Mot de passe : <input type="password" name="pass" /></p>
  <p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="Valider" value="Valider"/></p>
  
 </form>
 
   </div>
  </section>
  <!-- Image element - set the background image for the header in the line below -->
  <div class="py-5 bg-image-full" style="background-image: url('https://images.unsplash.com/photo-1506157786151-b8491531f063?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80');">
    <!-- Put anything you want here! There is just a spacer below for demo purposes! -->
    <div style="height: 200px;"></div>
  </div>

  <!-- Content section -->
  <section class="py-5">
    <div class="container">
      <h1>Création de compte</h1>
     
      <form action="accueil" method ="post">

<p> <label id ="idCreate"> Identifiant :</label>
<input type = "text" id ="idCreate" name="idCreate">
</p>



<p><label id = "passwordCreate"> Mot de passe :</label>
<input type = "text" id="passwordCreate" name="passwordCreate">
</p>
	
<input type="submit"/>
</form>


    </div>
  </section>

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; StabarinMartineauGaultier 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
