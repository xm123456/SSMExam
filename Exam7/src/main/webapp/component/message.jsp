<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%!String MSG;
	String RE;%>
<%
	if ((MSG = (String) request.getAttribute("message")) == null) {
		MSG = (request.getParameter("message") != null) ? request.getParameter("message") : "未知消息";
	}
	if ((RE = (String) request.getAttribute("redir")) == null) {
		RE = (request.getParameter("redir") != null) ? request.getParameter("redir") : "/WebTest/03/welcome.jsp";
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示信息</title>
<link rel="stylesheet" type="text/css" href="../css/message.css" />
<script type="text/javascript">
setTimeout("window.location.href='<%=RE%>'", 3000);
</script>
</head>
<body>
	<div id="message">
		<p><%=MSG%></p>
		<p>
			三秒后<a href="<%=RE%>">重定向</a>
		</p>
	</div>
</body>
</html>