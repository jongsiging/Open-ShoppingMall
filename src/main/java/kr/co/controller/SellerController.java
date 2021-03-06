package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.BoardVO;
import kr.co.domain.CategoryVO;
import kr.co.domain.ItemVO;
import kr.co.domain.OrdersVO;
import kr.co.domain.PageTO;
import kr.co.domain.QnaVO;
import kr.co.domain.ReviewVO;
import kr.co.domain.SellerVO;
import kr.co.service.CategoryService;
import kr.co.service.ItemService;
import kr.co.service.OrderService;
import kr.co.service.QnaService;
import kr.co.service.ReviewService;
import kr.co.service.SellerService;

@Controller
@RequestMapping("seller")
public class SellerController {
	
	@Inject
	private SellerService sService;
	
	@Inject
	private CategoryService cService;
	
	@Inject
	private ItemService iService;
	
	@Inject
	private QnaService qService;
	
	@Inject
	private ReviewService rService;
	
	@Inject
	private OrderService oService;
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/seller";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(SellerVO vo, Model model) {
		SellerVO sellerLogin = sService.login(vo);	
		model.addAttribute("sellerLogin", sellerLogin);	
		return "seller/read";
	}
	
	@RequestMapping(value = "/loginUI", method = RequestMethod.GET)
	public String login() {
		return "seller/login";
	}
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String idcheck(String seller_id) {
		SellerVO vo = sService.idcheck(seller_id);		
		if(vo == null) {
			return "사용이 가능한 아이디 입니다";
		}else {
			return "사용이 불가능한 아이디 입니다";
		}		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insertUI() {
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(SellerVO vo) {
		sService.insert(vo);
		return "redirect:/seller";
	}
	
	@RequestMapping(value = "/read/{seller_id}", method = RequestMethod.GET)
	public String read(@PathVariable("seller_id") String seller_id, Model model) {
		SellerVO vo = sService.read(seller_id);		
		model.addAttribute("vo", vo);
		return "seller/read";	
	}
	
	@RequestMapping(value = "/update/{seller_id}", method = RequestMethod.GET)
	public String updateUI(@PathVariable("seller_id") String seller_id, Model model) {
		SellerVO vo = sService.updateUI(seller_id);
		model.addAttribute("vo", vo);		
		return "/seller/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(SellerVO vo) {
		sService.update(vo);		
		return "redirect:/seller/read/"+vo.getSeller_id();
	}
	
	 @RequestMapping(value = "/delete/{seller_id}", method = RequestMethod.GET)
	 public String deleteUI(@PathVariable("seller_id") String seller_id, Model model) { 
		 SellerVO vo = sService.deleteUI(seller_id); 
		 model.addAttribute("vo", vo);
		 
		 return "seller/delete"; 
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(SellerVO vo) {
		sService.delete(vo);		
		return "redirect:/seller";
	}
	
	@RequestMapping(value = "/passChk", method = RequestMethod.POST)
	@ResponseBody
	public int passChk(SellerVO vo) {
		int result = sService.passChk(vo);
		return result;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String main() {
		return "seller/main";
	}
	@RequestMapping(value = "insertItem/{seller_id}", method = RequestMethod.GET)
	public String insertItem(@PathVariable("seller_id") String seller_id,  Model model) {
		List<CategoryVO> list = cService.categorylist();
		
		model.addAttribute("list", list);
		model.addAttribute("seller_id", seller_id);
		return "seller/insertItem";
	}
	
	@RequestMapping(value = "/insertItem", method = RequestMethod.POST)
	public String insert(ItemVO ivo, BoardVO bvo) {

		sService.insert(ivo,bvo);
		
		
		return "redirect:/seller/listForSeller/" + ivo.getSeller_id()+"/1";
	}
	
	@RequestMapping(value = "/listForSeller/{seller_id}/{curPage}", method = RequestMethod.GET)
	public String listofall(@PathVariable("seller_id") String seller_id, @PathVariable("curPage") int curPage, PageTO<ItemVO> pt, Model model) {
		
		pt.setCurPage(curPage);
		
		pt = iService.listForSeller(pt, seller_id);
		
		model.addAttribute("pt", pt);
		
		return "seller/listForSeller";
	}
	
	@RequestMapping(value = "/listForSeller/{seller_id}", method = RequestMethod.GET)
	public void listofall(@PathVariable("seller_id") String seller_id, PageTO<ItemVO> pt, Model model) {
		pt.setCurPage(1);
		
		pt = iService.listForSeller(pt, seller_id);
		
		model.addAttribute("pt", pt);
	}
	
	@RequestMapping(value = "/updateItem/{item_no}", method = RequestMethod.GET)
	public String updateUI(@PathVariable("item_no") int item_no, Model model) {
		ItemVO vo = iService.updateUI(item_no);
		
		model.addAttribute("vo", vo);
		
		return "seller/updateItem";
	}

	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	public String update(ItemVO vo) {

		iService.update(vo);

		return "redirect:/seller/listForSeller/" + vo.getSeller_id()+"/1";
	}
	
	@RequestMapping(value = "/addItem/{item_no}", method = RequestMethod.GET)
	public String addItemUI(@PathVariable("item_no") int item_no, Model model) {
		ItemVO vo = iService.updateUI(item_no);
		
		model.addAttribute("vo", vo);
		
		return "seller/addItem";
	}
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem(ItemVO vo) {
		
		iService.addItem(vo);
		
		return "redirect:/seller/listForSeller/" + vo.getSeller_id()+"/1";
	}
	@RequestMapping(value = "/delete/{seller_id}/{item_no}", method = RequestMethod.GET)
	public String delete(@PathVariable("seller_id") String seller_id,@PathVariable("item_no") int item_no) {
		
		iService.delete(item_no);
		
		return "redirect:/seller/listForSeller/" + seller_id+"/1";
	}
	
	@RequestMapping(value = "/qnalist/{seller_id}", method = RequestMethod.GET)
	public String qnalist(@PathVariable("seller_id") String seller_id,PageTO<QnaVO> pt, Model model) {
		
		pt.setCurPage(1);
		
		pt = qService.qnalist(pt, seller_id);
		
		model.addAttribute("pt", pt);
		
		return "seller/qnalist";
	}
	@RequestMapping(value = "/qnalist/{seller_id}/{curPage}", method = RequestMethod.GET)
	public String qnalist(@PathVariable("seller_id") String seller_id,@PathVariable("curPage") int curPage,PageTO<QnaVO> pt, Model model) {

		pt.setCurPage(curPage);

		pt = qService.qnalist(pt, seller_id);
		
		model.addAttribute("pt", pt);
		
		return "seller/qnalist";
	}
	@RequestMapping(value = "/qnaUpdate/{qna_no}", method = RequestMethod.GET)
	public String qnaUpdateUI(@PathVariable("qna_no") int qna_no, Model model) {

		QnaVO vo = qService.updateUI(qna_no);

		model.addAttribute("vo", vo);

		return "/seller/qnaUpdate";
	}

	@RequestMapping(value = "/qnaUpdate", method = RequestMethod.POST)
	public String update(QnaVO vo, String seller_id) {

		qService.update(vo);
		
		return "redirect:/seller/qnalist/"+seller_id;
	}
	@RequestMapping(value = "/qnaDelete/{qna_no}/{seller_id}", method = RequestMethod.GET)
	public String delete(@PathVariable("qna_no") int qna_no, @PathVariable("seller_id") String seller_id) {
		
		qService.delete(qna_no);

		return "redirect:/seller/qnalist/"+seller_id;
	}
	
	@RequestMapping(value = "/reviewlist/{seller_id}", method = RequestMethod.GET)
	public String reviewlist(@PathVariable("seller_id") String seller_id,PageTO<ReviewVO> pt, Model model) {
		
		pt.setCurPage(1);
		
		pt = rService.reviewlist(pt, seller_id);
		
		model.addAttribute("pt", pt);
		
		return "seller/reviewlist";
	}
	
	@RequestMapping(value = "/reviewlist/{seller_id}/{curPage}", method = RequestMethod.GET)
	public String reviewlist(@PathVariable("curPage") int curPage,@PathVariable("seller_id") String seller_id, PageTO<ReviewVO> pt, Model model) {

		pt.setCurPage(curPage);

		pt = rService.reviewlist(pt, seller_id);
		
		model.addAttribute("pt", pt);
		
		return "seller/reviewlist";
	}
	
	@RequestMapping(value = "/orderlist/{seller_id}", method = RequestMethod.GET)
	public String orderlist(PageTO<OrdersVO> pt,@PathVariable("seller_id") String seller_id, Model model) {
		
		pt.setCurPage(1);
		
		pt = oService.orderlist(pt,seller_id);
		
		model.addAttribute("pt", pt);
		model.addAttribute("seller_id", seller_id);
		
		return "seller/orderlist";
	}
	
	@RequestMapping(value = "/orderlist/{seller_id}/{curPage}", method = RequestMethod.GET)
	public String orderlist(PageTO<OrdersVO> pt,@PathVariable("curPage") int curPage,@PathVariable("seller_id") String seller_id, Model model) {
		
		pt.setCurPage(curPage);
		
		pt = oService.orderlist(pt, seller_id);
		
		model.addAttribute("pt", pt);
		model.addAttribute("seller_id", seller_id);
		
		return "seller/orderlist";
	}
}
