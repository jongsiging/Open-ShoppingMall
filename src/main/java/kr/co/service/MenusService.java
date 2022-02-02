package kr.co.service;

import java.util.List;

import kr.co.domain.MenusVO;

public interface MenusService {

	List<MenusVO> list();

	void insert(MenusVO vo);

	MenusVO updateUI(int menu_no);

	void update(MenusVO vo);

	void delete(int menu_no);

}
