package kr.co.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.domain.CategoryVO;
import kr.co.domain.ItemVO;
import kr.co.domain.MenusVO;
import kr.co.domain.PageTO;
import kr.co.domain.QnaVO;
import kr.co.service.BoardService;
import kr.co.service.CategoryService;
import kr.co.service.FileService;
import kr.co.service.ItemService;
import kr.co.service.MenusService;

@Controller
@RequestMapping("menus")
public class MenusController {

	@Inject
	private MenusService mService;

	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertUI() {
		return "menus/insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MenusVO vo) {

		mService.insert(vo);
		
		
		return "redirect:/menus/listOfAll";
	}

	@RequestMapping(value = "/update/{menu_no}", method = RequestMethod.GET)
	public String updateUI(@PathVariable("menu_no") int menu_no, Model model) {
		MenusVO vo = mService.updateUI(menu_no);
		
		model.addAttribute("vo", vo);
		
		return "menus/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MenusVO vo) {

		mService.update(vo);

		return "redirect:/menus/listOfAll";
	}
	
	@RequestMapping(value = "/delete/{menu_no}", method = RequestMethod.GET)
	public String delete(@PathVariable("menu_no") int menu_no) {
		
		mService.delete(menu_no);
		
		return "redirect:/menus/listOfAll";
	}

	@RequestMapping(value = "/listOfAll", method = RequestMethod.GET)
	public String listofall(Model model) {
		
		List<MenusVO> list = mService.list();
		
		model.addAttribute("list", list);
		
		return "menus/listOfAll";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<MenusVO>> list(Model model) {
		ResponseEntity<List<MenusVO>> entity = null;
		try {
			List<MenusVO> list = mService.list();
			model.addAttribute("list", list);
			entity = new ResponseEntity<List<MenusVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<MenusVO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
