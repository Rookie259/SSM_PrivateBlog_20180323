﻿/*初始化获取当前用户昵称*/
var nowNIckName;
$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "writeComment/InitializationUser",
        dataType: "json",
        success: function (msg) {
            if (msg.initializationUserInfo != null) {
                $.each(msg, function (i, item) {
                    nowNIckName = item.uNickName;
                })
            } else if (msg.initializationUserInfo == null) {
                acieveNickname();
            }
        }
    })
});

/*获取当前电脑ip*/
function acieveNickname() {
    $.ajax({
        type: "get",
        url: "writeComment/achieveNickName",
        dataType: "json",
        success: function (msg) {
            nowNIckName = msg.nickname;
        }
    })
}


$(function () {
    $('.content').flexText();
});


function keyUP(t) {
    var len = $(t).val().length;
    if (len > 139) {
        $(t).val($(t).val().substring(0, 140));
    }
}


$('.commentAll').on('click', '.plBtn', function () {
    var myDate = new Date();
    //获取当前年
    var year = myDate.getFullYear();
    //获取当前月
    var month = myDate.getMonth() + 1;
    //获取当前日
    var date = myDate.getDate();
    var h = myDate.getHours();       //获取当前小时数(0-23)
    var m = myDate.getMinutes();     //获取当前分钟数(0-59)
    if (m < 10) m = '0' + m;
    var s = myDate.getSeconds();
    if (s < 10) s = '0' + s;
    var now = year + '-' + month + "-" + date + " " + h + ':' + m + ":" + s;
    //获取输入内容
    var oSize = $(this).siblings('.flex-text-wrap').find('.comment-input').val();

    console.log(oSize);
    /*获取游客nickname*/
    var nickname = nowNIckName;
    //动态创建评论模块
    oHtml = '<div class="comment-show-con clearfix">' +
        '<div class="comment-show-con-img pull-left">' +
        '' +
        '<img src="http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%8B%97%E7%8B%97.png" alt=""></div> ' +
        '<div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix">' +
        ' <a href="#" class="comment-size-name"> ' + nickname + ' : </a> ' +
        '<span class="my-pl-con">&nbsp;' + oSize + '</span> </div> ' +
        '<div class="date-dz"> <span class="date-dz-left pull-left comment-time">' + now + '</span>' +
        ' <div class="date-dz-right pull-right comment-pl-block">' +
        ' <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span>' +
        ' <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">0</i>)</a> </div> ' +
        '</div><div class="hf-list-con"></div></div> </div>';
    if (oSize.replace(/(^\s*)|(\s*$)/g, "") != '') {
        $(this).parents('.reviewArea ').siblings('.comment-show').prepend(oHtml);
        $(this).siblings('.flex-text-wrap').find('.comment-input').prop('value', '').siblings('pre').find('span').text('');
    }
});


