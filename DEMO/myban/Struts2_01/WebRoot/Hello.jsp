<%@page pageEncoding="utf-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<meta content="text/html; charset=utf-8">
		<title>Struts2的Hello页面</title>
	</head>
	<body>
		<h2>Hello,Struts2</h2>
		<h3>debug:<s:debug/></h3>
		<h3>栈顶：<s:property/></h3>
		<h3>访问context中的数据：<s:property value="#action.name"/></h3>
		<h3>访问context中的数据：<s:property value="#action.HelloAction.name"/></h3><!-- 错误，无输出。 -->
		<h4>迭代集合：
			<s:iterator value="cityList" var="city">	<!-- 若集合中的元素没有属性，则定义一个变量 -->
				<s:property value="city"/>
			</s:iterator>
		</h4>
		<h4>迭代数组：
			<s:iterator value="langArr" >
				<s:property/>		<!-- 直接访问栈顶元素 -->
			</s:iterator>	
		</h4>
		<h4>迭代对象集合：<br/>
			<s:iterator value="emps">
				名字：<s:property value="ename"/>，	
				工资：<s:property value="sal"/><br/>
			</s:iterator>
		</h4>
		<h4>迭代数字：
			<s:iterator begin="from" end="to" var="i">
				<s:property value="#i"/>	<!-- 从context的Map中取数据 -->
			</s:iterator>
		</h4>
		
		
		
		
		
		
		
		<h3>OGNL表达式练习</h3>
		<h4>1.基本属性：</h4>
		<h5>ID:<s:property value="id"/></h5>
		<h5>NAME:<s:property value="name"/></h5>
		<h5>Name:${name }${ id }</h5>	
		<H4>2.访问实体的属性</H4>
		<h5>用户名:<s:property value="user.username"/></h5>
		<h5>密码：<s:property value="user.password"/></h5>
		<h4>3.访问数组、集合、Map</h4>
		<h5>数组第二个元素:<s:property value="langArr[1]"/></h5>
		<h5>集合第二个元素:<s:property value="cityList[1]"/></h5>
		<h5>Map第一个元素:<s:property value="cityMap.北京"/></h5>
		<h4>4.进行计算</h4>
		<h5>My name is <s:property value="'我叫什么呢?'+ name"/></h5>
		<h5>去哪里：<s:property value="'我要去：'+ cityList[0]"/></h5>
		<h4>5.访问时调用方法</h4>
		<h5>调用切换大小写方法：前：<s:property value="langArr[0]"/> 后：<s:property value="langArr[0].toUpperCase()"/></h5>
		<h4>6.创建集合</h4>
		<h5>创建集合：<s:property value="{1, 2, 3, 4}"/></h5>
		<h5>集合类型:<s:property value="{'a','b','c'}.getClass().getName()"/></h5>
		<h4>7.创建Map</h4>
		<h5>Map:<s:property value="#{'bj':'北京', 'sh':'上海'}"/></h5>
		
		<!-- 
		<h2>从jsp中传给Action组件的参数，这里再从Action中使用EL表达式获取传出的参数。</h2>
		<h2>姓名：${name}</h2>
		<h2>账号：${user.username }</h2>
		<h2>密码：${user.password }</h2>
		 -->
	</body>
</html>