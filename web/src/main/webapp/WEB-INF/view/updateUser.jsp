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
        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">用户管理系统</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/web/logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <form class="form-horizontal" action="/web/users/update" method="post">
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
                        <div class="col-sm-4">
                            <label class="radio-inline">
                                <input type="radio" name="gender"  value="female"> female
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender"  value="male" checked> male
                            </label>
                        </div>
                    </c:if>
                    <c:if test="${user.gender == 'female'}">
                        <div class="col-sm-4">
                            <label class="radio-inline">
                                <input type="radio" name="gender"  value="female" checked> female
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender"  value="male"> male
                            </label>
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
