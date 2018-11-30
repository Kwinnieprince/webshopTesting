<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Update</title>
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
            add product
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
    <form method="post" action="Controller?action=Update" novalidate="novalidate">
        <!-- novalidate in order to be able to run tests correctly -->
        <p><label for="name">Name</label><input type="text" id="name" name="name" required value="${product.name}"> </p>
        <p><label for="description">Description</label><input type="text" id="description" name="description" required value="${product.description}"> </p>
        <p><label for="price">price</label><input type="text" id="price" name="price" required value="${product.price}"></p>
        <p><label for="id">id</label><input type="text" id="id" name="id" required value="${product.productId}" readonly></p>
        <p><input type="submit" id="update" value="update product"></p>

    </form>
</main>
    <footer>
        &copy; group22
    </footer>
</div>
</body>
</html>