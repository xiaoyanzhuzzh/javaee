<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>更新用户信息</title>
    <spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/lib/css/createUser.css" var="createUserCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${createUserCss}" rel="stylesheet" />
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <form class="form-horizontal" action="" method="post">
                <input type="hidden" value="${user.id}" name="id"><br>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name" value="${user.name}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Gender</label>
                    <c:if test="${user.gender == 'male'}">
                        <div class="col-sm-4" id="gender">
                            <input class="gender" name="gender" type="radio" value="female">female
                            <input class="gender" name="gender" type="radio" value="male">male
                        </div>
                    </c:if>
                    <c:if test="${user.gender == 'female'}">
                        <div class="col-sm-4" id="gender">
                            <input class="gender" name="gender" type="radio" value="female" checked>female
                            <input class="gender" name="gender" type="radio" value="male">male
                        </div>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">Age</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="age" name="age" value="${user.age}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-4">
                        <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
