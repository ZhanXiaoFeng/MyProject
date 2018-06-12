$(document).ready(function(){
    initDoubleCart();
});

function createCartEmptyTR(){
    var emptyTR = $("<tr><td colspan='7' valign='middle' align='center'>购物车为空！</td></tr>");
    return emptyTR;
}

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
    var td6 = $(otherTR).find("td:nth-child(6)");
    var td7 = $(otherTR).find("td:nth-child(7)");
    
    var tdGroup1 = $(td1).add(td2).add(td4).add(td5).add(td6).add(td7);
    $(tdGroup1).attr("align", "center");
    $(tdGroup1).attr("valign", "middle");
    
    $(td3).css("padding-left", "20px");
    
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
    
    var checkbox = $("<input type='checkbox'>");
    $(checkbox).attr("name", cartType + "Checkbox");
    $(checkbox).val(idValue);
    var checkbox_td = $("<td></td>");
    $(checkbox_td).append(checkbox);
    
    var id_td = $("<td></td>");
    $(id_td).text(idValue);
    
    var booknameA = $("<a></a>");
    $(booknameA).attr("href", "#");
    $(booknameA).text(bookNameValue);
    var bookname_td = $("<td></td>");
    $(bookname_td).append(booknameA);
    
    var bookprice_td = $("<td></td>");
    $(bookprice_td).text(bookPriceValue);
    
    var leftButton = $("<input type='button'>");
    $(leftButton).val("-");
    $(leftButton).css("width", "15px");
    $(leftButton).attr("cartType", cartType);
    $(leftButton).attr("bookId", idValue);
    var newBookNum = $("<input type='text'>");
    $(newBookNum).val(bookNumValue);
    $(newBookNum).css("width", "30px");
    $(newBookNum).css("text-align", "center");
    $(newBookNum).attr("readOnly", true);
    $(newBookNum).attr("id", "newBookNum" + cartType + idValue);
    var rightButton = $("<input type='button'>");
    $(rightButton).val("+");
    $(rightButton).css("width", "15px");
    $(rightButton).attr("cartType", cartType);
    $(rightButton).attr("bookId", idValue);
    
    var buttonEvent = function(){
        var operateType = $(this).val();
        var cartType = $(this).attr("cartType");
        var bookId = $(this).attr("bookId");
        updateCartBookNum(operateType, cartType, bookId);
    }
    
    $(leftButton).click(buttonEvent);
    $(rightButton).click(buttonEvent);
    
    var booknum_td = $("<td></td>");
    $(booknum_td).append(leftButton);
    $(booknum_td).append(newBookNum);
    $(booknum_td).append(rightButton);
    
    var booksum_td = $("<td></td>");
    $(booksum_td).text(bookSumValue);
    
    var deleteBookA = $("<a>删除</a>");
    $(deleteBookA).attr("href", "javascript:deleteCartOneBook('" + cartType + "'," + idValue + ")");
    var operate_td = $("<td></td>");
    $(operate_td).append(deleteBookA);
    
    $(returnTR).append(checkbox_td);
    $(returnTR).append(id_td);
    $(returnTR).append(bookname_td);
    $(returnTR).append(bookprice_td);
    $(returnTR).append(booknum_td);
    $(returnTR).append(booksum_td);
    $(returnTR).append(operate_td);
    
    return returnTR;
}

