package com.hjb.bangbangserver.controller.admin;

import com.hjb.bangbangserver.service.CategoryService;
import com.hjb.pojo.Category;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *  专门用于存储,页面跳转handler方法的controller
 */
@Slf4j
@Controller
@RequestMapping("/admin")
@Api(tags = "存储,页面跳转相关接口")
public class HtmlJumpController {

    @Autowired
    private CategoryService categoryService;

    /**
     *  设计欢迎页面跳转controller
     * @return login 登录页面
     */
    @GetMapping({"","index.html","index"})
    @ApiOperation("跳转登录页面")
    public String  welcome(){
        log.info("HtmlJumpController.welcome 跳转登录页面!");
        return "login";
    }


    /**
     * 登录成功跳转到index页面!
     * @return
     */
    @GetMapping("/home")
    @ApiOperation("跳转index页面")
    public String home(){
        log.info("HtmlJumpController.home登录成功,跳转程序首页!index页面!");
        return "index";
    }

    /**
     * 跳转用户管理页面
     */
    @GetMapping("/user")
    @ApiOperation("跳转登录页面")
    public String user(){
        log.info("HtmlJumpController.user,跳转用户管理!user页面!");
        return "user/user";
    }

    /**
     * 跳转商品管理页面
     */
    @GetMapping("/product")
    @ApiOperation("跳转商品页面")
    public String product(){
        log.info("HtmlJumpController.product,跳转商品管理!product页面!");
        return "product/product";
    }


    /**
     * 跳转类别管理页面
     */
    @GetMapping("/category")
    @ApiOperation("跳转类别管理页面")
    public String category(){
        log.info("HtmlJumpController.category,跳转类别管理!category页面!");
        return "category/category";
    }


    /**
     * 跳转订单管理页面
     */
    @GetMapping("/order")
    @ApiOperation("跳转订单管理页面")
    public String order(){
        log.info("HtmlJumpController.order,跳转订单管理!order页面!");
        return "order/order";
    }

    /**
     * 打开编辑用户页面
     */
    @GetMapping("/user/update/html")
    @ApiOperation("打开编辑用户页面")
    public String userUpdateHtml(){
        log.info("HtmlJumpController.userUpdateHtml业务结束，结果:{}");
        return "user/edit";
    }


    /**
     * 打开保存用户页面
     */
    @GetMapping("/user/save/html")
    @ApiOperation("打开保存用户页面")
    public String userSaveHtml(){
        log.info("HtmlJumpController.userSaveHtml业务结束，结果:{}");
        return "user/add";
    }




    /**
     * 打开编辑类别页面
     */
    @GetMapping("/category/update/html")
    @ApiOperation("打开编辑类别页面")
    public String categoryUpdateHtml(){
        log.info("HtmlJumpController.categoryUpdateHtml业务结束，结果:{}");
        return "category/edit";
    }

    /**
     * 打开保存类别页面
     * @return
     */
    @GetMapping("/category/save/html")
    @ApiOperation("打开保存类别页面")
    public String categorySaveHtml(){
        log.info("HtmlJumpController.categorySaveHtml结束，结果:{}");
        return "category/add";
    }


    /**
     * 商品添加页面
     * @return
     */
    @GetMapping("/product/save/html")
    @ApiOperation("打开商品添加页面")
    public String productSaveHtml(Model model){
        log.info("HtmlJumpController.productSaveHtml业务结束，结果:{}");

        //查询类别列表,存入共享域
        R r = categoryService.list();
        List<Category> categoryList = (List<Category>) r.getData();

        model.addAttribute("clist",categoryList);
        return "product/add";
    }

    /**
     * 商品保存页面跳转
     * @return
     */
    @GetMapping("/product/update/html")
    @ApiOperation("打开商品更新页面")
    public String productUpdateHtml(Model model){
        log.info("HtmlJumpController.productUpdateHtml业务结束，结果:{}");

        //查询类别列表,存入共享域
        R r = categoryService.list();
        List<Category> categoryList = (List<Category>) r.getData();

        model.addAttribute("clist",categoryList);
        return "product/edit";
    }
}