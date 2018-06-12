$(document).ready(function(){

    var inputOrderInfo = getInputOtherInfo();
    
    initShengList();
    if (inputOrderInfo.shengId != '') {
        $("#sheng").val(inputOrderInfo.shengId);
    }
    
    var selectedShengId = $("#sheng").val();
    initShiList(selectedShengId);
    if (inputOrderInfo.shiId != '') {
        $("#shi").val(inputOrderInfo.shiId);
    }
    
    var selectedShiId = $("#shi").val();
    initXianList(selectedShiId);
    if (inputOrderInfo.xianId != '') {
        $("#xian").val(inputOrderInfo.xianId);
    }
    
    //
    
    initOtherInfo(inputOrderInfo);
});

function initShengList(){
    var returnXMLString = $.ajax({
        "url": "getShengList?t=" + new Date().getTime(),
        "type": "post",
        "async": false,
    }).responseText;
    var xmlObject = $(returnXMLString);
    var shengList = $(xmlObject).find("sheng");
    for (var i = 0; i < shengList.length; i++) {
        var shengId = $(shengList[i]).find("id").text();
        var shengName = $(shengList[i]).find("shengName").text();
        
        var newOption = $("<option></option>");
        $(newOption).val(shengId);
        $(newOption).text(shengName);
        
        $("#sheng").append(newOption);
        
    }
    initShiList($("#sheng").val());
}

function initShiList(shengIdParam){
    $("#shi").empty();
    var returnXMLString = $.ajax({
        "url": "getShiListByShengId?t=" + new Date().getTime(),
        "type": "post",
        "data": {
            "shengId": shengIdParam
        },
        "async": false
    }).responseText;
    
    var xmlObject = $(returnXMLString);
    var shiList = $(xmlObject).find("shi");
    for (var i = 0; i < shiList.length; i++) {
        var shiId = $(shiList[i]).find("id").text();
        var shiName = $(shiList[i]).find("shiName").text();
        
        var newOption = $("<option></option>");
        $(newOption).val(shiId);
        $(newOption).text(shiName);
        
        $("#shi").append(newOption);
        
    }
    initXianList($("#shi").val());
}

function initXianList(shiIdParam){
    $("#xian").empty();
    var returnXMLString = $.ajax({
        "url": "getXianListByShiId?t=" + new Date().getTime(),
        "type": "post",
        "data": {
            "shiId": shiIdParam
        },
        "async": false
    }).responseText;
    
    var xmlObject = $(returnXMLString);
    var xianList = $(xmlObject).find("xian");
    for (var i = 0; i < xianList.length; i++) {
        var xianId = $(xianList[i]).find("id").text();
        var xianName = $(xianList[i]).find("xianName").text();
        
        var newOption = $("<option></option>");
        $(newOption).val(xianId);
        $(newOption).text(xianName);
        
        $("#xian").append(newOption);
    }
}

function saveInputOrderInfo(){

    var sheng = $("#sheng").val();
    var shi = $("#shi").val();
    var xian = $("#xian").val();
    var detailsAddress = $("#detailsAddress").val();
    var receiver = $("#receiver").val();
    var phone = $("#phone").val();
    var note = $("#note").val();
    
    $.post("saveInputOrderInfo?t=" + new Date().getTime(), {
        "sheng": sheng,
        "shi": shi,
        "xian": xian,
        "detailsAddress": detailsAddress,
        "receiver": receiver,
        "phone": phone,
        "note": note
    }, function(data){
        if (data != '1') {
            alert("保存失败！");
        }
    })
    
}

function InputOrderInfo(shengId, shengName, shiId, shiName, xianId, xianName, detailsAddress, receiver, phone, note){
    this.shengId = shengId;
    this.shiId = shiId;
    this.xianId = xianId;
    this.detailsAddress = detailsAddress;
    this.receiver = receiver;
    this.phone = phone;
    this.note = note;
}

function getInputOtherInfo(){
    var returnXMLString = $.ajax({
        "url": "getInputOrderInfo?t=" + new Date().getTime(),
        "type": "get",
        "async": false
    }).responseText;
    
    var xmlObject = $(returnXMLString);
    
    var shengId = $(xmlObject).find("shengId").text();
    var shiId = $(xmlObject).find("shiId").text();
    var xianId = $(xmlObject).find("xianId").text();
    var detailsAddress = $(xmlObject).find("detailsAddress").text();
    var receiver = $(xmlObject).find("receiver").text();
    var phone = $(xmlObject).find("phone").text();
    var note = $(xmlObject).find("note").text();
    
    var inputOrderInfo = new InputOrderInfo(shengId, "", shiId, "", xianId, "", detailsAddress, receiver, phone, note);
    
    return inputOrderInfo;
}


function initOtherInfo(inputOrderInfo){
    $("#detailsAddress").val(inputOrderInfo.detailsAddress);
    $("#receiver").val(inputOrderInfo.receiver);
    $("#phone").val(inputOrderInfo.phone);
    $("#note").val(inputOrderInfo.note);
}
