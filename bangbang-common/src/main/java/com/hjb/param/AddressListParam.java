package com.hjb.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 **地址结合参数接收
 */
@Data
@ApiModel(description = "要查询地址的用户id")
public class AddressListParam {

    @NotNull
    @JsonProperty("user_id")
    private Integer userId;
}
