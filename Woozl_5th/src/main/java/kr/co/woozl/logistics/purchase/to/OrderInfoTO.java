package kr.co.woozl.logistics.purchase.to;

import kr.co.woozl.common.annotation.Dataset;
import kr.co.woozl.common.to.BaseTO;

@Dataset(name="gds_orderInfo")
public class OrderInfoTO extends BaseTO{


	String orderNo, customerCode, orderDate,
	personCodeInCharge, description, orderInfoStatus;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getPersonCodeInCharge() {
		return personCodeInCharge;
	}

	public void setPersonCodeInCharge(String personCodeInCharge) {
		this.personCodeInCharge = personCodeInCharge;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderInfoStatus() {
		return orderInfoStatus;
	}

	public void setOrderInfoStatus(String orderInfoStatus) {
		this.orderInfoStatus = orderInfoStatus;
	}






}
