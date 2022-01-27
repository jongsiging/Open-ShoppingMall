package kr.co.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.SellerVO;
import kr.co.service.SellerService;

@Controller
@RequestMapping("seller")
public class SellerController {
	
	@Inject
	private SellerService sService;
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout() {
//		return "redirect:/";
//	}
//	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String loginPost(MemberVO vo, Model model) {
//		MemberVO login = sService.login(vo);		
//		model.addAttribute("login", login);	
//		return "member/read";
//	}
//	
//	@RequestMapping(value = "/loginUI", method = RequestMethod.GET)
//	public String login() {
//		return "member/login";
//	}
//	
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
//	
//	@RequestMapping(value = "/update/{member_id}", method = RequestMethod.GET)
//	public String updateUI(@PathVariable("member_id") String member_id, Model model) {
//		MemberVO vo = sService.updateUI(member_id);
//		model.addAttribute("vo", vo);		
//		return "/member/update";
//	}
//	
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String update(MemberVO vo) {
//		sService.update(vo);		
//		return "redirect:/member/read/"+vo.getMember_id();
//	}
//	
//	 @RequestMapping(value = "/delete/{member_id}", method = RequestMethod.GET)
//	 public String deleteUI(@PathVariable("member_id") String member_id, Model model) { 
//		 MemberVO vo = sService.deleteUI(member_id); 
//		 model.addAttribute("vo", vo);
//		 
//		 return "member/delete"; 
//	}
//	
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public String delete(MemberVO vo) {
//		sService.delete(vo);		
//		return "redirect:/";
//	}
//	
//	@RequestMapping(value = "/passChk", method = RequestMethod.POST)
//	@ResponseBody
//	public int passChk(MemberVO vo) {
//		int result = sService.passChk(vo);
//		return result;
//	}
//	
//	@RequestMapping(value = "/mypage/{member_id}", method = RequestMethod.GET)
//	public String mypage(@PathVariable("member_id") String member_id) {
//		
//		return "member/mypage";
//	}
	

}
