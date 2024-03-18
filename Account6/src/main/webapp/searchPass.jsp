<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
    </style>
</head>
<body>
    <div id="wrap" class="card-body">
        <header>
            <h1>비밀번호 찾기</h1>
        </header>
        <section>
            <h2>가입하신 아이디와 이메일을 입력해주세요.</h2>
            <form action="CheckPassCtrl" method="post">
                <table class="table table-bordered">
                    <tr>
                        <td><label for="a_id"> 아이디  : </label></td>
                        <td><input type="text" name="id" id="a_id" required ></td>
                    </tr>
                    <tr>
                        <td><label for="a_email"> 이메일 : </label></td>
                        <td><input type="email" name="email" id="a_email" required ></td>
                    </tr>                    		
                    <tr>
                        <td colspan="5">
                            <input type="submit" value="비밀번호 찾기" class="btn btn-primary">
                        </td>
                    </tr>							
                </table>
            </form>
        </section>
</div>
</body>
</html>