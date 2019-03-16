<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="resources/main.css" type="text/css">
<title>Todo List</title>
</head>
<body>
  <header>
    <h1 class="main_title">나의 해야할 일들</h1>
    <a href="/Todo/form">새로운 TODO 등록</a>
  </header>
  <section>
    <ul class="TODO">
      <li class="table_title">
        <b>TODO</b>
      </li>      
      <c:forEach items="${todo}" var="item">
      	<li id="${item.id}">
			<b><c:out value="${item.title}"/></b><br>
			<p class="context">
				등록날짜 : <c:out value="${item.regdate}"/>, 
				<c:out value="${item.name}"/>,
				우선순위 <c:out value="${item.sequence}"/>
				<input type="button" name="btn_todo" value="->" onclick="upt_click('DOING');">
			</p>
	  	</li>
	  </c:forEach>      
    </ul>
    <ul class="DOING">
      <li class="table_title">
        <b>DOING</b>
      </li>
      <c:forEach items="${doing}" var="item">
      	<li id="${item.id}">
			<b><c:out value="${item.title}"/></b><br>
			<p class="context">
				등록날짜 : <c:out value="${item.regdate}"/>, 
				<c:out value="${item.name}"/>,
				우선순위 <c:out value="${item.sequence}"/>
				<input type="button" name="btn_doing" value="->" onclick="upt_click('DONE');">
			</p>
		</li>
	  </c:forEach> 
    </ul>
    <ul class="DONE">
      <li class="table_title">
        <b>DONE</b>
      </li>
	  <c:forEach items="${done}" var="item">
      	<li id="${item.id}">
			<b><c:out value="${item.title}"/></b><br>
			<p class="context">
				등록날짜 : <c:out value="${item.regdate}"/>, 
				<c:out value="${item.name}"/>,
				우선순위 <c:out value="${item.sequence}"/>
			</p>
	  	</li>
	  </c:forEach> 
    </ul>
  </section>
</body>
<script>
function upt_click(type) {
	alert(type + "으로 업데이트됩니다");
}
</script>
</html>