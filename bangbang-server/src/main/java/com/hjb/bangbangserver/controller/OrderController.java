package com.hjb.bangbangserver.controller;

import com.hjb.bangbangserver.service.OrderService;
import com.hjb.param.CartListParam;
import com.hjb.param.OrderParam;
import com.hjb.param.PageParam;
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


@RestController
@RequestMapping("order")
@Api(tags = "订单相关接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("save")
    @ApiOperation("新增订单")
    public R save(@RequestBody OrderParam orderParam){
        return orderService.save(orderParam);
    }


    @PostMapping("list")
    @ApiOperation("查询订单")
    public R list(@RequestBody @Validated CartListParam CartListParam, BindingResult result){

        if (result.hasErrors()){
            return R.fail("参数异常,查询失败!");
        }

        return orderService.list(CartListParam.getUserId());
    }


//    @PostMapping("remove/check")
//    public R check(@RequestBody Integer productId)
//    {
//        return orderService.check(productId);
//    }
//
//
//    @PostMapping("admin/list")
//    public R adminList(@RequestBody PageParam pageParam)
//    {
//        return orderService.adminList(pageParam);
//    }

}
