<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<style type="text/css">
  	#warning{  
  		width:60%;
   	 	height:60%;
    	position:relative;
		text-align: center;	
		position: relative;
		margin: 0 auto;
  	}
  	
  	#warmen{
  		margin-top: 15px;
  	}
  	
  	#backhome{
  		margin-top: 10px; 
  	}
</style>
<body>
<jsp:include page="../header.jsp" />
<jsp:include page="../sidebar.jsp" />
<div  id="warning">
	<img src="../../../resources/img/ban.png" width="350" height="350" id="ban">
	<c:choose>
		<c:when test="${empty e}">
			<div id="warmen">
				<h4>서비스 이용에 불편을 드려 죄송합니다.</h4>
			</div>
		</c:when>
		<c:otherwise>
			<div id="warmen">
				<h4>${e}</h4>
			</div>
		</c:otherwise>
	</c:choose>
	<button type="button" class="btn btn-danger" id="backhome">홈으로 되돌아가기</button>
</div>

<jsp:include page="../footer.jsp" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#backhome").click(function() {
			location.assign("/");
		}); 
	});
</script>
</body>
</html>