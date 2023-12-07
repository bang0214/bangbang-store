package com.hjb.bangbangserver.service;

import com.hjb.pojo.Address;
import com.hjb.utils.R;

public interface AddressService {
    /**
     * 根据用户id查询地址
     * @param userId
     * @return
     */
    R list(Integer userId);

    /**
     * 新增地址
     * @param address
     * @return
     */
    R save(Address address);

    /**
     * 删除地址
     * @param id
     * @return
     */
    R remove(Integer id);
}
