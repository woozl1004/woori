package kr.co.woozl.logistics.purchase.sf;

import java.util.List;
import java.util.Map;

import kr.co.woozl.logistics.production.to.MrpGatheringTO;
import kr.co.woozl.logistics.purchase.to.BomDeployTO;
import kr.co.woozl.logistics.purchase.to.BomTO;
import kr.co.woozl.logistics.purchase.to.ItemTO;
import kr.co.woozl.logistics.purchase.to.MaterialPaymentTO;
import kr.co.woozl.logistics.purchase.to.OrderDetailTO;
import kr.co.woozl.logistics.purchase.to.OrderGatheringTO;
import kr.co.woozl.logistics.purchase.to.OrderInfoTO;
import kr.co.woozl.logistics.purchase.to.StockTO;
import kr.co.woozl.logistics.purchase.to.WarehousingTO;

public interface PurchaseServiceFacade {

	public List<ItemTO> findItemList();

	public List<ItemTO> batchItem(List<ItemTO> itemList);

	public List<BomTO> findBomList();
	
	public void batchBom(List<BomTO> bomList);

	public List<BomDeployTO> findBomDeployList(Map<String,Object> map);
	
	public List<BomDeployTO> findBomDeployList2(Map<String,Object> map);

	public List<OrderInfoTO> findOrderInfoList();

	public List<OrderDetailTO> findOrderDetailList();

	public List<OrderGatheringTO> findOrderGatheringList();

	public void registerOrder(List<OrderInfoTO> orderInfoList,List<OrderDetailTO> orderDetailList,List<MrpGatheringTO> mrpGatheringList);

	public List<StockTO> findStockList();

	public void bathStock(List<StockTO> stockList);

	public List<MaterialPaymentTO> findMaterialPaymentList();

	public void registMaterialPayment(List<MaterialPaymentTO> WarehousingList);

	public List<WarehousingTO> findWarehousingList();

	public void registWarehousing(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList, List<StockTO> stockList,List<WarehousingTO> warehousingList);


}
