package com.hjb.bangbangserver.controller;
import com.hjb.bangbangserver.service.CollectService;
import com.hjb.pojo.Collect;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  收藏controller
 */
@RestController
@RequestMapping("collect")
@Api(tags = "收藏相关接口")
public class CollectController {

    @Autowired
    private CollectService collectService;

    /**
     * 添加收藏
     * @param collect
     * @return
     */
    @PostMapping("save")
    @ApiOperation(value = "根据用户id和商品id添加收藏")
    public R save(@RequestBody Collect collect){

        return collectService.save(collect);
    }

    @PostMapping("list")
    @ApiOperation(value = "根据用户id查询商品信息集合")
    public R list(@RequestBody Collect collect){

        return collectService.list(collect.getUserId());
    }


    @PostMapping("remove")
    @ApiOperation(value = "根据用户id和商品id删除收藏")
    public R remove(@RequestBody Collect collect){

        return collectService.remove(collect);
    }
//
//
//    @PostMapping("remove/product")
//    public R removeByPid(@RequestBody Integer productId){
//
//        return collectService.removeByPid(productId);
//    }

}
