package kr.co.repository;

import java.util.List;

import kr.co.domain.MenusVO;

public interface MenusDAO {

	List<MenusVO> list();

	void insert(MenusVO vo);

	MenusVO updateUI(int menu_no);

	void update(MenusVO vo);

	void delete(int menu_no);

}
