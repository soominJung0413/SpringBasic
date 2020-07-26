<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@tag import="java.time.format.DateTimeFormatter"  %>
<%@attribute name="value" required="true" type="java.time.temporal.TemporalAccessor" %>
<%@attribute  name="pattern" required="false" type="java.lang.String" %>

<% 
	if(pattern == null) pattern = "yyyy-MM-dd";
%>
<%= DateTimeFormatter.ofPattern(pattern).format(value) %>