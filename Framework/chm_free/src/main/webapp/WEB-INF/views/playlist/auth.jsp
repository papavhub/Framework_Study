<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Auth</title>
		<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	</head>

	<body>
	
		<form action="login_ok.jsp" method="post">
			아이디:<input type="text" name="id"><br/>
			비밀번호:<input type="password" name="pw"><br/>
			<input type="submit" value="로그인"><br/>
		</form>
	
	</body>
</html>