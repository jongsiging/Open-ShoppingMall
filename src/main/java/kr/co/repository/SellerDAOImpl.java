package kr.co.repository;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
	
}
