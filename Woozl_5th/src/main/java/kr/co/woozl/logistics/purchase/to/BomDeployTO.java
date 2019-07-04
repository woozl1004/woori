package kr.co.woozl.logistics.purchase.to;

import kr.co.woozl.common.annotation.Dataset;
import kr.co.woozl.common.to.BaseTO;

@Dataset(name="gds_bomDeploy")
public class BomDeployTO extends BaseTO{

	String itemCode, itemName, parentItemCode, parentItemName, 
	unitOfStock, lossRate, leadTime, standardUnitPrice, itemClassification, netAmount;

	public String getItemClassification() {
		return itemClassification;
	}

	public void setItemClassification(String itemClassification) {
		this.itemClassification = itemClassification;
	}

	public String getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getParentItemCode() {
		return parentItemCode;
	}

	public void setParentItemCode(String parentItemCode) {
		this.parentItemCode = parentItemCode;
	}

	public String getParentItemName() {
		return parentItemName;
	}

	public void setParentItemName(String parentItemName) {
		this.parentItemName = parentItemName;
	}

	public String getUnitOfStock() {
		return unitOfStock;
	}

	public void setUnitOfStock(String unitOfStock) {
		this.unitOfStock = unitOfStock;
	}

	public String getLossRate() {
		return lossRate;
	}

	public void setLossRate(String lossRate) {
		this.lossRate = lossRate;
	}

	public String getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}

	public String getStandardUnitPrice() {
		return standardUnitPrice;
	}

	public void setStandardUnitPrice(String standardUnitPrice) {
		this.standardUnitPrice = standardUnitPrice;
	}



}
