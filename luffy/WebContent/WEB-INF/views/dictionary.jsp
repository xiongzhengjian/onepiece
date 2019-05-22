<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dictionary</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/item/queryitem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
字典列表：
<table width="100%" border=1>
<tr>
	<td>字典ID</td>
	<td>信息描述</td>
	<!-- <td>生产日期</td> -->
	<td>字典代码</td>
	<td>操作</td>
</tr>
<c:forEach items="${dicList }" var="item">
<tr>
	<td>${item.dictionary_id }</td>
	<td>${item.message }</td>
	
	<td>${item.code }</td>
	
	<td><a href="${pageContext.request.contextPath }/dictionaryEdit.action?id=${item.dictionary_id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>