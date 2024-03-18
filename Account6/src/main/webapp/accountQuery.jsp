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
    <script src="./js/accountQuery.js"></script>
    <!-- 기본 Reset CSS -->
    <link rel="stylesheet" href="./css/reset.css">
    <!-- 페이지 관련 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/accountQuery.css">
    <link rel="stylesheet" href="./css/Main.css">
  
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
                <p><a href="MainAccountCtrl">메인페이지로 이동</a></p>
                <p><%=name %>님 반갑습니다 &nbsp;&nbsp;</p>
                <button class="btn btn-secondary" onclick="location.href='LogoutCtrl'">로그아웃</button>
            </aside>
        </div>
        <header>
        <a href="accountInsert.jsp" class="btn btn-primary" style="position: relative;left: 550px;top: 50px;">추가 입력하기</a>
        </header>
        <h1>날짜 조회하기</h1>
        <section class="contents">
           <form action="AccountQueryCtrl" method="post">
                <table class="table" id="tb1">
                    <tr>
                        <td>조회기간</td>
                    </tr>
                    <tr>
                        <td>
                            <select name="selectYear1" >
                                <option >--</option>
                                <option value="2023">2023</option>
                                <option value="2024">2024</option>
                                <option value="2025">2025</option>
                                <option value="2026">2026</option>
                                <option value="2027">2027</option>
                                <option value="2028">2028</option>
                                <option value="2029">2029</option>
                                <option value="2030">2030</option>
                                <option value="2031">2031</option>
                                <option value="2032">2032</option>
                                <option value="2033">2033</option>
                                <option value="2034">2034</option>
                                <option value="2035">2035</option>
                                <option value="2036">2036</option>
                                <option value="2037">2037</option>
                            </select>
                            년
                            <select name="selectMonth1" class="selectMonth1">
                                <option >--</option>
                                <option value="01">1</option>
                                <option value="02">2</option>
                                <option value="03">3</option>
                                <option value="04">4</option>
                                <option value="05">5</option>
                                <option value="06">6</option>
                                <option value="07">7</option>
                                <option value="08">8</option>
                                <option value="09">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                            월
                            <select name="selectDay1" class="selectDay1">
                                <option>--</option>

                            </select>
                            일&nbsp;&nbsp;부터&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                        <td>
                            <select name="selectYear2" >
                                <option >--</option>
                                <option value="2023">2023</option>
                                <option value="2024">2024</option>
                                <option value="2025">2025</option>
                                <option value="2026">2026</option>
                                <option value="2027">2027</option>
                                <option value="2028">2028</option>
                                <option value="2029">2029</option>
                                <option value="2030">2030</option>
                                <option value="2031">2031</option>
                                <option value="2032">2032</option>
                                <option value="2033">2033</option>
                                <option value="2034">2034</option>
                                <option value="2035">2035</option>
                                <option value="2036">2036</option>
                                <option value="2037">2037</option>
                            </select>
                            년
                            <select name="selectMonth2" class="selectMonth2">
                                <option >--</option>
                                <option value="01">1</option>
                                <option value="02">2</option>
                                <option value="03">3</option>
                                <option value="04">4</option>
                                <option value="05">5</option>
                                <option value="06">6</option>
                                <option value="07">7</option>
                                <option value="08">8</option>
                                <option value="09">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                            월
                            <select name="selectDay2" class="selectDay2">
                                <option>--</option>
                            </select>
                            일&nbsp;&nbsp;까지
                            <div>
                                <input type="submit" value="조회" class="btn btn-primary" style="position: relative;top: -30px;left: 180px;">
                            </div>
                        </td>
                    </tr>

<%
	String deposit = String.valueOf((long)request.getAttribute("deposit"));
	String withdraw = String.valueOf((long)request.getAttribute("withdraw"));
	String sum = String.valueOf((long)request.getAttribute("deposit")-(long)request.getAttribute("withdraw"));
	

%>            
            <tr class="result">
                <td>총 입금금액</td>
                <td>총 출금금액</td>
                <td>결산 금액</td>
            </tr>
            <tr>
                <td><%= deposit %>원</td>
                <td><%= withdraw %>원</td>
                <td><%= sum %>원</td>
            </tr>
            <tr>
                <td style="position: relative;left: -100px;">입금 내역</td>
                <td style="position: relative;left: 35px;">출금 내역</td>
            </tr>
        </table>
        <div class="recent" style="width:900px;">
            <table class="table" id="recent_table1">
                <tr>
                    <td style="width:175px;">최근입금 내역</td>
                    <td style="width:175px;">최근입금 금액</td>
                </tr>
<c:forEach var="list1" items="${depositlist }">         
                <tr>
                    <td>${list1.regdate }</td>
                    <td>${list1.money }원</td>
                    <td>
                        <input type="button" value="상세보기" onclick='location.href="AccountDetailCtrl?seq=${list1.seq}"'>
                        <input type="hidden" name="seq" value="${list1.seq }">
                    </td>
                </tr>
</c:forEach>                
            </table>
            <table class="table" id="recent_table2" style="width: 350px" >
                <tr>
                    <td style="width:175px;">최근입금 내역</td>
                    <td style="width:175px;">최근입금 금액</td>
                </tr>
<c:forEach var="list2" items="${withdrawlist }">                 
                <tr>
                    <td>${list2.regdate }</td>
                    <td>${list2.money }원</td>
                    
	                    <td>
	                        <input type="button" value="상세보기" onclick='location.href="AccountDetailCtrl?seq=${list2.seq}"'>
	                        <input type="hidden" name="seq" value="${list2.seq }">
	                    </td>
                </tr>
</c:forEach>                
            </table>  
     
     </div>
     </form>
        </section>
        </div>
</body>
</html>