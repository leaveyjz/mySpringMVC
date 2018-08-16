<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/postForm" method="post">
		书本数量：<input type="text" name="num" value="${requestScope.book.num}">
		书名：<input type="text" name="name" value="${requestScope.book.name}">
		价格：<input type="text" name="price" value="${requestScope.book.price}">
		类别：<input type="text" name="catogary" value="${requestScope.book.catogary}">
		<input type="hidden" name="type" value="update" >
		<input type="hidden" name="id" value="${requestScope.book.id}" >
		<button type="submit">提交</button>
	</form>
</body>
</html>
