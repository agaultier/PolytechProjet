<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix ="c" %>
<!DOCTYPE html>
<html lang="en">

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
      <a class="navbar-brand" href="accueil.jsp">En avant la musique</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item ">
            <a class="nav-link" href="accueil.jsp">Home
           
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="aPropos.jsp">A propos de nous</a>
          </li>
          
          <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Les groupes
        </a>
         <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="rock.jsp">Rock</a>
          <a class="dropdown-item active" href="rap.jsp">Rap</a>
          <a class="dropdown-item" href="electro.jsp">Electro</a>
          <a class="dropdown-item" href="pop.jsp">Pop</a>
          <a class="dropdown-item" href="variete.jsp">Variete Francaise</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item " href="autre.jsp">Autre</a>
        </div>
      </li>
          <li class="nav-item active">
            <a class="nav-link" href="recherche">Recherche/Liste artistes
               <span class="sr-only">(current)</span>
               </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Header - set the background image for the header in the line below -->
  <header class="py-5 bg-image-full" style="background-image: url('https://images.unsplash.com/photo-1572648586565-8b332ccd46e4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80');">
    <img class="img-fluid d-block mx-auto" src="https://images.unsplash.com/photo-1572648586565-8b332ccd46e4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80" alt="" width = 30%  >
  </header>

  <!-- Content section -->
  <section class="py-5">
    <div class="container">
      <h1>Recherche/Liste artistes</h1>
      <p class="lead">Sur cette page vous pouvez rechercher des artistes en particulier en fonction des 
      differentes caracteristiques et vous avez acces a la liste entiere des artistes</p>
    

<table class="table table-striped table-bordered table-hover ">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Artiste</th>
      <th scope="col">Annee</th>
      <th scope="col">Genre</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      
        
<c:forEach items="${resultat}"  var="musique">
	<tr class="ÃÂ${rowStyle}">
	<th scope="row">${musique.identifiant}</th>
          <td>${musique.artiste}</td>
           <td>${musique.annee}</td>
           <td>${musique.genre}</td>
          
          
           </tr>

</c:forEach>
    </table>
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
      <h1>Ajoutez/Modifiez/Supprimez vos groupes preferes</h1>
      
 <form method="post" name="Form" action="recherche"
              style="width:50%;margin:auto;background-color:whitesmoke;padding-bottom:15px;">
    
  <h2 style="text-align:center;color:black;background-color:wheat;">Ajout d'un groupe</h2>
  <p style="text-align:center;">Genre : <input type="text" name="genre"  /></p>
  <p style="text-align:center;">Artiste : <input type="text" name="artiste" /></p>
 <p style="text-align:center;">Annee : <input type="text" name="annee"  /></p>
  <p style="text-align:center;">Identifiant : <input type="text" name="id" /></p>
 
  <p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="Valider" value="Valider"/></p>
  
 </form>
 
 <form method="post" name="Form" action="recherche"
              style="width:50%;margin:auto;background-color:whitesmoke;padding-bottom:15px;">
    
  <h2 style="text-align:center;color:black;background-color:wheat;">Modification d'un groupe</h2>
  <p style="text-align:center;">Genre : <input type="text" name="genreModif"  /></p>
  <p style="text-align:center;">Artiste : <input type="text" name="artisteModif" /></p>
 <p style="text-align:center;">Annee : <input type="text" name="anneeModif"  /></p>
  <p style="text-align:center;">Identifiant : <input type="text" name="idModif" /></p>
 
  <p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="Valider" value="Valider"/></p>
  
 </form>
 
 <form method="post" name="Form" action="recherche"
              style="width:50%;margin:auto;background-color:whitesmoke;padding-bottom:15px;">
    
  <h2 style="text-align:center;color:black;background-color:wheat;">Suppression d'un groupe</h2>
  <p style="text-align:center;">Identifiant : <input type="text" name="idSuppr" /></p>
 
  <p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="Valider" value="Valider"/></p>
  
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
