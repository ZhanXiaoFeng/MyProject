//计算总价格
function total(){
	var priceColl = $("li[name=price]");
	var acountColl = $("li[name=acount]");
	var sumAmount=0;//商品总数
	var sum = 0;//总价格
	for (var i = 0; i < priceColl.length; i++) {
		var price = $(priceColl[i]).text();
		var acount = $(acountColl[i]).text();
		sum += parseFloat(price) * parseInt(acount);
		sumAmount+=parseInt(acount);
	}
	$("#total").html("商品总价:"+sum.toFixed(2));
	$("#totalAmount").html("商品总数:"+sumAmount.toFixed(2));
}
$(function(){
	total();
})

function deleteOrderItem(date){
	
}
//删除
function dele(obj){
	//被删除的对象
	var objUL = $(obj).parent().parent();
	$(objUL).remove();
	total();
	var deleteOrderId=$("li[name=orderId]");
	deleteOrderItem(deleteOrderId);
}

//结账并删除该订单项
function pay(obj){
	//被结账的对象
	var objUL = $(obj).parent().parent();
	$(objUL).remove();
	total();
	var deleteOrderId=$("li[name=orderId]");
	deleteOrderItem(deleteOrderId);
}