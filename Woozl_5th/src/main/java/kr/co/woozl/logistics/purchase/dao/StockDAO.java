package kr.co.woozl.logistics.purchase.dao;

import java.util.List;

import kr.co.woozl.logistics.purchase.to.StockTO;

public interface StockDAO {

	public List<StockTO> selectStockList();

	public void insertStock(StockTO stockTO);

	public void updateStock(StockTO stockTO);

	public void deleteStock(StockTO stockTO);

}
