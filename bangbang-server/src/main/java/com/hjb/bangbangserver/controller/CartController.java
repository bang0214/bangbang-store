package com.hjb.bangbangserver.controller;

import com.hjb.bangbangserver.service.CartService;
import com.hjb.param.CartListParam;
import com.hjb.param.CartSaveParam;
import com.hjb.pojo.Cart;
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
@RequestMapping("cart")
@Api(tags = "购物车相关接口")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("save")
    @ApiOperation(value = "添加购物车商品")
    public R save(@RequestBody @Validated CartSaveParam cartSaveParam, BindingResult result){
        if (result.hasErrors()){
            return R.fail("核心参数为null,添加失败!");
        }

        return cartService.save(cartSaveParam);
    }


    @PostMapping("list")
    @ApiOperation(value = "查询购物车商品")
    public R list(@RequestBody @Validated CartListParam cartListParam, BindingResult bindingResult){

        if (bindingResult.hasErrors()){

            return R.fail("购物车数据查询失败!");
        }

        return cartService.list(cartListParam.getUserId());
    }


    @PostMapping("update")
    @ApiOperation(value = "更新购物车商品数量")
    public R update(@RequestBody Cart cart){
        return cartService.update(cart);
    }


    @PostMapping("remove")
    @ApiOperation(value = "删除购物车商品")
    public R remove(@RequestBody Cart cart){

        return cartService.remove(cart);
    }


    @PostMapping("remove/check")
    @ApiOperation(value = "检查购物车商品")
    public R removeCheck(@RequestBody Integer productId){

        return cartService.check(productId);
    }

}
