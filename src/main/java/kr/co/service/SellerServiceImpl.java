package kr.co.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.BoardVO;
import kr.co.domain.ItemVO;
import kr.co.domain.MemberVO;
import kr.co.domain.SellerVO;
import kr.co.repository.BoardDAO;
import kr.co.repository.FileDAO;
import kr.co.repository.ItemDAO;
import kr.co.repository.SellerDAO;

@Service
public class SellerServiceImpl implements SellerService {

	@Inject
	private SellerDAO sDao;
	
	@Inject
	private ItemDAO iDao;
	
	@Inject
	private FileDAO fDao;
	
	@Inject
	private BoardDAO bDao;
	
	
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

	@Override
	public SellerVO login(SellerVO vo) {
		// TODO Auto-generated method stub
		return sDao.login(vo);
	}

	@Override
	public void insert(ItemVO ivo, BoardVO bvo) {
		iDao.insert(ivo);
		
		bvo.setItem_no(ivo.getItem_no());
		
		bDao.insert(bvo);
		
		String[] arr = ivo.getInsertfiles();
		int item_no = ivo.getItem_no();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item_no", item_no);
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				map.put("file_name", arr[i]);
				fDao.insert(map);
			}
		}
	}
	
}
