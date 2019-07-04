
package kr.co.woozl.base.applicationService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.woozl.base.dao.CodeDAO;
import kr.co.woozl.base.dao.CodeDetailDAO;
import kr.co.woozl.base.dao.MenuDAO;
import kr.co.woozl.base.to.CodeDetailTO;
import kr.co.woozl.base.to.CodeTO;
import kr.co.woozl.base.to.MenuTO;

@Component
public class BaseApplicationServiceImpl implements BaseApplicationService{

	@Autowired
	private CodeDAO codeDAO;
	
	@Autowired
	private CodeDetailDAO codeDetailDAO;
	
	@Autowired
	private MenuDAO menuDAO;
	

	@Override
	public List<CodeTO> findCodeList() {
		// TODO Auto-generated method stub
		return codeDAO.selectCodeList();
	}

	@Override
	public List<CodeDetailTO> findCodeDetailList() {
		// TODO Auto-generated method stub
		return codeDetailDAO.selectCodeDetailList();
	}

	@Override
	public void batchDetailCode(List<CodeDetailTO> codeDetailList) {
		// TODO Auto-generated method stub
		
		for(CodeDetailTO codeDetailTO : codeDetailList) {
			
			switch(codeDetailTO.getStatus()) {
			case "insert" : codeDetailDAO.insertDetailCode(codeDetailTO); break;
			case "update" : codeDetailDAO.updateDetailCode(codeDetailTO); break;
			case "delete" : codeDetailDAO.deleteDetailCode(codeDetailTO); break;
					
			}
					
		}
	}

	
	@Override
	public List<MenuTO> findMenuList() {
		// TODO Auto-generated method stub
		return menuDAO.selectMenuList();
	}

	@Override
	public String takeSerialCode(Map<String,Object> findSeq) {
		// TODO Auto-generated method stub
		return codeDetailDAO.selectSequence(findSeq);
	}

}
