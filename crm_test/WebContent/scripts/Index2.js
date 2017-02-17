var curr = 1;
$(function () {
    load(curr);

})


function load(curr) {
    $.ajax({
        url: "../Json/Index.aspx",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: {"flag": "load", "curr": curr},
        success: function (data) {

            var html = "";
            $.each(data.items, function (i, item) {
                html += " <tr> " +
                    " <td>" + item.userName + "</td> " +
                    " <td>" + item.Chinese + "</td> " +
                    " <td>" + item.Math + "</td> " +
                    " <td>" + item.English + "</td> " +
                    " <td><a class=\"btn btn-info\" onclick='openedt(\"" + item.userName + "\");'>修改</a>&nbsp;&nbsp;<a class=\"btn btn-warning\" onclick='del(\"" + item.userName + "\");'>删除</a></td> " +
                    " </tr>";
            })
            $("#tbody").html(html);
            laypage({
                cont: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                pages: Math.ceil(data.cnt / 10), //通过后台拿到的总页数
                skin: "#49afcd",
                curr: curr || 1, //当前页
                jump: function (obj, first) { //触发分页后的回调
                    if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
                        curr = obj.curr;
                        load(curr);
                    }
                }
            });

        }
    })
}

function openadd() {
    //异步每次都创建一个select 创建前删除
    $("#uList").remove();
    $("#add").remove();
    $("#myModalLabel").text("添加客户");
    $("#userName").attr("readonly", false);
    $("input").val("");
    $("#addModal").modal("show");
    $("#add").show();
    $("#edt").hide();
    getUserList();
    var $btn = $("<button class='btn btn-primary' id='add' onclick='addCustomer();' >保存</button>")
    $("#addOrEdit").append($btn);
}
function openEdit(cid) {
    //异步每次都创建一个select 创建前删除
    $("#uList").remove();
    $("#add").remove();
    $("#myModalLabel").text("修改客户");
    $("#userName").attr("readonly", false);
    $("input").val("");
    $("#addModal").modal("show");
    $("#add").show();
    $("#edt").hide();
    //根据 CID 异步获取当前用户
    getCustomer(cid);
    getUserList();
    var $btn = $("<button class='btn btn-primary' id='add' onclick='updateCustomer();' >保存</button>")
    $("#addOrEdit").append($btn);
}

function getUserList(selected) {
    //1 创建select元素对象
    //2 设置name属性
    var $select = $("<select name='user.uid' id='uList' ></select>")
    //3 创建提示option
    var $option = $("<option value='' >--请选择--</option>");
    $select.append($option);
    //4 发送ajax请求,请求用户列表json数据
    $.getJSON("${pageContext.request.contextPath}/userAction_list", {}, function (json) {
        //遍历json.创建一个option.并放入select
        for (var i = 0; i < json.length; i++) {
            var $option = $("<option></option>");
            $option.attr("value", json[i]["uid"]);
            $option.html(json[i]["nickname"]);
            //判断当前option的值是否是应该被选中的值
            if (json[i]["uid"] == selected) {
                $option.attr("selected", "selected");
            }
            //-------------------------------------------------
            //将组装好的option放入select
            $select.append($option);
        }

    });
    //5 将select UserSelect 这个DIV中
    $("#UserSelect").append($select);
}
function getCustomer(cid) {

    $.getJSON("${pageContext.request.contextPath}/customerAction_toEdit", {cid: cid}, function (json) {
        $("#cid").val(json["cid"]);
        $("#cust_name").val(json["cust_name"]);
        $("#cust_type").val(json["cust_type"]);
        $("#cust_phone").val(json["cust_phone"]);
        $("#cust_address").val(json["cust_address"]);
        $("#uList  option[value='" + json['user']["uid"] + "']").attr("selected", true);
    });
}

function addCustomer() {

    if ($("#cust_address").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#cust_address');
        return;
    }
    if ($("#cust_phone").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#cust_phone');
        return;
    }
    if ($("#cust_type").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#cust_type');
        return;
    }
    if ($("#cust_name").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#cust_name');
        return;
    }
    if ($("#uList").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#uList');
        return;
    }
    document.customerForm.action = "${pageContext.request.contextPath}/customerAction_add";
    document.customerForm.submit();
}
function updateCustomer() {

    if ($("#cust_address").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#cust_address');
        return;
    }
    if ($("#cust_phone").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#cust_phone');
        return;
    }
    if ($("#cust_type").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#cust_type');
        return;
    }
    if ($("#cust_name").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#cust_name');
        return;
    }
    if ($("#uList").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#uList');
        return;
    }
    document.customerForm.action = "${pageContext.request.contextPath}/customerAction_update";
    document.customerForm.submit();
}

//删除确认方法
function deleteConfirm(name, url) {
    //1 弹出确认框,确认
    var confirm = window.confirm("您确认要删除<" + name + ">客户吗?");
    if (confirm) {
        //确认删除 => 让页面跳转到删除路径并携带id
        window.location.href = url;
    }
    //取消=>什么都不做

}


function add() {
    if ($("#userName").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#userName');
        return;
    }
    if ($("#Chinese").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#Chinese');
        return;
    }
    if ($("#Math").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#Math');
        return;
    }
    if ($("#English").val() == "") {
        layer.tips('<font color="red">不能为空</font>', '#English');
        return;
    }
    /*var formdata = {
     flag: "add",
     userName: $("#userName").val(),
     Chinese: $("#Chinese").val(),
     Math: $("#Math").val(),
     English: $("#English").val()
     }
     $.ajax({
     url: "../Json/Index.aspx",
     timeout: 300000,
     dataType: "json",
     type: "post",
     data: formdata,
     success: function (data) {
     $("#addModal").modal("hide");
     layer.alert(data.msg);
     $("input").val("");
     load(curr);
     }
     })*/
}


function openedt(userName) {
    $.ajax({
        url: "../Json/Index.aspx",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: {"flag": "getUser", "userName": userName},
        success: function (data) {
            $("#myModalLabel").text("修改成绩");
            $("#userName").val(data.userName);
            $("#userName").attr("readonly", true);
            $("#Chinese").val(data.Chinese);
            $("#Math").val(data.Math);
            $("#English").val(data.English);

            $("#edt").show();
            $("#add").hide();
            $("#addModal").modal("show");
        }
    })
}

function edt() {
    if ($("#userName").val() == "") {
        layer.tips('不能为空', '#userName');
        return;
    }
    if ($("#Chinese").val() == "") {
        layer.tips('不能为空', '#Chinese');
        return;
    }
    if ($("#Math").val() == "") {
        layer.tips('不能为空', '#Math');
        return;
    }
    if ($("#English").val() == "") {
        layer.tips('不能为空', '#English');
        return;
    }
    var formdata = {
        flag: "edt",
        userName: $("#userName").val(),
        Chinese: $("#Chinese").val(),
        Math: $("#Math").val(),
        English: $("#English").val()
    }
    $.ajax({
        url: "../Json/Index.aspx",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: formdata,
        success: function (data) {
            $("#addModal").modal("hide");
            layer.alert(data.msg);
            $("input").val("");
            load(curr);
        }
    })
}


function del(userName) {
    //询问框
    layer.confirm('您确定要删除？', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        $.ajax({
            url: "../Json/Index.aspx",
            timeout: 300000,
            dataType: "json",
            type: "post",
            data: {"flag": "del", "userName": userName},
            success: function (data) {
                layer.alert(data.msg);
                load(curr);
            }
        })
    }, function () {
        //  layer.close();
    });

}