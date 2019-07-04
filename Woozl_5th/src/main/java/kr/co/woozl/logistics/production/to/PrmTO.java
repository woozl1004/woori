package kr.co.woozl.logistics.production.to;

import kr.co.woozl.common.annotation.Dataset;
import kr.co.woozl.common.to.BaseTO;

@Dataset(name="gds_prm")
public class PrmTO extends BaseTO{

	String productionResultNo, workInstructionNo,
	productionDate, productionAmount, itemCode,
	itemName, unitOfProductionResult, description;

	public String getProductionResultNo() {
		return productionResultNo;
	}

	public void setProductionResultNo(String productionResultNo) {
		this.productionResultNo = productionResultNo;
	}

	public String getWorkInstructionNo() {
		return workInstructionNo;
	}

	public void setWorkInstructionNo(String workInstructionNo) {
		this.workInstructionNo = workInstructionNo;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getProductionAmount() {
		return productionAmount;
	}

	public void setProductionAmount(String productionAmount) {
		this.productionAmount = productionAmount;
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

	public String getUnitOfProductionResult() {
		return unitOfProductionResult;
	}

	public void setUnitOfProductionResult(String unitOfProductionResult) {
		this.unitOfProductionResult = unitOfProductionResult;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}




}
