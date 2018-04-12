/***
 banner图片效果
 Version 1
 ***/

window.onfocus = function () {
    console.log("note");
    clearInterval(cid);
    clearInterval(rid);
    clearInterval(aid);
    end = 0.5;
    start = 1;
    for (var i = 0; i < img.length; i++) {
        img[i].style.opacity = start;
        img[i].style.filter = "alpha(opacity=" + 100 * start + ")";
    }
    cid = setInterval(chImg, 3500);	//图片定时更换
}
//页面切换后重开定时器

var img = document.getElementById("banner").getElementsByTagName("img"); //img对象
var active = null;		//当前img
var next = null;			//下个img
var cid = null;			//定时器ID
var rid = null; 			//opacity减小函数ID
var aid = null;			//opacity增大函数ID
var start = 1;			//最大opacity
var end = 0.5;			//最小opacity
var delay = 100;			//延迟

function chImg() {
    //获取当前显示img
    for (var i = 0; i < img.length; i++) {
        if (img[i].style.display == "block") {
            active = i;
        }
    }
    //启动opacity减小定时器
    rid = setInterval(reduce, delay);
}

//opacity减小函数
function reduce() {
    start = (start * 10 - 1) / 10;
    console.log(start);
    if (start > end) {
        img[active].style.opacity = start;
        img[active].style.filter = "alpha(opacity=" + 100 * start + ")";
    }
    else {
        img[active].style.display = "none";				//隐藏当前img
        if (active < (img.length - 1)) {
            next = active + 1;
        }
        else {
            next = 0;
        }
        img[next].style.display = "block";				//显示下个img
        img[next].style.opacity = 0;					//初始透明0
        start = 1;
        clearInterval(rid);							//清除减小opacity定时器
        rid = null;
        aid = setInterval(add, delay);
    }
}

//opacity增大函数
function add() {
    end = (end * 10 + 1) / 10;
    // end = (Math.round(end*10))/10;
    console.log(end);
    if (end < start) {
        img[next].style.opacity = end;
        img[next].style.filter = "alpha(opacity=" + 100 * end + ")";
    }
    else {
        end = 0.5;
        clearInterval(aid);						//清除增大opacity定时器
        aid = null;
    }
}

cid = setInterval(chImg, 3500);	//图片定时更换

/*获取全文内容*/
function blogFullText(id) {
    data = {
        bid: id
    }
    $.ajax({
        type: "get",
        url: "writeBlog/achieveFullText.do",
        data: data,
        dataType: "json",
        success: function (msg) {
              if(msg.achieveState == "success")
                  window.location.href = "bodet94192577.do";
        }
    })
}