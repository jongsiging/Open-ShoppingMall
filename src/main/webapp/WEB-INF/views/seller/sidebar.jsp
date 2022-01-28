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
<script src="/resources/js/sidebar.js" type="text/javascript"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="sidebar-sticky pt-3">
					<h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						<span>Manager</span> <a
							class="d-flex align-items-center text-muted" href="#"
							aria-label="Add a new report"> <span
							data-feather="plus-circle"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
					
						<li class="nav-item"><a class="nav-link text-muted" href="/item/listofall/">
								<span data-feather="file-text"></span> 아이템
						</a></li>
						<li class="nav-item"><a class="nav-link text-muted" href="/order/detailAll/1">
								<span data-feather="file-text"></span> 주문 목록
						</a></li>
						<li class="nav-item"><a class="nav-link text-muted" href="/Myreplies/listOfAll">
								<span data-feather="file-text"></span> 리뷰 목록
						</a></li>
						<li class="nav-item"><a class="nav-link text-muted" href="/qna/listOfAll">
								<span data-feather="file-text"></span> QnA 목록
						</a></li>
						
					</ul>
				</div>
			</nav>
</body>
</html>