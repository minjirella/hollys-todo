﻿<!DOCTYPE html>
<html>
<head>
<%
request.setCharacterEncoding("utf-8");
%>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="resources/form.css" type="text/css">
  <title>Todo 등록</title>
</head>
<body>
  <h1>할일 등록</h1>
  <form action="/Todo/new" method="post">
  	<section>
	    <div class="label">어떤 일인가요?</div>
	    <input type="text" name="title" class="todo_title" maxlength="24" placeholder="Swift 공부 (24자까지)">
	  </section>
	  <section>
	    <div class="label">누가 할일인가요?</div>
	      <input type="text" name="name" class="todo_name" placeholder="홍길동">
	  </section>
	  <section class="radio">
	    <div class="label">우선순위를 선택하세요</div>
	    <input type="radio" name="sequence" value="1" class="todo_seq" checked>1순위&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="radio" name="sequence" value="2" class="todo_seq">2순위&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="radio" name="sequence" value="3" class="todo_seq">3순위&nbsp;&nbsp;&nbsp;&nbsp;
	  </section>
  </form>
	  
  <section id="btn">
    <a href="/Todo/main" class="btn_prev">이전</a>
    <nav class="btn_del">내용지우기</nav>
    <nav class="btn_submit">제출</nav>
  </section>
</body>
</html>