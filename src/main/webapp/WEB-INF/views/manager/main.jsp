<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- <script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->

<title>관리자용 페이지</title>


</head>
<body>


	<div class="mx-5 mt-3" style="margin-bottom: 500px;">
		<h1 class="display-4">DAPAN & DA</h1>
		<hr class="my-4" style="background-color: white;">

		<p>
			<c:if test="${managerLogin != null }">${managerLogin.manager_id} 님, 환영합니다.</c:if>
			아래 메뉴 중 선택하십시오.
		</p>

		<div class="row">
			<a class="btn btn-outline-dark" href="/">Home 바로가기</a> &nbsp; &nbsp;


			<c:if test="${managerLogin == null }">



				<div class="dropdown">
					<button class="btn btn-outline-dark dropdown-toggle" type="button"
						id="dropdownMenu2" data-toggle="dropdown" aria-expanded="false">
						관리자/경영자 로그인</button>
					<form class="dropdown-menu p-2 border-primary "
						aria-labelledby="dropdownMenu2" action="/manager/managerLogin"
						, method="post">
						<div class="form-group">
							<label for="exampleDropdownFormEmail2">아이디</label> <input
								type="text" class="form-control border-primary"
								id="exampleDropdownFormEmail2" name="manager_id"
								placeholder="ID" required="required">
						</div>
						<div class="form-group">
							<label for="exampleDropdownFormPassword2">비밀번호</label> <input
								type="password" class="form-control border-primary"
								id="exampleDropdownFormPassword2" name="manager_pw"
								placeholder="Password" required="required">
						</div>

						<button type="submit"
							class="btn btn-outline-primary btn-sm btn-block">로그인</button>
					</form>
				</div>




			</c:if>




			<c:if test="${managerLogin.manager_code == 2 }">
				<a class="btn btn-outline-dark" href="/manager/insert">관리자 생성</a> &nbsp; &nbsp;
  			</c:if>

			<c:if test="${managerLogin != null }">
				<a class="btn btn-outline-dark" href="/manager/logout">로그아웃</a> &nbsp; &nbsp;
  				<a class="btn btn-outline-dark" href="/manager/managerList">관리자 리스트</a> &nbsp; &nbsp;
				<a class="btn btn-outline-dark" href="/manager/memberList">회원 리스트</a> &nbsp; &nbsp;
				<a class="btn btn-outline-dark" href="/manager/excel">주문 리스트(엑셀) 다운</a> &nbsp; &nbsp;
  			</c:if>

			<c:if test="${managerLogin.manager_code == 2}">
				<a class="btn btn-outline-dark" href="/manager/calendar">통계</a> &nbsp; &nbsp;
  			</c:if>
		</div>
	</div>
	<div class="container">
		<jsp:include page="../manager/managerFooter.jsp" />
	</div>


</body>
</html>