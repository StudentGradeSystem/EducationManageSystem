<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<HEAD id=Head1>
		<base href="<%=basePath%>">

		<title>My JSP 'YHChannelApply.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


		<META http-equiv=Content-Type content="text/html; charset=utf-8">
		<LINK href="css/right/Style.css" type=text/css rel=stylesheet>
		<LINK href="css/right/Manage.css" type=text/css rel=stylesheet>
		<!--  <SCRIPT language=javascript src="try/right/FrameDiv.js"></SCRIPT>

		<SCRIPT language=javascript src="try/right/Common.js"></SCRIPT>-->

		<SCRIPT language=javascript>
        function selectallbox()
        {
            var list = document.getElementsByName('setlist');
            var listAllValue='';
             if(document.getElementById('checkAll').checked)
             {
                  for(var i=0;i<list.length;i++)
                  {
                    list[i].checked = true;
                    if(listAllValue=='')
                        listAllValue=list[i].value;
                    else
                        listAllValue = listAllValue + ',' + list[i].value;
                  }
                  document.getElementById('boxListValue').value=listAllValue;
             }
             else 
             {
                  for(var i=0;i<list.length;i++)
                  {
                    list[i].checked = false;
                  }
                  document.getElementById('boxListValue').value='';
             }
         } 
    </SCRIPT>

		<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
	</HEAD>
	<BODY>
		<FORM id=form1 name=form1
			method=post>
			<SCRIPT type=text/javascript>
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</SCRIPT>

			<TABLE cellSpacing=0 cellPadding=0 width="101%" border=0>
				<TBODY>
					<TR>
						<TD width=15>
							<IMG src="img/right/new_019.jpg" border=0>
						</TD>
						<TD width="100%" background=img/right/new_020.jpg height=20></TD>
						<TD width=15>
							<IMG src="img/right/new_021.jpg" border=0>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="101%" height="100%"
				border=0>
				<TBODY>
					<TR>
						<TD width=15 background=img/right/new_022.jpg>
							<IMG src="img/right/new_022.jpg" border=0>
						</TD>
						<TD vAlign=top width="960" height="500" bgColor=#ffffff>
							
							<div>
								<iframe src="index/iframe_background.jsp" name="contentFrame"
									height="100%" width="100%" scrolling="yes"></iframe>

							</div>
						</TD>
						<TD width=15 background=img/right/new_023.jpg>
							<IMG src="img/right/new_023.jpg" border=0>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD width=15>
							<IMG src="img/right/new_024.jpg" border=0>
						</TD>
						<TD align=middle width="100%" background=img/right/new_025.jpg
							height=15></TD>
						<TD width=15>
							<IMG src="img/right/new_026.jpg" border=0>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</FORM>
	</BODY>
</HTML>

