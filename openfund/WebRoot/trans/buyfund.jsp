<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>购买基金</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script language="javascript" type="text/javascript"
	src="js/jquery-1.11.3.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery-ui.js"></script>

<script type="text/javascript">
	function getPrice() {
		var fundNo = $("#fundNo").val();
		$.ajax({
			type : "POST", //提交方式
			url : "ajax/findPrice.action", //提交地址
			data : { //提交数据
				"fundNo" : fundNo
			},
			async : true, //异步
			success : function(data) {
				$("#price").val(data.toFixed(2));
			}
		});
	}
	$(document).ready(function() {
		getPrice();
	});
</script>
</head>
<body>
	<s:action name="findAllFunds" namespace="/fund"></s:action>
	<s:form action="trans/buyFund.action" method="post"
		class="form-horizontal">
		<div class="control-group">
			<legend>
				<span class="controls"> 购买基金 </span>
			</legend>
		</div>

		<div>
			<s:actionerror style="color:red" />
		</div>

		<div class="control-group">
			<label class="control-label"> 基金名称： </label>
			<div class="controls">
				<s:select name="fundNo" id="fundNo" onchange="getPrice()"
					list="#request.funds" listKey="fundNo" listValue="fundName" />
				<span style="color: red; font-size: 17;">&nbsp;*</span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label"> 基金价格： </label>
			<div class="controls">
				<s:textfield readOnly="true" name="price" id="price" />
				<span style="color: red; font-size: 17;">&nbsp;*</span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label"> 购买数量： </label>
			<div class="controls">
				<s:textfield name="amount" id="amount" />
				<span style="color: red; font-size: 17;">&nbsp;*</span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label"> 资金账号： </label>
			<div class="controls">
				<s:textfield name="accNo" id="accNo" />
				<span style="color: red; font-size: 17;">&nbsp;*</span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label"> 资金账号密码 </label>
			<div class="controls">
				<s:password name="accPwd" id="accPwd" />
				<span style="color: red; font-size: 17;">&nbsp;*</span>
			</div>
		</div>

		<div class="control-group controls">
			<button type="submit" class="btn btn-primary">购买</button>
			<button type="reset" class="btn btn-primary">取消</button>
		</div>


	</s:form>
</body>
</html>
