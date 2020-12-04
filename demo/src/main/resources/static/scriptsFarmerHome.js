//Adding CSRF token to each ajax call
//REFERENCE:https://docs.spring.io/spring-security/site/docs/3.2.0.CI-SNAPSHOT/reference/html/csrf.html
$(document).ready(function(){
    $(function () {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
})

//Ajax call to see details
$(document).ready(function(){
    $("button").click(function(){
        var userId=$(this).attr("id")

        $.ajax({
            type:"post",
            data:{
                userId:userId
            },
            url:"/farmerhome/addressDetails",
            dataType:"text",
            success:function(data){
                alert(data);
            }
        })
    });
});