<%-- 
    Document   : lister_films
    Created on : 23 nov. 2017, 15:20:08
    Author     : Administrateur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Année</h1>
        <c:forEach items="${listeFilms}" var="film">
            ${film.titre}            


        </c:forEach>
    </body>
</html>
