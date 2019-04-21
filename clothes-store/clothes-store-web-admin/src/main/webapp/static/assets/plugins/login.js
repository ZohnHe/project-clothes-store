$(function () {
    //滑动验证码
    imgVer({
        el:'$("#imgVer")',
        width:'260',
        height:'116',
        img:[

            '/static/assets/plugins/verify/images/2.jpg',
            '/static/assets/plugins/verify/images/3.jpg',
            '/static/assets/plugins/verify/images/4.jpg',
            '/static/assets/plugins/verify/images/5.jpg',

        ],
        //验证码通过的操作
        success:function () {
            $("#verify").attr("value","ok");
        },
        //验证码不通过的操作
        error:function () {
            $("#verify").attr("value",null);
        }
    });

    //记住密码后，显示账号,密码
    $(document).ready(
        function () {
            if($.cookie("remember")){
                $("#loginId").val($.cookie("loginId"));
                $("#loginPwd").val($.cookie("loginPwd"));
                if($.cookie("remember")){
                    $("#remember").prop("checked",true);
                }
            }
        }
    );

    //异步登录
    $("#loginBtn").click(function () {
        var loginId = $("#loginId").val();
        var loginPwd =$("#loginPwd").val();
        var verify = $("#verify").val();
        var salt;
        if(loginId.trim() == ""){
            $("#errormsg").text("用户名不能为空");
            return;
        }
        if(loginPwd.trim() == ""){
            $("#errormsg").text("密码不能为空");
            return;
        }
        //判断用户是否修改了密码框中的密码
        if(loginPwd != $.cookie("loginPwd")){
            //设置为同步请求，以免后面的 ajax 先执行
            $.ajaxSettings.async = false;
            //获取后台的盐值
            $.get("/user/salt?loginId=" + loginId,function (data) {
                if(data != null){
                    salt = data;
                }
            })
            //设置为异步请求
            $.ajaxSettings.async = true;
            //密码加盐
            loginPwd = $.md5(loginPwd);
            loginPwd = $.md5(loginPwd + salt);
        }

        //登录
        $.ajax({
            type:"post",
            url:"/user/userLogin",
            data:{loginId:loginId,loginPwd:loginPwd,verify:verify},
            dataType:"json",
            success:function (data) {
                var json = data;
                if(json.success == "1"){
                    //勾选了记住密码
                    if($("#remember").prop("checked")){
                        $.cookie("loginId",loginId,{expired:7});
                        $.cookie("loginPwd",loginPwd,{expired:7});
                        $.cookie("remember",true,{expired:7});
                    }
                    //没勾选，删除 cookie
                    else{
                        $.cookie("loginId","",{expired:-1});
                        $.cookie("loginPwd","",{expired:-1});
                        $.cookie("remember",false,{expired:-1});
                    }
                    window.location.href="/admin/main";
                }else if (json.success == "0"){
                    $("#error").prop("class","alert alert-danger")
                    $("#errormsg").text("验证码校验失败！" )
                }
                else if (json.success == "2"){
                    $("#error").prop("class","alert alert-danger")
                    $("#errormsg").text("账号或密码错误！" )
                }
            }
        });
    })
});