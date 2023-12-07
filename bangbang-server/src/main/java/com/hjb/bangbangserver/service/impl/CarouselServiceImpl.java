package com.hjb.bangbangserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjb.bangbangserver.mapper.CarouselMapper;
import com.hjb.bangbangserver.service.CarouselService;
import com.hjb.pojo.Carousel;
import com.hjb.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    /**
     * 查询轮播图数据,只要优先级最高的6条!
     * @return
     */
    @Override
    @Cacheable(value="list.carousel",key = "#root.methodName" ,cacheManager = "cacheManagerDay")
    public R list() {

        QueryWrapper<Carousel> carouselQueryWrapper = new QueryWrapper<>();
        carouselQueryWrapper.orderByDesc("priority");

        List<Carousel> list = carouselMapper.selectList(carouselQueryWrapper);
        //jdk 1.8 stream
        List<Carousel> collect = list.stream().limit(6).collect(Collectors.toList());

        R ok = R.ok(collect);

        log.info("CarouselServiceImpl.list业务结束，结果:{}",ok);
        return ok;
    }
}
