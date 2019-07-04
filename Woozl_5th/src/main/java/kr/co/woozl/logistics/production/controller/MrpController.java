package kr.co.woozl.logistics.production.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.woozl.common.mapper.DatasetBeanMapper;
import kr.co.woozl.logistics.production.sf.ProductionServiceFacade;
import kr.co.woozl.logistics.production.to.MpsTO;
import kr.co.woozl.logistics.production.to.MrpGatheringTO;
import kr.co.woozl.logistics.production.to.MrpGatheringTO2;
import kr.co.woozl.logistics.production.to.MrpOpenTempTO;
import kr.co.woozl.logistics.production.to.MrpTO;

@Controller
public class MrpController  {

	@Autowired
	private ProductionServiceFacade productionServiceFacade;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("logistics/production/findMrpList.do")
	public void findMrpList (HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<MrpTO> mrpList = productionServiceFacade.findMrpList();

		datasetBeanMapper.beansToDataset(outData, mrpList, MrpTO.class);


	}


	@RequestMapping("logistics/production/findMrpGatheringList.do")
	public void findMrpGatheringList (HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData outData = (PlatformData) request.getAttribute("outData");
		
		List<MrpGatheringTO> mrpGatheringList = productionServiceFacade.findMrpGatheringList();

		datasetBeanMapper.beansToDataset(outData, mrpGatheringList, MrpGatheringTO.class);


	}


	@RequestMapping("logistics/production/findMrpOpenTempProcessList2.do")
	public void findMrpOpenTempProcessList2(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData inData = (PlatformData) request.getAttribute("inData");
		PlatformData outData = (PlatformData) request.getAttribute("outData");
	
		HashMap<String, Object> paramMap = new HashMap<>();
		
		List<MpsTO> mpsArray = datasetBeanMapper.datasetToBeans(inData, MpsTO.class);
		
		int flag=0;
		   for(MpsTO mp :mpsArray){
		      flag++;
		   }
		   String[] mpsNo=new String[flag];
		   int index=0;
		   for(MpsTO mpt :mpsArray){
		      System.out.println(mpt.getMpsNo());
		      mpsNo[index]=(String)mpt.getMpsNo();
		      index++;
		      System.out.println(index+"uuu"+mpsNo[index-1]);
		   }

		paramMap.put("paramArray", mpsNo);

		productionServiceFacade.findMrpOpenTempProcessList(paramMap);

		List<MrpOpenTempTO> mrpOpenTempList=(List<MrpOpenTempTO>)paramMap.get("result");
		
		datasetBeanMapper.beansToDataset(outData, mrpOpenTempList, MrpOpenTempTO.class);

	}



	@RequestMapping("logistics/production/bathMrpGathering.do")
	public void bathMrpGathering(HttpServletRequest request, HttpServletResponse response) throws Exception{

		PlatformData inData = (PlatformData) request.getAttribute("inData");
		
		List<MrpGatheringTO> mrpGatheringList = datasetBeanMapper.datasetToBeans(inData, MrpGatheringTO.class);

		productionServiceFacade.bathMrpGathering(mrpGatheringList);

		findMrpList(request, response);
		findMrpGatheringList(request, response);

	}


	@RequestMapping("logistics/production/findMrpGatheringList2.do")
	public void findMrpGatheringList2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 PlatformData inData = (PlatformData) request.getAttribute("inData");
		 
		 PlatformData outData = (PlatformData) request.getAttribute("outData");
		
	      List<MrpTO> mrpList = datasetBeanMapper.datasetToBeans(inData, MrpTO.class);

	      List<MrpGatheringTO2> mrpGatheringList = productionServiceFacade.findMrpGatheringList2(mrpList);

	      datasetBeanMapper.beansToDataset(outData, mrpGatheringList, MrpGatheringTO2.class);

	}

	@RequestMapping("logistics/production/registMrpGathering.do")
	public void registMrpGathering(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 PlatformData inData = (PlatformData) request.getAttribute("inData");
		 
		 PlatformData outData = (PlatformData) request.getAttribute("outData");
		 
		HashMap<String, Object> paramMap = new HashMap<>();
		
		List<MrpTO> mrpArray = datasetBeanMapper.datasetToBeans(inData, MrpTO.class);
		
		int flag=0;
		String mpsn="a";
		   for(MrpTO mr :mrpArray){
			   if(!(mpsn).equals(mr.getMpsNo())) {
				    mpsn=mr.getMpsNo();
				    flag++;
			   }
		   }
		   String[] mpsNo=new String[flag];
		   int index=0;
		   for(MrpTO mrp :mrpArray){
			   System.out.println(mrp.getMpsNo());
			   if(index==0) {
				   mpsNo[index]=(String)mrp.getMpsNo();
				   	index++; 
			   }
		   if(index!=0) {
			   if(!(mpsNo[index-1]).equals(mrp.getMpsNo())) {
				   mpsNo[index]=(String)mrp.getMpsNo();
				   index++;
			   }else {
				   System.out.println("진입실패");
			   }
		   }
		  }

		paramMap.put("mpsNo", mpsNo);

		productionServiceFacade.registMrpGathering(paramMap);
		
		List<MrpGatheringTO> mrpOpenTempList=(List<MrpGatheringTO>)paramMap.get("result");
		
		datasetBeanMapper.beansToDataset(outData, mrpOpenTempList, MrpGatheringTO.class);

	}



}
