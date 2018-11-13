<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="henu.utils.*,java.sql.*,henu.dao.*,henu.factory.*,henu.bean.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">	
		<tr>
			<th>用户名</th>
			<th>用户类型</th>
			<th>性别</th>
			<th>爱好</th>
			<th>出生日期</th>
			<th>电子邮箱</th>
			<th>自我介绍</th>
			<th>操作</th>
		</tr>
	   <%
	     String sql = "SELECT * FROM tb_users";
		//将查询结果存入session名为search的属性中
		StringBuffer sb=new StringBuffer();
		 sb=DbcpPool.sqlsb(sql);
		 out.print(sb.toString());
	   %>
	</table>
	<center>
<form action="/Test7.2/U?stype=delete" method="post" >
  用户名:<input name="username" type="text" ></input><br>
     <input type="submit" name="submit" value="提交"/>
     <input type="reset" name="reset" value="重置"/>
</form>
</center>
</body>
</html>