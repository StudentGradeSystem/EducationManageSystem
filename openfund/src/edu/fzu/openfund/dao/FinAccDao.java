package edu.fzu.openfund.dao;

import edu.fzu.openfund.domain.FinAcc;

public interface FinAccDao extends BaseHibDao<FinAcc> {
	/**
	 * 根据账户编号查询账户信息
	 * 
	 * @param passwd
	 *            密码
	 * @param accNo
	 *            账户编号
	 * @return 该编号对应的账户信息
	 */
	FinAcc find(String passwd, int accNo);
}
