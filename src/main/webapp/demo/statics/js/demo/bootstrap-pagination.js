!function ($) {
    // 需要的参数： pageIndex totalPage
    var pageIndex = parseInt(document.getElementById("pageIndex").value);
    var totalPageSize = parseInt(document.getElementById("totalPageSize").value);
    var pageUrl = document.getElementById("pageUrl").value;
    var pagination = document.getElementById("pagination");
    var pageContextHtml = "";

    var prepage = pageIndex - 1;
    var preTwoPage = pageIndex - 2;
    var nextpage = pageIndex + 1;
    var nextTwoPage = pageIndex + 2;
    var lastPage = totalPageSize;
    var lastTwoPage = totalPageSize - 1;
    var difference = totalPageSize - pageIndex;

    pageContextHtml = pageContextHtml + '<div style="font-size: 12px;float:right;">';
    pageContextHtml = pageContextHtml + '<ul class="pagination">';
    if (totalPageSize > 10) {
        if (pageIndex == 1) {
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastTwoPage + '">' + lastTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + totalPageSize + '">' + totalPageSize + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex > 5 && difference >= 5) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + preTwoPage + '">' + preTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">' + prepage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastTwoPage + '">' + lastTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + totalPageSize + '">' + totalPageSize + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex == 5) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=3">3</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=4">4</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastTwoPage + '">' + lastTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + totalPageSize + '">' + totalPageSize + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex == 4) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=3">3</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastTwoPage + '">' + lastTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + totalPageSize + '">' + totalPageSize + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex == 3) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastTwoPage + '">' + lastTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + totalPageSize + '">' + totalPageSize + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex == 2) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastTwoPage + '">' + lastTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + totalPageSize + '">' + totalPageSize + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex > 5 && difference == 4) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + preTwoPage + '">' + preTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">' + prepage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastTwoPage + '">' + lastTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + totalPageSize + '">' + totalPageSize + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex > 5 && difference == 3) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + preTwoPage + '">' + preTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">' + prepage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + totalPageSize + '">' + totalPageSize + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex > 5 && difference == 2) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + preTwoPage + '">' + preTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">' + prepage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + totalPageSize + '">' + totalPageSize + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex > 5 && difference == 1) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + preTwoPage + '">' + preTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">' + prepage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
        } else if (pageIndex == totalPageSize) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + preTwoPage + '">' + preTwoPage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">' + prepage + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
            pageContextHtml = pageContextHtml + '<li class="disabled"><a>下一页</a></li>';
        } else {

        }
    } else {
        if (pageIndex == 1) {
            if (totalPageSize == 0 || totalPageSize == 1) {
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>上一页</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a >下一页</a></li>';
            } else if (totalPageSize > 1 && totalPageSize > 1 && totalPageSize <= 5) {
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>上一页</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
                for (var index = 2; index <= totalPageSize; index++) {
                    pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + index + '">' + index + '</a></li>';
                }
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
            } else {
                //  totalPageSize > 5
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>上一页</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastTwoPage + '">' + lastTwoPage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastPage + '">' + lastPage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
            }
        } else if (pageIndex > 1 && pageIndex <= 5) {
            pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
            for (var index = 1; index <= pageIndex; index++) {
                if (index == pageIndex) {
                    pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
                } else {
                    pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + index + '">' + index + '</a></li>';
                }
            }
            if (difference >= 5) {
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">' + nextpage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextTwoPage + '">' + nextTwoPage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastTwoPage + '">' + lastTwoPage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + lastPage + '">' + lastPage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
            } else {
                for (var index = pageIndex + 1; index <= totalPageSize; index++) {
                    pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + index + '">' + index + '</a></li>';
                }
                if (pageIndex == totalPageSize) {
                    pageContextHtml = pageContextHtml + '<li class="disabled"><a>下一页</a></li>';
                } else {
                    pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
                }

            }
        } else if (pageIndex > 5) {
            if (pageIndex == totalPageSize) {
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + preTwoPage + '">' + preTwoPage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">' + prepage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>下一页</a></li>';
            } else {
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">上一页</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=1">1</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=2">2</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>...</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + preTwoPage + '">' + preTwoPage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + prepage + '">' + prepage + '</a></li>';
                pageContextHtml = pageContextHtml + '<li class="disabled"><a>' + pageIndex + '</a></li>';
                for (var index = pageIndex + 1; index <= totalPageSize; index++) {
                    pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + index + '">' + index + '</a></li>';
                }
                pageContextHtml = pageContextHtml + '<li><a href="' + pageUrl + '&pageIndex=' + nextpage + '">下一页</a></li>';
            }
        } else {

        }
    }
    pageContextHtml = pageContextHtml + '</ul></div>';
    pagination.innerHTML = pageContextHtml;
}(window.jQuery);