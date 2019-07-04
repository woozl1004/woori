package kr.co.woozl.base.dao;

import java.util.List;

import kr.co.woozl.base.to.CodeTO;

public interface CodeDAO{

	public List<CodeTO> selectCodeList();
	// 코드 리스트 조회
	
	
}
