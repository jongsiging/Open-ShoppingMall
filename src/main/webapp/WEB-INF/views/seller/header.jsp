<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<style type="text/css">
body {
    font-size: 12px;
    margin: 0;
}

#rolling {
    outline-color: activeborder;
    background-color: inherit;
    
}

#roll a {
    color: white;
    text-decoration: none;
 
}

#roll a:hover {
    text-decoration: underline;
    color: black;
}

#roll {
    overflow: hidden;
    width: 120px;
    height: 38px;
    margin: 0;
    color: white;
}


#roll ul {
    position: relative;
    margin: 0;
    color: white;
}

#roll ol {
    position: absolute;
    top: 0;
    left: 0;
    margin: 0;
    padding: 0;
    list-style-type: none;
    color: white;
}

#roll li {
    height: 38px;
    line-height: 38px;
    color: white;
    text-overflow: ellipsis;
   white-space: nowrap;
   overflow: hidden;
   width : 100px;
}
</style>
<style type="text/css">
      
.cat-box {
position : relative;
height : 38px;
cursor : pointer;
background-color: inherit;

}

.cat-box:after {
content: '';
display:block;
height : 100%;
position : absolute;
}

.cat-box .cat-label {
color : white;
height : inherit;
width : 100px;
cursor : pointer;
outline: white;
}

.cat-box .cat-menu {
position : absolute;
list-style-type : none;
overflow : hidden;
transition : .3s ease-in;
}

.cat-box.active .cat-menu {
max-height : 500px;
}

.cat-box .cat-item {
transition : .1s;
}

.cat-box .cat-item:hover {
background : gray;
}

.cat-box .cat-item:last-child {
border-bottom:0 none;
}

.area-search {
margin-top : 18px;
display: inline-table;
}

.put {
margin-top : 15px;
display: inline-block;
}
#search_btn {
display : inline-block;
background-color: white;
height : 38px;

}
</style>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="div1">
  <span class="navbar-brand mb-0 h1"><a class="nav-link text-light" href="/seller">DAPAN&DA Seller</a></span>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <!-- <li class="nav-item active">
        <a class="nav-link text-light" href="/">Home<span class="sr-only">(current)</span></a>
      </li> -->
      <li class="nav-item">
      </li>
    </ul>
  </div>
</nav>


    <header class="bg-light d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0 ml-5">
      <c:choose>
          <c:when test="${empty sellerLogin}">
            <li><a href="/seller" class="nav-link px-2 link-secondary text-dark">Home</a></li>
           <li><a href="/seller/loginUI" class="nav-link px-2 link-dark text-dark">아이템</a></li>
           <li><a href="/seller/loginUI" class="nav-link px-2 link-dark text-dark">주문 목록</a></li>
           <li><a href="/seller/loginUI" class="nav-link px-2 link-dark text-dark">리뷰 목록</a></li>
           <li><a href="/seller/loginUI" class="nav-link px-2 link-dark text-dark">QnA 목록</a></li>
          </c:when>
          
          <c:when test="${not empty sellerLogin}">
            <li><a href="/seller" class="nav-link px-2 link-secondary text-dark">Home</a></li>
           <li><a href="/seller/listForSeller/${sellerLogin.seller_id}/1" class="nav-link px-2 link-dark text-dark">아이템</a></li>
           <li><a href="/seller/orderlist/${sellerLogin.seller_id}" class="nav-link px-2 link-dark text-dark">주문 목록</a></li>
           <li><a href="/seller/reviewlist/${sellerLogin.seller_id}" class="nav-link px-2 link-dark text-dark">리뷰 목록</a></li>
           <li><a href="/seller/qnalist/${sellerLogin.seller_id}" class="nav-link px-2 link-dark text-dark">QnA 목록</a></li>
          </c:when>
        </c:choose>
     
      </ul>

      <div class="col-md-3 text-end">
        <c:choose>
          <c:when test="${empty sellerLogin}">
            <a class="btn btn-outline-primary btn-sm" href="/seller/loginUI">로그인</a>
            <a class="btn btn-outline-primary btn-sm" href="/seller/insert">회원가입</a>
          </c:when>
          
          <c:when test="${not empty sellerLogin}">
            ${sellerLogin.seller_id} 님, 환영합니다. 
            <a class="btn btn-outline-primary btn-sm" href="/seller/read/${sellerLogin.seller_id}">회원 정보 보기</a> 
            <a class="btn btn-outline-primary btn-sm" href="/seller/logout">로그아웃</a>
          </c:when>
        </c:choose>
      </div>
    </header>