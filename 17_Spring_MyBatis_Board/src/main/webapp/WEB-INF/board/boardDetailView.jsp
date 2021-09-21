<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<style type="text/css">
table {width:600px;}
</style>
boardDetailView.jsp<br>
<hr>
<center>
<h2>글 내용 보기</h2>
<table border="1">
	<tr>
		<th width="25%">글번호</th>
		<td width="25%" align="center">${boardBean.num }</td>
		<th width="25%">조회수</th>
		<td width="25%" align="center">${boardBean.readcount }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td align="center">${boardBean.writer }</td>
		<th>작성일</th>
		<td align="center">
			<fmt:parseDate var="parseRegDate" value="${boardBean.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
			<fmt:formatDate value="${parseRegDate }" pattern="yyyy/MM/dd"/>
		</td>
	</tr>
	<tr>
		<th>글제목</th>
		<td colspan="3" align="center">${boardBean.subject }</td>
	</tr>
	<tr>
		<th height="100">글내용</th>
		<td colspan="3">${boardBean.content }</td>
	</tr>
	<tr>
		<td colspan="4" align="right">
			<input type="button" value="글수정" onClick="location.href='update.bd?num=${boardBean.num}&pageNumber=${pageNumber }'">
			<input type="button" value="글삭제" onClick="location.href='delete.bd?num=${boardBean.num}&pageNumber=${pageNumber }'">
			<input type="button" value="답글쓰기" onClick="location.href='reply.bd?num=${boardBean.num}&pageNumber=${pageNumber }'">
			<input type="button" value="글목록" onClick="location.href='list.bd?pageNumber=${pageNumber }'">
		</td>
	</tr>
</table>
</center>