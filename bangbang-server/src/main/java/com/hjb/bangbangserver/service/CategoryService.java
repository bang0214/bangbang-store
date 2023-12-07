package com.hjb.bangbangserver.service;

import com.hjb.param.ProductHotParam;
import com.hjb.utils.R;

public interface CategoryService {
    /**
     * 根据类别名称查询对象
     * @param categoryName
     * @return
     */
    R byName(String categoryName);

    /**
     * 查询类别数据,进行返回!
     * @return
     */
    R list();

    /**
     * 根据传入的热门类别名称集合!返回类别对应的id集合
     * @param productHotParam
     * @return
     */
    R hotsCategory(ProductHotParam productHotParam);
}
