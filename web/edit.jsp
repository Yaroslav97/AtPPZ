<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
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
            <a class="navbar-brand" href="#">Smart Fridge</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="cabinet.jsp">Cabinet</a></li>
            <li class="active"><a href="/logout">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <form action="/editProfile" method="get" class="col-xs-8">
        <h3>Edit profile: ${login}</h3>
        <input type="text" name="eFullName" value=${fullName} class="form-control" placeholder="Full Name"><br>
        <input type="email" name="eEmail" value=${email} class="form-control" placeholder="Email"><br>
        <input type="password" name="ePassword" class="form-control" placeholder="Password"><br>
        <input type="submit" value="edit">
    </form>

</div>

</body>
</html>
