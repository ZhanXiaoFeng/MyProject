<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>goodsMgr</title>
</head>
<body>
	selectById
	<form action="${pageContext.request.contextPath }/goodsSelectById.do"
		method="post">

		<div>
			<input type="text" name="id" />
		</div>
		<div>
			<input type="submit" value="select" />
		</div>
	</form>

	selectCondition
	<form
		action="${pageContext.request.contextPath }/goodsSelectCondition.do"
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

	insert
	<form action="${pageContext.request.contextPath }/goodsInsert.do"
		method="post" enctype="multipart/form-data">
		<div>
			id <input type="text" name="id" required="true" />
		</div>

		<div>
			name <input type="text" name="name"  />
		</div>

		<div>
			imgs<input type="file" name="part" />
		</div>

		<div>
			tags <input type="text" name="tags"  />
		</div>

		<div>
			color <input type="text" name="color" />
		</div>

		<div>
			categoryId<input type="text" name="categoryId" />
		</div>

		<div>
			price1<input type="text" name="price1" value="1.00" />
		</div>

		<div>
			price2<input type="text" name="price2" value="1.00" />
		</div>

		<div>
			xiaoliang<input type="text" name="xiaoLiang" value="0"
				/>
		</div>

		<div>
			source <input type="text" name="source" />
		</div>

		<div>
			baoyou <input type="radio" name="baoYou" value=1 checked="checked">yes
			<input type="radio" name="baoYou" value=0>no
		</div>

		<div>
			display <input type="radio" name="display" value=1 checked="checked">yes
			<input type="radio" name="display" value=0>no
		</div>

		<div>
			level<input type="text" name="level_" value="1"  />
		</div>

		<div>
			kucun<input type="text" name="kuCun" value="0" />
		</div>

		<div>
			introduce<input type="text" name="intro" />
		</div>

		<div>
			<input type="submit" value="insert" />
		</div>
	</form>

	delete
	<form action="${pageContext.request.contextPath }/goodsDelete.do"
		method="post">

		<div>
			id<input type="text" name="id" />
		</div>
		<div>
			<input type="submit" value="delete" />
		</div>
	</form>

	updateCondition
	<form
		action="${pageContext.request.contextPath }/goodsUpdateCondition.do"
		method="post">
		<div>
			id <input type="text" name="id" required="true" />
		</div>

		<div>
			name <input type="text" name="name" />
		</div>

		<div>
			tags <input type="text" name="tags" />
		</div>

		<div>
			color <input type="text" name="color" />
		</div>

		<div>
			categoryId<input type="text" name="categoryId" />
		</div>

		<div>
			price1<input type="text" name="price1" />
		</div>

		<div>
			price2<input type="text" name="price2" />
		</div>

		<div>
			xiaoliang<input type="text" name="xiaoLiang" />
		</div>

		<div>
			source <input type="text" name="source"  />
		</div>

		<div>
			baoyou <input type="radio" name="baoYou" value=1 checked="checked">yes
			<input type="radio" name="baoYou" value=0>no
		</div>

		<div>
			display <input type="radio" name="display" value=1 checked="checked">yes
			<input type="radio" name="display" value=0>no
		</div>

		<div>
			level<input type="text" name="level_" />
		</div>

		<div>
			kucun<input type="text" name="kuCun"  />
		</div>

		<div>
			introduce<input type="text" name="intro" />
		</div>

		<div>
			<input type="submit" value="update" />
		</div>
	</form>
</body>
</html>