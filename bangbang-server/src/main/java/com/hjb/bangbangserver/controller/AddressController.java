package com.hjb.bangbangserver.controller;

import com.hjb.bangbangserver.service.AddressService;
import com.hjb.param.AddressListParam;
import com.hjb.param.AddressParam;
import com.hjb.param.AddressRemoveParam;
import com.hjb.pojo.Address;
import com.hjb.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/address")
@Api(tags = "地址相关接口")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 根据用户id查询地址
     * @param addressListParam
     * @param result
     * @return
     */
    @PostMapping("list")
    @ApiOperation(value = "根据用户id查询地址")
    public R list(@RequestBody @Validated AddressListParam addressListParam, BindingResult result){

        if(result.hasErrors()){
            return R.fail("参数异常,查询失败!");
        }

        return addressService.list(addressListParam.getUserId());
    }

    /**
     * 新增地址
     * @param addressParam
     * @param result
     * @return
     */
    @PostMapping("save")
    @ApiOperation(value = "新增地址")

    public R save(@RequestBody @Validated AddressParam addressParam, BindingResult result){

        if (result.hasErrors()){

            return R.fail("参数异常,保存失败!");
        }

        Address address = addressParam.getAdd();
        address.setUserId(addressParam.getUserId());

        return addressService.save(address);
    }

    /**
     * 删除地址
     * @param addressRemoveParam
     * @param result
     * @return
     */
    @PostMapping("remove")
    @ApiOperation(value = "删除地址")
    public R remove(@RequestBody @Validated AddressRemoveParam addressRemoveParam, BindingResult result){
        if (result.hasErrors()){

            return R.fail("参数异常,删除失败!");
        }

        return addressService.remove(addressRemoveParam.getId());
    }
}
