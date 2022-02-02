package kr.co.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.PageTO;
import kr.co.domain.SellerVO;

@Repository
public class SellerDAOImpl implements SellerDAO {

	@Inject
	private SqlSession sqlSession;

	private final String NS = "kr.co.seller";

	@Override
	public void insert(SellerVO vo) {
		sqlSession.insert(NS+".insert", vo);
	}

	@Override
	public SellerVO idcheck(String seller_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".idcheck", seller_id);
	}

	@Override
	public SellerVO read(String seller_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".read", seller_id);
	}

	@Override
	public SellerVO updateUI(String seller_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".updateUI", seller_id);
	}

	@Override
	public void update(SellerVO vo) {
		sqlSession.update(NS+".update", vo);
	}

	@Override
	public int passChk(SellerVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".passChk", vo);
	}

	@Override
	public SellerVO deleteUI(String seller_id) {
		
		return sqlSession.selectOne(NS+".deleteUI", seller_id);
	}

	@Override
	public void delete(SellerVO vo) {
		sqlSession.delete(NS+".delete", vo);
	}

	@Override
	public SellerVO login(SellerVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".login", vo);
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getAmount");
	}

	@Override
	public List<SellerVO> sellerList(PageTO<SellerVO> pt) {
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".sellerList", null, rbs);
	}
	
}
