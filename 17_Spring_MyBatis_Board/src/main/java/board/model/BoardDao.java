package board.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("boardDao")
public class BoardDao {
	private String namespace = "board.model.Board";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public int getArticleTotalCount(Map<String, String> map) {
		return sqlSessionTemplate.selectOne(namespace+".getArticleTotalCount", map);
	}
	public List<BoardBean> getArticleList(Map<String, String> map, Paging pageInfo) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		return sqlSessionTemplate.selectList(namespace+".getArticleList", map, rowBounds);
	}
	public BoardBean getArticleOne(int num) {
		return sqlSessionTemplate.selectOne(namespace+".getArticleOne", num);
	}
	public void increaseReadcount(int num) {
		sqlSessionTemplate.update(namespace+".increaseReadcount", num);
	}
	public int insertArticle(BoardBean boardBean) {
		return sqlSessionTemplate.insert(namespace+".insertArticle", boardBean);
	}
	public int updateArticle(BoardBean boardBean) {
		return sqlSessionTemplate.update(namespace+".updateArticle", boardBean);
	}
	public int deleteArticle(int num) {
		return sqlSessionTemplate.delete(namespace+".deleteArticle", num);
	}
	public int updateRestep(BoardBean boardBean) {
		return sqlSessionTemplate.update(namespace+".updateRestep", boardBean);
	}
	public int insertReplyArticle(BoardBean boardBean) {
		return sqlSessionTemplate.insert(namespace+".insertReplyArticle", boardBean);
		
	}
}
