<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/skeleton/2.0.4/skeleton.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Web shop</span></h1>
        <nav>
            <ul>
                <li><a href="Controller">Home</a></li>
                <li id="actual"><a href="Controller?action=Products">products</a></li>
                <li><a href="Controller?action=Overview">orders</a></li>
                <li><a href="Controller?action=AddProduct">add product</a></li>
                <li><a href="Controller?action=Cart">show cart</a></li>
            </ul>
        </nav>
        <h2>
            Overview
        </h2>
    </header>
<main>
    <table>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>price</th>
        </tr>
        <c:forEach var ="products" items = "${products}" >
        <tr>
            <form method="post" action="Controller?action=AddToCart&id=${products.productId}">
                <td><a href="Controller?action=Change&product=${products.productId}"><c:out value="${products.name}"/></a></td>
                <td><c:out value="${products.description}"/></td>
                <td><c:out value="${products.price}"/></td>
                <td><a href="Controller?action=Delete&id=${products.productId}">delete</a></td>
                <td>
                    <label for="nrofproducts"><input type="number" name="nrofproducts" id="nrofproducts" value="1"></label>
                    <input type="submit" name="addToCart" id="addToCart" value="add to cart">
                </td>
                </form>
                <!--<a href="Controller?action=AddToCart&id=${products.productId}">add to cart</a>-->
        </tr>
        </c:forEach>
        <caption>Users Overview</caption>
    </table>
</main>
<footer>
    &copy; group22
</footer>
</div>
</body>
</html>
