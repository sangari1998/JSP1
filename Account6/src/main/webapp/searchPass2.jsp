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
            <h1>이메일로 전송된 인증번호 6자리를 입력해주세요.</h1>
            <h2 class="timer"></h2>
        </header>
        <section>
            <form action="CheckPassCtrl2" method="post">
                <table class="table table-bordered">
                    <tr>
                        <td><label for="pass"> 인증번호  : </label></td>
                        <td><input type="text" name="pass" id="pass" required ></td>
                    </tr>                   		
                    <tr>
                        <td colspan="5">
                            <input type="submit" value="인증번호 입력" class="btn btn-primary">
                        </td>
                    </tr>							
                </table>
            </form>
        </section>
</div>
<script>
    // 타이머 클래스에 변수를 추가하는 함수
    var seconds = 180;
    function updateTimer() {
        var timerElement = document.querySelector('.timer');
        seconds--;
        if(seconds == 0){
            alert('시간이 만료되어 전 페이지로 돌아갑니다.')
            history.back();
        }
        // 변수를 텍스트로 설정하여 요소에 추가
        timerElement.textContent = '남은 시간: ' + seconds;
    }
    // 매 초마다 updateTimer 함수를 호출하여 타이머 업데이트
    setInterval(updateTimer, 1000);
</script>
</body>
</html>