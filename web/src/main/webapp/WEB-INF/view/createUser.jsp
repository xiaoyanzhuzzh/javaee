<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加新用户</title>
</head>
<body>
    <form action="" method="post">
        姓名:<input type="text" name="name"><br>
        性别:
        <label><input name="gender" type="radio" value=female>female</label>
        <label><input name="gender" type="radio" value=male>male</label><br>
        年龄:<input type="text" name="age"><br>
        邮箱:<input type="email" name="email"><br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
