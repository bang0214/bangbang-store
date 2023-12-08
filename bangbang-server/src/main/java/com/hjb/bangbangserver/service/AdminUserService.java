package com.hjb.bangbangserver.service;


import com.hjb.param.AdminUserParam;
import com.hjb.pojo.AdminUser;

/**
 *
 */
public interface AdminUserService {

    /**
     * 登录业务方法
     * @param adminUserParam
     * @return
     */
    AdminUser login(AdminUserParam adminUserParam);
}
