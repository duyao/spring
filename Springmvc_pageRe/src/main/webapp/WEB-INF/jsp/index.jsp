<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>index.jsp</title>

</head>

<body>
	<h2>Spring Page Redirection</h2>
	<p>Click below button to redirect the result to new page</p>
	<form:form method="get" action="/pageRedirect/redirect">
		<table>
			<tr>
				<td><input type="submit" value="Redirect Page" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>
