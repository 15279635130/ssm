<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("PATH", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<style type="text/css">
	th {
		width: 150px;
	}
</style>
</head>
<body>
	<table border="1px" cellspacing="0" cellpadding="10" align="center" style="text-align: center;">
		<caption><h2>用户列表</h2></caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>用户名</th>
				<th>地址</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.username }</td>
					<td>${user.address }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">
					<a href="${PATH }/list?page=1">首页</a>&nbsp;
					<a href="${PATH }/list?page=${pageInfo.prePage}">上一页</a>&nbsp;
					<c:forEach items="${pageInfo.navigatepageNums}" var="num">
						<c:if test="${pageInfo.pageNum == num}">
							[${num }]&nbsp;
						</c:if>
						<c:if test="${pageInfo.pageNum != num}">
							<a href="${PATH }/list?page=${num}">${num }</a>&nbsp;
						</c:if>
					</c:forEach>
					<a href="${PATH }/list?page=${pageInfo.nextPage}">下一页</a>&nbsp;
					<a href="${PATH }/list?page=${pageInfo.pages}">尾页</a>&nbsp;
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>