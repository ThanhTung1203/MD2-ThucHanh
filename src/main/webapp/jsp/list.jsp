<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2023
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sachs</title>
</head>
<body>
<h1>Danh sach hoc sinh </h1>
<c:forEach items='${List}' var="lists">
<h3>ID: ${lists.id} -- Name: ${lists.name} -- Age: ${lists.age} -- Sex: ${lists.sex} -- Address: ${lists.address} -- Score: ${lists.score} <a href="/student?action=edit&id=${lists.id}">Edit</a> <a href="/student?action=delete&id=${lists.id}">Delete</a></h3>
</c:forEach>
<a href="/student?action=create">Thêm </a>

</body>
</html>
