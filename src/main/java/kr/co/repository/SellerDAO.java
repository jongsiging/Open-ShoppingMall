package kr.co.repository;

import kr.co.domain.SellerVO;

public interface SellerDAO {

	void insert(SellerVO vo);

	SellerVO idcheck(String seller_id);

	SellerVO read(String seller_id);

	SellerVO updateUI(String seller_id);

	void update(SellerVO vo);

	int passChk(SellerVO vo);

	SellerVO deleteUI(String seller_id);

	void delete(SellerVO vo);

	SellerVO login(SellerVO vo);

}
