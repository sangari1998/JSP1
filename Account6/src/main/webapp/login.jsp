<%@page import="biz.vo.AccountingVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- 타이틀단 이미지 32 x 32 -->
    <link rel="shortcut icon" href="./images/fav_logo.png">
    <!-- 모바일단 이미지 180 x 180 -->
    <link rel="apple-touch-icon=precomposed" href="./images/favmc180.png">
    <!-- prefix js파일 -->
    <script src="./js/prefixfree.min.js"></script>
    <!-- 페이지 관련 CSS -->
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/login.css">
</head>
<%
	String id = (String)session.getAttribute("id");
	if(id != null){
		response.sendRedirect("MainAccountCtrl");
	}
%>
<body>
    <div id="wrap" class="card-body">
        <header>
            <h1>회계 JSP</h1>
        </header>
        <section>
            <h2>로그인</h2>
            <form action="LoginCtrl" method="post">
                <table class="table table-bordered">
                    <tr>
                        <td><label for="a_id"> 아이디  : </label></td>
                        <td><input type="text" name="id" id="a_id" required maxlength="15" ></td>
                    </tr>
                    <tr>
                        <td><label for="a_pw"> 비밀번호 : </label></td>
                        <td><input type="password" name="pass" id="a_pw" required maxlength="30"></td>
                    </tr>                    		
                    <tr>
                        <td colspan="5">
                            <input type="submit" value="로그인" class="btn btn-primary">
                            <input type="button" value="회원가입" class="btn btn-success" onclick="location.href='createAccount.jsp'"></input>
                        </td>
                    </tr>							
                    <tr>
                        <td onclick="openCenteredWindow('searchPass.jsp', '_blank', 600, 400);" style="position: relative; left:200px;cursor: pointer;"><a href="login.jsp">비밀번호 찾기</a></td>
                    </tr>									
                </table>
            </form>
        </section>
</div>
<script>
    function openCenteredWindow(url, name, width, height) {
        var left = (window.screen.width - width) / 2;
        var top = (window.screen.height - height) / 2;
        var options = 'width=' + width + ',height=' + height + ',top=' + top + ',left=' + left + ',scrollbars=no';
        window.open(url, name, options);
    }
</script>
</body>
</html>