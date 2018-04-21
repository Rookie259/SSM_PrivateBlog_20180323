var count = 1;
/*获取全文内容*/
function blogFullText(id) {
    window.open("writeBlog/achieveFullText/" + id);
}

$("#moreArticle").click(function () {
    data = {
        begin: 3 * count
    }
    $.ajax({
        type: "get",
        url: "writeBlog/achieveMoreBlog",
        data: data,
        dataType: "json",
        success: function (msg) {
            /*integerList*/
            var integerList = msg.machBlog[0];
            var topBlog = msg.machBlog[1];
            var dateBlog = msg.machBlog[2];
            var list_label = msg.machBlog[3];
            $.each(topBlog, function (blogIndex, blog) {
                var oHtml = " <div class=\"article\">\n" +
                    "                <div class=\"article-logo\">";
                $.each(dateBlog,function (dateIndex,date) {
                    if(dateIndex == blogIndex){
                        oHtml += " <span class=\"month\">"+date.month+"月</span>\n" +
                            "                        <span class=\"day\">"+date.day+"</span>";
                    }
                });
                oHtml += "   </div>\n" +
                    "                <div class=\"article-body\">\n" +
                    "                    <div class=\"article-title\">\n" +
                    "                        <h1>"+blog.btitle+"</h1>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"tag-article\">\n";

                $.each(list_label,function (labelIndex,label) {
                    if(labelIndex == blogIndex){
                        $.each(label,function (lbIndex,lb) {
                            oHtml +="  <span class=\"label label-zan\" style=\"margin-left: 1px\">\n" +
                                "                    "+lb+"\n" +
                                "            </span>";
                        })
                    }
                })
                oHtml += " </div>\n" +
                    "                    <div class=\"content-article\">\n" +
                    "                        <p>\n" +
                    "                                "+blog.bcontent+"\n" +
                    "                        </p>\n" +
                    "                    </div>\n" +
                    "                    <p class=\"btn-danger\" href=\"BlogContent.jsp\" id=\""+blog.bid+"\" onclick=\"blogFullText(this.id);\">\n" +
                    "                        阅读全文\n" +
                    "                        <span class=\"badge\">";
                $.each(integerList,function (integerIndex,integer) {
                    oHtml += integer;
                })
                oHtml += "    </span>\n" +
                    "                    </p>\n" +
                    "                </div>\n" +
                    "            </div>"
                $(".clear").before(oHtml);
                count++;
            });
        }
    })
})


