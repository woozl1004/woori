package kr.co.woozl.base.applicationService;

import java.util.List;
import java.util.Map;

import kr.co.woozl.base.to.CodeDetailTO;
import kr.co.woozl.base.to.CodeTO;
import kr.co.woozl.base.to.MenuTO;

public interface BaseApplicationService {

	public List<CodeTO> findCodeList();
	// 코드리스트 조회
	
	public List<CodeDetailTO> findCodeDetailList();
	// 상세코드리스트 조회
	
	public void batchDetailCode(List<CodeDetailTO> codeDetailList); 
	// DetailCode 변경저장
	
	public List<MenuTO> findMenuList();
	
	public String takeSerialCode(Map<String,Object> findSeq);
}
