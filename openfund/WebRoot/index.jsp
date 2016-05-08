<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>欢迎来到建设银行开放式基金交易平台！</title>
		<script language="javascript">
	function callStatus(){ 
		var title="欢迎来到本站点！";
		
			//for(var i=1;i<=title.length;i++){
				var i=1;
				intervalID= window.setInterval(function(){ //间隔n时间执行function（）函数
					var title1=title.substr(0,i);	
					window.status=title1
					var date = new Date();
					var timeStr=date.toLocaleString();
						window.status=title1+"        "+timeStr;
					
						i++;
						if(i==9)
						i=1;
				},3000);
				
		
		
	}
	callStatus();
</script>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	<frameset cols="*,1360,*" border="0" frameSpacing="0" frameBorder="0">
	<frame src="about:blank"></frame>
	<FRAMESET frameSpacing="0" rows="80,*" style="width:1360;">
		<frame name=top src="index/top.jsp" frameBorder=0 noResize
			scrolling=no>
		<FRAMESET frameSpacing="0" cols="165,*">
			<FRAME name=menu src="index/left.jsp" frameBorder=0 noResize>
			<FRAME name=dmMain src="index/right.jsp" frameBorder=0  scrolling="no">
		</FRAMESET>
	</FRAMESET>
	<frame src="index/index.jsp"></frame>
	</frameset>
</html>
