<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>정보 수정</title>
		<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	</head>
	
	<body>
		<div align=center>
		
			<header>학생 정보 수정</header>
			<form name=form1 action="http://localhost:8080/myweb/member/modify/" method="post">
				<table>
					<tr><th>LoginID</th><td><input type="text" name="id" autofocus placeholder="${student.id}"></td></tr>
					<tr><th>LoginPWD</th><td><input type="text" name="passwd" autofocus placeholder="${student.passwd}"></td></tr>
					<tr><th>YourName</th><td><input type="text" name="username" autofocus placeholder="${student.username}"></td></tr>
					<tr><th>StudentNumber</th><td><input type="text" name="snum" autofocus placeholder="${student.snum}"></td></tr>
					<tr><th>Department</th><td><input type="text" name="depart" autofocus placeholder="${student.depart}"></td></tr>
					<tr><th>MobileNumber</th><td><input type="text" name="mobile" autofocus placeholder="${student.mobile}"></td></tr>
					<tr><th>EmailAddress</th><td><input type="text" name="email" autofocus placeholder="${student.email}"></td></tr>
				</table>
				
				
				<dl>
					<dd><input type="submit" name="submit" value="보내기"></dd>
					<dd><input type="reset" name="reset" value="다시 작성"></dd>
				</dl>

			</form>
		</div>
	</body>


</html>