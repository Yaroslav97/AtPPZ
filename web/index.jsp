<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>smart</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Smart Fridge</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
            <li><a href="signup.jsp">Registration</a></li>
            <li><a href="restoring.jsp">Restoring access</a></li>
            <li><a href="about.jsp">About</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <form action="/mainServlet" method="get" class="col-xs-6">
        <div class="form-group">
            <h2>SmartFridge</h2>
            <input type="text" name="login" class="form-control" id="login" placeholder="Enter login">
        </div>
        <br>
        <div class="form-group">
            <input type="password" name="password" class="form-control" placeholder="Enter password">
        </div>
        <br>
        <input type="submit" name="login" value="sign in">
        <br>
        <br>
        <hr>
        <div class="form-group">
            <a href="signup.jsp">sing up</a>
            <br>
            <a href="restoring.jsp">can't sign in?</a>
        </div>
    </form>
</div>

</body>
</html>