<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

<meta charset="ISO-8859-1">
<title>Board</title>
</head>
<body>


<!-- Table with cells -->
<div id="board">
	<table class="table">
	
		<tr id="A">
			<c:forEach var="cell" items="${cells}" begin="0" end="8">
				<td id="${cell.name}">
					<%@ include file="cell.jsp" %>
					test
				</td>
			</c:forEach>
		</tr>
		
		<tr id="B">
			<c:forEach var="cell" items="${cells}" begin="9" end="17">
				<td id="${cell.name}">
					<%@ include file="cell.jsp" %>
					test
				</td>
			</c:forEach>
		</tr>
		
		<tr id="C">
			<c:forEach var="cell" items="${cells}" begin="18" end="26">
				<td id="${cell.name}">
					<%@ include file="cell.jsp" %>
					test
				</td>
			</c:forEach>
		</tr>
		
		<tr id="D">
			<c:forEach var="cell" items="${cells}" begin="27" end="35">
				<td id="${cell.name}">
					<%@ include file="cell.jsp" %>
					test
				</td>
			</c:forEach>
		</tr>
		
		<tr id="E">
			<c:forEach var="cell" items="${cells}" begin="36" end="44">
				<td id="${cell.name}">
					<%@ include file="cell.jsp" %>
				</td>
			</c:forEach>
		</tr>
		
		<tr id="F">
			<c:forEach var="cell" items="${cells}" begin="45" end="53">
				<td id="${cell.name}">
					<%@ include file="cell.jsp" %>
				</td>
			</c:forEach>
		</tr>
		
		<tr id="G">
			<c:forEach var="cell" items="${cells}" begin="54" end="62">
				<td id="${cell.name}">
					<%@ include file="cell.jsp" %>
				</td>
			</c:forEach>
		</tr>
		
		<tr id="H">
			<c:forEach var="cell" items="${cells}" begin="63" end="71">
				<td id="${cell.name}">
					<%@ include file="cell.jsp" %>
				</td>
			</c:forEach>
		</tr>
		
		<tr id="I">
			<c:forEach var="cell" items="${cells}" begin="72" end="80">
				<td id="${cell.name}">
					<%@ include file="cell.jsp" %>
				</td>
			</c:forEach>
		</tr>
	
	</table>
</div>


</body>
</html>