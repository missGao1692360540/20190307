<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<!--头部-->
<%@ include file="top.jsp"%>
<!--主体内容-->
<section class="publicMian">
    <%@ include file="left.jsp"%>
    <div class="right">
        <h1>添加用户</h1>
        <form method="post" action="/UserServlet.do?choose=2">
            用户名：<input name="username"><br>
            <br>
            密码：<input type="password" name="password"><br>
            <br>
            昵称:<input name="nickname"><br>
            <br>
            <br> <input type="submit" value="提交">
        </form>
    </div>
</section>
<footer class="footer"> 版权归XXXX </footer>
<script src="../js/time.js"></script>
</body>
</html>
