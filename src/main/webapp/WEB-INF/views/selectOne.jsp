<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
table{
	border-collapse: collapse;
}
</style>
</head>
<form method="post" action="./update">
<body>

   <center>
      <h3>게시판</h3>
      <table border="1">
         <tr>
            <td style="width: 100px; text-align:center;">번호</th>
			<td colspan='3' style="width: 700px;">${boardItem.id}
			<input type="hidden" name="id" value=${boardItem.id} />
			</td>
         </tr>
         <tr>
            <td style="width: 100px; text-align:center;">제목</th>
			<td colspan='3' style="width: 700px;">${boardItem.title}
			<input type="hidden" name="title" value=${boardItem.title} />
			</td>
         </tr>
         <tr>
            <td style="width: 100px; text-align:center;">내용</td>
			<td colspan='3' style="width: 700px; height : 500px">
			<textarea name="content" style="width: 690px; height : 490px">${boardItem.content}</textarea></td>
         </tr>
         <tr>
            <td style="width: 100px; text-align:center;">등록일</td>
			<td style="width: 300px;">${boardItem.date}
			<input type="hidden" name="date" value="${boardItem.date}"></td>
			<td style="width: 100px; text-align:center;">조회수</td>
			<td style="width: 300px;">${boardItem.viewcnt}
			<input type="hidden" name="viewcnt" value=${boardItem.viewcnt}></td>
         </tr>
      </table>
      <br /><br /><br /><br />
      <div style="display: flex; width: 800px; justify-content: flex-end;">
         <div style="padding-top: 10px;">
         	<a href="/board/comment?id=${boardItem.id}"><button type="button">댓글쓰기</button></a>
         	<a href="/board/deleteDB?id=${boardItem.id}"><button type="button">삭제</button></a>
            <button type="submit">수정</button></a>
            <a href="/board/list"><button type="button">목록</button></a>
         </div>
      </div>
      </form>
      <h3>댓글</h3>
      <table border = 1 style ="text-align:center">
      	<c:forEach var="clist" items="${boardCommentlist}">
      	<form method="post" action="./update_comment">
      	<tr>
      		<td style="width : 550px"><input type="text" style="width:550px;" name="content"
      		value="${clist.content}"></td>
      		<td style="width : 150px">${clist.date}
      		<input type="hidden" name="date" value="${clist.date}">
      		<input type="hidden" name="rootid" value="${clist.boardItem.id}">
      		<input type="hidden" name="id" value="${clist.id}"></td>
      		<td style="width:50px"><button type="submit">수정</button></td>
      		<td style="width:50px"><a href="/board/delete_comment?id=${clist.id}&rootid=${clist.boardItem.id}">
      		<button type="button">삭제</button></a></td>
      	</tr>
      	</form>
      	</c:forEach>
      </table>
   </center>

</body>
</html>