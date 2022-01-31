package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.MenusVO;
import kr.co.repository.MemberDAO;
import kr.co.repository.MenusDAO;

@Service
public class MenusServiceImpl implements MenusService {

	@Inject
	private MenusDAO mDao;

	@Override
	public List<MenusVO> list() {
		// TODO Auto-generated method stub
		return mDao.list();
	}

	@Override
	public void insert(MenusVO vo) {
		mDao.insert(vo);
	}

	@Override
	public MenusVO updateUI(int menu_no) {
		// TODO Auto-generated method stub
		return mDao.updateUI(menu_no);
	}

	@Override
	public void update(MenusVO vo) {
		mDao.update(vo);
	}

	@Override
	public void delete(int menu_no) {
		mDao.delete(menu_no);
	}

	
}
