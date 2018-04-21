$("#loginButton").click(function () {
    var accountEamil = $("#userEamil").val();
    var password = $("#userPassword").val();
    if (accountEamil != "" && password != "") {
        $.ajax({
            type: "post",
            url: "userController/userLogin",
            data: $("#loginForm").serialize(),
            dataType: "json",
            success: function (msg) {
                var num = "564654654";
                if (msg.loginState == "exist")
                window.location.href = "writeBlog/achieveBlog";
                else if (msg.loginState == "noExist") {
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

var count = 0;
function checkRegister() {
    var question, solution;
    question = prompt("谁制作的本页面?");
    if (question == "沐惜真NB" || question == "come on") {
        window.location.href = "userController/checkRegisterIsOk"
    }
    else {
        switch ((parseInt(8 * Math.random())).toString()) {
            case "1" :
                alert("这都可以输错,你可真够笨的啊")
                break;
            case "2" :
                alert("给你一次重新组织语言的机会")
                break;
            case "3" :
                alert("在乱说我就报警了啊")
                break;
            case "4" :
                alert("不听不听 王八念经")
                break;
            case "5" :
                alert("任你千言万语,我也佁然不动")
                break;
            case "6" :
                alert("曾梦想仗剑走天涯,可没出门bug就到啦")
                break;
            case "7" :
                alert("一bug甩你脸上")
                break;
            case "8" :
                alert("啦啦啦 啦啦啦 我是卖bug的小行家")
                break;
        }
    }
}