package kr.co.woozl.logistics.purchase.dao;

import java.util.List;

import kr.co.woozl.logistics.purchase.to.MaterialPaymentTO;

public interface MaterialPaymentDAO {

	public List<MaterialPaymentTO> selectMaterialPaymentList();

	public void insertMaterialPayment(MaterialPaymentTO materialPaymentTO);


}
