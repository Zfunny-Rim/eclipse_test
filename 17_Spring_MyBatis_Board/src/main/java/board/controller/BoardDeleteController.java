package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
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
public class BoardDeleteController {
	private final String command = "/delete.bd";
	private final String getPage = "boardDelete";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao boardDao;
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView doActionGet(ModelAndView mav,
			@RequestParam("num")int num,
			@RequestParam("pageNumber")int pageNumber) {
		mav.addObject("num", num);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doActionPost(HttpServletResponse response,
			@RequestParam("num")int num,
			@RequestParam("pageNumber")int pageNumber,
			@RequestParam("passwd")String passwd) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		ModelAndView mav = new ModelAndView();
		
		if(passwd.equals("")) {
			pw.print("<script>alert('비밀번호를 입력하세요.');</script>");
			pw.flush();
			mav.addObject("num", num);
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(getPage);
			return mav;
		}
		BoardBean dbBoardBean = boardDao.getArticleOne(num);
		if(!dbBoardBean.getPasswd().equals(passwd)) {
			pw.print("<script>alert('비밀번호가 일치하지 않습니다.');</script>");
			pw.flush();
			mav.addObject("num", num);
			mav.addObject("pageNumber", pageNumber);
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = boardDao.deleteArticle(num);
		mav.setViewName(gotoPage);
		mav.addObject("pageNumber", pageNumber);
		return mav;
	}
}
