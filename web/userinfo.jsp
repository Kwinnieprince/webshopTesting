<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Userinfo</title>
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
                <li><a href="Controller?action=Cart">show cart</a></li>
            </ul>
        </nav>
        <h2>
            User info
        </h2>
    </header><main>
    <c:if test="${not empty errors}">
        <c:forEach var="error" items="${errors}">
            <div class="alert-danger">
                <ul>
                    <li>${error}</li>
                </ul>
            </div>
        </c:forEach>
    </c:if>
    <form method="post" action="Controller?action=Checkout" novalidate="novalidate">
        <!-- novalidate in order to be able to run tests correctly -->
        <p <c:if test="${nameerror == true}"> class="alert-danger" </c:if>><label for="username">Name</label><input type="text" id="username" name="username" required placeholder="What is your name?" <c:if test="${postalerror == true}">value="${username}"</c:if>"> </p>
        <p <c:if test="${adresserror == true}"> class="alert-danger" </c:if>><label for="adress">Adress</label><input type="text" id="adress" name="adress" required placeholder="What is the adress?" <c:if test="${postalerror == true}">value="${adress}"</c:if>> </p>
        <p <c:if test="${postalerror == true}"> class="alert-danger" </c:if>><label for="postalcode">postal code</label><input type="number" id="postalcode" name="postalcode" required placeholder="postal code"> <c:if test="${postalerror == true}"> The postal code is wrong.</c:if></p>
        <p><input type="submit" id="update" value="submit"></p>

    </form>
</main>
    <footer>
        &copy; group22
    </footer>
</div>
</body>
</html>