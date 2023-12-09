package com.hjb.bangbangserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjb.param.PageParam;
import com.hjb.param.ProductHotParam;
import com.hjb.param.ProductIdsParam;
import com.hjb.param.ProductSaveParam;
import com.hjb.pojo.Product;
import com.hjb.to.OrderToProduct;
import com.hjb.utils.R;

import java.util.List;

public interface ProductService extends IService<Product> {
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

    /**
     * 根据商品ids查询多个商品
     * @param productIds
     * @return
     */
    List<Product> cartList(List<Integer> productIds);

    /**
     * 修改库存和增加销售量
     * @param orderToProducts
     */
    void subNumber(List<OrderToProduct> orderToProducts);

    /**
     * 类别对应的商品数量查询
     * @param categoryId
     * @return
     */
    public Long adminCount(Integer categoryId);

    /**
     * 管理端分页查询商品
     * @param pageParam
     * @return
     */
    R pageList(PageParam pageParam);

    /**
     * 商品保存业务
     * @param productSaveParam
     * @return
     */
    R adminSave(ProductSaveParam productSaveParam);

    /**
     * 商品数据更新
     * @param product
     * @return
     */
    R adminUpdate(Product product);

    /**
     * 商品删除业务
     * @param productId
     * @return
     */
    R adminRemove(Integer productId);
}
