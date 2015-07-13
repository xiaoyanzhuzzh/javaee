<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加新用户</title>
    <spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/lib/css/createUser.css" var="createUserCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${createUserCss}" rel="stylesheet" />
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <form class="form-horizontal" action="" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Gender</label>
                    <div class="col-sm-4" id="gender">
                        <input class="gender" name="gender" type="radio" value=female>female
                        <input class="gender" name="gender" type="radio" value=male>male
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">Age</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="age" name="age" placeholder="age">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-4">
                        <input type="email" class="form-control" id="email" name="email" placeholder="email">
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
