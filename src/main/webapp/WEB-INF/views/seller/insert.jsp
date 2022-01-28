<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

<jsp:include page="header.jsp" />

	<div class="row mb-2 container">
		<div class="col-md-10">
			<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
				<div class="col p-4 d-flex flex-column position-static">

					<form action="/seller/insert" method="post" id="insertform">
						<div class="input-group mb-2">
							<span class="input-group-text">아이디</span> 
							<input class="form-control" id="seller_id" name="seller_id" maxlength="15" required>
							<button id="idcheck">중복검사</button>
							<p id="idCheckResult"></p>
						</div>

						<div class="input-group mb-2">
							<span class="input-group-text">비밀번호</span> 
							<input class="form-control" type="password" id="seller_pw" name="seller_pw" maxlength="10" required>
						</div>

						<div class="input-group mb-2">
							<span class="input-group-text">이름</span> 
							<input class="form-control" id="seller_name" name="seller_name" maxlength="15" required>
						</div>

						<div class="input-group mb-2">
							<span class="input-group-text">이메일</span> 
							<input class="form-control" id="seller_email" maxlength="30" name="seller_email" placeholder="사용하시는 이메일 주소를 넣어주세요" required>
						</div>

						<div class="input-group mb-2">
							<span class="input-group-text">전화번호</span> 
							<input class="form-control" id="seller_phone" name="seller_phone"  placeholder="숫자만 입력하여 주십시오" max="99999999999" required>
						</div>

						<input type="submit" id="signup" value="판매자 등록">
					</form>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp" />



<script type="text/javascript">

function emailcheck(emailString) {
	const regEmail = /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;
   	if (regEmail.test(emailString) === true) {
   		return true;
    }
    return false;
}
	$(document).ready(function() {
		//id중복체크
		$("#seller_email").on('change', function(event){
			var emailString = $(this).val();
			var validationResult = emailcheck(emailString);
			if(validationResult == true){
				return;
			}
			alert("이메일 형식이 올바르지 않습니다.")
			});
		$("#idcheck").click(function(event) {
			event.preventDefault();
			var member_id = $("[name='seller_id']").val();

			if (member_id == '') {
				$("[name ='seller_id']").focus();
			} else {
				$.ajax({
					type : 'post',
					url : '/seller/idcheck',
					data : {
						'seller_id' : member_id
					},
					dataType : 'text',
					success : function(result) {
						$("p#idCheckResult").text(result);
					}
				});
			}
		});
		
		$("#signup").click(function(event) {
			event.preventDefault();
			var idCheckResult = $("p#idCheckResult").text();
			if(idCheckResult == ""){
				alert("중복체크를 해주세요.");
				$("#seller_id").focus();
				return false;
			}
			if(idCheckResult == "사용이 불가능한 아이디 입니다"){
				alert("아이디를 다시 입력해주세요.");
				$("#seller_id").focus();
				return false;
			}
			if($("#seller_id").val()==""){
				alert("사용하실 아이디를 입력해주세요.");
				$("#seller_id").focus();
				return false;
			}
			
			if($("#seller_pw").val()==""){
				alert("사용하실 비밀번호를 입력해주세요.");
				$("#seller_pw").focus();
				return false;
			}
			
			if($("#seller_name").val()==""){
				alert("이름을 입력해주세요.");
				$("#seller_name").focus();
				return false;
			}
			
			if($("#seller_email").val()==""){
				alert("사용중인 이메일을 입력해주세요.");
				$("#seller_email").focus();
				return false;
			}
			
			if($("#seller_phone").val()==""){
				alert("사용중인 전화번호를 입력해주세요.");
				$("#seller_phone").focus();
				return false;
			}
			var str = $('#insertform').serialize();
			if(str != ""){
				alert("정삭적으로 회원가입이 되었습니다. 다시 로그인 하여주십시오.")
				$("#insertform").submit();
			}
		});
		
		});

</script>

</body>
</html>