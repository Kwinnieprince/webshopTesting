<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <nav>
            <ul>
                <li><a href="Controller">Home</a></li>
                <li><a href="Controller?action=Products">products</a></li>
                <li><a href="Controller?action=AddProduct">add product</a></li>
                <li><a href="Controller?action=Cart">show cart</a></li>
            </ul>
        </nav>
        <h2>
            Delete product
        </h2>
    </header>
<form method="post" action="Controller?action=DeleteConfirmation" novalidate="novalidate">
    <p><label for="delete">delete? Ja / Nee </label><input type="text" id="delete" name="delete" required value="" ></p>
    <p><label for="id"></label><input type="hidden" id="id" name="id" required value="${id}" ></p>
    <p><input type="submit" id="update" value="delete product"></p>
</form>
</div>
</body>
</html>
