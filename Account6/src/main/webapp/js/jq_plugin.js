$(function(){
    $('ul li').eq(0).click(function(){
        $('article img').stop().show('shake',1000);
    });
    $('ul li').eq(1).click(function(){
        $('article img').stop().hide('fold','fast');
    });
    $('ul li').eq(2).click(function(){
        $('article img').stop().toggle('explode',1000);
    });

    /* 2. jQuery Core에서는 속성값이 숫자인것만 가능 
       jQuery UI 플러그인에서는 대부분 속성 사용 가능
    */
    // 실습.

    $('ul li').eq(3).click(function(){
        $('footer').stop().animate({backgroundColor:'black',color:'silver'},500);
        $('footer span').stop().animate({color:'red',fontWeight:'700'},3000);
    });
});