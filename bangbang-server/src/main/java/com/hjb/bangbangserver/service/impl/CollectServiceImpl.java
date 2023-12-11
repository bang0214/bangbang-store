package com.hjb.bangbangserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjb.bangbangserver.mapper.CollectMapper;
import com.hjb.bangbangserver.mapper.ProductMapper;
import com.hjb.bangbangserver.service.CollectService;
import com.hjb.bangbangserver.service.ProductService;
import com.hjb.pojo.Collect;
import com.hjb.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private ProductService productService;

    /**
     * 添加收藏
     * @param collect
     * @return
     */
    @Override
    public R save(Collect collect) {

        //1.先查询是否存在
        QueryWrapper<Collect> queryWrapper =
                new QueryWrapper<>();

        queryWrapper.eq("user_id",collect.getUserId());
        queryWrapper.eq("product_id",collect.getProductId());

        Long count = collectMapper.selectCount(queryWrapper);

        if (count > 0){
            return R.fail("收藏已经添加,无需二次添加!");
        }
        //2.不存在进行添加
        //补充下时间
        collect.setCollectTime(System.currentTimeMillis());
        int rows = collectMapper.insert(collect);
        log.info("CollectServiceImpl.save业务结束，结果:{}",rows);

        return R.ok("收藏添加成功!");
    }

    /**
     * 根据用户id查询商品信息集合
     * @param userId
     * @return
     */
    @Override
    public R list(Integer userId) {
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.select("product_id");

        List<Object> objects = collectMapper.selectObjs(queryWrapper);
        List<Integer> ids = objects.stream().map(object -> Integer.parseInt(object.toString())).collect(Collectors.toList());

        R r = productService.ids(ids);
        log.info("CollectServiceImpl.list业务结束，结果:{}",r);
        return r;

    }

    /**
     * 根据用户id和商品id删除收藏
     * @param collect
     * @return
     */
    @Override
    public R remove(Collect collect) {
        QueryWrapper<Collect> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("user_id",collect.getUserId());
        queryWrapper.eq("product_id",collect.getProductId());

        int rows = collectMapper.delete(queryWrapper);
        log.info("CollectServiceImpl.remove业务结束，结果:{}",rows);
        return R.ok("收藏移除成功!");
    }

    /**
     * 根据商品id删除收藏
     * @param productId
     * @return
     */
    @Override
    public R adminRemove(Integer productId) {

        QueryWrapper<Collect> queryWrapper  = new QueryWrapper<>();
        queryWrapper.eq("product_id",productId);

        int rows = collectMapper.delete(queryWrapper);
        log.info("CollectServiceImpl.adminRemove业务结束，结果:{}",rows);
        return R.ok("收藏商品删除成功!");
    }
}
