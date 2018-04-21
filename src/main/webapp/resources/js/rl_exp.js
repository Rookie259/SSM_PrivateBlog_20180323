$(function () {
    var rl_exp = {
        baseUrl: 'resources/images/hobby/',
        pace: 200,
        dir: ['mr', 'gnl', 'lxh', 'bzmh'],
        text: [/*表情包title文字，自己补充*/
            [
                'mr00', 'mr01', 'mr02', 'mr03', 'mr04', 'mr05', 'mr06', 'mr07', 'mr08', 'mr09', 'mr10', 'mr11', 'mr12', 'mr13', 'mr14', 'mr15', 'mr16', 'mr17', 'mr18', 'mr19', 'mr20',
                'mr21', 'mr22', 'mr23', 'mr24', 'mr25', 'mr26', 'mr27', 'mr28', 'mr29', 'mr30', 'mr31', 'mr32', 'mr33', 'mr34', 'mr35', 'mr36', 'mr37', 'mr38', 'mr39', 'mr40',
                'mr41', 'mr42', 'mr43', 'mr44', 'mr45', 'mr46', 'mr47', 'mr48', 'mr49', 'mr50', 'mr51', 'mr52', 'mr53', 'mr54', 'mr55', 'mr56', 'mr57', 'mr58', 'mr59', 'mr60',
                'mr61', 'mr62', 'mr63', 'mr64', 'mr65', 'mr66', 'mr67', 'mr68', 'mr69', 'mr70', 'mr71', 'mr72', 'mr73', 'mr74', 'mr75', 'mr76', 'mr77', 'mr78', 'mr79', 'mr80',
                'mr81', 'mr82', 'mr83', 'mr84', 'mr85', 'mr86', 'mr87', 'mr88', 'mr89', 'mr90', 'mr91', 'mr92', 'mr93', 'mr94', 'mr95', 'mr96'
            ],
            [
                'gn00', 'gn01', 'gn02', 'gn03', 'gn04', 'gn05', 'gn06', 'gn07', 'gn08', 'gn09', 'gn10', 'gn11', 'gn12', 'gn13', 'gn14', 'gn15', 'gn16', 'gn17', 'gn18', 'gn19', 'gn20',
                'gn21', 'gn22', 'gn23', 'gn24', 'gn25', 'gn26', 'gn27', 'gn28', 'gn29', 'gn30', 'gn31', 'gn32', 'gn33', 'gn34', 'gn35', 'gn36', 'gn37', 'gn38', 'gn39', 'gn40',
                'gn41', 'gn42', 'gn43', 'gn44', 'gn45', 'gn46', 'gn47', 'gn48', 'gn49', 'gn50', 'gn51', 'gn52', 'gn53', 'gn54', 'gn55', 'gn56', 'gn57', 'gn58', 'gn59', 'gn60',
                'gn61', 'gn62', 'gn63', 'gn64', 'gn65', 'gn66', 'gn67', 'gn68', 'gn69', 'gn70', 'gn71', 'gn72', 'gn73', 'gn74', 'gn75', 'gn76', 'gn77', 'gn78', 'gn79', 'gn80',
                'gn81', 'gn82', 'gn83', 'gn84', 'gn85', 'gn86', 'gn87', 'gn88', 'gn89', 'gn90', 'gn91', 'gn92', 'gn93', 'gn94', 'gn95', 'gn96'
            ],
            [
                'lx00', 'lx01', 'lx02', 'lx03', 'lx04', 'lx05', 'lx06', 'lx07', 'lx08', 'lx09', 'lx10', 'lx11', 'lx12', 'lx13', 'lx14', 'lx15', 'lx16', 'lx17', 'lx18', 'lx19', 'lx20',
                'lx21', 'lx22', 'lx23', 'lx24', 'lx25', 'lx26', 'lx27', 'lx28', 'lx29', 'lx30', 'lx31', 'lx32', 'lx33', 'lx34', 'lx35', 'lx36', 'lx37', 'lx38', 'lx39', 'lx40',
                'lx41', 'lx42', 'lx43', 'lx44', 'lx45', 'lx46', 'lx47', 'lx48', 'lx49', 'lx50', 'lx51', 'lx52', 'lx53', 'lx54', 'lx55', 'lx56', 'lx57', 'lx58', 'lx59', 'lx60',
                'lx61', 'lx62', 'lx63', 'lx64', 'lx65', 'lx66', 'lx67', 'lx68', 'lx69', 'lx70', 'lx71', 'lx72', 'lx73', 'lx74', 'lx75', 'lx76', 'lx77', 'lx78', 'lx79', 'lx80',
                'lx81', 'lx82', 'lx83', 'lx84', 'lx85', 'lx86', 'lx87', 'lx88', 'lx89', 'lx90', 'lx91', 'lx92', 'lx93', 'lx94', 'lx95', 'lx96'
            ],
            [
                'bz00', 'bz01', 'bz02', 'bz03', 'bz04', 'bz05', 'bz06', 'bz07', 'bz08', 'bz09', 'bz10', 'bz11', 'bz12', 'bz13', 'bz14', 'bz15', 'bz16', 'bz17', 'bz18', 'bz19', 'bz20',
                'bz21', 'bz22', 'bz23', 'bz24', 'bz25', 'bz26', 'bz27', 'bz28', 'bz29', 'bz30', 'bz31', 'bz32', 'bz33', 'bz34', 'bz35', 'bz36', 'bz37', 'bz38', 'bz39', 'bz40',
                'bz41', 'bz42', 'bz43', 'bz44', 'bz45', 'bz46', 'bz47', 'bz48', 'bz49', 'bz50', 'bz51', 'bz52', 'bz53', 'bz54', 'bz55', 'bz56', 'bz57', 'bz58', 'bz59', 'bz60',
                'bz61', 'bz62', 'bz63', 'bz64', 'bz65', 'bz66', 'bz67', 'bz68', 'bz69', 'bz70', 'bz71', 'bz72', 'bz73', 'bz74', 'bz75', 'bz76', 'bz77', 'bz78', 'bz79', 'bz80',
                'bz81', 'bz82', 'bz83', 'bz84', 'bz85', 'bz86', 'bz87', 'bz88', 'bz89', 'bz90', 'bz91', 'bz92', 'bz93', 'bz94', 'bz95', 'bz96'
            ]
        ],
        num: [84, 46, 82, 69],
        isExist: [0, 0, 0, 0],
        bind: function (i) {
            $("#rl_bq .rl_exp_main").eq(i).find('.rl_exp_item').each(function () {
                $(this).bind('click', function () {
                    rl_exp.insertText(document.getElementById('rl_exp_input'), '[' + $(this).find('img').attr('title') + ']');
                    $('#rl_bq').fadeOut(rl_exp.pace);
                });
            });
        },
        /*加载表情包函数*/
        loadImg: function (i) {
            var node = $("#rl_bq .rl_exp_main").eq(i);
            for (var j = 0; j < rl_exp.num[i]; j++) {
                if (j < 10) {
                    var domStr = '<li class="rl_exp_item">' +
                        '<img src="' + rl_exp.baseUrl + 'ho/' + rl_exp.dir[i] + '/' + "0" + j + '.gif" alt="' + rl_exp.text[i][j] +
                        '" title="' + rl_exp.text[i][j] + '" />' +
                        '</li>';
                } else {
                    var domStr = '<li class="rl_exp_item">' +
                        '<img src="' + rl_exp.baseUrl + 'ho/' + rl_exp.dir[i] + '/' + j + '.gif" alt="' + rl_exp.text[i][j] +
                        '" title="' + rl_exp.text[i][j] + '" />' +
                        '</li>';
                }

                $(domStr).appendTo(node);
            }
            rl_exp.isExist[i] = 1;
            rl_exp.bind(i);
        },
        /*在textarea里光标后面插入文字*/
        insertText: function (obj, str) {
            obj.focus();
            if (document.selection) {
                var sel = document.selection.createRange();
                sel.text = str;
            } else if (typeof obj.selectionStart == 'number' && typeof obj.selectionEnd == 'number') {
                var startPos = obj.selectionStart,
                    endPos = obj.selectionEnd,
                    cursorPos = startPos,
                    tmpStr = obj.value;
                obj.value = tmpStr.substring(0, startPos) + str + tmpStr.substring(endPos, tmpStr.length);
                cursorPos += str.length;
                obj.selectionStart = obj.selectionEnd = cursorPos;
            } else {
                obj.value += str;
            }
        },
        init: function () {
            $("#rl_bq > ul.rl_exp_tab > li > a").each(function (i) {
                $(this).bind('click', function () {
                    if ($(this).hasClass('selected'))
                        return;
                    if (rl_exp.isExist[i] == 0) {
                        rl_exp.loadImg(i);
                    }
                    $("#rl_bq > ul.rl_exp_tab > li > a.selected").removeClass('selected');
                    $(this).addClass('selected');
                    $('#rl_bq .rl_selected').removeClass('rl_selected').hide();
                    $('#rl_bq .rl_exp_main').eq(i).addClass('rl_selected').show();
                });
            });
            /*绑定表情弹出按钮响应，初始化弹出默认表情。*/
            $("#rl_exp_btn").bind('click', function () {
                if (rl_exp.isExist[0] == 0) {
                    rl_exp.loadImg(0);
                }
                var w = $(this).position();
                $('#rl_bq').css({left: w.left, top: w.top + 30}).fadeIn(400);
            });
            /*绑定关闭按钮*/
            $('#rl_bq a.close').bind('click', function () {
                $('#rl_bq').fadeOut(rl_exp.pace);
            });
            /*绑定document点击事件，对target不在rl_bq弹出框上时执行rl_bq淡出，并阻止target在弹出按钮的响应。*/
            $(document).bind('click', function (e) {
                var target = $(e.target);
                if (target.closest("#rl_exp_btn").length == 1)
                    return;
                if (target.closest("#rl_bq").length == 0) {
                    $('#rl_bq').fadeOut(rl_exp.pace);
                }
            });
        }
    };
    rl_exp.init();	//调用初始化函数。
});


