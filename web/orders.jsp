<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Orders</title>
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
                <li><a href="Controller?action=Products">products</a></li>
                <li id="actual"><a href="Controller?action=Overview">orders</a></li>
                <li><a href="Controller?action=AddProduct">add product</a></li>
                <li><a href="Controller?action=Cart">show cart</a></li>
            </ul>
        </nav>
        <h2>
            Order Overview
        </h2>
    </header>
    <main>
        <h2>Orders:</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>price</th>
            </tr>
            <c:forEach var ="products" items = "${productscart}" >
                <tr>
                    <td><c:out value="${products.name}"/></td>
                    <td><c:out value="${products.description}"/></td>
                    <td><c:out value="${products.price}"/></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <p>
            The total cost of this order is: €
            <c:if test="${totalprice != 0}">
                <c:out value="${totalprice}"/>
            </c:if>

        </p>
        <br>
        <h2>This is your adress:</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>adress</th>
                <th>postal code</th>
            </tr>
            <tr>
                <td><c:out value="${name}"/></td>
                <td><c:out value="${adress}"/></td>
                <td><c:out value="${postalcode}"/></td>
            </tr>
        </table>
    </main>
    <footer>
        &copy; group22
    </footer>
</div>
</body>
</html>
