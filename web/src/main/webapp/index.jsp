<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Javaee</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>邮箱</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.email}</td>
                <td><a href="/web/deleteUser?id=${user.id}">删除</a></td>
                <td><a href="/web/updateUser?id=${user.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
    <div><a href="./createUser.jsp">添加用户</a></div>
</body>
</html>
