
$("#release").click(function () {
    $.ajax({
        type : "post",
        url : "writeBlog/publish.do",
        dataType : "json",
        success : function (msg) {
            alert(msg.state)
            if(msg.state == "success")
                window.location.href = "writeBlog/achieveBlog.do"
        }
    })
})