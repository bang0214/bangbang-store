package com.hjb.bangbangserver.service;

import com.hjb.param.PageParam;
import com.hjb.param.ProductHotParam;
import com.hjb.pojo.Category;
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

    /**
     * 分页查询方法
     * @param pageParam
     * @return
     */
    R pageList(PageParam pageParam);

    /**
     * 进行分类数据添加
     * @param category
     * @return
     */
    R save(Category category);

    /**
     * 根据id删除类别数据
     * @param categoryId
     * @return
     */
    R remove(Integer categoryId);

    /**
     * 修改类别信息
     * @param category
     * @return
     */
    R update(Category category);
}
