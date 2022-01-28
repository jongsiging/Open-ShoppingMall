package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.MemberVO;
import kr.co.domain.SellerVO;
import kr.co.repository.SellerDAO;

@Service
public class SellerServiceImpl implements SellerService {

	@Inject
	private SellerDAO sDao;

	@Override
	public void insert(SellerVO vo) {
		sDao.insert(vo);
	}

	@Override
	public SellerVO idcheck(String seller_id) {
		// TODO Auto-generated method stub
		return sDao.idcheck(seller_id);
	}

	@Override
	public SellerVO read(String seller_id) {
		// TODO Auto-generated method stub
		return sDao.read(seller_id);
	}

	@Override
	public SellerVO updateUI(String seller_id) {
		// TODO Auto-generated method stub
		return sDao.updateUI(seller_id);
	}

	@Override
	public void update(SellerVO vo) {
		sDao.update(vo);
	}

	@Override
	public int passChk(SellerVO vo) {
		// TODO Auto-generated method stub
		return sDao.passChk(vo);
	}

	@Override
	public SellerVO deleteUI(String seller_id) {
		// TODO Auto-generated method stub
		return sDao.deleteUI(seller_id);
	}

	@Override
	public void delete(SellerVO vo) {
		sDao.delete(vo);
	}
	
}
