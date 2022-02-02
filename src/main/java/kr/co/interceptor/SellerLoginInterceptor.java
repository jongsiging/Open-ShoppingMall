package kr.co.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.domain.MemberVO;
import kr.co.domain.SellerVO;


public class SellerLoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {		
		HttpSession session = request.getSession();
		Object sellerLogin = session.getAttribute("sellerLogin");
		if(sellerLogin != null) {
			session.invalidate();
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Map<String, Object> map = modelAndView.getModel();		
		SellerVO sellerLogin = (SellerVO) map.get("sellerLogin");
		
		HttpSession session = request.getSession();
		session.setAttribute("sellerLogin", sellerLogin);	
		
		 String where = (String) session.getAttribute("where");
		  
		 if(where == null) {  
			 response.sendRedirect("../seller");
		 }else {
			 response.sendRedirect(where); 
		 }
	}

}
