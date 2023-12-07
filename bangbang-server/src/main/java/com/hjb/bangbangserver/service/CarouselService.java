package com.hjb.bangbangserver.service;

import com.hjb.utils.R;

public interface CarouselService {
    /**
     * 查询轮播图数据,只要优先级最高的6条!
     * @return
     */
    R list();
}
