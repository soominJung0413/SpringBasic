<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title><spring:message code="login.title" /></title>
</head>
<body>
	<form:form  modelAttribute="loginCommand">
		<form:errors element="span" delimiter="<br>" /> <!-- 커멘드 객체 에러 표시 -->
			<p>
				<label>
					<spring:message code="email" /> : <br />
					<form:input path="email"/>
					<form:errors path="email" />
				</label>
			</p>
			<p>
				<label>
					<spring:message code="password"/> : <br />
					<form:password path="password"/>
					<form:errors path="password" />
				</label>
			</p>
			<p>
				<label>
				<spring:message code="rememberEmail" /> : <form:checkbox path="rememberEmail"/>
				</label>
			</p>
			<input type="submit" value="<spring:message code="login.btn" />" />
	</form:form>
</body>
</html>