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
            Orders Overview
        </h2>
    </header>
    <main>
        <h2>Orders:</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>adress</th>
                <th>postal code</th>
                <th>products</th>
                <th>total</th>
            </tr>
            <c:forEach var ="orders" items = "${orders}" >
                <tr>
                    <td><c:out value="${orders.person}"/></td>
                    <td><c:out value="${orders.adress}"/></td>
                    <td><c:out value="${orders.postalcode}"/></td>
                    <td><c:out value="${orders.products}"/></td>
                    <td><c:out value="${orders.total}"/> </td>
                </tr>
            </c:forEach>
        </table>
        <br>
    </main>
    <footer>
        &copy; group22
    </footer>
</div>
</body>
</html>
