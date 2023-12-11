package com.hjb.bangbangserver.controller.admin;


import com.hjb.bangbangserver.service.OrderService;
import com.hjb.param.PageParam;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/order")
@Api(tags = "管理前台订单相关接口")
public class FrontOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    @ApiOperation(value = "查询前台订单")
    public R list(PageParam pageParam){

        return orderService.adminList(pageParam);
    }
}
