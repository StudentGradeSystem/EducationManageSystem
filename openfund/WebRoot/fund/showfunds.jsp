<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="edu.fzu.openfund.domain.Fund,java.text.DecimalFormat"%>
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
<title>查询基金产品结果</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css">

<script language="javascript" type="text/javascript"
	src="js/datepicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery-1.11.3.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery-ui.js"></script>

<script type="text/javascript">
		var fund, fundNo;
		$(function() {
			$("#dialog-fund").dialog({
				modal : false,
				autoOpen : false, //是否自动打开
				height : 430, //对话框宽高
				width : 450,
				title : "修改基金信息",
				buttons:{
				"确定":function(){
					updateFund();
				},
				"取消":function(){
					$(this).dialog("close");
				}
				}
			});
		});
        //点击“修改”按钮，调用getFund方法
		function getFund(fNo) {
			$.ajax({
				type : "POST",  //提交方式
				url : "ajax/findFund.action",  //提交地址
				data : {              //提交数据
					"fundNo" : fNo
				},
				async : true,  //异步
				success : function(data) {
					fund = data;
					$("#fundName").val(fund.fundName);
					$("#fundPrice").val(fund.fundPrice.toFixed(2));
					$("#fundStatus").find("option[value='"+fund.fundStatus+"'"+"]").attr("selected",true);
					$("#fundDes").val(fund.fundDes);
					$("#fundNo").val(fund.fundNo);					
				}
			});
			$("#dialog-fund").dialog("open");  //打开对话框
		}
		
		function updateFund() {
			$.ajax({
				type : "POST",
				url : "ajax/updateFund.action",
				dataType:"json",
				data : $("#form-fund").serialize(), //表单数据序列化
				async : true,
				success : function(msg) {
				    $("#f"+fund.fundNo+" td:eq(1)").html($("#fundName").val());
				    $("#f"+fund.fundNo+" td:eq(2)").html($("#fundPrice").val());
				    if($("#fundStatus").val() == "Y")	
				    	$("#f"+fund.fundNo+" td:eq(3)").html("可交易");	
				    else
				   		$("#f"+fund.fundNo+" td:eq(3)").html("未上市交易");					
					$("#dialog-fund").dialog("close");					
					alert(msg);
				}
			});
		}			
	</script>
</head>

<body>

	<div id="dialog-fund">
		<form id="form-fund" class="form-horizontal">
			<div class="control-group">
				<legend>
					<span class="controls"> 修改基金产品 </span>
				</legend>
			</div>
			<div class="control-group">
				<label class="control-label" for="fundName"> 基金产品名称: </label>
				<div class="controls">
					<input type="text" name="fund.fundName" id="fundName" /> <span
						style="color: red; font-size: 17;">&nbsp;*</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="fundPrice"> 基金产品价格: </label>
				<div class="controls">
					<input type="text" name="fund.fundPrice" id="fundPrice" /> <span
						style="color: red; font-size: 17;">&nbsp;*</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="fundDes"> 基金产品描述: </label>
				<div class="controls">
					<input type="text" name="fund.fundDes" id="fundDes" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="fundStatus"> 基金产品状态: </label>
				<div class="controls">
					<select name="fund.fundStatus" id="fundStatus" class="input-medium">
						<option value="">==请选择==</option>
						<option value="Y">可交易</option>
						<option value="N">未上市交易</option>
					</select> <span style="color: red; font-size: 17;">&nbsp;*</span>
				</div>
			</div>
			<div class="control-group controls">
				<input type="hidden" name="fund.fundNo" id="fundNo" />
			</div>
		</form>
	</div>



	<div id="header">
		<h2 class="text-center">基金产品查询</h2>
	</div>
	<div id="mider">
		<form action="fund/showFund.action" method="post" class="form-search">
			<span>基金产品名称</span> <input type="text" name="fundName"
				class="search-query input-small" value="${requestScope.fundName}" />
			<span> 基金价格：从</span> <input type="text" name="fromPrice"
				maxlength="7" class="search-query input-small"
				value="${requestScope.fromPrice}" /> <span> 到</span> <input
				type="text" name="toPrice" maxlength="7"
				class="search-query input-small" value="${requestScope.toPrice}" />
			<span> 基金产品状态:</span> <select name="fundStatus"
				class="search-query span2">
				<option value="">==请选择==</option>
				<option value="Y"
					<%if (request.getAttribute("fundStatus") != null
					&& ((String) request.getAttribute("fundStatus"))
							.equals("Y"))
				out.println("selected");%>>
					可交易</option>
				<option value="N"
					<%if (request.getAttribute("fundStatus") != null
					&& ((String) request.getAttribute("fundStatus"))
							.equals("N"))
				out.println("selected");%>>
					未上市交易</option>
			</select> <span> 基金创建时间：从</span> <input type="text" name="fromDate"
				class="search-query span2"
				onFocus="WdatePicker({isShowClear:false,readOnly:true})"
				value="${requestScope.fromDate}" /> <span> 到</span> <input
				type="text" name="toDate" class="search-query span2"
				onFocus="WdatePicker({isShowClear:false,readOnly:true})"
				value="${requestScope.toDate}" />
			<button type="submit" class="search-query btn btn-primary">查询</button>
		</form>
	</div>
	<jsp:useBean id="pageBean" class="edu.fzu.openfund.util.PageBean"
		scope="request"></jsp:useBean>
	<table class="table table-hover table-bordered table-striped">
		<thead>
			<th>基金编号</th>
			<th>基金产品名称</th>
			<th>基金产品价格</th>
			<th>基金产品状态</th>
			<th>基金产品创建时间</th>
			<th>操作</th>
			<!-- 		</thead> -->
			<s:iterator var="fund" value="#request.pageBean.data">
				<tr id="f<s:property value='#fund.fundNo'/>">
					<td><s:property value="#fund.fundNo" /></td>
					<td><s:property value="#fund.fundName" /></td>
					<td><s:property value="#fund.fundPrice" /></td>
					<td><s:if test='#fund.fundStatus=="Y"'>可交易</s:if> <s:if
							test='#fund.fundStatus=="N"'>未上市交易</s:if></td>
					<td><s:property value="#fund.fundCreateDate" /></td>
					<td><a
						href="fund/deleteFund.action?fundNo=<s:property value='#fund.fundNo'/>"
						class="btn btn-danger">删除</a>
						<button id="modify" class="btn btn-warning"
							onclick="getFund(<s:property value='#fund.fundNo'/>)">修改</button></td>
				</tr>
			</s:iterator>
	</table>
	<%
		if (pageBean.maxPage != 1) {
	%>
	<form name="PageForm" action="fund/showFund.action" method="post">
		<%@ include file="/page.jsp"%>
		<input type="hidden" name="fundName" value="${requestScope.fundName}" />
		<input type="hidden" name="fromPrice"
			value="${requestScope.fromPrice}" /> <input type="hidden"
			name="toPrice" value="${requestScope.toPrice}" /> <input
			type="hidden" name="fundStatus" value="${requestScope.fundStatus}" />
		<input type="hidden" name="fromDate" value="${requestScope.fromDate}" />
		<input type="hidden" name="toDate" value="${requestScope.toDate}" />
	</form>
	<%
		}
	%>


</body>
</html>
