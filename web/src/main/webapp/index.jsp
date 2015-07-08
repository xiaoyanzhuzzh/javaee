<%@ page import="java.util.List" %>
<%@ page import="com.tw.web.HelloServlet" %>
<%@ page import="com.tw.core.entity.User" %>
<%@ page import="com.tw.core.service.Service" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Javaee</title>
</head>
<body>
    <% Service service= new Service();
        List<User> users = service.getUsers();
    %>
    <table border="1">
        <tr>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>邮箱</td>
        </tr>
        <% for(User user: users){ %>
            <tr>
                <td><%= user.getName() %></td>
                <td><%= user.getGender() %></td>
                <td><%= user.getAge() %></td>
                <td><%= user.getEmail() %></td>
            </tr>
        <%}%>
    </table>
</body>
</html>
