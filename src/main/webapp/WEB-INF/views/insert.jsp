<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
<form method="post" action="./insertDB">
<body>

   <center>
      <h3>게시판</h3>
      <table border="1">
         <tr>
            <td style="width: 100px; text-align:center;">번호</td>
			<td colspan='3' style="width: 700px;">
			&nbsp;&nbsp;&nbsp;자동부여
			</td>
         </tr>
         <tr>
            <td style="width: 100px; text-align:center;">제목</td>
			<td colspan='3' style="width: 700px;">
			<input type="text" name="title" value="" />
			</td>
         </tr>
         <tr>
            <td style="width: 100px; text-align:center;">내용</td>
			<td colspan='3' style="width: 700px; height : 500px">
			<textarea name="content" style="width: 690px; height : 490px"></textarea></td>
         </tr>
         <tr>
            <td style="width: 100px; text-align:center;">등록일</td>
			<td style="width: 300px;">${date}
			<input type="hidden" name="date" value=${date} />
			</td>
         </tr>
      </table>
      <div style="display: flex; width: 800px; justify-content: flex-end;">
         <div style="padding-top: 10px;">
            <button type="submit">신규등록</button></a>
            <a href="/board/list"><button type="button">목록</button></a>
         </div>
      </div>
   </center>
</form>

</body>
</html>