package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardReplyController {
	private final String command = "/reply.bd";
	private final String getPage = "boardReply";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao boardDao;
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView doActionGet(ModelAndView mav,
			@RequestParam("num")int num,
			@RequestParam("pageNumber")int pageNumber) {
		BoardBean boardBean = boardDao.getArticleOne(num);
		int ref = boardBean.getRef();
		int restep = boardBean.getRestep();
		int relevel = boardBean.getRelevel();
		mav.setViewName(getPage);
		mav.addObject("ref", ref);
		mav.addObject("restep", restep);
		mav.addObject("relevel", relevel);
		mav.addObject("pageNumber", pageNumber);
		return mav;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doActionPost(@Valid BoardBean boardBean, BindingResult result,
			@RequestParam("pageNumber")int pageNumber,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			mav.addObject("ref", boardBean.getRef());
			mav.addObject("restep", boardBean.getRestep());
			mav.addObject("relevel", boardBean.getRelevel());
			mav.addObject("pageNumber", pageNumber);
			return mav;
		}
		boardBean.setIp(request.getRemoteAddr());
		boardDao.updateRestep(boardBean);
		boardDao.insertReplyArticle(boardBean);
		mav.setViewName(gotoPage);
		mav.addObject("pageNumber", pageNumber);
		return mav;
	}
}
