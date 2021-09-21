package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;
import utility.Paging;

@Controller
public class BoardListController {
	private final String command = "/list.bd";
	private final String getPage = "boardList";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(ModelAndView mav,
			HttpServletRequest request,
			@RequestParam(value="pageNumber", required=false)String pageNumber,
			@RequestParam(value="whatColumn", required=false)String whatColumn,
			@RequestParam(value="keyword", required=false)String keyword
			) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		String pageSize = "5";
		String url = request.getContextPath()+command;
		int totalCount = boardDao.getArticleTotalCount(map);
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword, null);
		List<BoardBean> articleList = boardDao.getArticleList(map, pageInfo);
		mav.setViewName(getPage);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("articleList", articleList);
		return mav;
	}
}
