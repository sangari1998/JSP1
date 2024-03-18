<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
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
            <h2>�����Ͻ� ȸ������ ��й�ȣ</h2>
                <table class="table table-bordered">
                    <tr>
                        <td><label for="a_id"> ��й�ȣ  : ${ originalPass} </label></td>
                        <td>�Դϴ�.</td>
                    </tr>						
                </table>
        </section>
</div>
</body>
</html>