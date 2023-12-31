<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>

<html>
<head>
<meta charset="UTF-8">
<title>댓글 작성</title>
<style>
table{
	border-collapse: collapse;
}
</style>
</head>
<body>
   <center>
      <h3>댓글 작성</h3>
      <form method="post" action="./commentDB" id="root_id">
      <table border="1">
         <tr>
            <td style="width: 100px; text-align:center;">원글 제목</td>
			<td style="width: 300px;">
			&nbsp;&nbsp;&nbsp;${board.getTitle()}
			<input type="hidden" name="title" value=${board.getTitle()}>
			</td>
			<td style="width: 100px; text-align:center;">원글 번호</td>
			<td style="width: 300px;">
			<%-- &nbsp;&nbsp;&nbsp;${board.getId()} --%>
			&nbsp;&nbsp;&nbsp;${id}
			<input type="hidden" name="root_id" value=${board.getId()}>
			</td>
         </tr>
         <tr>
            <td style="width: 100px; text-align:center;">내용</td>
			<td colspan='3' style="width: 700px; height : 200px">
			<textarea name="content" style="width: 690px; height : 180px"></textarea></td>
         </tr>
         <tr>
            <td style="width: 100px; text-align:center;">등록일</td>
			<td colspan='3' style="width: 300px;">${date}
			<input type="hidden" name="date" value=${date} />
			</td>
         </tr>
      </table>
      <div style="display: flex; width: 800px; justify-content: flex-end;">
         <div style="padding-top: 10px;">
            <button type="submit">댓글 등록</button></a>
            <a href="/board/list"><button type="button">목록</button></a>
         </div>
      </div>
      </form>
   </center>

</body>
</html>