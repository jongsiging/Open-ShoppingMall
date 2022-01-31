package kr.co.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.MenusVO;

@Repository
public class MenusDAOImpl implements MenusDAO {

	@Inject
	private SqlSession sqlSession;
	
	private String NS = "kr.co.menus";

	@Override
	public List<MenusVO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+".list");
	}

	@Override
	public void insert(MenusVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NS+".insert", vo);
	}

	@Override
	public MenusVO updateUI(int menu_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".updateUI", menu_no);
	}

	@Override
	public void update(MenusVO vo) {
		sqlSession.selectOne(NS+".update", vo);
	}

	@Override
	public void delete(int menu_no) {
		sqlSession.delete(NS+".delete", menu_no);
	}
	
}
