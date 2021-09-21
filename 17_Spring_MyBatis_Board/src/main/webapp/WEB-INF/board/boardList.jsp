<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<style type="text/css">
table {width:800px;}
</style>
boardList.jsp<br>
<hr>
<center>
<h2>게시판 목록보기</h2>
<form method="get" action="list.bd">
	<select name="whatColumn">
		<option value="all">전체검색</option>
		<option value="subject">제목</option>
		<option value="writer">작성자</option>
	</select>
	<input type="text" name="keyword"/>
	<input type="submit" value="검색"/>
</form>
글 목록 (전체 글 : ${pageInfo.totalCount }) / pageNumber : ${ pageInfo.pageNumber} / pageSize : ${ pageInfo.pageSize }<br>
<table border="1">
	<tr>
		<td colspan="6" align="right"><input type="button" value="추가하기" onClick="location.href='insert.bd'"></td>
	</tr>
	<tr>
		<th>번호</th>
		<th width="35%">제목</th>
		<th width="10%">작성자</th>
		<th width="15%">작성일</th>
		<th>조회수</th>
		<th>IP</th>
	</tr>
	<c:forEach var="article" items="${articleList }" varStatus="vs">
	<tr>
		<td align="center">${pageInfo.totalCount - ((pageInfo.pageNumber-1) * pageInfo.pageSize) - vs.count + 1}</td>
		<td>
			<c:if test="${article.relevel > 0 }">
				<c:set var="imgWidth" value="${(article.relevel-1) * 15 }"/>
				<img src="<%=request.getContextPath()%>/resources/images/level.gif" width="${imgWidth }" height="20">
				<img src="<%=request.getContextPath()%>/resources/images/re.gif">
			</c:if>
			<a href="detailView.bd?num=${article.num }&pageNumber=${pageInfo.pageNumber }">
				${article.subject }
			</a>
			<c:if test="${article.readcount > 10 }">
				<img src="<%=request.getContextPath()%>/resources/images/hot.gif">
			</c:if>
		</td>
		<td align="center">${article.writer }</td>
		<td align="center">
			<fmt:parseDate var="parseRegDate" value="${article.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
			<fmt:formatDate value="${parseRegDate }" pattern="yyyy/MM/dd"/>
		</td>
		<td align="center">${article.readcount }</td>
		<td align="center">${article.ip }</td>
	</tr>
	</c:forEach>
</table>
${pageInfo.pagingHtml }
</center>