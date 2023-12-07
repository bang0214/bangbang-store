package com.hjb.bangbangserver.controller;

import com.hjb.bangbangserver.service.ProductService;
import com.hjb.param.ProductHotParam;
import com.hjb.param.ProductIdParam;
import com.hjb.param.ProductIdsParam;
import com.hjb.param.ProductPromoParam;
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
 *  商品模块controller
 */
@RestController
@RequestMapping("product")
@Api(tags = "商品相关接口")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/promo")
    @ApiOperation(value = "根据单类别名称查询热门商品")
    public R promo(@RequestBody @Validated ProductPromoParam productPromoParam, BindingResult result){

        if (result.hasErrors()){
            return R.fail("数据查询失败!");
        }

        return  productService.promo(productPromoParam.getCategoryName());
    }


    @PostMapping("hots")
    @ApiOperation(value = "根据多类别名称查询热门商品")
    public R hots(@RequestBody @Validated ProductHotParam productHotParam,BindingResult result){

        if (result.hasErrors()){
            return R.fail("数据查询失败!");
        }

        return productService.hots(productHotParam);
    }

    @PostMapping("category/list")
    @ApiOperation(value = "查询所有类别")
    public R clist(){

        return productService.clist();
    }

    @PostMapping("bycategory")
    @ApiOperation(value = "根据类别查询商品")
    public R byCategory(@RequestBody @Validated ProductIdsParam productIdsParam,BindingResult result){

        if (result.hasErrors()){
            return R.fail("类别商品查询失败!");
        }

        return productService.byCategory(productIdsParam);
    }


    @PostMapping("all")
    @ApiOperation(value = "查询所有商品")
    public R all(@RequestBody @Validated ProductIdsParam productIdsParam,BindingResult result){

        if (result.hasErrors()){
            return R.fail("类别商品查询失败!");
        }

        return productService.byCategory(productIdsParam);
    }

    @PostMapping("detail")
    @ApiOperation(value = "查询商品详情")
    public R detail(@RequestBody @Validated ProductIdParam productIdParam,BindingResult result){

        if (result.hasErrors()) {
            return R.fail("商品详情查询失败");
        }
        return productService.detail(productIdParam.getProductID());
    }

    @PostMapping("pictures")
    @ApiOperation(value = "查询商品图片详情")
    public R pictures(@RequestBody @Validated ProductIdParam productIdParam,BindingResult result){

        if (result.hasErrors()) {
            return R.fail("商品图片详情查询失败");
        }
        return productService.pictures(productIdParam.getProductID());
    }
//
//    @PostMapping("search")
//    public R search(@RequestBody ProductSearchParam productSearchParam){
//
//        return productService.search(productSearchParam);
//    }

}
