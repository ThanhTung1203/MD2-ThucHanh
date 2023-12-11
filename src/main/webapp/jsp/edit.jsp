<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2023
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  method="post" >
    <input type="number" name="id"  value="${edit.id}" >
    <input type="text" name="name"  value="${edit.name}" >
    <input type="number" name="age"  value="${edit.age}" >
    <input type="text" name="sex"  value="${edit.sex}" >
    <input type="text" name="address"  value="${edit.address}" >
    <input type="number" name="score"  value="${edit.score}" >

    <button >Edit</button>
</form>



</body>
</html>
