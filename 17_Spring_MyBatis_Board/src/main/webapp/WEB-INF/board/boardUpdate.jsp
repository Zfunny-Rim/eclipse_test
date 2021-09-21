<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<style type="text/css">
 table {width:500px;}
 .err{font-size:11px; font-weight:bold; color:red;}
</style>
boardUpdate.jsp<br>
<hr>
<center>
<h2>글수정</h2>
<form:form commandName="boardBean" method="post" action="update.bd">
	<input type="hidden" name="num" value="${boardBean.num }">
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
				<input type="text" name="passwd">
				<form:errors cssClass="err" path="passwd"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="글수정">
				<input type="reset" value="다시작성">
				<input type="button" value="목록보기" onClick="location.href='list.bd'">
			</td>
		</tr>
	</table>
</form:form>
</center>