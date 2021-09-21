<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
boardDelete.jsp<br>
<hr>
<center>
<h2>글 삭제</h2>
<form method="post" action="delete.bd">
	<input type="hidden" name="num" value="${num }">
	<input type="hidden" name="pageNumber" value="${pageNumber }">
	<table border="1">
		<tr>
			<th>비밀번호를 입력해주세요.</th>
		</tr>
		<tr>
			<td><input type="text" name="passwd"/></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="글삭제">
				<input type="button" value="글목록" onClick="location.href='list.bd?pageNumber='+${pageNumber}">
			</td>
		</tr>		
	</table>
</form>
</center>