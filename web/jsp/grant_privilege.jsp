<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

</head>
<body>
	<!--头部-->
	<%@ include file="top.jsp"%>
	<!--主体内容-->
	<section class="publicMian">
		<%@ include file="left.jsp"%>
		<div class="right">
				<table border="1" style="text-align: center;">
					<tr>
						<td>角色名称</td>
						<td>${rolename}</td>
					</tr>
					<tr>
						<td>描述</td>
						<td>已具有权限： <c:forEach items="${privilegeList}"
								var="privileges">
	 ${privileges.name}<input type="checkbox" disabled name="privilegedelete" value="${privileges.id}" checked="checked">&nbsp;
	</c:forEach>
						</td>
					</tr>

					<tr>
						<td>系统所有权限列表</td>
						<td><c:forEach items="${privilegesList}"
									   var="privileges">
							${privileges.name}<input type="checkbox" onchange="changestate(this,this.checked)" name="privilegedelete" value="${privileges.id}" checked="checked">&nbsp;
						</c:forEach>
							<c:forEach items="${privilegeList}" var="privileges">
		 ${privileges.name}<input type="checkbox" name="privilegeadd"	value="${privileges.id}">&nbsp;
	</c:forEach></td>
					</tr>
<tr>
<td colspan="2">
<input type="hidden" name="roleID" value="${rolesid}">
<input type="hidden" name="choose" value="3" >
<input type="button"  value="授权" onclick="submits()"> </td>

</tr>

				</table>


		</div>
	</section>
	<footer class="footer"> 版权归XXXX </footer>
	<script src="../js/time.js"></script>
</body>
<script src="/js/jquery.js"></script>
<script>

    function changestate(th,checked){
        if(checked){
            $(th).attr("checked","checked");
		}else{
            $(th).removeAttr("checked");
		}
	}
	function submits() {

        var privilegedeletes = $("input[name='privilegedelete']");
        var privilegeadds = $("input[name='privilegeadd']");
        var privildeles="";
        var priviladds="";
        $(privilegedeletes).each(function (i) {
            privildeles +=this.value+",";
        });
        $(privilegedeletes).each(function (i) {
			if(this.checked==true){
                priviladds +=this.value+",";
			}
        });
        privildeles = privildeles.substring(0,privildeles.length-1);
        priviladds = priviladds.substring(0,priviladds.length-1);
		$.ajax({
			url:"PrivilegeSerServlet.do",
			type:"post",
			dateType:"json",
			date:{
			    roleid:$("#roleID").val(),
				privilegedeleteid:privildeles,
				privilegeaddid:priviladds,
				choose:1
			},
			success:function (date) {
			    if(date.date==1){
			        window.location("/PrivilegeSerServlet.do?choose=2");
                }
            }
		});
    }
</script>
</html>