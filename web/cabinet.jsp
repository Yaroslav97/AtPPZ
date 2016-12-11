<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>cabinet</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>


    <script type="text/javascript">
        $(document).on('click', '.spinbox-up, .spinbox-down', function () {
            var $spinbox = $(this).closest('.spinbox');
            if ($spinbox.length) {
                var $input = $spinbox.find('input.spinbox-input');
                if ($input.length) {
                    var max = parseInt($spinbox.data('max')) || false;
                    var min = parseInt($spinbox.data('min')) || false;
                    var val = parseInt($input.val()) || min || 0;
                    var sign = $(this).hasClass('spinbox-up') ? 1 : -1;
                    val += sign * (parseInt($spinbox.data('step')) || 1);
                    if (max && val > max) {
                        val = max;
                    } else if (min && val < min) {
                        val = min;
                    }
                    $input.val(val).trigger('change');
                }
            }
        });

        $('.spinbox-input').on('change', function () {
            console.log('Spinbox value has been changed!')
        });
    </script>

    <style type="text/css">
        .spinbox {
            max-width: 60px;
            position: relative;
            padding-right: 20px;
        }

        .spinbox .spinbox-input {
            min-width: 40px;
            padding-left: 3px;
            padding-right: 3px;
            text-align: center;
        }

        .spinbox .spinbox-buttons {
            text-align: center;
            position: absolute;
            right: 0;
            top: 0;
            height: 100%;
            width: 20px;
        }

        .spinbox .spinbox-buttons .spinbox-up {
            position: absolute;
            top: 0;
            right: 0;
            height: 50%;
            width: 100%;
            border-left: none;
            line-height: 1;
        }

        .spinbox .spinbox-buttons .spinbox-down {
            position: absolute;
            bottom: 0;
            right: 0;
            height: 50%;
            width: 100%;
            border-left: none;
            line-height: 1;
        }
    </style>


</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Smart Fridge</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
            <li><a href="edit.jsp">Edit profile</a></li>
            <li><a href="/logout">Logout</a></li>
            <li><a href="#">${fullName}</a></li>
        </ul>
    </div>
</nav>

<div class="container" class="spinbox" data-min="-1" data-max="20" data-step="1">
    <h2>Cabinet</h2><br><br>

    <h2>Fridge parameter</h2>

    <form action="/cabinetServlet" method="get">

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Fridge id</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>Power</th>
                <th><input type="checkbox" name="power" checked data-toggle="toggle" checked="checked"></th>
            </tr>
            <tr>
                <td>Defrost</td>
                <td><input type="checkbox" name="defrost" data-toggle="toggle"></td>
            </tr>
            <tr>
                <td>tFridge</td>
                <%--<td><input name="tFridge" size="3px" value="${tFridge}" placeholder="      t"></td>--%>
                <td>
                    <div class="spinbox" data-min="-1" data-max="20" data-step="1">
                        <input name="tFridge" value="${tFridge}" placeholder="      t"
                               class="form-control spinbox-input">
                        <div class="spinbox-buttons">
                            <button class="spinbox-up btn btn-default btn-xs" type="button">+</button>
                            <button class="spinbox-down btn btn-default btn-xs" type="button">-</button>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>tFreezer</td>
                <%--<td><input name="tFreezer" size="3px" value="${tFreezer}" placeholder="      t"></td>--%>
                <td>
                    <div class="spinbox" data-min="-1" data-max="20" data-step="1">
                        <input name="tFreezer" value="${tFreezer}" placeholder="      t"
                               class="form-control spinbox-input">
                        <div class="spinbox-buttons">
                            <button class="spinbox-up btn btn-default btn-xs" type="button">+</button>
                            <button class="spinbox-down btn btn-default btn-xs" type="button">-</button>
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <input type="submit" value="change">
    </form>
</div>

<hr>

<br>
<br>

<div align="right"><p>${print}</p></div>
</body>
</html>