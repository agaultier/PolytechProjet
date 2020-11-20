<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Pour modifier un étudiant rentrez son identifiant et les informations que vous voulez modifier</h2>



<form action="dao" method ="post">

<p> <label id ="idModif"> Identifiant :</label>
<input type = "text" id ="idModif" name="idModif">
</p>



<p><label id = "nomModif"> nom à modifier :</label>
<input type = "text" id="nomModif" name="nomModif">
</p>


<p><label id = "prenomModif"> prenom à modifier :</label>
<input type = "text" id="prenomModif" name="prenomModif">
</p>

<input type="submit"/>
</form>


<h2>Pour rechercher des étudiants rentrez un identifiant et/ou les informations que vous voulez rechercher</h2>



<form action="dao" method ="post">

<p> <label id ="idRecherche"> Identifiant :</label>
<input type = "text" id ="idRecherche" name="idRecherche">
</p>



<p><label id = "nomRecherche"> nom à rechercher :</label>
<input type = "text" id="nomRecherche" name="nomRecherche">
</p>


<p><label id = "prenomRecherche"> prenom à rechercher :</label>
<input type = "text" id="prenomRecherche" name="prenomRecherche">
</p>

<input type="submit"/>
</form>



<h2>Pour supprimer un étudiant rentrez son identifiant</h2>

<form action="dao" method ="post">

<p> <label id ="idSuppr"> Identifiant :</label>
<input type = "text" id ="idSuppr" name="idSuppr">
</p>


<input type="submit"/>

</form>


<h2>Ajouter un étudiant</h2>

<form action="dao" method = "post">

<p><label id = "id"> Identifiant</label>
<input type = "text" id="id" name="id">
</p>


<p><label id = "nom"> nom</label>
<input type = "text" id="nom" name="nom">
</p>


<p><label id = "prenom"> prenom</label>
<input type = "text" id="prenom" name="prenom">
</p>

<input type="submit"/>
</form>



<c:out value="J'arrive a reconnaitre la jstl et je peux l'utiliser"/>


<c:forEach items="${resultat}" var="etud">
<ul>
<li>
${etud.nom}
<!--<c:out value ="${etud}"></c:out>-->
</li>
</ul>

</c:forEach>

 <p>
 Essayer d'aider
 </p>
<c:forEach items="${ll }" var="etu">

<c:out value="${etu.nom }"> </c:out>

</c:forEach>

</body>
</html>
<!-- 

<p>
<c:forEach items="${etudiants}" var="etudiant">

<ul>
<li><c:out value="${etudiant.nom}"/></li>
</ul>
</c:forEach>

</p>
  -->