<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="edu.fzu.openfund.domain.FundHolding" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>查询持仓情况</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css">
<script language="javascript" type="text/javascript"
	src="js/datepicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery-1.11.3.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery-ui.js"></script>

</head>
<body>
    <!-- s:debug/>   -->
	<div id="header">
		<h2 class="text-center">持仓情况查询</h2>
	</div>
	<div id="mider">
		<form action="trans/showHolding.action" method="post"
			class="form-search">
			<span>基金账户编号</span> <input type="text" name="accNo"
				class="search-query input-small" 
				 <s:if test="#request.accNo!=0"> value="<s:property value='#request.accNo'/>"</s:if>
				  />
			<button type="submit" class="search-query btn btn-primary">查询</button>
		</form>
	</div>
	<jsp:useBean id="pageBean" class="edu.fzu.openfund.util.PageBean"
		scope="request"></jsp:useBean>
	<table class="table table-hover table-bordered table-striped">
		<thead>
			<th>账户号码</th>
			<th>产品名称</th>
			<th>产品份额</th>
			<th>产品当前价格</th>
		</thead>
		<s:iterator var="holding" value="#request.pageBean.data">
			<tr>
			    <td><s:property value="#holding.finAcc.accNo"/></td>
				<td><s:property value="#holding.fund.fundName" /></td>
				<td><s:property value="#holding.holdAmount" /></td>
				<td><s:property value="#holding.fund.fundPrice" /></td>
			</tr>
		</s:iterator>

	</table>
	<%
		if (pageBean.maxPage != 1) {
	%>
	<form name="PageForm" action="trans/showHolding.action" method="post">
		<%@ include file="/page.jsp"%>
		<input type="hidden" name="accNo"  <s:if test="#request.accNo!=0"> value="<s:property value='#request.accNo'/>"</s:if>
				  />
	</form>
	<%
		}
	%>


</body>
</html>
