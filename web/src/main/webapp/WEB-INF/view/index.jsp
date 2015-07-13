<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Javaee首页</title>
    <spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <div><a href="./create">addUser</a></div>
            <table class="table table-bordered">
                <caption><h2>用户信息表</h2></caption>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Age</th>
                        <th>Email</th>
                        <th>Operation</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.name}</td>
                            <td>${user.gender}</td>
                            <td>${user.age}</td>
                            <td>${user.email}</td>
                            <td>
                                <a href="./delete?id=${user.id}">delete</a>
                                <a href="./update?id=${user.id}">update</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <%--<spring:url value="/lib/js/bootstrap.min.js" var="bootstrapJs" />--%>
    <%--<script src="${bootstrapJs}"></script>--%>
</body>
</html>
