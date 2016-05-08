package edu.fzu.openfund.service;

import edu.fzu.openfund.util.PageBean;

public interface FundTransService {
	/**
	 * 根据基金编号、数量、价格、账户编号、账户密码完成购买基金
	 * 
	 * @param fundNo
	 *            基金编号
	 * @param amount
	 *            购买数量
	 * @param price
	 *            买入价
	 * @param accNo
	 *            账户编号
	 * @param accPwd
	 *            账户密码
	 * @return 购买状态，有4种情况： 1-账户不存在或密码不对，失败; 2-账户属于冻结状态，失败; 3-账户余额不够，失败;0-购买成功。
	 */
	int buyFund(int fundNo, int amount, double price, int accNo, String accPwd);

	/**
	 * 根据账户编号、页码返回分页持仓情况
	 * 
	 * @param accNo
	 *            账户编号
	 * @param pageNo
	 *            页码
	 * @return 分页持仓信息。
	 */
	PageBean getFundHolding(int accNo, int pageNo);
}
