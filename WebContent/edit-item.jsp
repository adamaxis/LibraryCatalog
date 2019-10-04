<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Book ID: ${itemToEdit.id}
Title: <input type ="text" name = "title" value= "${itemToEdit.title}">
ISBN#: <input type = "text" name = "isbn" value= "${itemToEdit.isbn}">
Author#: <input type = "text" name = "author" value= "${itemToEdit.author}">
Subject#: <input type = "text" name = "subject" value= "${itemToEdit.subject}">
Date Published: <input type = "text" name = "published" value= "${itemToEdit.published}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form><br>
<a href="addItemsForListServlet">Create a new book list instead</a><br>
<a href="index.html">Add a book instead</a>
</body>
</html>