/*点击发表  添加li  并插入数据库信息*/
$("#textButton").click(function () {
    var text = $("#rl_exp_input").val()
    var src_bz = "resources/images/hobby/ho/bzmh/";
    var src_gn = "resources/images/hobby/ho/gnl/";
    var src_lx = "resources/images/hobby/ho/lxh/";
    var src_mr = "resources/images/hobby/ho/mr/";


    if (conBZ(text))
        text = splitGN(text, "bz", src_bz)
    if (conGN(text))
        text = splitGN(text, "gn", src_gn)
    if (conLX(text))
        text = splitGN(text, "lx", src_lx)
    if (conMR(text))
        text = splitGN(text, "mr", src_mr)

    data = {
        text: text
    }
    $.ajax({
        type: "post",
        url: "hobby/addHobby",
        data: data,
        dataType: "json",
        success: function (msg) {
            if (msg.addHobby == "success") {
                $(".myUl").prepend(" <li class=\"myUlLi\">\n" +
                    "                    <div style=\"height: 15px\"></div>\n" +
                    "                    <span style=\"margin-left: 35px;margin-top:20px\">\n" +
                    "                          <img src=\"http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E6%97%A5%E6%9C%9F.png\"\n" +
                    "                               style=\"vertical-align: sub\"> <span style=\"margin-left: 9px;color: #707070\">" + currentTime() + "</span>\n" +
                    "                      </span>\n" +
                    "                    <div class=\"myUlLiText\">\n" +
                    "                        <p>" + text + "</p>\n" +
                    "                    </div>\n" +
                    "                </li><div style='margin-top: 7px;background: #FFFFFF'></div>")

                $("#rl_exp_input").val("")
                $('.myUl').load("hobby/addHobby" + ' .myUl').fadeIn('slow');
            }
        }
    })
})

