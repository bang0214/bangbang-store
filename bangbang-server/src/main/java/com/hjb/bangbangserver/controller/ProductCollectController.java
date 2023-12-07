package com.hjb.bangbangserver.controller;

import com.hjb.bangbangserver.service.ProductService;
import com.hjb.param.ProductCollectParam;
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
 * 商品被收藏调用的controller
 */
@RestController
@RequestMapping("product")
@Api(tags = "商品被收藏调用的相关接口")
public class ProductCollectController {

    @Autowired
    private ProductService productService;

    @PostMapping("collect/list")
    @ApiOperation(value = "根据商品id集合查询商品")
    public R productIds(@RequestBody @Validated ProductCollectParam productCollectParam, BindingResult result){

        if (result.hasErrors()){
            return R.ok("没有收藏数据!");
        }

        return productService.ids(productCollectParam.getProductIds());
    }
}
