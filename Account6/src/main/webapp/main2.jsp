<%@page import="biz.vo.AccountingVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회계메인</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- 타이틀단 이미지 32 x 32 -->
    <link rel="shortcut icon" href="./images/fav_logo.png">
    <!-- 모바일단 이미지 180 x 180 -->
    <link rel="apple-touch-icon=precomposed" href="./images/favmc180.png">
    <!-- prefix js파일 -->
    <script src="./js/prefixfree.min.js"></script>
    <script src="./js/jquery-1.12.4.min.js"></script>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <!-- 기본 Reset CSS -->
    <link rel="stylesheet" href="./css/reset.css">
    <!-- 페이지 관련 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/accountQuery.css">
    <link rel="stylesheet" href="./css/Main.css">
    <link rel="stylesheet" href="./css/accountDetail.css">
    <style>
		aside {
    		display: flex;
    		flex-flow: row wrap;
    		justify-content: end;
		}
		aside p {
    		padding-top: 7px;
		}
		aside p:first-child {
    		position: absolute;
    		left: 150px;
    		top: 50px;
    		font-size: 20px;
		}
		header {
    		display: flex;
    		flex-flow: row wrap;
    		justify-content: center;
		}
        #wrap{
           width: 1300px;
           margin: 0 auto;
           border: 1px solid #ccc;
           padding-bottom: 200px;
        }
        h2{
        	margin-bottom: 100px;
        }
     </style>    
</head>
<%
	// 아이디 이름 부여권한 세션에 담겨있음  
	String name = (String)session.getAttribute("name");
	String grandted = (String)session.getAttribute("granted");
	if( name == null ){
%>
	<script>
		alert('로그인 먼저 해주세요');
		location.href='login.jsp'
	</script>
<%		
	}
%>
<body>
    <div id="wrap" class="card-body">
        <div>
            <aside>
                <p><a href="#">메인페이지로 이동</a></p>
                <p><%=name %>님 반갑습니다 &nbsp;&nbsp;</p>
                <button class="btn btn-secondary" onclick="location.href='LogoutCtrl'">로그아웃</button>
            </aside>
        </div>
        <header>
        <a href="#" class="btn btn-primary" style="position: relative;left: 550px;top: 50px;">추가 입력하기</a>
        </header>
        <h2>상세 조회하기</h2>
        <section class="contents">
    <form action="AccountUpdateCtrl" method="post">
        <table class="table" id="tb1">
            <tr style="width: 900px;">
                <td style="font-size: 28px;position: relative;left: -20px;">날짜</td>
                <td style="position: relative;left: -60px;">구분</td>
                <td style="position: relative;left: -40px;">금액</td>
                <td>사용목적</td>
            </tr>
            <tr style="width: 900px;">
                <td>${vo.getRegdate() }</td>
<c:if test="${vo.getCategory() == '입금' }">                
                <td>
                    <select name="category" id="income">
                        <option value="입금" selected>입금</option>
                        <option value="출금">출금</option>
                    </select>                    
                </td>
</c:if>
<c:if test="${vo.getCategory() == '출금' }">                
                <td>
                    <select name="category" id="income">
                        <option value="입금">입금</option>
                        <option value="출금" selected>출금</option>
                    </select>                    
                </td>
</c:if>
                <td><input type="text" name="money" id="money" value="${vo.getMoney() }"><span>원</span></td>
                <td><input type="text" name="note" id="object" value="${vo.getNote() }"></td>
            </tr>
        </table>
        <table class="table" id="tb2">
            <tr>
                <td>
                    <input type="submit" value="수정" class="btn_modify btn btn-primary">
                    <input type="button" value="삭제" class="btn_delete btn btn-secondary">
                    <input type="hidden" name="seq" value="${vo.getSeq() }">
                </td>
            </tr>
        </table>
    </form>              
        </section>
        </div>
</body>
</html>