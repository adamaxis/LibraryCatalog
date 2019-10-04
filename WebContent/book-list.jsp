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
<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<tr>
		<td><input type="radio" name="id" value="${currentitem.id}"></td>
		<td>Catalog ID: ${currentitem.id}</td>
		<td>Title: ${currentitem.title}</td>
		<td>ISBN#: ${currentitem.isbn}</td>
		<td>Author: ${currentitem.author}</td>
		<td>Subject: ${currentitem.subject}</td>
		<td>Date Published: ${currentitem.published}</td>
	</tr>
</c:forEach>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
</table><br>
<a href="addItemsForListServlet">Create a new book list</a><br>
<a href="index.html">Add a book</a>
</body>
</html>