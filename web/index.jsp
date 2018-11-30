<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/skeleton/2.0.4/skeleton.min.css">
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
					<li><a href="Controller?action=Overview">orders</a></li>
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

		</main>
		<footer> &copy; group22 </footer>
	</div>
</body>
</html>