package com.hjb.bangbangserver.controller;

import com.hjb.bangbangserver.service.CarouselService;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carousel")
@Api(tags = "轮播图相关接口")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    /**
     * 查询轮播图数据,只要优先级最高的6条!
     * @return
     */
    @PostMapping("list")
    @ApiOperation(value = "查询轮播图")
    public R list(){

        return carouselService.list();
    }
}