$('.comment-show').on('click', '.pl-hf', function () {
    //获取回复人的名字
    var fhName = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
    var arr_fhName = fhName.split(":");
    var fhName = "";
    for (var i = 0; i < arr_fhName.length; i++) {
        fhName += arr_fhName[i];
    }

    reply = fhName;
    //回复@
    var fhN = '回复@'.replace(/^(\s|\u00A0)+/, '').replace(/(\s|\u00A0)+$/, '') + fhName.replace(/^(\s|\u00A0)+/, '').replace(/(\s|\u00A0)+$/, '') + ":";
    //var oInput = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
    var fhHtml = '<div class="hf-con pull-left"> ' +
        '<textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"  id="sendDoubleDeckTextarea">' +
        '</textarea> <a href="javascript:;" class="hf-pl"  onclick="writeDoubleDeck();">评论</a></div>';
    //显示回复
    if ($(this).is('.hf-con-block')) {
        $(this).parents('.date-dz-right').parents('.date-dz').append(fhHtml);
        $(this).removeClass('hf-con-block');
        $('.content').flexText();
        $(this).parents('.date-dz-right').siblings('.hf-con').find('.pre').css('padding', '6px 15px');
        //console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
        //input框自动聚焦
        $(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
    } else {
        $(this).addClass('hf-con-block');
        $(this).parents('.date-dz-right').siblings('.hf-con').remove();
    }
});

/*评论回复块创建*/
$('.comment-show').on('click', '.hf-pl', function () {
    var oThis = $(this);
    var myDate = new Date();
    //获取当前年
    var year = myDate.getFullYear();
    //获取当前月
    var month = myDate.getMonth() + 1;
    //获取当前日
    var date = myDate.getDate();
    var h = myDate.getHours();       //获取当前小时数(0-23)
    var m = myDate.getMinutes();     //获取当前分钟数(0-59)
    if (m < 10) m = '0' + m;
    var s = myDate.getSeconds();
    if (s < 10) s = '0' + s;
    var now = year + '-' + month + "-" + date + " " + h + ':' + m + ":" + s;
    //获取输入内容
    var oHfVal = $(this).siblings('.flex-text-wrap').find('.hf-input').val();
    console.log(oHfVal)
    var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
    var oAllVal = '回复@' + oHfName;
    if (oHfVal.replace(/^ +| +$/g, '') == '' || oHfVal == oAllVal) {

    } else {
        $.getJSON("resources/json/comment/pl.json", function (data) {
            var oAt = '';
            var oHf = '';
            $.each(data, function (n, v) {
                delete v.hfContent;
                delete v.atName;
                var arr;
                var ohfNameArr;
                if (oHfVal.indexOf("@") == -1) {
                    data['atName'] = '';
                    data['hfContent'] = oHfVal;
                } else {
                    arr = oHfVal.split(':');
                    ohfNameArr = arr[0].split('@');
                    data['hfContent'] = arr[1];
                    data['atName'] = ohfNameArr[1];
                }

                if (data.atName == '') {
                    oAt = data.hfContent;
                } else {
                    oAt = '回复<a href="#" class="atName">@' + data.atName + '</a> : ' + data.hfContent;
                }
                oHf = data.hfName;
            });
            var atPresentNickname = nowNIckName;
            var oHtml = '<div class="all-pl-con">' +
                '<div class="pl-text hfpl-text clearfix">' +
                '<a href="#" class="comment-size-name">' +
                '' + atPresentNickname + ' : ' +
                '</a>' +
                '<span class="my-pl-con">'
                + oAt + '</span>' +
                '</div>' +
                '<div class="date-dz"> ' +
                '<span class="date-dz-left pull-left comment-time">' + now + '</span>' +
                ' <div class="date-dz-right pull-right comment-pl-block">' +
                /* ' <a href="javascript:;" class="removeBlock">删除</a> ' +*/
                '<a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> ' +
                '<span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left">' +
                '<i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div></div>';
            oThis.parents('.hf-con').parents('.comment-show-con-list').find('.hf-list-con').css('display', 'block').prepend(oHtml) && oThis.parents('.hf-con').siblings('.date-dz-right').find('.pl-hf').addClass('hf-con-block') && oThis.parents('.hf-con').remove();
        });
    }
});

/*删除评论块*/
$('.commentAll').on('click', '.removeBlock', function () {
    var oT = $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con');
    if (oT.siblings('.all-pl-con').length >= 1) {
        oT.remove();
    } else {
        $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con').parents('.hf-list-con').css('display', 'none')
        oT.remove();
    }
    $(this).parents('.date-dz-right').parents('.date-dz').parents('.comment-show-con-list').parents('.comment-show-con').remove();
})

/*点赞*/
/*$('.comment-show').on('click', '.date-dz-z', function () {

})*/


/*
    此插件textarea的高度是 height:100%; 继承父元素的高度 ==> 父元素只有一个 position:relative; 用于定位textarea
    页面中加载完毕又添加了pre标签，pre标签是以块元素存在的并且不可见，但是占用空间，
    不像display:none;什么空间也不占。
    所以textarea父元素的高度是通过pre撑开的(在textarea里面写入文字，文字会被添加到pre底下的span标签里，以此来撑开pre的高度)

    要改变textarea初始化时的高度，只需改变pre的padding值即可，页面加载时pre里面添加<br />标签是为了让pre标签初始时有个高度
 */
;(function ($) {

    // Constructor
    function FT(elem) {
        this.$textarea = $(elem);

        this._init();
    }

    FT.prototype = {
        _init: function () {
            var _this = this;

            // Insert wrapper elem & pre/span for textarea mirroring
            this.$textarea.wrap('<div class="flex-text-wrap" />').before('<pre class="pre"><span /><br /></pre>');

            this.$span = this.$textarea.prev().find('span');

            // Add input event listeners
            // * input for modern browsers
            // * propertychange for IE 7 & 8
            // * keyup for IE >= 9: catches keyboard-triggered undos/cuts/deletes
            // * change for IE >= 9: catches mouse-triggered undos/cuts/deletions (when textarea loses focus)
            this.$textarea.on('input propertychange keyup change', function () {
                _this._mirror();
            });

            // jQuery val() strips carriage return chars by default (see http://api.jquery.com/val/)
            // This causes issues in IE7, but a valHook can be used to preserve these chars
            $.valHooks.textarea = {
                get: function (elem) {
                    return elem.value.replace(/\r?\n/g, "\r\n");
                }
            };

            // Mirror contents once on init
            this._mirror();
        }

        // Mirror pre/span & textarea contents
        , _mirror: function () {
            this.$span.text(this.$textarea.val());
        }
    };

    // jQuery plugin wrapper
    $.fn.flexText = function () {
        return this.each(function () {
            // Check if already instantiated on this elem
            if (!$.data(this, 'flexText')) {
                // Instantiate & store elem + string
                $.data(this, 'flexText', new FT(this));
            }
        });
    };

})(jQuery);


/*评论内容 与后台交互*/
/*发表时*/
$("#sendComment").click(function () {
    id = $("#blog_id").val()
    data = {
        id: $("#blog_id").val(),
        nickname: nowNIckName,
        text: $("#textareaComment").val()
    }
    $.ajax({
        type: "post",
        url: "writeComment/sendZeroComment",
        data: data,
        dataType: "json",
        success: function (msg) {
            if (msg.addBaseComment == "success") {
                $(".commentAll").load("writeComment/sendZeroComment" + {} + " .commentAll").fadeIn("slow")
            }
        }
    })
})

var reply = "";
var nowBaseCommentId;

function achieveBaseCommentId(id) {
    nowBaseCommentId = id;
}

function writeDoubleDeck() {
    var text = $("#sendDoubleDeckTextarea").val();
    var text_split = new Array();
    text_split = text.split(":");
    var text_result = "";
    /*文本内容*/
    var replyName = reply.replace(/^(\s|\u00A0)+/, '').replace(/(\s|\u00A0)+$/, '')
    /*回复人名字*/
    var bid = $("#blog_id").val();
    /*博客id*/

    for (var i = 0; i < text_split.length; i++) {
        if (i > 0) {
            text_result += text_split[i];
        }
    }
    /*
    * 1.获取文本     已有
    * 2.获取回复人   已有
    * 3.获取博客id   已有
    * */
    var replyName_arr = replyName.split(":");
    replyName = "";
    for (var i = 0; i < replyName_arr.length; i++) {
        replyName += replyName_arr[i];
    }
    if (typeof(nowBaseCommentId) == "undefined") {
        nowBaseCommentId = "0"
    }
    data = {
        text: text_result,
        reply: replyName,
        bid: bid,
        baseCommentId: nowBaseCommentId
    }
    $.ajax({
        type: "post",
        url: "writeComment/doubleDeck",
        data: data,
        dataType: "json",
        success: function (msg) {
            $('.comment-show').load("writeComment/doubleDeck" + '').fadeIn('slow');
        }
    })
}


function firstFloor(id) {
    var id_arr = id.split('t');
    var nowId = id_arr[1];
    var blog_Id = $("#blog_id").val();
    data = {
        bid : blog_Id,
        cid : nowId
    }
    $.ajax({
          type : "post",
          url : "writeComment/achieveFirstFloorLike",
          data : data,
          dataType:"json",
          success : function (msg) {
               if(msg.addFirstFloorLikeState == "exist"){
                   alert("点赞失败  已点过赞")
               }else {
                   var zNum = $("#"+id).find('.z-num').html();
                   zNum++;
                   $("#"+id).addClass('date-dz-z-click');
                   $("#"+id).find('.z-num').html(zNum);
                   /*颜色变红*/
                   $("#"+id).find('.date-dz-z-click-red').addClass('red');
                   alert("点赞成功")
               }
          }
    })
}

function douSta(id) {
    var id_arr = id.split('a');
    var nowId = id_arr[1];
    var blog_Id = $("#blog_id").val();
    $.ajax({
        type : "post",
        url : "writeComment/achieveFirstFloorLike",
        data : data,
        dataType:"json",
        success : function (msg) {
            if(msg.addFirstFloorLikeState == "exist"){
            }else {
                var zNum = $("#"+id).find('.z-num').html();
                zNum++;
                $("#"+id).addClass('date-dz-z-click');
                $("#"+id).find('.z-num').html(zNum);
                /*颜色变红*/
                $("#"+id).find('.date-dz-z-click-red').addClass('red');
            }
        }
    })
}