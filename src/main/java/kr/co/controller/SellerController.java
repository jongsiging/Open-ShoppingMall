package kr.co.controller;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.BoardVO;
import kr.co.domain.CategoryVO;
import kr.co.domain.ItemVO;
import kr.co.domain.PageTO;
import kr.co.domain.SellerVO;
import kr.co.service.CategoryService;
import kr.co.service.ItemService;
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
		return "redirect:/";
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
		return "redirect:/";
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

}
