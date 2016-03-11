<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.dianrong.common.uniauth.common.cons.AppConstants" %>
<%
	String ajaxReqType = request.getHeader(AppConstants.AJAS_CROSS_HEADER);
	String baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	String reqUrl = baseUrl + request.getContextPath() + "/login?" + request.getQueryString();
%>

<script>
	alert("<%= ajaxReqType + ":" + baseUrl%>");
</script>

<%
	if (ajaxReqType == null || baseUrl.startsWith(ajaxReqType)) {
%>
		<jsp:directive.include file="includes/login.jsp" />
<%
	} else {
		response.setContentType("application/json");
		response.addHeader("Cache-Control", "no-store");
%>
{
	"info":
		[
			{
				"name": "<%=AppConstants.LOGIN_REDIRECT_URL%>",
				"msg": "<%= reqUrl %>"
			}
		]
}
<%
	}
%>