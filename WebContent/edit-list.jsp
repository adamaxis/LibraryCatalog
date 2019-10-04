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
<form action = "editServlet" method="post">
<label><h1>Remove items:</h1></label>
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.itemToEdit.listOfItems}" var="currentItem"><br>
<option value = "${currentItem.id}">${currentItem.title}   [ISBN: ${currentItem.isbn}]</option><br>
</c:forEach>
</select>
<br><input type = "submit" value="Save Edited Item">
</form>
</body>
</html>