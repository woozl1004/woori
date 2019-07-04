package kr.co.woozl.logistics.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.common.mapper.DatasetBeanMapper;
import kr.co.woozl.logistics.base.sf.ManagementServiceFacade;
import kr.co.woozl.logistics.base.to.PositionTO;

@Controller
public class PositionController  {

	@Autowired
	private ManagementServiceFacade managementServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("logistics/base/findPositionList.do")
	public void findPositionList(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<PositionTO> positionList = managementServiceFacade.findPositionList();

		datasetBeanMapper.beansToDataset(outData, positionList, PositionTO.class);

	}



}
