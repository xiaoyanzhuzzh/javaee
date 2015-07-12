<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
    <form action="/web/updateUser" method="post">
        <input type="hidden" value="${user.id}" name="id"><br>
        姓名:<input type="text" value="${user.name}" name="name"><br>
        性别:
        <c:if test ="${user.gender == 'male'}">
            <label><input name="gender" type="radio" value="female">female</label>
            <label><input name="gender" type="radio" value="male" checked>male</label><br>
        </c:if>

        <c:if test ="${user.gender == 'female'}">
            <label><input name="gender" type="radio" value="female" checked>female</label>
            <label><input name="gender" type="radio" value="male">male</label><br>
        </c:if>
        年龄:<input type="text" value="${user.age}" name="age"><br>
        邮箱:<input  type="email" value="${user.email}" name="email"><br>
        <input type="submit" value="确认修改">
    </form>
</body>
</html>
