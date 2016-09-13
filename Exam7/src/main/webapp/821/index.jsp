<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理系统</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="../css/index.css">
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../component/header.jsp"></jsp:include>
<div id="body-context">
    <div id="body-context-left">
        <ul id="vec-nav" class="nav nav-divider nav-stacked">
            <li role="presentation">
                <a href="/Exam7/customer/index.do" target="iframe_show">
                    <span class="glyphicon glyphicon-stop"></span>
                    &nbsp; Customer管理
                    <span style="float: right">&gt;</span>
                </a>
            </li>
            <li role="presentation">
                <a href="/Exam7/821/uncomplete.html" target="iframe_show">
                    <span class="glyphicon glyphicon-stop"></span>
                    &nbsp; Film设置
                    <span style="float: right">&gt;</span>
                </a>
            </li>        
        </ul>
    </div>
    <div id="body-context-right">
        <iframe src="/Exam7/821/welcome.html" width="100%" height="600" frameborder="0" name="iframe_show"></iframe>
    </div>
</div>
</body>
</html>