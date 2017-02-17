<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${pageContext.request.contextPath}/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet"/>
    <title></title>
    <link href="${pageContext.request.contextPath}/styles/Common.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/styles/Index2.css" rel="stylesheet"/>
	<script type="text/javascript">
	function openEdit(cid) {
		
	}
	function deleteCust(data){
		if (confirm("是否删除？")) {
			location.href="${pageContext.request.contextPath }/customerAction_delete?cid="+data;
		}
	}
	</script>

</head>
<body>
<div class="container-fluid">

    <div class="row-fluid">
        <h4>数据列表</h4>

        <div>
            <form action="${pageContext.request.contextPath}/customerAction_list" id="searchFrom" method="post">
                <div class="uinArea" id="uinArea">
                    客户名称：
                    <input type="text" id="u" name="custName" value="${customer.custName}" class="inputstyle"/>
                    客户类型：
                    <input type="text" id="p" name="custType" value="${customer.custType}" class="inputstyle"/>
                	&nbsp;&nbsp;
                	<input type="image" name="submit" src="${pageContext.request.contextPath}/images/Search.png" onClick="document.searchFrom.submit()">
                </div>
            </form>
        </div>
        <div class="add"><a class="btn btn-success" href="${pageContext.request.contextPath}/customerAction_toAdd.action">新增</a></div>
        <div class="w">
            <div class="span12">
                <table class="table table-condensed table-bordered table-hover tab">
                    <thead>
                    <tr>
                        <th>客户名称</th>
                        <th>客户类型</th>
                        <th>联系电话</th>
                        <th>联系地址</th>
                        <th>所属员工</th>
                        <th>操作</th>
                    </tr>

                    </thead>
                    <tbody id="tbody">
                    <%--<tr>--%>
                    <%--<th>123</th>--%>
                    <%--<th>123</th>--%>
                    <%--<th>123</th>--%>
                    <%--<th>123</th>--%>
                    <%--<th>123</th>--%>
                    <%--<th><a href="#">修改</a><a href="#">删除</a></th>--%>
                    <%--</tr>--%>
                    <c:forEach items="${list }" var="customer">
                    	<tr>
                        <th>${customer.custName }</th>
                        <th>${customer.custType }</th>
                        <th>${customer.custPhone }</th>
                        <th>${customer.custAddress }</th>
                        <th>${customer.custLinkUser.nickname }</th>
                        <th>
                            <a href="${pageContext.request.contextPath }/customerAction_toEdit?cid=${customer.cid }">修改</a>
                            &nbsp;&nbsp;
                            <a href="#" onclick="deleteCust(${customer.cid })">删除</a>
                        </th>
                   		</tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div id="page" class="tr"></div>
            </div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap2.3.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/scripts/layer.js"></script>
<script src="${pageContext.request.contextPath}/scripts/laypage.js"></script>
<script src="${pageContext.request.contextPath}/scripts/Index2.js"></script>
</body>
</html>