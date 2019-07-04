package kr.co.woozl.logistics.production.to;

import kr.co.woozl.common.annotation.Dataset;
import kr.co.woozl.common.to.BaseTO;

@Dataset(name="gds_materialCheckTemp")
public class MaterialCheckTempTO extends BaseTO{

	String itemCode, itemName, stocktaking, safetyStocktaking, 
	stockStatus, safetyStockStatus, necessaryAmount;

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

	public String getStocktaking() {
		return stocktaking;
	}

	public void setStocktaking(String stocktaking) {
		this.stocktaking = stocktaking;
	}

	public String getSafetyStocktaking() {
		return safetyStocktaking;
	}

	public void setSafetyStocktaking(String safetyStocktaking) {
		this.safetyStocktaking = safetyStocktaking;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getSafetyStockStatus() {
		return safetyStockStatus;
	}

	public void setSafetyStockStatus(String safetyStockStatus) {
		this.safetyStockStatus = safetyStockStatus;
	}

	public String getNecessaryAmount() {
		return necessaryAmount;
	}

	public void setNecessaryAmount(String necessaryAmount) {
		this.necessaryAmount = necessaryAmount;
	}
	
}
