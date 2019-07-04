package kr.co.woozl.base.dao;

import java.util.List;

import kr.co.woozl.base.to.MenuTO;

public interface MenuDAO {

	public List<MenuTO> selectMenuList();
}
