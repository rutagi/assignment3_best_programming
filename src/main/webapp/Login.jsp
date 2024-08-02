<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Byishimo Olivier</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
    }
    table {
        width: 100%;
        margin-top: 20px;
    }
    td {
        padding: 10px;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="submit"] {
        background-color: #45a049;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #3d8e3d;
    }
    .message {
        color: red;
        text-align: center;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Login - Rutagi Byron</h1>
    <form action="login" method="post">
        <table>
            <tr><td>User Name: </td><td><input type="text" name="username"></td></tr>
            <tr><td>Password: </td><td><input type="password" name="password"></td></tr>
            <tr><td></td><td><input type="submit" value="Login"></td></tr>
        </table>
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
                out.println("<p class='message'>" + errorMessage + "</p>");
            }
        %>
    </form>
</div>
</body>
</html>
