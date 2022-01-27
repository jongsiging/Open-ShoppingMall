package kr.co.service;

import kr.co.domain.MemberVO;
import kr.co.domain.SellerVO;

public interface SellerService {

	void insert(SellerVO vo);

	SellerVO idcheck(String seller_id);

	SellerVO read(String seller_id);

}
