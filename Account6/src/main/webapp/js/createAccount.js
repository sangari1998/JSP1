$('#idcheck').on('click',function(){
    var id  = $('#a_id').val()
    $.ajax({
        url : 'CreateMemberCtrl',
        data : {"id" : id},
        method : "POST",
        dataType : "JSON",
        success : function(data){
            console.log(data);
            if(data.status == 0){
                alert('사용가능한 아이디 입니다.')
                $('.idchecking').val('idchecked');
            }else if(data.status == 1){
                alert('이미 사용중인 아이디 입니다.')   
            }
        },
        error : function(error){
            alert('에러'+error);
        }
    })
})
//아이디 재입력시 
function checkId(){
    $('.idchecking').val('idunchecked');
    console.log($('.idchecking').val());
}
//비밀번호 같은지를 체크함
function checkPwd() {
    var pw1 = $('#a_pw').val();
    var pw2 = $('#a_pw2').val();
    console.log(pw1)
    if(pw1 == pw2 && pw2!="" ){
        $(".dupliPass").children().css({opacity:'0'})
        $(".dupliPass").children().eq(0).css({opacity:'1'})
        $(".checkpwdEquals").val("Equal");
    }
    if(pw1 != pw2 && pw2!=""){
        $(".dupliPass").children().css({opacity:'0'})
        $(".dupliPass").children().eq(1).css({opacity:'1'})
        $(".checkpwdEquals").val("noEqual");
    }
    if(pw1 == "" || pw2 == ""){
        $(".dupliPass").children().css({opacity:'0'})
        $(".checkpwdEquals").val("noEqual");
    }
    console.log($(".checkpwdEquals").val()+"비밀번호 values값");
}
// 아이디 중복체크를 안하거나 비밀번호가 다르면 폼 제출 방지
$('form').submit(function(e) {
    // 아이디 중복 체크를 수행합니다.
    var checkId = $('.idchecking').val();
    if (checkId != "idchecked") {
        e.preventDefault();
        alert('아이디 중복을 확인해주세요.');
    }
    var checkPwd = $(".checkpwdEquals").val();
    if(checkPwd != "Equal"){
        e.preventDefault();
        alert('비밀번호를 재확인 해주세요.')
    }
    // 연락처 입력값을 가져옵니다.
    var tel1 = $('#a_tel1').val();
    var tel2 = $('#a_tel2').val();
    var tel3 = $('#a_tel3').val();
    var tel = tel1 + tel2 + tel3;

    // 연락처가 숫자로만 이루어져 있는지 확인합니다.
    if (!(/^\d+$/.test(tel))) {
        e.preventDefault();
        alert('연락처에 숫자만 입력가능합니다.');
    }
});
