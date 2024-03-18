$(document).ready(function(){
    /* scrollTo 플러그인 사용 */
    $('.gnb a').click(function(e){
        e.preventDefault();
        // scrollTo(링크될 # || Y축픽셀값,애니메이션 시간)
        $(window).scrollTo(this.hash || 0,500);
    });
    
    $(window).scroll(function(){
        var srlT = $(this).scrollTop();
        if(srlT>100) {
            $('aside div').stop().fadeIn('normal');
        }else {
            $('aside div').stop().fadeOut('normal');
        };
    });

    $('.top').on('click',function(e){
        e.preventDefault();
        $('html,body').stop().animate({scrollTop:0},600,'swing');
    });
});

