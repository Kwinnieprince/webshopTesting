<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Error</title>
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
            Error
        </h2>
    </header>
    <main>
        <h3>Oops something went wrong!</h3>
        <p><a href="index.jsp">go back to home</a></p>
        <p><c:out value="${pageContext.exception.message}" /> </p>
        <p>Something unexpected happened please try again and if the problem persists please contact us at <a href="mailto:noreply@ucll.be">support@ucll.be</a></p>
    </main>
</div>
</body>
</html>