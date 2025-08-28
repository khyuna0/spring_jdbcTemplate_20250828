<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 회원 목록</title>
</head>
<body>
	<h2>모든 회원 목록</h2>
	<hr>
	<c:forEach items="${mDtos }" var="mDtos" >
		${mDtos.memberid }/${mDtos.memberpw }/${mDtos.membername }/${mDtos.memberage } <br><br>
	</c:forEach>
</body>
</html>