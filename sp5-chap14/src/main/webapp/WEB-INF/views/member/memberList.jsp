<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>회원 조회</title>
</head>
<body>
	<form:form modelAttribute="cmd" method="post">
	<p>
	<label>
		from : <form:input path="from"/>
		<form:errors path="from" />
	</label>
	~
	<label>
		to : <form:input path="to"/>
		<form:errors path="to" />
	</label>
	<input type="submit" value="조회" />
	</p>
	</form:form>
	
	<c:if test="${not empty members}">
		<table>
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
			<c:forEach var="mem" items="${members}">
				<tr>
					<td>${mem.id}</td>
					<td> <a href=' <c:url value='/members/${mem.id}' /> '>${mem.email }</a> </td>
					<td>${mem.name}</td>
					<td><tf:formatDateTime value="${mem.regdate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>