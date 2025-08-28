<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 찾기</title>
</head>
<body>
	<form action="searchOk" >
	아이디로 회원 찾기 : <input type="text" name="memberid" >
	<input type="submit" name="회원 이름 검색" >
	</form>
	
	<c:if test="${not empty mDto }">
		<h2>검색된 회원 : ${mDto.membername }</h2>
	</c:if>
</body>
</html>