package kr.co.woozl.logistics.purchase.dao;

import java.util.List;

import kr.co.woozl.logistics.purchase.to.OrderDetailTO;
import kr.co.woozl.logistics.purchase.to.OrderGatheringTO;


public interface OrderDetailDAO {

	public List<OrderDetailTO> selectOrderDetailList();

	public List<OrderGatheringTO> selectOrderGatheringList();

	public void insertOrderDetail(OrderDetailTO orderDetailTO);

	public void updateOrderDetail(OrderDetailTO orderDetailTO);

}
