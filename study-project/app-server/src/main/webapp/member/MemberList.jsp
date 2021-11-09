<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원목록</title>
  <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">
  <link rel="stylesheet" href="../node_modules/sweetalert2/dist/css/sweeetalert2.css">
  <link rel="stylesheet" href="../css/common.css">
  
  
  <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script>
  <script src="../node_modules/bootstrap/dist/bootstrap.css"></script>
  <script src="../node_modules/sweetalert2/dist/sweetalert2.js"></script>
  <style>
    .container {
      xborder: 1px solid red;
      width: 640px;}
      
      
      tr a {
        text-decoration: none;
        color: black;
      }
      
      tr a:visited {
        color: black;
      }
      
      tr:hover { //tr 태그에 마우스가 올라갈 때
        cursor:pointer;
      }
      
  </style>
  
  
</head>
<body>
<div class="container">

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../sidebar.jsp"></jsp:include>


<h1>회원 목록(MVC + EL + JSTL + Boots)</h1>
<a href='form' class="btn btn-outline-primary btn-sm">새회원</a><br>
<table class="table table-hover">
<thead>
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>이메일</th>
    <th>전화</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>

<c:forEach items="#{memberList}" var="member">
<tr data-no='${member.no}'>
    <td>${member.no}</td>
    <%-- 
    <td><a href='detail?no=${member.no}'>${member.name}</a></td>  
    --%>
    <td>${member.name}</td>
    <td>${member.email}</td> 
    <td>${member.tel}</td> 
    <td>${member.registeredDate}</td>
</tr>
</c:forEach>
</tbody>
</table>

<jsp:include page="../footer.jsp"></jsp:include>

</div><!-- .container -->



<script>

document.querySelectorAll("tbody a").forEach((e) => {
	 e.target.onclick = () => false;
});

var trList = document.querySelectorAll("tbody tr"); //리턴 객체는 HTMLCollection타입 객체이다.
trList.forEach(function(e) {
   //tr 태그 클릭할 때마다 이 펑션 이벤트 활성화
	//e가 tr 객체 click 이벤트 > this는 window가 되어버림 > e.target으로!!! 이벤트가 발생된 객체!!
	// 아 근데 td 태그 말고 !!! >>  currentTarget >>리스너가 등록된 객체! >> tr 태그
e.onclick = (e) => {
	// console.log(e.currentTarget.querySelector("a").href); //currentTarget tr 중에 a 태그
	// e.currentTarget.querySelector("a").click();
	// window.location.href = e.currentTarget.querySelector("a").href; //현재 페이지를 저 페이지로 바꿔버렷!!

	window.location.href = "detail?no=" + e.currentTarget.getAttribute("data-no");
};
	
});

</script>




</body>
</html>








