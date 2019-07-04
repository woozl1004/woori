package kr.co.woozl.logistics.business.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.common.mapper.DatasetBeanMapper;
import kr.co.woozl.logistics.business.sf.BusinessServiceFacade;
import kr.co.woozl.logistics.business.to.CustomerTO;

@Controller
public class CustomerController  {

	@Autowired
	private BusinessServiceFacade businessServiceFacade;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("logistics/business/findCustomerList.do")
	public void findCustomerList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData outData = (PlatformData) request.getAttribute("outData");

		List<CustomerTO> customerList = businessServiceFacade.findCustomerList();
		
		datasetBeanMapper.beansToDataset(outData, customerList, CustomerTO.class);
		
	}
	
	@RequestMapping("logistics/business/batchCustomer.do")
	public void batchCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<CustomerTO> customer = datasetBeanMapper.datasetToBeans(inData, CustomerTO.class); 
		
		businessServiceFacade.batchCustomer(customer);
		
		findCustomerList(request, response);
		
	}
	
}
