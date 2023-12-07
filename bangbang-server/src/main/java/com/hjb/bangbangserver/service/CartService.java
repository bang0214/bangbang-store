package com.hjb.bangbangserver.service;

import com.hjb.param.CartSaveParam;
import com.hjb.pojo.Cart;
import com.hjb.utils.R;

import java.util.List;

public interface CartService {
    /**
     * 购物车添加商品
     * @param cartSaveParam
     * @return
     */
    R save(CartSaveParam cartSaveParam);

    /**
     * 查询购物车商品
     * @param userId
     * @return
     */
    R list(Integer userId);

    /**
     * 更新购物车业务
     * @param cart
     * @return
     */
    R update(Cart cart);

    /**
     * 删除购物车数据
     * @param cart
     * @return
     */
    R remove(Cart cart);

    /**
     * 清空对应id的购物车项
     * @param cartIds
     */
    void clearIds(List<Integer> cartIds);

    /**
     * 查询购物车项
     * @param productId
     * @return
     */
    R check(Integer productId);
}
