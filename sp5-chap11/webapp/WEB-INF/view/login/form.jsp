<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
	<form:form method="post" modelAttribute="login" >
		<form:select path="loginTypes" items="${loginTypes}">
		</form:select>
	</form:form>
	<hr />
	<form:form method="post" modelAttribute="login">
		<form:select path="loginTypes">
		<option value="">-------선택하세요---------------</option>
			<form:options items="${loginTypes}"/>		
		</form:select>
	</form:form>
	<hr />
	<form:form method="post" modelAttribute="login">
		<form:select path="loginTypes">
			<form:option value="일반회원" />
			<form:option value="기업">기업회원</form:option>
			<form:option value="헤드헌터회원" label="헤드헌터"> </form:option>
		</form:select>	
	</form:form>
	<hr />
	<form:form method="post" modelAttribute="code">
		<form:select path="jobCode">
			<form:options items="${jobCode}" itemLabel="label" itemValue="code" />
		</form:select>
	</form:form>
</body>
</html>