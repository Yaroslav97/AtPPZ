<%@ page errorPage="error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restoring access</title>
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
            <li><a href="#">About Us</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <form action="/restore" method="get" class="col-xs-6">
        <div class="form-group">
            <h3>Restoring access</h3>
            <input type="text" name="rLogin" minlength="4" class="form-control" id="login" placeholder="Login">
            <br>
            <input type="email" name="rEmail" minlength="4" class="form-control" placeholder="Email">
        </div>
        <input type="submit" value="send" class="btn btn-info btn-lg">
    </form>
</div>

</body>
</html>