function updateCartBookNumTRInfo(cartType, bookId){
    var findTR = $("#" + cartType + "TR" + bookId);
    
    $.get("getDoubleCart?t=" + new Date().getTime(), function(data){
        var doubleCart = $(data);
        
        var cartEntity = "";
        if (cartType == 'public') {
            cartEntity = $(doubleCart).find("publicCartEntity");
        }
        if (cartType == 'private') {
            cartEntity = $(doubleCart).find("privateCartEntity");
        }
        
        var bookinfoArray = $(cartEntity).find("listBookinfo").find("cartBookinfo");
        for (var i = 0; i < bookinfoArray.length; i++) {
            var idValue = $(bookinfoArray[i]).find("id").text();
            var bookNumValue = $(bookinfoArray[i]).find("bookNum").text();
            var bookSumValue = $(bookinfoArray[i]).find("bookSum").text();
            if (("" + idValue) == ("" + bookId)) {
                $(findTR).find("td:eq(4) :text").val(bookNumValue);
                $(findTR).find("td:eq(5)").text(bookSumValue);
                break;
            }
        }
    }, "xml");
    
}

function updateCartBookNum(operateType, cartType, bookId){
    $.post("updateCartBookNum?t=" + new Date().getTime(), {
        "operateType": operateType,
        "cartType": cartType,
        "bookId": bookId
    }, function(data){
        if (data == '1') {
            updateCartBookNumTRInfo(cartType, bookId);
            setCartBottomInfoTR(cartType);
        }
        else {
            alert("更新书籍数量失败！");
        }
    });
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

function initDoubleCart(){
    $.get("getDoubleCart?t=" + new Date().getTime(), function(data){
        var doubleCart = $(data);
        
        var publicCartEntity = $(doubleCart).find("publicCartEntity");
        var privateCartEntity = $(doubleCart).find("privateCartEntity");
        
        if (publicCartEntity.length == 0) {
            $("#publicCartTable tr:last").before(createCartEmptyTR());
        }
        else {
            var bookinfoArray = $(publicCartEntity).find("listBookinfo").find("cartBookinfo");
            for (var i = 0; i < bookinfoArray.length; i++) {
                var returnTR = createCartTR(bookinfoArray[i], 'public');
                $("#publicCartTable tr:last").before(returnTR);
            }
        }
        setCartBottomInfoTR('public');
        setBookinfoTableTheme('public');
        
        $.get("getCurrentLoginUsername?t=" + new Date().getTime(), function(data){
            if (data != 'null') {
                $("#putPrivateA").fadeIn(2000);
                $("#privateCartDIV").fadeIn(2000);
                if (privateCartEntity.length == 0) {
                    $("#privateCartTable tr:last").before(createCartEmptyTR());
                }
                else {
                    var bookinfoArray = $(privateCartEntity).find("listBookinfo").find("cartBookinfo");
                    for (var i = 0; i < bookinfoArray.length; i++) {
                        var returnTR = createCartTR(bookinfoArray[i], 'private');
                        $("#privateCartTable tr:last").before(returnTR);
                    }
                }
                setCartBottomInfoTR('private');
                setBookinfoTableTheme('private');
            }
        })
        
    }, "xml");
}

function allChecked(cartType){
    $(":checkbox[name='" + cartType + "Checkbox']").prop("checked", true);
}

function allNotChecked(cartType){
    var allCheckbox = $(":checkbox[name='" + cartType + "Checkbox']");
    var checkedbox = $(allCheckbox).filter(":checked");
    var unCheckedbox = $(allCheckbox).not(checkedbox);
    $(unCheckedbox).prop("checked", true);
    $(checkedbox).prop("checked", false);
}

function allUnChecked(cartType){
    $(":checkbox[name='" + cartType + "Checkbox']").prop("checked", false);
}

function deleteCartOneBook(cartType, bookId){
    var deleteBookIds = bookId;
    deleteCartBookinfoAjax(cartType, deleteBookIds);
}

function deleteCartMoreBook(cartType){
    var deleteBookIds = "";
    var checkedboxArray = $(":checkbox[name='" + cartType + "Checkbox']:checked");
    if (checkedboxArray.length != 0) {
        for (var i = 0; i < checkedboxArray.length; i++) {
            deleteBookIds = deleteBookIds +
            "-" +
            $(checkedboxArray[i]).val();
        }
        deleteBookIds = deleteBookIds.substring(1);
        deleteCartBookinfoAjax(cartType, deleteBookIds);
    }
    else {
        alert("没有选择要删除的书籍！");
    }
}

function deleteCartBookinfoAjax(cartType, deleteBookIds){
    $.post("deleteCartBookinfo?t=" + new Date().getTime(), {
        "cartType": cartType,
        "deleteBookIds": deleteBookIds
    }, function(data){
        if (data == '1') {
            var deleteBookIdArray = ("" + deleteBookIds).split("-");
            for (var i = 0; i < deleteBookIdArray.length; i++) {
                var bookId = deleteBookIdArray[i];
                $("#" + cartType + "TR" + bookId).remove();
            }
            var findTable = $("#" + cartType + "CartTable");
            if ($(findTable).find("tr").length == 2) {
                $(findTable).find("tr:last").before(createCartEmptyTR());
            }
            setCartBottomInfoTR(cartType);
            setBookinfoTableTheme(cartType);
        }
        else {
            alert("删除失败！");
        }
    });
}

function putPrivateCart(){
    var checkboxArray = $("#publicCartTable :checkbox[name='publicCheckbox']:checked");
    if (checkboxArray.length == 0) {
        alert("没有选中要移动的书籍！");
    }
    else {
        var id_num_string = "";
        for (var i = 0; i < checkboxArray.length; i++) {
            var bookId = $(checkboxArray[i]).val();
            var bookNum = $("#newBookNumpublic" + bookId).val();
            id_num_string = id_num_string + "-" + bookId + "_" + bookNum;
        }
        id_num_string = id_num_string.substring(1);
        $.post("putPrivateCart?t=" + new Date().getTime(), {
            "id_num_string": id_num_string
        }, function(data){
            if (data == '1') {
            
                $.get("getDoubleCart?t=" + new Date().getTime(), function(data){
                    var doubleCart = $(data);
                    
                    var tr2 = $("#privateCartTable tr:eq(1)");
                    if ($(tr2).find("td").text() == "购物车为空！") {
                        $(tr2).remove();
                    }
                    /*
                     */
                    var privateCartEntity = $(doubleCart).find("privateCartEntity");
                    var cookieBookinfoArray = $(privateCartEntity).find("listBookinfo").find("cartBookinfo");
                    var privateCheckboxArray = $("#privateCartTable :checkbox[name='privateCheckbox']");
                    for (var i = 0; i < privateCheckboxArray.length; i++) {
                        var checkboxId = $(privateCheckboxArray[i]).val();
                        for (var j = 0; j < cookieBookinfoArray.length; j++) {
                            var eachBookinfo = cookieBookinfoArray[j];
                            var idValue = $(eachBookinfo).find("id").text();
                            var bookNumValue = $(eachBookinfo).find("bookNum").text();
                            var bookSumValue = $(eachBookinfo).find("bookSum").text();
                            if (("" + checkboxId) == ("" + idValue)) {
                                updateCartBookNumTRInfo('private', idValue);
                            }
                        }
                    }
                    for (var i = 0; i < cookieBookinfoArray.length; i++) {
                        var eachBookinfo = cookieBookinfoArray[i];
                        var idValue = $(eachBookinfo).find("id").text();
                        var isFindBookId = false;
                        for (var j = 0; j < privateCheckboxArray.length; j++) {
                            var checkboxId = $(privateCheckboxArray[j]).val();
                            if (("" + idValue) == ("" + checkboxId)) {
                                isFindBookId = true;
                                break;
                            }
                        }
                        if (isFindBookId == false) {
                            var returnTR = createCartTR(eachBookinfo, 'private');
                            $("#privateCartTable tr:last").before(returnTR);
                        }
                    }
                    setCartBottomInfoTR('private');
                    setBookinfoTableTheme('private');
                }, "xml");
                
            }
            else {
                alert("放入私有购物车失败！");
            }
        });
    }
}
