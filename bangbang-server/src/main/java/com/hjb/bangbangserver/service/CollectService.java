package com.hjb.bangbangserver.service;

import com.hjb.pojo.Collect;
import com.hjb.utils.R;

public interface CollectService {
    /**
     * 添加收藏
     * @param collect
     * @return
     */
    R save(Collect collect);

    /**
     * 根据用户id查询商品信息集合
     * @param userId
     * @return
     */
    R list(Integer userId);

    /**
     * 根据用户id和商品id删除收藏
     * @param collect
     * @return
     */
    R remove(Collect collect);
}
