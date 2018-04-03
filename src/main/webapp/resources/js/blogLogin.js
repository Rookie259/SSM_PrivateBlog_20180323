$("#loginButton").click(function () {
    var accountEamil = $("#userEamil").val();
    var password = $("#userPassword").val();
    if (accountEamil != "" && password != "") {
        $.ajax({
            type: "post",
            url: "userController/userLogin.do",
            data: $("#loginForm").serialize(),
            dataType: "json",
            success: function (msg) {
                if (msg.loginState == "exist")
                   // window.location.href = "BlogHomePage.jsp";
                    window.location.href = "writeBlog/achieveBlog.do";
                else if(msg.loginState == "noExist"){
                    $("#errorSpan").text("账号密码错误!请重新输入");
                    $("#errorSpan").css('display', 'block');
                }
            }
        })
    } else {
        $("#errorSpan").css('display', 'block');
        $("#errorSpan").text("请输入完整信息");
    }
})