package kr.co.woozl.logistics.purchase.applicationService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.woozl.logistics.production.applicationService.ProductionApplicationService;
import kr.co.woozl.logistics.production.to.MrpGatheringTO;
import kr.co.woozl.logistics.purchase.dao.BomDAO;
import kr.co.woozl.logistics.purchase.dao.ItemDAO;
import kr.co.woozl.logistics.purchase.dao.MaterialPaymentDAO;
import kr.co.woozl.logistics.purchase.dao.OrderDetailDAO;
import kr.co.woozl.logistics.purchase.dao.OrderInfoDAO;
import kr.co.woozl.logistics.purchase.dao.StockDAO;
import kr.co.woozl.logistics.purchase.dao.WarehousingDAO;
import kr.co.woozl.logistics.purchase.to.BomDeployTO;
import kr.co.woozl.logistics.purchase.to.BomTO;
import kr.co.woozl.logistics.purchase.to.ItemTO;
import kr.co.woozl.logistics.purchase.to.MaterialPaymentTO;
import kr.co.woozl.logistics.purchase.to.OrderDetailTO;
import kr.co.woozl.logistics.purchase.to.OrderGatheringTO;
import kr.co.woozl.logistics.purchase.to.OrderInfoTO;
import kr.co.woozl.logistics.purchase.to.StockTO;
import kr.co.woozl.logistics.purchase.to.WarehousingTO;

@Component
public class PurchaseApplicationServiceImpl implements PurchaseApplicationService{

	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private BomDAO bomDAO;
	
	@Autowired
	private OrderInfoDAO orderInfoDAO;
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Autowired
	private StockDAO stockDAO;
	
	@Autowired
	private MaterialPaymentDAO materialPaymentDAO;
	
	@Autowired
	private WarehousingDAO warehousingDAO;

	@Autowired
	private ProductionApplicationService productionApplicationService;


	@Override
	public List<ItemTO> findItemList() {
		// TODO Auto-generated method stub
		return itemDAO.selectItemList();
	}

	@Override
	public List<ItemTO> batchItem(List<ItemTO> itemList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BomTO> findBomList() {
		// TODO Auto-generated method stub
		return bomDAO.selectBomList();
	}
	
	@Override
	public void batchBom(List<BomTO> bomList) {
		// TODO Auto-generated method stub

		for(BomTO bomTO : bomList) {

			switch(bomTO.getStatus()) {
			case "insert" : bomDAO.insertBom(bomTO); break;
			case "update" : bomDAO.updateBom(bomTO); break;
			case "delete" : bomDAO.deleteBom(bomTO); break;

			}

		}
	}

	@Override
	public List<BomDeployTO> findBomDeployList(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return bomDAO.selectBomDeployList(map);
	}

	@Override
	public List<OrderInfoTO> findOrderInfoList() {
		// TODO Auto-generated method stub
		return orderInfoDAO.selectOrderInfoList();
	}

	@Override
	public List<OrderDetailTO> findOrderDetailList() {
		// TODO Auto-generated method stub
		return orderDetailDAO.selectOrderDetailList();
	}

	@Override
	public void registerOrder(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList,
			List<MrpGatheringTO> mrpGatheringList) {
		// TODO Auto-generated method stub

		for(OrderInfoTO orderInfoTO : orderInfoList) {

			switch(orderInfoTO.getStatus()) {
			case "insert" : orderInfoDAO.insertOrderInfo(orderInfoTO); break;
			case "update" : orderInfoDAO.updateOrderInfo(orderInfoTO); break;
			}
		}


		for(OrderDetailTO orderDetailTO : orderDetailList) {

			switch(orderDetailTO.getStatus()) {

			case "insert" : orderDetailDAO.insertOrderDetail(orderDetailTO); break;
			case "update" : orderDetailDAO.updateOrderDetail(orderDetailTO); break;
			}
		}

		if(mrpGatheringList!=null) {
		productionApplicationService.bathMrpGathering(mrpGatheringList);
		//productionApplicationService.findMrpGatheringList();
		}


	}

	@Override
	public List<OrderGatheringTO> findOrderGatheringList() {
		// TODO Auto-generated method stub

		return orderDetailDAO.selectOrderGatheringList();
	}

	@Override
	public List<StockTO> findStockList() {
		// TODO Auto-generated method stub
		return stockDAO.selectStockList();
	}

	@Override
	public void bathStock(List<StockTO> stockList) {
		// TODO Auto-generated method stub

		for(StockTO stockTO : stockList) {


			switch(stockTO.getStatus()) {
			case "insert" : stockDAO.insertStock(stockTO); break;
			case "update" : stockDAO.updateStock(stockTO); break;
			case "delete" : stockDAO.deleteStock(stockTO); break;

			}

		}
	}

	@Override
	public List<MaterialPaymentTO> findMaterialPaymentList() {
		// TODO Auto-generated method stub
		return materialPaymentDAO.selectMaterialPaymentList();
	}

	@Override
	public void registMaterialPayment(List<MaterialPaymentTO> materialPaymentList) {
		// TODO Auto-generated method stub

		for(MaterialPaymentTO materialPaymentTO : materialPaymentList) {


			switch(materialPaymentTO.getStatus()) {
			case "insert" : materialPaymentDAO.insertMaterialPayment(materialPaymentTO); break;
			//case "update" : materialPaymentDAO.updatematerialPayment(materialPaymentTO); break;
			//case "delete" : materialPaymentDAO.deletematerialPayment(materialPaymentTO); break;

			}

		}



	}

	@Override
	public List<WarehousingTO> findWarehousingList() {
		// TODO Auto-generated method stub
		return warehousingDAO.selectWarehousingList();
	}




	@Override
	public void registWarehousing(List<OrderInfoTO> orderInfoList, List<OrderDetailTO> orderDetailList,
			List<StockTO> stockList, List<WarehousingTO> warehousingList) {
		// TODO Auto-generated method stub


		if(orderInfoList!=null && orderDetailList!=null) {
		registerOrder(orderInfoList,orderDetailList,null);
		}

		if(stockList!=null) {
		bathStock(stockList);
		}

		for(WarehousingTO warehousingTO : warehousingList) {


			switch(warehousingTO.getStatus()) {
			case "insert" : warehousingDAO.insertWarehousing(warehousingTO); break;
			case "update" : warehousingDAO.updateWarehousing(warehousingTO); break;
			//case "delete" : warehousingDAO.deleteSWarehousing(warehousingTO); break;

			}

		}





	}

	@Override
	public List<BomDeployTO> findBomDeployList2(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return bomDAO.selectBomDeployList2(map);
	}

}
