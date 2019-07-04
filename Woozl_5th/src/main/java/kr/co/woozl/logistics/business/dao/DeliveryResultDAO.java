package kr.co.woozl.logistics.business.dao;

import java.util.List;

import kr.co.woozl.logistics.business.to.DeliveryResultTO;

public interface DeliveryResultDAO {

	public List<DeliveryResultTO> selectDeliveryResultList();

	public void insertDeliveryResult(DeliveryResultTO selectDeliveryTO);


}
