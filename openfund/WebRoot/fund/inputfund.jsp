<%@ page language="java" import="java.util.*,edu.fzu.openfund.domain.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
		<title>新增基金产品</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	</head>
	<body>
		<script type="text/javascript">
    	function validata()
    	{
	    	var fundName = document.forms[0].fundName.value;
	    	var fundPrice = document.forms[0].fundPrice.value;
	    	var fundDes = document.forms[0].fundDes.value;
	    	var fundStatus = document.forms[0].fundStatus.value;
	    	
	    	if (fundName.length <= 0)
	    	{
	    		alert("基金产品名称不能为空，请输入基金产品名称");
	    		return false;
	    	}
	    	else if (isNaN(fundPrice) || ((fundPrice.length > 0) && (parseFloat(fundPrice) < 0 || parseFloat(fundPrice) > 9999.99)))
	    	{
	    		alert("请输入合法价格，范围为0~9999.99内的数值");
	    		return false;
	    	}
	    	else if (fundPrice.length <= 0)
	    	{
	    		alert("未输入基金产品价格，请输入基金产品价格");
	    		return false;
	    	}
	    	else if (fundStatus.length <=0 )
	    	{
	    		alert("基金产品状态未选择，请选择基金产品状态");
	    		return false;
	    	}
	    	return true;
    	}
    </script>
		<form action="fund/createFund.action" method="post" id="form"
			onsubmit="return validata()" class="form-horizontal">
			<div class="control-group">
				<legend>
					<span  class="controls">
					新增基金产品
					</span>
				</legend>
			</div>
			<div class="control-group">
				<label class="control-label" for="fundName">
					基金产品名称:
				</label>
				<div class="controls">
					<!--  input type="text" name="fundName" id="fundName" /> -->
					<s:textfield name="fund.fundName" id="fundName"/>
					<span style="color: red; font-size: 17;">&nbsp;*</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="fundPrice">
					基金产品价格:
				</label>
				<div class="controls">
					<!--  <input type="text" name="fund.fundPrice" id="fundPrice" />  -->
					<s:textfield name="fund.fundPrice" id="fundPrice"/>
					<span style="color: red; font-size: 17;">&nbsp;*</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="fundDes">
					基金产品描述:
				</label>
				<div class="controls">
					<!--  <input type="text" name="fundDes" id="fundDes" /> -->
					<s:textfield name="fund.fundDes"  id="fundDes"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="fundStatus">
					基金产品状态:
				</label>
				<div class="controls">
				<!-- 
				    <select name="fundStatus" id="fundStatus" class="input-medium">
						<option value="">
							==请选择==
						</option>
						<option value="Y">
							可交易
						</option>
						<option value="N">
							未上市交易
						</option>
					</select>
					 -->
					<s:select class="input-medium"  id="fundStatus" name="fund.fundStatus" 
					list="#{'Y':'可交易','N':'未上市交易'}">
					</s:select>
					<span style="color: red; font-size: 17;">&nbsp;*</span>
				</div>
			</div>
			<div class="control-group controls">
				<button type="submit" class="btn btn-primary">
					添加
				</button>
			</div>
		</form>
	</body>
</html>
