$(document).ready(function(){
    initPrivateCart();
    initOrderInfo();
});

function setBookinfoTableTheme(cartType){
    var findTable = $("#" + cartType + "CartTable");
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
    var td5 = $(otherTR).find("td:nth-child(5)");
    
    var tdGroup1 = $(td1).add(td3).add(td4).add(td5);
    $(tdGroup1).attr("align", "center");
    $(tdGroup1).attr("valign", "middle");
    
    $(td2).css("padding-left", "20px");
    
    $(findTable).find("a").addClass("myStyleA");
    
}

function createCartTR(eachBookinfo, cartType){
    var idValue = $(eachBookinfo).find("id").text();
    var bookNameValue = $(eachBookinfo).find("bookName").text();
    var bookPriceValue = $(eachBookinfo).find("bookPrice").text();
    var bookNumValue = $(eachBookinfo).find("bookNum").text();
    var bookSumValue = $(eachBookinfo).find("bookSum").text();
    
    var returnTR = $("<tr></tr>");
    $(returnTR).attr("id", cartType + "TR" + idValue);
    
    var id_td = $("<td></td>");
    $(id_td).text(idValue);
    
    var booknameA = $("<a></a>");
    $(booknameA).attr("href", "#");
    $(booknameA).text(bookNameValue);
    var bookname_td = $("<td></td>");
    $(bookname_td).append(booknameA);
    
    var bookprice_td = $("<td></td>");
    $(bookprice_td).text(bookPriceValue);
    
    
    var booknum_td = $("<td></td>");
    $(booknum_td).text(bookNumValue);
    
    var booksum_td = $("<td></td>");
    $(booksum_td).text(bookSumValue);
    
    $(returnTR).append(id_td);
    $(returnTR).append(bookname_td);
    $(returnTR).append(bookprice_td);
    $(returnTR).append(booknum_td);
    $(returnTR).append(booksum_td);
    
    return returnTR;
}

function setCartBottomInfoTR(cartType){
    $.get("getDoubleCart?t=" + new Date().getTime(), function(data){
        var doubleCart = $(data);
        
        var cartEntity = "";
        if (cartType == 'public') {
            cartEntity = $(doubleCart).find("publicCartEntity");
        }
        
        if (cartType == 'private') {
            cartEntity = $(doubleCart).find("privateCartEntity");
        }
        
        var numTD = $("#" + cartType + "AllBookNum");
        var sumTD = $("#" + cartType + "AllBookSum");
        
        
        if (cartEntity.length == 0) {
            $(numTD).text("总数：0册");
            $(sumTD).text("总计：0元 ");
        }
        else {
            var allBookNum = $(cartEntity).find("allBookNum").text();
            var allBookSum = $(cartEntity).find("allBookSum").text();
            $(numTD).text("总数：" + allBookNum + "册");
            $(sumTD).text("总计：" + allBookSum + "元 ");
        }
    }, "xml");
}

function initPrivateCart(){
    $.get("getDoubleCart?t=" + new Date().getTime(), function(data){
        var doubleCart = $(data);
        
        var privateCartEntity = $(doubleCart).find("privateCartEntity");
        
        $.get("getCurrentLoginUsername?t=" + new Date().getTime(), function(data){
            var bookinfoArray = $(privateCartEntity).find("listBookinfo").find("cartBookinfo");
            for (var i = 0; i < bookinfoArray.length; i++) {
                var returnTR = createCartTR(bookinfoArray[i], 'private');
                $("#privateCartTable tr:last").before(returnTR);
            }
            setCartBottomInfoTR('private');
            setBookinfoTableTheme('private');
        })
        
    }, "xml");
}



function initOrderInfo(){
    var returnXMLString = $.ajax({
        "url": "getInputOrderInfo?t=" + new Date().getTime(),
        "type": "get",
        "async": false
    }).responseText;
    
    var xmlObject = $(returnXMLString);
    
    var shengName = $(xmlObject).find("shengName").text();
    var shiName = $(xmlObject).find("shiName").text();
    var xianName = $(xmlObject).find("xianName").text();
    var detailsAddress = $(xmlObject).find("detailsAddress").text();
    var receiver = $(xmlObject).find("receiver").text();
    var phone = $(xmlObject).find("phone").text();
    var note = $(xmlObject).find("note").text();
    
    $("#shengName").text(shengName);
    $("#shiName").text(shiName);
    $("#xianName").text(xianName);
    $("#detailsAddress").text(detailsAddress);
    
    $("#receiver").text(receiver);
    $("#phone").text(phone);
    $("#note").text(note);
}

function submitOrder(){
    $.get("submitOrder?t=" + new Date().getTime(), function(data){
        if (data == '1') {
            alert("订单提交成功，模拟删除Cookie");
        }
        else {
            alert("订单提交失败！");
        }
    });
    
}
