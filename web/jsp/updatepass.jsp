<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<!--头部-->
<%@ include file="top.jsp"%>
<!--主体内容-->
<section class="publicMian">
    <%@ include file="left.jsp"%>
    <div class="right">
        <h1>修改密码</h1>
        <form method="post" action="/UserServlet.do?choose=3">
           要修改用户的ID：<input name="id"><br>
            <br>
            新的密码：<input type="password" name="password"><br>
            <br>
            <br> <input type="submit" value="提交">
        </form>
    </div>
</section>
<footer class="footer"> 版权归XXXX </footer>
<script src="../js/time.js"></script>
</body>
</html>