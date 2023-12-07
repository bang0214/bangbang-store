package com.hjb.bangbangserver.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hjb.param.OrderParam;
import com.hjb.param.PageParam;
import com.hjb.pojo.Order;
import com.hjb.utils.R;


public interface OrderService extends IService<Order> {


    /**
     * 进行订单数据保存业务
     * @param orderParam
     * @return
     */
    R save(OrderParam orderParam);

    /**
     * 分组查询订单数据
     * @param userId
     * @return
     */
    R list(Integer userId);

    /**
     * 检查订单中是否有商品引用
     * @param productId
     * @return
     */
    R check(Integer productId);

    /**
     * 后台管理查询订单数据
     * @param pageParam
     * @return
     */
    R adminList(PageParam pageParam);
}
