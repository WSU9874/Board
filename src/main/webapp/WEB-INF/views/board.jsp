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
<body>

   <center>
      <h3>게시판</h3>
      <form class="search" action="/board" method="get">
         <input type="text" name="searchKeyword" value="${searchKeyword}">
         <button style="width: 100px" type="submit">
            <h2>검색</h2>
         </button>
		<div style="display: flex; justify-content: center;">
         <a href="?sortTitle=1"><button type="button" name="sortTitle">제목으로
               정렬</button></a> <a href="?sortView=1"><button type="button" name="sortView">조회수로
               정렬</button></a>
      	</div>
      </form>
      <table border="1">
         <tr style = "background-color:yellow">
            <th class="center" style="width: 100px;">번호</th>
            <th class="center" style="width: 600px;">제목</th>
            <th class="center" style="width: 150px;">등록일</th>
            <th class="center" style="width: 100px;">조회수</th>
         </tr>
         <c:forEach var="list" items="${boards.content}">
            <tr>
               <td style="text-align: center">${list.id}</td>
               <td style="text-align:center">
               <a href="/board/selectOne?id=${list.id}">${list.title} </a></td>
               <td style="text-align: center">${list.date}</td>
               <td style="text-align: center">${list.viewcnt}</td>
            </tr>
         </c:forEach>
      </table>
      <div style="display: flex; width: 950px; justify-content: flex-end;">
         <div style="padding-top: 10px;">
            <a href="/board/insert"><button type="button">신규 등록</button></a>
         </div>
      </div>
               <h3>${nowPage }</h3>
               <h3>${startPage }</h3>
      <!-- 페이징 처리 -->

      <c:choose>
      
         <c:when test="${empty boards }">
            <h4>게시글이 없습니다.</h4>
         </c:when>

         <c:otherwise>
            <div>
               <c:if test="${startPage > -1}">
                  <a
                     href="?sortView=${sortView}&sortTitle=${sortTitle}&searchKeyword=${searchKeyword}&page=0">First</a>
               </c:if>

               <c:if test="${nowPage > 1}">
                  <a
                     href="?sortView=${sortView}&sortTitle=${sortTitle}&searchKeyword=${searchKeyword}&page=${nowPage - 2}">Previous</a>
               </c:if>


               <c:forEach begin="${startPage}" end="${endPage}" varStatus="stat">
                  <c:choose>
                     <c:when test="${stat.current eq nowPage}">
                        <a
                           href="?sortView=${sortView}&sortTitle=${sortTitle}&searchKeyword=${searchKeyword}&page=${stat.current -1}"
                           class="active"> <c:out value="${stat.current}" /></a>
                     </c:when>
                     <c:otherwise>
                        <a
                           href="?sortView=${sortView}&sortTitle=${sortTitle}&searchKeyword=${searchKeyword}&page=${stat.current -1}">
                           <c:out value="${stat.current}" />
                        </a>
                     </c:otherwise>
                  </c:choose>
               </c:forEach>


               <c:if test="${nowPage < endPage}">
                  <a
                     href="?sortView=${sortView}&sortTitle=${sortTitle}&searchKeyword=${searchKeyword}&page=${nowPage}">Next</a>
               </c:if>
               <c:if test="${endPage > 1}">
                  <a
                     href="?sortView=${sortView}&sortTitle=${sortTitle}&searchKeyword=${searchKeyword}&page=${endPage -1}">Last</a>
               </c:if>
            </div>

         </c:otherwise>
         
      </c:choose>
      
   </center>
   <!-- --------------------------------------------------------------------------------------- -->

  


</body>
</html>