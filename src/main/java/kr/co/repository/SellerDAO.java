package kr.co.repository;

import kr.co.domain.SellerVO;

public interface SellerDAO {

	void insert(SellerVO vo);

	SellerVO idcheck(String seller_id);

	SellerVO read(String seller_id);

}
