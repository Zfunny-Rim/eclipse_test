package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardInsertController {
	private final String command = "/insert.bd";
	private final String getPage = "boardInsert";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao boardDao;
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView doActionGet(ModelAndView mav) {
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doActionPost(@Valid BoardBean boardBean, BindingResult result,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		boardBean.setIp(request.getRemoteAddr());
		int cnt = boardDao.insertArticle(boardBean);
		mav.setViewName(gotoPage);
		return mav;
	}
	
}
