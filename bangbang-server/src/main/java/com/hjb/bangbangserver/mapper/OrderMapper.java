package com.hjb.bangbangserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjb.pojo.Order;
import com.hjb.vo.AdminOrderVo;
import com.hjb.vo.OrderVo;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 后台查询订单数据
     * @param offset
     * @param pageSize
     * @return
     */
    List<OrderVo> selectOrder(@Param("offset") int offset, @Param("pageSize") int pageSize);
}
