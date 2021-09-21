package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
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
public class BoardUpdateController {
	private final String command = "/update.bd";
	private final String getPage = "boardUpdate";
	private final String gotoPage = "redirect:/detailView.bd";
	
	@Autowired
	BoardDao boardDao;
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView doActionGet(ModelAndView mav,
			@RequestParam("num")int num,
			@RequestParam("pageNumber")int pageNumber) {
		BoardBean boardBean = boardDao.getArticleOne(num);
		mav.setViewName(getPage);
		mav.addObject("boardBean", boardBean);
		mav.addObject("pageNumber", pageNumber);
		return mav;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doActionPost(@Valid BoardBean boardBean, BindingResult result,
			@RequestParam("pageNumber")int pageNumber,
			HttpServletResponse response, ModelAndView mav) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		if(result.hasErrors()) {
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(getPage);
			return mav;
		}
		BoardBean dbBoardBean = boardDao.getArticleOne(boardBean.getNum());
		if(!dbBoardBean.getPasswd().equals(boardBean.getPasswd())) {
			pw.print("<script>alert('비밀번호가 일치하지 않습니다.');</script>");
			pw.flush();
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(getPage);
			return mav;
		}
		boardDao.updateArticle(boardBean);
		mav.addObject("num", boardBean.getNum());
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(gotoPage);
		return mav;
	}
}
