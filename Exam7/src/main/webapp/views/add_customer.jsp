<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.sakila.Entity.Address"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/customer_index.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/add_customer.js"></script>
<%!List<Address> al;%>
<%
	al = (List<Address>) request.getAttribute("address_list");
%>
</head>
<body>
	<div id="Title">
		<h1>客户管理</h1>
	</div>
	<div class="container">
		<div class="panel panel-default" style="margin-top: 8px;">
			<div id="this-panal-head" class="panel-heading">
				<h3 class="panel-title" style="display: inline;">基本信息</h3>
			</div>
			<div class="panel-body">
				<form action="/Exam7/customer/addCustomer" method="post"
					name="customer">
					<div class="col-md-6">
						<table
							class="table table-condensed table-hover ">
							<tr>
								<td><span>First Name<span class="red-word">*</span></span></td>
								<td><input type="text" class="form-control" id="input-first-name"
									name="first_name" /></td>
							</tr>
							<tr>
								<td><span>Last Name<span class="red-word">*</span></span></td>
								<td><input type="text" class="form-control" id="input-last-name"
									name="last_name" /></td>
							</tr>
							<tr>
								<td><span>Email</span></td>
								<td><input type="text" class="form-control" name="email" /></td>
							</tr>
							<tr>
								<td><span>Address<span class="red-word">*</span></span></td>
								<td>
									<p style="text-align: center;">
										<select name="address_id" class="form-control"
											aria-describedby="basic-addon3">
											<%
												for (int i = 0; i < al.size(); i++) {
											%>
											<option value="<%=al.get(i).getID()%>"><%=al.get(i).getAddress()%></option>
											<%
												}
											%>
										</select>
									</p>
								</td>
							</tr>
						</table>
						<div style="padding: 5px; text-align: center; margin-top: 5px;">
							<a id="btn-cancle" class="btn btn-default" href="#">取消</a>&nbsp;&nbsp;
							<input class="btn btn-info" type="submit" value="提交"
								onclick="return check(this);" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>