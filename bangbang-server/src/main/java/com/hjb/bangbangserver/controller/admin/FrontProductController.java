package com.hjb.bangbangserver.controller.admin;


import com.hjb.bangbangserver.service.ProductService;
import com.hjb.bangbangserver.utils.AliyunOSSUtils;
import com.hjb.param.PageParam;
import com.hjb.param.ProductSaveParam;
import com.hjb.param.ProductSearchParam;
import com.hjb.pojo.Product;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@RestController
@RequestMapping("/admin/product")
@Api(tags = "管理前台商品相关接口")
public class FrontProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AliyunOSSUtils aliyunOSSUtils;

    @GetMapping("list")
    @ApiOperation(value = "查询前台商品")
    public R pageList(PageParam pageParam){

        return productService.pageList(pageParam);
    }

    @PostMapping("upload")
    @ApiOperation(value = "上传商品图片")
    public R  adminUpload(@RequestParam("img") MultipartFile img) throws Exception {

        String filename = img.getOriginalFilename();
        filename = UUID.randomUUID().toString().replaceAll("-","")
                +filename;
        String contentType = img.getContentType();

        byte[] content = img.getBytes();

        int hours = 3000;

        String url = aliyunOSSUtils.uploadImage(filename, content, contentType, hours);
        System.out.println("url = " + url);
        return R.ok("图片上传成功!",url);
    }


    @PostMapping("save")
    @ApiOperation(value = "新增商品")
    public R adminSave(ProductSaveParam productSaveParam){

        return productService.adminSave(productSaveParam);
    }

//    @PostMapping("update")
//    @ApiOperation(value = "更新商品")
//    public R adminUpdate(Product product){
//
//        return productService.update(product);
//    }
//
//    @PostMapping("remove")
//    @ApiOperation(value = "删除商品")
//    public R adminRemove(Integer productId){
//
//        return productService.remove(productId);
//    }
}
