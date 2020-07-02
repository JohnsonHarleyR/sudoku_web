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
<title>Sudoku</title>
</head>
<body>


<!-- MainBody -->
<main class="container">

<h1>Sudoku</h1>

<!-- Board -->
<section id="board" style="display:flex;flex-wrap: wrap;">

			<!-- Row A -->
			<c:forEach var="cell" items="${cells}" begin="0" end="8">
				
				<c:choose>
					<c:when test='${cell.name == "a3" || cell.name == "a6" }'>
						<div class="square" style="border-right:4px solid black;">
						
							<!-- This is instead of ${cell.value} -->
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="square">
							
							<!-- This is instead of ${cell.value} -->
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
							
						</div>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			
			<div class="break"></div> <!-- break -->
			
			<!-- Row B -->
			<c:forEach var="cell" items="${cells}" begin="9" end="17">
				
				<c:choose>
					<c:when test='${cell.name == "b3" || cell.name == "b6" }'>
						<div class="square" style="border-right:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="square">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			
			<div class="break"></div> <!-- break -->
			
			<!-- Row C -->
			<c:forEach var="cell" items="${cells}" begin="18" end="26">
				
				<c:choose>
					<c:when test='${cell.name == "c3" || cell.name == "c6" }'>
						<div class="square" style="border-bottom:4px solid black;
						border-right:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="square" style="border-bottom:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			
			<div class="break"></div> <!-- break -->
			
			<!-- Row D -->
			<c:forEach var="cell" items="${cells}" begin="27" end="35">
				<c:choose>
					<c:when test='${cell.name == "d3" || cell.name == "d6" }'>
						<div class="square" style="border-right:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="square">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<div class="break"></div> <!-- break -->
			
			<!-- Row E -->
			<c:forEach var="cell" items="${cells}" begin="36" end="44">
				<c:choose>
					<c:when test='${cell.name == "e3" || cell.name == "e6" }'>
						<div class="square" style="border-right:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
									
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="square">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
									
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<div class="break"></div> <!-- break -->
			
			<!-- Row F -->
			<c:forEach var="cell" items="${cells}" begin="45" end="53">
				<c:choose>
					<c:when test='${cell.name == "f3" || cell.name == "f6" }'>
						<div class="square" style="border-bottom:4px solid black;
						border-right:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="square" style="border-bottom:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<div class="break"></div> <!-- break -->
			
			<!-- Row G -->
			<c:forEach var="cell" items="${cells}" begin="54" end="62">
				<c:choose>
					<c:when test='${cell.name == "g3" || cell.name == "g6" }'>
						<div class="square" style="border-right:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="square">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<div class="break"></div> <!-- break -->
			
			<!-- Row H -->
			<c:forEach var="cell" items="${cells}" begin="63" end="71">
				<c:choose>
					<c:when test='${cell.name == "h3" || cell.name == "h6" }'>
						<div class="square" style="border-right:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="square">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<div class="break"></div> <!-- break -->
			
			<!-- Row I -->
			<c:forEach var="cell" items="${cells}" begin="72" end="80">
				<c:choose>
					<c:when test='${cell.name == "i3" || cell.name == "i6" }'>
						<div class="square" style="border-right:4px solid black;">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="square">
							
							<c:choose>
								<c:when test="${cell.visible}">
									<input type="hidden" name="${cell.name}" value="${cell.value}"/>
									${cell.value}
								</c:when>
								<c:otherwise>
									<input type="text" class="squaretext" name="${cell.name}"/>
								</c:otherwise>
							</c:choose>

						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
</section>

<a href="/generate/complete"><button>Generate Complete</button></a>
<a href="/generate/unsolved"><button>Generate Unsolved</button></a>
<br>

</main>

</body>
</html>