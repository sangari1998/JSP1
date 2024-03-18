<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>�α���</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- Ÿ��Ʋ�� �̹��� 32 x 32 -->
    <link rel="shortcut icon" href="./images/fav_logo.png">
    <!-- ����ϴ� �̹��� 180 x 180 -->
    <link rel="apple-touch-icon=precomposed" href="./images/favmc180.png">
    <!-- prefix js���� -->
    <script src="./js/prefixfree.min.js"></script>
    <!-- ������ ���� CSS -->
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
            <h1>�̸��Ϸ� ���۵� ������ȣ 6�ڸ��� �Է����ּ���.</h1>
            <h2 class="timer"></h2>
        </header>
        <section>
            <form action="CheckPassCtrl2" method="post">
                <table class="table table-bordered">
                    <tr>
                        <td><label for="pass"> ������ȣ  : </label></td>
                        <td><input type="text" name="pass" id="pass" required ></td>
                    </tr>                   		
                    <tr>
                        <td colspan="5">
                            <input type="submit" value="������ȣ �Է�" class="btn btn-primary">
                        </td>
                    </tr>							
                </table>
            </form>
        </section>
</div>
<script>
    // Ÿ�̸� Ŭ������ ������ �߰��ϴ� �Լ�
    var seconds = 180;
    function updateTimer() {
        var timerElement = document.querySelector('.timer');
        seconds--;
        if(seconds == 0){
            alert('�ð��� ����Ǿ� �� �������� ���ư��ϴ�.')
            history.back();
        }
        // ������ �ؽ�Ʈ�� �����Ͽ� ��ҿ� �߰�
        timerElement.textContent = '���� �ð�: ' + seconds;
    }
    // �� �ʸ��� updateTimer �Լ��� ȣ���Ͽ� Ÿ�̸� ������Ʈ
    setInterval(updateTimer, 1000);
</script>
</body>
</html>