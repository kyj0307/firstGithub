<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>글상세</h1>
		<a href="logout_proc.jsp">Log-Out</a>
		<hr>
		<form action="updateBoard.do" method="post">
			<input type="hidden" name="seq" value="${board.getSeq}">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left">
						<input name="title" type="text" value="${board.getTitle}">
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left">${board.getWriter}</td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left">
						<textarea name="content" cols="40" rows="10">${board.getContent}</textarea>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left">${board.getRegDate}</td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left">${board.getCnt}</td>
				</tr>
				<tr>
					<td bgcolor="orange" align="center">
						<input type="submit" value="글 수정">
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=${board.getSeq}">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글목록</a>
	</center>
</body>
</html>