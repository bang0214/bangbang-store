package com.hjb.bangbangserver.service;

import com.hjb.param.ProductHotParam;
import com.hjb.param.ProductIdsParam;
import com.hjb.utils.R;

import java.util.List;

public interface ProductService {
    /**
     * 单类别名称 查询热门商品 至多7条数据
     * @param categoryName 类别名称
     * @return r
     */
    R promo(String categoryName);


    /**
     * 查询类别商品集合
     * @return
     */
    R clist();

    /**
     * 通用性的业务!
     *   传入了类别id,根据id查询并且分页
     *   没有传入类别的id! 查询全部!
     * @param productIdsParam
     * @return
     */
    R byCategory(ProductIdsParam productIdsParam);

    /**
     * 根据商品id,查询商品详情信息
     * @param productID
     * @return
     */
    R detail(Integer productID);

    /**
     * 查询商品对应的图片详情集合
     * @param productID
     * @return
     */
    R pictures(Integer productID);

    /**
     * 多类别热门商品查询 根据类别名称集合! 至多查询7条!
     * @param productHotParam 类别名称集合
     * @return r
     */
    R hots(ProductHotParam productHotParam);

    /**
     * 根据商品id集合查询商品
     * @param productIds
     * @return
     */
    R ids(List<Integer> productIds);
}
