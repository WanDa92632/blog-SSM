$(document).ready(function(){
    $(".article").mouseenter((function(){
        $(this).animate({bottom:'2px'},"fast");
    }));
    $(".article").mouseleave((function(){
        $(this).animate({bottom:'0px'},"fast");
    }));
});