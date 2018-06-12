$(document).ready(function(){
    initLoginUI();
    initBookinfoListUI();
});

//http://localhost:8081/69shop/

function createBookinfoTR(eachBookinfo){
    var id = $(eachBookinfo).find("id").text();
    var bookname = $(eachBookinfo).find("bookname").text();
    var bookprice = $(eachBookinfo).find("bookprice").text();
    
    var id_td = $("<td></td>");
    $(id_td).text(id);
    
    var booknameA = $("<a></a>");
    $(booknameA).attr("href", "#");
    $(booknameA).text(bookname);
    var bookname_td = $("<td></td>");
    $(bookname_td).append(booknameA);
    
    var bookprice_td = $("<td></td>");
    $(bookprice_td).text(bookprice);
    
    var putCartA = $("<a>放入购物车</a>");
    $(putCartA).attr("href", "javascript:putCart(" + id + ")");
    var putCart_td = $("<td></td>");
    
    var putCartSuccessDIV = $("<div>成功放入购物车</div>");
    $(putCartSuccessDIV).addClass("putCartSuccessDIVStyle");
    $(putCartSuccessDIV).attr("id", "putCartSuccessDIV" + id);
    
    var putCartErrorDIV = $("<div>放入购物车失败</div>");
    $(putCartErrorDIV).addClass("putCartErrorDIVStyle");
    $(putCartErrorDIV).attr("id", "putCartError" + id);
    
    $(putCart_td).append(putCartA);
    $(putCart_td).append(putCartSuccessDIV);
    $(putCart_td).append(putCartErrorDIV);
    
    var newTR = $("<tr></tr>");
    $(newTR).attr("id", "bookinfoTR" + id);
    
    $(newTR).append(id_td);
    $(newTR).append(bookname_td);
    $(newTR).append(bookprice_td);
    $(newTR).append(putCart_td);
    
    return newTR;
}

function initBookinfoListUI(){
    $.get("getAllBookinfo?t=" + new Date().getTime(), function(data){
        var listBookinfo = $(data);
        var bookinfoArray = $(listBookinfo).find("list").find("bookinfo");
        for (var i = 0; i < bookinfoArray.length; i++) {
            var eachBookinfo = bookinfoArray[i];
            var returnTR = createBookinfoTR(eachBookinfo);
            $("#bookinfoTable").append(returnTR);
        }
        setBookinfoTableTheme();
    }, "xml");
}

function setBookinfoTableTheme(){
    var findTable = $("#bookinfoTable");
    var allTR = $(findTable).find("tr");
    var firstTR = $(allTR).filter(":first");
    var otherTR = $(allTR).not(firstTR);
    var evenTR = $(otherTR).filter("tr:even");
    var oddTR = $(otherTR).filter("tr:odd");
    
    $(evenTR).find("td").attr("bgcolor", "#336699");
    $(oddTR).find("td").attr("bgcolor", "#FF6600");
    $(firstTR).find("td").attr("bgcolor", "#000066");
    
    $(findTable).css("fontSize", "16px");
    $(findTable).css("color", "#FFFFFF");
    
    $(firstTR).css("height", "40px");
    $(otherTR).css("height", "35px");
    $(firstTR).attr("align", "center");
    $(firstTR).attr("valign", "middle");
    
    var td1 = $(otherTR).find("td:nth-child(1)");
    var td2 = $(otherTR).find("td:nth-child(2)");
    var td3 = $(otherTR).find("td:nth-child(3)");
    var td4 = $(otherTR).find("td:nth-child(4)");
    var td134 = $(td1).add(td3).add(td4);
    $(td134).attr("align", "center");
    $(td134).attr("valign", "middle");
    
    $(td2).css("padding-left", "20px");
    
    $(findTable).find("a").addClass("myStyleA");
    
}

function initWelcomeUI(welcomeUsername){
    var welcomeA = $("<a></a>");
    $(welcomeA).text(welcomeUsername);
    $(welcomeA).attr("href", "#");
    $("#welcomeDIV").append(welcomeA);
    $("#welcomeDIV").fadeIn(1500);
}

function initLoginUI(){
    $.get("getCurrentLoginUsername?t=" + new Date().getTime(), function(data){
        if (data != 'null') {
            initWelcomeUI(data);
        }
        else {
            $("#loginForm").fadeIn(1500);
        }
    });
}

function login(){
    var usernameValue = $("#username").val();
    var passwordValue = $("#password").val();
    $.post("login?t=" + new Date().getTime(), {
        "username": usernameValue,
        "password": passwordValue
    }, function(data){
        if (data == 'true') {
            $("#loginForm").hide();
            initWelcomeUI(usernameValue);
        }
        else {
            alert("登陆失败请重新输入！");
        }
    });
}

function putCart(bookId){
    $.post("putCart?t=" + new Date().getTime(), {
        "bookId": bookId
    }, function(data){
        var showDIV = "";
        if (data == '1') {
            showDIV = $("#putCartSuccessDIV" + bookId);
        }
        else {
            showDIV = $("#putCartError" + bookId);
        }
        var lastTD = $("#bookinfoTR" + bookId).find("td:last");
        var leftValue = $(lastTD).offset().left;
        var topValue = $(lastTD).offset().top;
        $(showDIV).css("left", leftValue + 134);
        $(showDIV).css("top", topValue);
        $(showDIV).fadeIn(1000);
        $(showDIV).fadeOut(1000);
    });
}
