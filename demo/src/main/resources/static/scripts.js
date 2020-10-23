
//Ajax call to add an order
$(document).ready(function(){
    $("button").click(function(){
       var id=$(this).attr("id")
        $(this).hide();
       $.ajax({
           type:"post",
           data:{
               id:id
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

