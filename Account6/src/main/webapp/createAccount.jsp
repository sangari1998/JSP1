<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- 타이틀단 이미지 32 x 32 -->
    <link rel="shortcut icon" href="./images/fav_logo.png">
    <!-- 모바일단 이미지 180 x 180 -->
    <link rel="apple-touch-icon=precomposed" href="./images/favmc180.png">
    <!-- prefix js파일 -->
    <script src="./js/prefixfree.min.js"></script>
    <script src="./js/jquery-1.12.4.min.js"></script>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <!-- 페이지 관련 CSS -->
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/createAccount.css">
    <style>
        tr,td{
            border: none !important;
        }
    </style>
</head>
<body>
        <div id="wrap" class="card-body">
            <header>
                <h1>회원가입</h1>
            </header>
            <section>
                <form action="CreateMemberCtrl2" method="post" >
                    <table class="table table-bordered">
                        <tr>
                            <td><label for="a_id">아이디</label></td>
                            <td>
                                <input type="text" name="id" id="a_id" required oninput="checkId()" >
                            </td>
                            <td>
                                <input type="button" value="아이디 중복 체크" id="idcheck" class="btn btn-success">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="a_pw">비밀번호</label></td>
                            <td><input type="password" name="pass" id="a_pw" required oninput="checkPwd()"></td>
                        </tr>
                        <tr>
                            <td><label for="a_pw2">비밀번호 확인</label></td>
                            <td><input type="password" name="pass2" id="a_pw2" required oninput="checkPwd()"></td>
                            <td class="pwdch">
                                <div></div>
                                <div class="dupliPass">
                                    <div>비밀번호가 일치합니다.</div>
                                    <div>비밀번호가 일치하지 않습니다.</div>
                                </div>
                            </td>
                        </tr>           
                        <tr>
                            <td><label for="a_name">이름</label></td>
                            <td><input type="text" name="name" id="a_name" required></td>
                        </tr>         
                        <tr>
                            <td><label for="a_tel1">연락처</label></td>
                            <td>
                                <input type="tel" name="tel1" id="a_tel1" required maxlength="4">&nbsp;&nbsp;-
                                <input type="tel" name="tel2" id="a_tel2" required maxlength="4">&nbsp;&nbsp;&nbsp;-
                                <input type="tel" name="tel3" id="a_tel3" required maxlength="4">                                
                            </td>
                        </tr>	
                        <tr>
                            <td>
                                <label for="a_email">이메일</label>
                            </td>
                            <td>
                                <input type="email" name="email" id="a_email" required placeholder="joo888889@naver.com" >
                            </td>
                        </tr>	
                        <tr>
                            <td>
                                <input type="submit" value="회원가입" class="btn btn-primary">
                            </td>
                        </tr>															
                    </table>
                    <input type="hidden" name="idDuplication" value="idunchecked" class="idchecking">
                    <input type="hidden" name="equalsPwd" value="noEqual" class="checkpwdEquals">
                </form>
            </section>
        </div>
        <script src="./js/createAccount.js"></script>
    </body>
</html>