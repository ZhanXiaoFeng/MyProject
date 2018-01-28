<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>goodsUser</title>
</head>
<body>
	selectCondition
	<form
		action="${pageContext.request.contextPath }/goodsSelectUser.do"
		method="post">
		<div>
			name <input type="text" name="name" required="true" />
		</div>

		<div>
			tags <input type="text" name="tags" />
		</div>

		<div>
			color <input type="text" name="color" />
		</div>

		<div>
			source <input type="text" name="source" />
		</div>

		<div>
			baoyou <input type="radio" name="baoYou" value=1 checked="checked">yes
			<input type="radio" name="baoYou" value=0>no
		</div>
		<div>
			price2low <input type="text" name="price2low" value="0.00" />
		</div>
		to
		<div>
			price2high <input type="text" name="price2high" value="99.99"/>
		</div>
		<div>
			<input type="submit" value="select" />
		</div>
	</form>

</body>
</html>