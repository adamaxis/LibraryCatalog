<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout list</title>
</head>
<body>
<form method = "post" action = "navigationListServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
 <td><input type="radio" name="transID" value="${currentlist.id}"></td>
 <td><h2>#${currentlist.transCode}</h2></td></tr>
 <tr><td colspan="3">Date compiled: ${currentlist.transDate}</td></tr>
 <tr><td colspan="3">User:
${currentlist.user.userName}</td></tr>
 <c:forEach var = "listVal" items = "${currentlist.listOfItems}">
 <tr><td></td><td colspan="3">
Book ID: ${itemToEdit.id}
Title: ${listVal.title}
ISBN#: ${listVal.isbn}
Author#: ${listVal.author}
Subject#:${listVal.subject}
Date Published: ${listVal.published}
 </td>
 </tr>
 </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="addItemsForListServlet">Create a new book list</a>
<a href="index.html">Add a book</a>
</body>
</html>