<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="header">
    <%@ include file="../fragments/header.jspf" %>
</div>
<body>

	<table border=1>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Description</th>
			<th>Lista rozwiązań</th>
		</tr>
		<c:forEach items="${excerciseList}" var="excercise">
			<tr>
				<td>${excercise.id}</td>
				<td>${excercise.title}</td>
				<td>${excercise.description}</td>
				<td><a href="/Workshop3/SolutionsByExcerciseIdServlet?excerciseID=${excercise.id}">Rozwiązania</a></td>
				
			</tr>
		</c:forEach>
	</table>
		<br>
<div id="footer">
    <%@ include file="../fragments/footer.jspf" %>
</div>
</body>
</html>