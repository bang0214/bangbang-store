package com.hjb.param;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.hjb.vo.CartVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 订单接收参数的param
 */
@Data
public class  OrderParam implements Serializable {

    public static final Long serialVersionUID = 1L;

    @JsonProperty("user_id")
    private Integer userId;
    private List<CartVo> products;
}
