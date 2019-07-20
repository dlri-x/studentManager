<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import="com.datang.hrb.vo.*" %>
    <%@page import=" javax.servlet.*" %>
    <%String username=(String)session.getAttribute("username"); %>
    <%List<User> userList=(ArrayList<User>)session.getAttribute("userList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
登录成功！欢迎<%=username %>
<table border=1>
<tr><td>用户名</td><td>密码</td><td>年龄</td><td>时间戳</td></tr>
<% 
for(User tempUser:userList){%>
	<tr><td><%=tempUser.getUsername() %></td><td><%=tempUser.getPassword() %></td><td><%=tempUser.getAge() %></td><td><%=tempUser.getTs() %></td></tr>
<%}%>
</table>
<%-- <br/>
所有用户信息如下：
<%
for(int i=0;i<userList.size();i++){
User user=userList.get(i);
%>
<p>用户名：<%=user.getUsername() %> 年龄：<%=user.getAge() %></p>
<%
}
%>
 --%>

</body>
</html>