<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manual checkout</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
Checkout#: <input type ="text" name = "transCode"><br />
Checkout Date: <input type ="text" name = "month" placeholder="mm"
size="4"> <input type ="text" name = "day" placeholder="dd"
size="4">, <input type ="text" name = "year" placeholder="yyyy"
size="4">
Customer Name: <input type = "text" name = "userName"><br />
Available Books to Checkout:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
 <option value = "${currentitem.id}">${currentitem.title} | ${currentitem.isbn}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Items">
</form>
<a href = "index.html">Add books instead</a>
</body>
</html>