var nickNameExit = false;       //昵称存在状态
var eamilExit = false;        //邮箱是否被注册
var eamilCode = "";          //验证码
//1.检测昵称是否存在
//返回值 exist 存在  non-existent 不存在
$("#nickName").blur(function () {
    data = {
        nickName: $("#nickName").val()
    }
    $.ajax({
        type: "post",
        url: "userController/userNicknameIsExist.do",
        data: data,
        dataType: "json",
        success: function (msg) {
            if (msg.nicknameState == "exist") {
                nickName = true;
                $("#nickName").val("");
                $("#nickName").attr('placeholder', '昵称已经存在')
            }
        }
    })
})


//2.检测密码是否相同
function passwordFit() {
    var pwd = $("#pwd").val();
    var pwd2 = $("#pwd2").val();
    if (pwd == "") {
        $("#pwd").attr('placeholder', '密码不可为空');
        return false;
    }
    if (pwd2 == "") {
        $("#pwd").attr('placeholder', '请再次输入密码');
        return false;
    }
    if (pwd != "" && pwd2 != "") {
        if (pwd == pwd2) {
            return true;
        } else {
            $("#hintMassage").attr('placeholder', '请输入相同密码');
            return false;
        }
    }
}

//3.判断邮箱是否已被注册
$("#userEamil").blur(function () {
    if (checkEamil($("#userEamil").val())) {
        data = {
            userEamil: $("#userEamil").val()
        }
        $.ajax({
            type: "post",
            url: "userController/userEamilIsExist.do",
            data: data,
            dataType: "json",
            success: function (msg) {
                if (msg.userEamilState == "exist") {
                    eamilExit = true;
                    $("#hintMassage").text("邮箱已被注册");
                } else
                    $("#hintMassage").text("");
            }
        });
    } else if ($("#userEamil").val() != "") {
        $("#hintMassage").text("邮箱格式不出正确");
    }
})

//正则表达式 检测邮箱是否正确
function checkEamil(eamil) {
    var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
    if (myReg.test(eamil)) {
        return true;
    } else {
        $("#hintMassage").text("邮箱格式错误");
        return false;
    }
}


//4.获取验证码
$("#achieveCode").click(function () {
    if ($("#userEamil").val() != "") {
        data = {
            userEamil: $("#userEamil").val()
        }
        $.ajax({
            type: "post",
            url: "userController/userAchieveCode.do",
            data: data,
            dataType: "json",
            success: function (msg) {
                theLast();
                eamilCode = msg.code;
            }
        })
    } else {
        $("#hintMassage").text("请输入邮箱");
    }
})
var countdown = 60;

function theLast() {
    if (countdown == 0) {
        $("#achieveCode").css('background-color', '205AA7');
        $("#achieveCode").attr("disabled", false);
        $("#achieveCode").attr("value", "免费获取验证码");
        countdown = 60;
        return;
    } else {
        $("#achieveCode").css('background-color', 'A0A0A0');
        $("#achieveCode").attr("disabled", true);
        $("#achieveCode").attr("value", "重新发送(" + countdown + ")");
        $("#achieveCode").removeClass("hover");
        countdown--;
    }
    setTimeout(theLast, 1000)
}


//5.信息完善 开始注册
$("#register").click(function () {
    if (nickNameExit == false && passwordFit() == true && eamilExit == false && eamilCode != "") {
        $.ajax({
            type: "post",
            url: "userController/userRegister.do",
            data: $("#registerForm").serialize(),
            dataType: "json",
            success: function (msg) {
                if (msg.registerState == "registerError")
                    $("#hintMassage").text("信息输入错误");
                else
                    window.location.href = "BlogLogin.jsp"
            }
        })
    } else if ($("#nickName").val() == "") {
        $("#hintMassage").text("请输入昵称");
    } else if (eamilCode == "") {
        $("#hintMassage").text("请输入邮箱验证码");
    } else if (eamilCode == "" && $("#userCode").val() != "") {
        $("#hintMassage").text("请输入正确验证码");
    }
    else {
        $("#hintMassage").text("请完善注册信息");
    }
})