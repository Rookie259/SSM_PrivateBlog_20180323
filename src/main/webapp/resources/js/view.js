$(".likename img").click(function () {
    var src = $(this).attr('src');
    var src_1 = "http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%82%B9%E8%B5%9E(2).png";
    var src_2 = "http://rookieblog.oss-cn-beijing.aliyuncs.com/resources/%E7%82%B9%E8%B5%9E(3).png";

    if (src == src_1) {
        data = {
            bid: $("#blog_id").val()
        }
        $.ajax({
            type: "post",
            url: "writeComment/writeLike",
            data: data,
            dataType: "json",
            success: function (msg) {
                if (msg.likeState == "noExist") {
                    //当前ip未点赞
                    var like = $(".lickCount_1").text();
                    $(".lickCount_1").text(Number(like) + 1);
                    $(".likename img").attr('src', src_2);
                } else if (msg.likeState == "exist") {
                    //当前ip已经点赞
                }
            }
        })
    }
})

/*点击推荐进入*/
function recommend(id) {
/*    data = {
        bid: id
    }
    $.ajax({
        type: "get",
        url: "writeBlog/achieveFullText",
        data: data,
        dataType: "json",
        success: function (msg) {
            if (msg.achieveState == "success")*/
                window.location.href = "writeBlog/achieveFullText/"+id;
/*        }
    })*/
}


