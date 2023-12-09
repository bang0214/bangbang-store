package com.hjb.bangbangserver.controller.admin;

import com.hjb.bangbangserver.service.UserService;
import com.hjb.param.CartListParam;
import com.hjb.param.PageParam;
import com.hjb.pojo.User;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: b2c-store
 * <p>
 * description: 用户模块调用的controller
 */
@RestController
@RequestMapping("/admin/user")
@Api(tags = "管理前台用户相关接口")
public class FrontUserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    @ApiOperation(value = "查询前台用户")
    public R userList(PageParam pageParam){

        return userService.listPage(pageParam);
    }

    @PostMapping("remove")
    @ApiOperation(value = "删除前台用户")
    public R userList(CartListParam cartListParam){

        return userService.remove(cartListParam.getUserId());
    }

    @PostMapping("update")
    @ApiOperation(value = "更新前台用户信息")
    public R update(User user){

        return userService.update(user);
    }

    @PostMapping("save")
    @ApiOperation(value = "新增前台用户")
    public R save(User user){

        return userService.save(user);
    }
}
