<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>sign up</title>

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
    <form action="/mainServlet" method="get" class="col-xs-6">
        <div class="form-group">
        <h2>Registration</h2>
            <input type="text" name="fullName" class="form-control" id="name" placeholder="Full name"><br>
            <input type="text" name="fridgeID" class="form-control"  placeholder="Fridge ID"><br>
            <input type="text" name="login" class="form-control" id="login" placeholder="Login"><br>
            <input type="email" name="email" class="form-control" placeholder="Email"><br>
            <input type="password" name="password" class="form-control" placeholder="Password"><br>
            <input type="submit" value="sign up">
        </div>
    </form>
</div>

</body>
</html>
