package com.hjb.bangbangserver.controller;


import com.hjb.bangbangserver.service.ProductService;
import com.hjb.param.ProductCollectParam;
import com.hjb.param.ProductIdParam;
import com.hjb.pojo.Product;
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

import java.util.ArrayList;
import java.util.List;

/**
 * : 购物车调用商品服务的controller
 */
@RestController
@RequestMapping("product")
@Api(tags = "商品被购物车调用的相关接口")
public class ProductCartController {

    @Autowired
    private ProductService productService;

    @PostMapping("cart/detail")
    @ApiOperation(value = "根据商品id获得单个商品信息(用于添加购物车商品)")
    public Product cdetail(@RequestBody  @Validated ProductIdParam productIdParam,
                           BindingResult result){

        if (result.hasErrors()){
            return null;
        }
        R detail = productService.detail(productIdParam.getProductID());
        Product product = (Product) detail.getData();
        return  product;
    }

    @PostMapping("cart/list")
    @ApiOperation(value = "根据多商品id获得多个商品信息(用于查询购物车商品)")
    public List<Product> cartList(@RequestBody @Validated ProductCollectParam productCollectParam,
                                  BindingResult result){

        if (result.hasErrors()){
            return new ArrayList<Product>();
        }

        return productService.cartList(productCollectParam.getProductIds());
    }
}
