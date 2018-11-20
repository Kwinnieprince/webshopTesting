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
                <li id="actual"><a href="Controller?action=Cart">show cart</a></li>
            </ul>
        </nav>
        <h2>
            Cart
        </h2>
    </header>
    <main>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>price</th>
            </tr>
            <tr>
                <td>plant</td>
                <td>groene plant</td>
                <td>5.6</td>
            </tr>
            <c:if test="${not empty emp}">
                <p><c:out value="${emp}"/></p>
            </c:if>
            <c:if test="${not empty productscart}">
                <c:forEach var ="products" items = "${productscart}" >
                    <tr>
                        <td><c:out value="${products.name}"/></td>
                        <td><c:out value="${products.description}"/></td>
                        <td><c:out value="${products.price}"/></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </main>
    <footer>
        &copy; groep22
    </footer>
</div>
</body>
</html>
