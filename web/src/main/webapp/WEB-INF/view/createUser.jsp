<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加新用户</title>
    <spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <div><label for="">添加新用户</label></div>
            <form action="" method="post">
                姓名:<input type="text" name="name"><br>
                性别:
                <label><input name="gender" type="radio" value=female>female</label>
                <label><input name="gender" type="radio" value=male>male</label><br>
                年龄:<input type="text" name="age"><br>
                邮箱:<input type="email" name="email"><br>
                <input type="submit" value="添加">
            </form>
            <form class="form-horizontal" action="" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" placeholder="Name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">Gender</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="gender" placeholder="gender">
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">Age</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" placeholder="age">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email" placeholder="email">
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
