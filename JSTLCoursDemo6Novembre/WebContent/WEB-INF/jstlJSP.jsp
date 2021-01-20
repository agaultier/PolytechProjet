<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Je suis dans la vue JSTL ...
<br/>
Expression Language ...
<!-- Ici on voit qu'il faut mettre $ pour récupérer le paramètre et ? dans la barre url -->
<br/>
Mon nom est ${nom}
<br/>
<p>
<c:out value="<h5>Bonjour</h5> ${nom}" >

<!--  escapeXML = "false"  ?? -->
valeur par défaut 
</c:out>
</p>
<br/>
<c:out value = "${nom}">

</c:out>
<br/>
<c:set 	var = "prenom" value = "Samir" scope="page">
</c:set>
<br/>
<br/>
<br/>
<p>
<c:out value="ton prénom est ${prenom}"/>
</p>
<!-- page: Variable prenom est déclarée que pour la page
request : var disponible pendant toute la requête 
session : var pendant toute la session
application : variable globale-->


<br/>
<!--  Déclarer une variable x=14 -->
<p>
<c:set var = "x" value="14"></c:set>
<c:out value = "la variable ${x }"></c:out>
</p>

<!--  Modifier variable -->
<p>
<c:set var="x">291</c:set>
</p>
<c:out value="avec modification ${x }"></c:out>

<!--  Supprimer une variable -->
<p>
<c:remove var="x" scope="page"/>
</p>

<p>
<c:out value="valeur de x ${x}"/>
</p>
<!--  
<script type = "text/javascript" -->
<br/>
Notion importante : XSS, Cross site scripting
JSTL java server tag library

<br/>

<!--  Traitement d'un objet -->
<p>
<c:out value = "Nom :${etudiant.nom} Prénom: ${etudiant.prenom }"></c:out>
</p>

<br/>

<p>
<c:set target="${etudiant}" property="nom" >Anfoine</c:set>
<c:out value =" apres modif ${etudiant.nom}"></c:out>

</p>

<br/>
<!-- Faire la somme de deux paramètres récupérés dans une requête Get -->
<p>
<c:set var= "somme" value="${etudiant.identifiant + etudiant2.identifiant }"/>
<c:out value= "Somme des identifiants ${somme }"/>

<br/>


<!--  faire des Tests avec jSTL -->
<p>
<c:if test="${1==1}" var="tester" >
<h2>le test est vérifié</h2>
</c:if>
</p>

<br/>
<p>
<c:if test="${tester }">
On voit que le test marche
</c:if>
</p>

<!-- Choix multiple -->
<!--  On voit que les conditions sont exclusives -->
<c:choose>
<c:when test ="${!(1==1) }"> TEST 1=1</c:when>

<c:when test ="${2==2 }"> TEST 2=2</c:when>

<c:when test ="${3==3 }"> TEST 3=3</c:when>

<c:otherwise> Aucun test fonctionne</c:otherwise>
</c:choose>

<!--  MARCHE PAS -->
<br/>
<c:if test="${authentification.isConnexion() == true }">
<c:out value ="Vous êtes connecté!"> </c:out>
</c:if>



<br/>
<h1>**********Formulaire*********</h1>


<!-- Qu'est ce que form action -->
<form action="jstlDemo" method="post">
<label for="login"> login: </label>
<input type ="text" id="login" name="login"/>
<input type="submit"/>
<br/>
<label for="pass"> Mot de passe: </label>
<input type ="password" id="pass" name="pass"/>
<input type="submit"/>
</form>
</body>
</html>