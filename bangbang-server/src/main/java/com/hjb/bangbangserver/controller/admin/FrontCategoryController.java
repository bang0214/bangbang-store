package com.hjb.bangbangserver.controller.admin;


import com.hjb.bangbangserver.service.CategoryService;
import com.hjb.param.PageParam;
import com.hjb.pojo.Category;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  类别controller
 */
@RestController
@RequestMapping("/admin/category")
@Api(tags = "管理前台分类相关接口")
public class FrontCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    @ApiOperation(value = "查询前台分类")
    public R pageList(PageParam pageParam){

        return categoryService.pageList(pageParam);
    }

    @PostMapping("save")
    @ApiOperation(value = "新增前台分类")
    public R save(Category category){

        return categoryService.save(category);
    }

    @PostMapping("remove")
    @ApiOperation(value = "删除前台分类")
    public R remove(Integer categoryId){

        return categoryService.remove(categoryId);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新前台分类")
    public R update(Category category){

        return categoryService.update(category);
    }
}
