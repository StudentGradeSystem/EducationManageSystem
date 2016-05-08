<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>退出登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body  onload="exit()">
  <%
  session.removeAttribute("isLogin");
  session.removeAttribute("user");
  session.invalidate();
  %> 
  <script>
  	function exit(){
  	alert("成功退出系统");
  	window.location.assign("login.jsp");
  	}
  </script>
  </body>
</html>
