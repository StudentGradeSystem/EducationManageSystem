<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head id="Head1">
		<style type="text/css">
BODY {
	FONT-SIZE: 12px;
	COLOR: #ffffff;
	FONT-FAMILY: 宋体
}

TD {
	FONT-SIZE: 12px;
	COLOR: #ffffff;
	FONT-FAMILY: 宋体
}
</style>

		<meta content="MSHTML 6.00.6000.16809" name="GENERATOR">
		<script language="javascript" type="text/javascript">
                function validata()
                {
                	var adminname = document.getElementById("adminname");
                	var adminpwd = document.getElementById("adminpwd");
					var inputname = document.getElementById("inputname");
					var inputpwd = document.getElementById("inputpwd");
					var allinput = true;
					if (!adminname.value || adminname.value == "")
					{
						allinput = false;
						inputname.style.visibility = "visible";
					}
					else
					{
						inputname.style.visibility = "hidden";
					}
					if (!adminpwd.value || adminpwd.value == "")
					{
						allinput = false;
						inputpwd.style.visibility = "visible";
					}
					else
					{
						inputpwd.style.visibility = "hidden";
					}
					if (allinput == true)
					{ 
						var form1 = document.getElementById("form1");
						var name = document.getElementById("name");
						var pwd = document.getElementById("pwd");
						name.value = adminname.value;
						pwd.value = adminpwd.value;
						form1.submit();
						return true
					}
					return false;
                }
       	</script>
       	<title>请登录</title>
	</head>
	<body>
		<form id="form1" action="login.action" method="post">
			<div>
				<input id="name" type="hidden" name="name">
				<input id="pwd" type="hidden" name="pwd">
			</div>
			<div id="UpdatePanel1">
				<div id="div1"
					style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></div>
				<div id="div2"
					style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></div>
				<script language="JavaScript" type="text/javascript"> 
					var speed=20;
					var temp=new Array(); 
					var clipright=document.body.clientWidth/2,clipleft=0 
					for (i=1;i<=2;i++){ 
						temp[i]=eval("document.all.div"+i+".style");
						temp[i].width=document.body.clientWidth/2;
						temp[i].height=document.body.clientHeight;
						temp[i].left=(i-1)*parseInt(temp[i].width);
					} 
					function openit(){ 
						clipright-=speed;
						temp[1].clip="rect(0 "+clipright+" auto 0)";
						clipleft+=speed;
						temp[2].clip="rect(0 auto auto "+clipleft+")";
						if (clipright<=0)
							clearInterval(tim);
					} 
					tim=setInterval("openit()",100);
                </script>

				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					<table cellSpacing="0" cellPadding="0" width="900" align="center"
						border="0">
						<tbody>
							<tr>
								<td style="HEIGHT: 105px">
									<img src="img/login/login_1.gif" border=0"" alt="" width="900" height="105">
								</td>
							</tr>
							<tr>
								<td background="img/login/login_2.jpg" height="300">
									<table height="300" cellPadding="0" width="900" border="0">
										<tbody>
											<tr>
												<td colSpan="2" height="35"></td>
											</tr>
											<tr>
												<td width="360"></td>
												<td>
													<table cellSpacing="0" cellPadding="2" border="0">
														<tbody>
															<tr>
																<td style="HEIGHT: 28px" width="80">
																	登 录 名：
																</td>
																<td style="HEIGHT: 28px" width="150">
																	<input id="adminname" style="WIDTH: 130px" type="text">
																</td>
																<td style="HEIGHT: 28px" width="370">
																	<span id="inputname"
																		style="FONT-WEIGHT: bold; visibility: hidden; COLOR: white">请输入登录名</span>
																</td>
															</tr>
															<tr>
																<td style="HEIGHT: 28px">
																	登录密码：
																</td>
																<td style="HEIGHT: 28px">
																	<input id="adminpwd" style="WIDTH: 130px"
																		type="password">
																</td>
																<td style="HEIGHT: 28px">
																	<span id="inputpwd"
																		style="FONT-WEIGHT: bold; visibility: hidden; COLOR: white">请输入密码</span>
																</td>
															</tr>
															<tr>
																<td style="HEIGHT: 18px"></td>
																<td style="HEIGHT: 18px"></td>
																<td style="HEIGHT: 18px"></td>
															</tr>
															<tr>
																<td></td>
																<td>
																	<input id="btn"
																		style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
																		onclick='return validata()' type="image"
																		src="img/login/login_button.gif" name="btn">

																</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<img src="img/login/login_3.jpg" border="0" alt="">
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</body>
</HTML>