/*截取gn字符串 并获得每一位gn'的后一位数字*/
function splitGN(text, sp_str, url) {
    var arr_str = text.split(sp_str);
    var charNum = "";
    var arr_res_num = new Array();
    for (var i = 0; i < arr_str.length; i++) {
        if (i > 0) {
            charNum += arr_str[i].charAt(0);
            charNum += arr_str[i].charAt(1);
            arr_res_num.push(charNum)
            charNum = "";
        }
    }
    for (var j = 0; j < arr_res_num.length; j++) {
        text = text.replace("[" + sp_str + "" + arr_res_num[j] + "]", "<img src=" + url + arr_res_num[j] + ".gif" + ">");
    }
    return text;
}

function currentTime() {
    var d = new Date(), str = '';
    str += d.getFullYear() + '-';
    str += d.getMonth() + 1 + '-';
    str += d.getDate() + ' ';
    str += d.getHours() + ':';
    str += d.getMinutes() + ':';
    str += d.getSeconds();
    return str;
}


/*判断是否包含包  bz包图片*/
function conBZ(text) {
    if (text.indexOf("bz") > -1)
        return true;
    else
        return false;
}

/*判断是否包含包  gn包图片*/
function conGN(text) {
    if (text.indexOf("gn") > -1)
        return true;
    else
        return false;
}

/*判断是否包含包  lx包图片*/
function conLX(text) {
    if (text.indexOf("lx") > -1)
        return true;
    else
        return false;
}

/*判断是否包含包  mr包图片*/
function conMR(text) {
    if (text.indexOf("mr") > -1)
        return true;
    else
        return false;
}






