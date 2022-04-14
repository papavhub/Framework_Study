<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>DataNotFouncException</title>
		<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	</head>
	
	<body>
		<div align=center>
		
			<h1>DataNotFoundException</h1>
			
			<c:url value="/member/list" var="url"/>
			<a href="${url}">학생 목록 화면 가기</a>
			
			
		</div>
	</body>


</html>