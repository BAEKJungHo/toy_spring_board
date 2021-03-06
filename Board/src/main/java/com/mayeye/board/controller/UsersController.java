package com.mayeye.board.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mayeye.board.dto.UsersDTO;
import com.mayeye.board.service.UsersService;

@Controller
public class UsersController {
	private static final Logger Logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UsersService usersService;
	
	// 로그인 페이지로 이동
	@RequestMapping(value="/login", method = RequestMethod.GET) 
	public String login(UsersDTO usersDTO) {
		return "login";
	}
	
	/* 로그인 처리 : HttpServletRequest를 사용 
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(UsersDTO usersDTO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("usersDTO", usersService.select(usersDTO.getId()));
		return "boardList";
	} 
	*/
	
	// 로그인 처리 : HttpSession을 사용 
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(UsersDTO usersDTO, HttpSession session, RedirectAttributes rttr, Model model) {
		// 비밀번호 처리 
		boolean flag = usersService.checkPw(usersDTO.getId(), usersDTO.getPwd());

		if(flag) {
			UsersDTO user = usersService.select(usersDTO);
			session.setAttribute("user", user);
			session.setAttribute("id", user.getId());
			return "redirect:/boardSearchList";
		} else {
			rttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다");
			return "redirect:/login";
		}
		
	} 
	
	// 로그아웃 처리 : invalidate() 사용 
	@RequestMapping(value="/logout")
	public String logout(UsersDTO usersDTO, HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/login";
	} 
}
