package com.hjb.bangbangserver.controller.admin;


import com.hjb.bangbangserver.service.AdminUserService;
import com.hjb.param.AdminUserParam;
import com.hjb.pojo.AdminUser;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 *  后台管理用户处理controller
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "后台用户相关接口")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/user/login")
    @ApiOperation(value = "后台用户登录")
    public R login(@Validated AdminUserParam adminUserParam, BindingResult result, HttpSession session){
        if (result.hasErrors()){
            return R.fail("核心参数为null,登录失败!");
        }

        //验证码校验
        String captcha = (String) session.getAttribute("captcha");

        if (!adminUserParam.getVerCode().equalsIgnoreCase(captcha)){
            return R.fail("验证码错误!");
        }

        AdminUser user =  adminUserService.login(adminUserParam);

        if (user == null){
            return R.fail("登录失败!账号或者密码错误!");
        }

        session.setAttribute("userInfo",user);

        return R.ok("登录成功!");
    }

    @GetMapping("user/logout")
    @ApiOperation(value = "后台用户登出")
    public R logout(HttpSession session){
        //清空session即可
        session.invalidate();

        return R.ok("退出登录成功!");
    }

}
