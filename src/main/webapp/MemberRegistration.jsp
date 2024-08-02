<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New</title>
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
        background-color: #45a049; /* Updated to blue color */
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #3d8e3d; /* Slightly darker shade for hover effect */
    }
</style>
</head>
<body>
<div class="container">
    <h1>24707</h1>
    <form action="register" method="post">
        <table>
            <tr><td>ID: </td><td><input type="text" name="id"></td></tr>
            <tr><td>User Name: </td><td><input type="text" name="names"></td></tr>
            <tr><td>Email : </td><td><input type="text" name="email"></td></tr>
            <tr><td>Password: </td><td><input type="password" name="password"></td></tr>
            <tr><td></td><td><input type="submit" value="register"></td></tr>
        </table>
    </form>
</div>
</body>
</html>
