package kr.co.woozl.logistics.purchase.dao;

import java.util.List;

import kr.co.woozl.logistics.purchase.to.ItemTO;

public interface ItemDAO {

	List<ItemTO> selectItemList();
	
}
