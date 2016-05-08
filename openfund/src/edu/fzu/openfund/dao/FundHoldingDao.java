package edu.fzu.openfund.dao;

import java.util.List;
import edu.fzu.openfund.domain.FundHolding;

public interface FundHoldingDao extends BaseHibDao<FundHolding> {
	/**
	 * 根据账户编号、基金编号查询持仓情况
	 * 
	 * @param accNo
	 *            账户编号
	 * @param fundNo
	 *            基金编号
	 * @return 对应的持仓对象
	 */
	FundHolding findFundHolding(int accNo, int fundNo);
	public long getSize(int accNo);
	/**
	 * 根据账户编号、页码和每页显示的记录数分页查询持仓情况
	 * 
	 * @param pageNo
	 *            页码
	 * @param accNo
	 *            账户编号
	 * @param pageSize
	 *            每页显示的记录数
	 * @return 分页持仓情况
	 */
	List findHoldingsByAccPage(int accNo, int pageNo, int pageSize);

	/**
	 * 根据页码和每页显示的记录数分页查询持仓情况
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页显示的记录数
	 * @return 分页持仓情况
	 */
	List findHoldingsByPage(int pageNo, int pageSize);
}
