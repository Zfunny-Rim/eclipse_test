package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDetailViewController {
	private final String command = "/detailView.bd";
	private final String getPage = "boardDetailView";
	
	@Autowired
	BoardDao boardDao;
	@RequestMapping(value=command)
	public ModelAndView doAction(ModelAndView mav,
			@RequestParam("num")int num,
			@RequestParam("pageNumber")int pageNumber) {
		boardDao.increaseReadcount(num);
		BoardBean boardBean = boardDao.getArticleOne(num);
		mav.setViewName(getPage);
		mav.addObject("boardBean", boardBean);
		mav.addObject("pageNumber", pageNumber);
		return mav;
	}
}
