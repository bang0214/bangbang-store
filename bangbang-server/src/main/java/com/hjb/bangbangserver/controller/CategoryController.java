package com.hjb.bangbangserver.controller;


import com.hjb.bangbangserver.service.CategoryService;
import com.hjb.param.ProductHotParam;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
@Api(tags = "商品分类相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据类别名称查询商品
     * @param categoryName
     * @return
     */
    @GetMapping("/promo/{categoryName}")
    @ApiOperation(value = "根据类别名称查询商品")
    public R byName(@PathVariable String categoryName){

        if (StringUtils.isEmpty(categoryName)){
            return R.fail("类别名称为null,无法查询类别数据!");
        }

        return categoryService.byName(categoryName);
    }


    /**
     * 热门类别id查询!
     * @param productHotParam
     * @param result
     * @return
     */
    @PostMapping("hots")
    @ApiOperation(value = "查询热门类别")
    public R hotsCategory(@RequestBody @Validated ProductHotParam productHotParam, BindingResult result){

        if (result.hasErrors()){
            return R.fail("类别集合查询失败!");
        }

        return categoryService.hotsCategory(productHotParam);
    }

    /**
     * 查询全部类别
     * @return
     */
    @GetMapping("list")
    @ApiOperation(value = "查询全部类别")
    public R list(){

        return categoryService.list();
    }
}
