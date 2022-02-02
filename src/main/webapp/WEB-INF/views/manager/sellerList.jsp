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
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>경영자리스트</title>
</head>
<body>
	<jsp:include page="../manager/managerHeader.jsp" />

	<div class="container mt-5 bg-light text-dark">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">판매자 아이디</th>
					<th scope="col">판매자 이름</th>
					<th scope="col">판매자 이메일</th>
					<th scope="col">판매자 핸드폰 번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pt.list}" var="vo">
					<tr>
						<td>${vo.seller_id}
							<a href="/seller/read/${vo.seller_id}"
								class="badge badge-info">자세히보기</a>
						</td>
						<td>${vo.seller_name}</td>
						<td>${vo.seller_email}</td>
						<td>${vo.seller_phone}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<jsp:include page="pageForSeller.jsp" /><br>
	</div>





	<jsp:include page="../manager/managerFooter.jsp" />



</body>
</html>