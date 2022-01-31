<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/resources/js/file.js" type="text/javascript"></script>
</head>
<body>

	<jsp:include page="../header.jsp" />
	<jsp:include page="../sidebar.jsp" />
<div class="container" style=" font-size : small;">
<h4>메뉴 목록</h4>
<a class="btn btn-outline-primary btn-sm" style="float: right;" href="/menus/insert">메뉴 등록</a>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">메뉴명</th>
				<th scope="col">메뉴주소</th>
				<th scope="col">비고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${vo.menu_name}</td>
					<td>${vo.menu_href}</td>
					<td>
						<a class="btn btn-outline-primary btn-sm"
							href="/menus/update/${vo.menu_no}">수정</a> 
						<a class="btn btn-outline-primary btn-sm menus_delete" 
							href="/menus/delete/${vo.menu_no}">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	<jsp:include page="../footer.jsp" />
	<script type="text/javascript">
	$(document).ready(function(){
		
		$('.menus_delete').click(function() { 
			var result = confirm('삭제 하시겠습니까?'); 
			if(result) { 
				var link = $(this).href;
				location.assign(link);
			} else { 
				event.preventDefault();
			} 
		}); 
	});
</script>
</body>
</html>