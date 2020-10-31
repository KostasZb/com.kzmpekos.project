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


//Ajax call to add an order
$(document).ready(function(){
    $("button").click(function(){
       var productId=$(this).attr("id")

        $(this).hide();
       $.ajax({
           type:"post",
           data:{
               productId:productId
           },
           url:"/market/order",
           dataType:"text",
           success:function(data){
               alert(data);
           }
       })
    });
});

//deselecting checkbox if the other one is selected

$(document).ready(function(){
    $("#farmer").on("click",(function(){
        $("#customer").prop("checked",false);
    }))
})

$(document).ready(function(){
    $("#customer").click(function(){
        $("#farmer").prop("checked",false);

    })
})

