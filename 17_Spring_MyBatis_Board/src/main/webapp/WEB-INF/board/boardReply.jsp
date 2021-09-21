<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<style type="text/css">
 table {width:500px;}
 .err{font-size:11px; font-weight:bold; color:red;}
</style>
boardReply.jsp<br>
<hr>
<center>
<h2>답글쓰기</h2>
<form:form commandName="boardBean" method="post" action="reply.bd">
	<input type="hidden" name="ref" value="${ref }">
	<input type="hidden" name="restep" value="${restep }">
	<input type="hidden" name="relevel" value="${relevel }">
	<input type="hidden" name="pageNumber" value="${pageNumber }">
	<table border="1">
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="writer" value="${boardBean.writer }">
				<form:errors cssClass="err" path="writer"/>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" value="${boardBean.subject }">
				<form:errors cssClass="err" path="subject"/>
			</td>
		</tr>
		<tr>
			<th>Email</th>
			<td>
				<input type="text" name="email" value="${boardBean.email }">
				<form:errors cssClass="err" path="email"/>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="15" cols="45" name="content" style="resize: none;">${boardBean.content }</textarea>
				<br>
				<form:errors cssClass="err" path="content"/>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="text" name="passwd" value="${boardBean.passwd }">
				<form:errors cssClass="err" path="passwd"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="답글쓰기">
				<input type="reset" value="다시쓰기">
				<input type="button" value="목록보기" onClick="location.href='list.bd?pageNumber=${pageNumber}'">
			</td>
		</tr>
	</table>
</form:form>
</center>