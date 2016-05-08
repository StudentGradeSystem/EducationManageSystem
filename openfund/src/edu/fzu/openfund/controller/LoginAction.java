package edu.fzu.openfund.controller;

import java.util.Map;

import javax.mail.Flags.Flag;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.fzu.openfund.service.AdminService;
import edu.fzu.openfund.service.AdminServiceImpl;

public class LoginAction extends ActionSupport {
	private AdminService adminService;
	private String name;
	private String pwd;
	public String login() throws Exception{
		adminService=new AdminServiceImpl();
		boolean flag=adminService.checkUser(name, pwd);
		if (flag) {
			Map session=ActionContext.getContext().getSession();
			session.put("user", name);
			return "success";
		}else {
			return "failure";
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}	
}
