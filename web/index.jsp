<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<header>
			<h1>
				<span>Web shop</span>
			</h1>
			<nav>
				<ul>
					<li id="actual"><a href="Controller">Home</a></li>
					<li><a href="Controller?action=Products">products</a></li>
					<li><a href="Controller?action=AddProduct">add product</a></li>
					<li><a href="Controller?action=Cart">show cart</a></li>
				</ul>
			</nav>
			<h2>Home</h2>
		</header>
		<main>
			<p>Sed ut perspiciatis unde omnis iste natus error sit
			voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque
			ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
			dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
			aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
			qui ratione voluptatem sequi nesciunt.</p>
			<br>
			<p>Do you want to see a quote?</p>
			<form method="post" action="Controller?action=Quote" novalidate="novalidate">
				<p>
					<label for="yes"><input type="radio" name="quote" value="yes" id="yes">Yes</label>
					<label for="no"><input type="radio" name="quote" value="no" id="no">No</label>
					<br>
					<input type="submit" id="quote" value="Send">
				</p>
			</form>
			<br>
			<p>
				<c:if test="${cookiecheck == 'yes'}">
					Even a dead fish can go with the flow
				</c:if>
			</p>
		</main>
		<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
	</div>
</body>
</html>