baseUrl = window.location.origin;
// document.write('\<script type="text/javascript" src="' + baseUrl + '/lib/jquery/jquery-3.3.1.js"/>');
document.write('\<script type="text/javascript" src="' + baseUrl + '/lib/jquery/jquery.blockUI.js"/>');
// document.write('\<script type="text/javascript" src="' + baseUrl + '/lib/bootstrap/js/bootstrap.js"/>');
// document.write('\<link type="text/css" rel="stylesheet" href="' + baseUrl + '/lib/bootstrap/css/bootstrap.css"/>');
/*
 * 加载遮罩提示信息
 */
function loading(actoin, msg) {
    if (actoin === "open") {
        $.blockUI({
            message: '<div class="spinner">\n' +
                '  <div class="rect1"></div>\n' +
                '  <div class="rect2"></div>\n' +
                '  <div class="rect3"></div>\n' +
                '  <div class="rect4"></div>\n' +
                '  <div class="rect5"></div>\n' +
                '</div><div>' + msg + '</div>'
        })//显示遮罩
    } else {
        $.unblockUI()
    }
}

