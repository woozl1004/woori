package kr.co.woozl.logistics.purchase.sf;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.woozl.logistics.production.to.MrpGatheringTO;
import kr.co.woozl.logistics.purchase.applicationService.PurchaseApplicationService;
import kr.co.woozl.logistics.purchase.to.BomDeployTO;
import kr.co.woozl.logistics.purchase.to.BomTO;
import kr.co.woozl.logistics.purchase.to.ItemTO;
import kr.co.woozl.logistics.purchase.to.MaterialPaymentTO;
import kr.co.woozl.logistics.purchase.to.OrderDetailTO;
import kr.co.woozl.logistics.purchase.to.OrderGatheringTO;
import kr.co.woozl.logistics.purchase.to.OrderInfoTO;
import kr.co.woozl.logistics.purchase.to.StockTO;
import kr.co.woozl.logistics.purchase.to.WarehousingTO;

@Service
public class PurchaseServiceFacadeImpl implements PurchaseServiceFacade{

	@Autowired
	private PurchaseApplicationService purchaseApplicationService;


	@Override
	public List<ItemTO> findItemList() {

		return purchaseApplicationService.findItemList();
	}

	@Override
	public List<ItemTO> batchItem(List<ItemTO> itemList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BomTO> findBomList() {
		// TODO Auto-generated method stub
		return purchaseApplicationService.findBomList();
	}
	
	@Override
	public void batchBom(List<BomTO> bomList) {
		// TODO Auto-generated method stub
		purchaseApplicationService.batchBom(bomList);
	}
	

	@Override
	public List<BomDeployTO> findBomDeployList(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return purchaseApplicationService.findBomDeployList(map);
	}

	@Override
	public List<OrderInfoTO> findOrderInfoList() {
		// TODO Auto-generated method stub
		return purchaseApplicationService.findOrderInfoList();
	}

	@Override
	public List<OrderDetailTO> findOrderDetailList() {
		// TODO Auto-generated method stub
		return purchaseApplicationService.findOrderDetailList();
	}

	@Override
	public void registerOrder(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList,
			List<MrpGatheringTO> mrpGatheringList) {
		// TODO Auto-generated method stub
	purchaseApplicationService.registerOrder(orderInfoList,orderDetailList,mrpGatheringList);
	}

	@Override
	public List<OrderGatheringTO> findOrderGatheringList() {
		// TODO Auto-generated method stub
		return purchaseApplicationService.findOrderGatheringList();
	}

	@Override
	public List<StockTO> findStockList() {
		// TODO Auto-generated method stub
		return purchaseApplicationService.findStockList();
	}

	@Override
	public void bathStock(List<StockTO> stockList) {
		// TODO Auto-generated method stub
		purchaseApplicationService.bathStock(stockList);
	}

	@Override
	public List<MaterialPaymentTO> findMaterialPaymentList() {
		// TODO Auto-generated method stub
		return purchaseApplicationService.findMaterialPaymentList();
	}

	@Override
	public void registMaterialPayment(List<MaterialPaymentTO> materialPaymentList) {
		// TODO Auto-generated method stub
		purchaseApplicationService.registMaterialPayment(materialPaymentList);
	}

	@Override
	public List<WarehousingTO> findWarehousingList() {
		// TODO Auto-generated method stub
		return purchaseApplicationService.findWarehousingList();
	}


	@Override
	public void registWarehousing(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList,
			List<StockTO> stockList, List<WarehousingTO> warehousingList) {
		// TODO Auto-generated method stub
		purchaseApplicationService.registWarehousing(orderInfoList,orderDetailList,stockList,warehousingList);
	}

	@Override
	public List<BomDeployTO> findBomDeployList2(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return purchaseApplicationService.findBomDeployList2(map);
	}

}
