<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Cart</title>
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
                <li><a href="Controller?action=Overview">orders</a></li>
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
                <th>Price</th>
                <th>Amount</th>
                <th>Total</th>
            </tr>
            <c:if test="${not empty emp}">
                <p><c:out value="${emp}"/></p>
            </c:if>
            <c:if test="${not empty productscart}">
                <c:forEach var ="products" items = "${productscart}" >
                    <tr>
                        <td><c:out value="${products.key.name}"/></td>
                        <td><c:out value="${products.key.description}"/></td>
                        <td><c:out value="${products.key.price}"/></td>
                        <td><c:out value="${products.value}" /> </td>
                        <td> &euro; <c:out value="${products.key.price * products.value}"/></td>
                    </tr>
                </c:forEach>
                <p><c:out value="Total price : ${ total }€"/></p>
            </c:if>
        </table>
        <c:if test="${empty emp}">
            <div>
            <form method="post" action="userinfo.jsp">
                <input type="submit" value="checkout" />
            </form>
            <form method="post" action="Controller?action=ClearCart">
                <input type="submit" value="clear cart">
            </form>
            </div>
        </c:if>
    </main>
    <footer>
        &copy; groep22
    </footer>
</div>
</body>
</html>
