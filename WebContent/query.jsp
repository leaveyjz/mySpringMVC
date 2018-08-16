<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/postForm" method="get">
		书名查询：<input type="text" name="name" value="${sessionScope.name}">
		<input type="hidden" name="type" value="getByName">
		<button type="submit">提交</button>
	</form>
	<table>
		<tr>
			<th>编号</th>
			<th>ID</th>
			<th>书名</th>
			<th>类别</th>
			<th>数量</th>
			<th>价格</th>
			<th>日期</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.bookList}" var="books" varStatus="number">			
			<tr>
				<td>${number.count}</td>
				<td>${books.id}</td>
				<td>${books.name}</td>
				<td>${books.catogary}</td>
				<td>${books.num}</td>
				<td>${books.price}</td>
				<td>${books.date}</td>
			    <td>
			    	<a href="<%=request.getContextPath()%>/postForm?id=${books.id}&type=delete">删除</a>|
			    	<a href="<%=request.getContextPath()%>/postForm?id=${books.id}&type=getById">更新</a>
			    </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>