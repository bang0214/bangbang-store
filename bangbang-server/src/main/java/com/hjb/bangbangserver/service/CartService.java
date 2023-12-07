package com.hjb.bangbangserver.service;

import com.hjb.param.CartSaveParam;
import com.hjb.utils.R;

public interface CartService {
    /**
     * 购物车添加商品
     * @param cartSaveParam
     * @return
     */
    R save(CartSaveParam cartSaveParam);
}
