package kr.co.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.ItemVO;
import kr.co.domain.OrdersVO;
import kr.co.domain.PageTO;
import kr.co.domain.SearchPageTO;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NS = "kr.co.item";

	@Override
	public void insert(ItemVO vo) {
		sqlSession.insert(NS+".insert", vo);
	}

	@Override
	public ItemVO read(int item_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".read", item_no);
	}

	@Override
	public ItemVO updateUI(int item_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".updateUI", item_no);
	}

	@Override
	public void update(ItemVO vo) {
		sqlSession.update(NS+".update", vo);
	}

	@Override
	public int getAmount() {
		
		return sqlSession.selectOne(NS+".getAmount");
	}

	@Override
	public List<ItemVO> list(PageTO<ItemVO> pt) {
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".list", null, rbs);
	}

	@Override
	public void delete(int item_no) {
		sqlSession.delete(NS+".delete", item_no);
	}
	
	@Override
	   public int getAmountSearch(SearchPageTO<ItemVO> spt) {
	      Map<String, Object> map = new HashMap<String, Object>();
	      String item_category = spt.getItem_category();
	      String item_name = spt.getKeyword();
	      map.put("item_name", item_name);
	      map.put("item_category", item_category);
	      return sqlSession.selectOne(NS + ".getAmountSearch", map);
	   }
	
	@Override
	   public List<ItemVO> searchitem(SearchPageTO<ItemVO> spt) {
	      Map<String, Object> map = new HashMap<String, Object>();
	      String item_category = spt.getItem_category();
	      String item_name = spt.getKeyword();
	      map.put("item_name", item_name);
	      map.put("item_category", item_category);
	      RowBounds rbs = new RowBounds(spt.getStartNum()-1, spt.getPerPage());
	      return sqlSession.selectList(NS + ".searchitem", map, rbs);
	   }


	@Override
	public List<ItemVO> getItem_size(String item_name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS + ".getItem_size", item_name);
	}

	@Override
	public List<ItemVO> getItem_color(String item_name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS + ".getItem_color", item_name);
	}

	@Override
	public int getAmountbycategory(String item_category) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getAmountbycategory",item_category);
	}

	@Override
	public List<ItemVO> listbycategory(PageTO<ItemVO> pt, String item_category) {
		// TODO Auto-generated method stub
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".listbycategory", item_category, rbs);
	}


	@Override
	public void updatebycategory(ItemVO ivo) {
		sqlSession.update(NS+".updatebycategory", ivo);
	}

	@Override
	public int getAmountOfAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getAmountOfAll");
	}

	@Override
	public List<ItemVO> listofall(PageTO<ItemVO> pt) {
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".listofall", null, rbs);
	}
	
	@Override
	   public List<ItemVO> searchitemAll(SearchPageTO<ItemVO> spt) {
	      RowBounds rbs = new RowBounds(spt.getStartNum()-1, spt.getPerPage());
	      String item_name = spt.getKeyword();
	      return sqlSession.selectList(NS + ".searchitemAll", item_name, rbs);
	   }

	   @Override
	   public int getAmountSearchAll(SearchPageTO<ItemVO> spt) {
	      String item_name = spt.getKeyword();
	      return sqlSession.selectOne(NS + ".getAmountSearchAll", item_name);
	   }

	@Override
	public int getItme_no(ItemVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getItme_no", vo);
	}

	@Override
	public String getItem_name(int item_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getItem_name", item_no);
	}

	@Override
	public List<OrdersVO> listForRank() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+".listForRank");
	}

	@Override
	public void updateQuantity(int item_no) {
		sqlSession.update(NS+".updateQuantity", item_no);
	}

	@Override
	public int getAmountForSeller(String seller_id) {
		return sqlSession.selectOne(NS+".getAmountForSeller",seller_id);
	}

	@Override
	public List<ItemVO> listForSeller(PageTO<ItemVO> pt, String seller_id) {
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".listForSeller", seller_id, rbs);
	}

	@Override
	public int getAmount(int item_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getAmountItem", item_no);
	}

	@Override
	public List<ItemVO> listOfOld(PageTO<ItemVO> pt) {
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".listOfOld", null, rbs);
	}

	@Override
	public List<OrdersVO> listOfSell(PageTO<OrdersVO> pt) {
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".listForRank", null, rbs);
	}

	@Override
	public List<ItemVO> listOfOldByCategory(PageTO<ItemVO> pt, String item_category) {
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".listOfOldByCategory", item_category, rbs);
	}

	@Override
	public List<OrdersVO> listOfSellByCategory(PageTO<OrdersVO> pt, String item_category) {
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".listOfSellByCategory", item_category, rbs);
	}


}
