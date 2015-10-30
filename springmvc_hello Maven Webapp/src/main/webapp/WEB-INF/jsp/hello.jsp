<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>hello world</title>
</head>
<body>
	<h1>fdds</h1>
	<h2>${message}hkjh</h2>
	<h2>${message}hhh</h2>
	<c:out value="${message }"></c:out>
	<c:out value="fdasfa"></c:out>
	{$gfgsd}
	</br>request.getAttribute:<%=request.getAttribute("message")%>
</body>
</html>