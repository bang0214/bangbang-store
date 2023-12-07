package com.hjb.bangbangserver.controller;



import com.hjb.bangbangserver.service.UserService;
import com.hjb.param.UserCheckParam;
import com.hjb.param.UserLoginParam;
import com.hjb.pojo.User;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用户模块的控制器类
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口")
public class UserController {


    @Autowired
    private UserService userservice;

    /**
     * 检查账号是否可用的接口
     * @param userCheckParam 接收检查的账号实体 内部有参数校验注解
     * @param result 获取校验结果的实体对象
     * @return 返回封装结果R对象即可
     */
    @PostMapping("check")
    @ApiOperation(value = "检查账号是否可用")
    public R check(@RequestBody @Validated UserCheckParam userCheckParam, BindingResult result){

        //检查是否符合检验注解的规则  符合 false  不符合 true
        boolean b = result.hasErrors();

        if (b){
            return R.fail("账号为null,不可使用!");
        }

        return userservice.check(userCheckParam);
    }


    /**
     * 注册业务
     * @param user
     * @param result
     * @return
     */
    @PostMapping("register")
    @ApiOperation(value = "注册账号")
    public R register(@RequestBody @Validated User user, BindingResult result){

        if (result.hasErrors()){
            //如果存在异常,证明请求参数不符合注解要求
            return  R.fail("参数异常,不可注册!");
        }

        return userservice.register(user);
    }


    /**
     * 登录业务
     * @param userLoginParam
     * @param result
     * @return
     */
    @PostMapping("login")
    @ApiOperation(value = "用户登录")
    public R login(@RequestBody @Validated UserLoginParam userLoginParam, BindingResult result){

        if (result.hasErrors()){
            //如果存在异常,证明请求参数不符合注解要求
            return  R.fail("参数异常,不可登录!");
        }

        return userservice.login(userLoginParam);
    }


}
