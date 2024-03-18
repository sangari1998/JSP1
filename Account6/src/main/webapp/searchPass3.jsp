<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
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
    <style>
        #wrap {
            width: 600px;
            height: 400px;
            margin: 0 auto;
        }
        h2 {
            font-size: 20px;
            font-weight: 700;
            margin-bottom: 50px;
        }
    </style>
</head>
<body>
    <div id="wrap" class="card-body">
        <section>
            <h2>가입하신 회원님의 비밀번호</h2>
                <table class="table table-bordered">
                    <tr>
                        <td><label for="a_id"> 비밀번호  : ${ originalPass} </label></td>
                        <td>입니다.</td>
                    </tr>						
                </table>
        </section>
</div>
</body>
</html>