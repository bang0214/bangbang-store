package com.hjb.bangbangserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjb.bangbangserver.mapper.AddressMapper;
import com.hjb.bangbangserver.service.AddressService;
import com.hjb.pojo.Address;

import com.hjb.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 根据用户id查询地址
     * @param userId
     * @return
     */
    @Override
    public R list(Integer userId) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);

        List<Address> addressList = addressMapper.selectList(queryWrapper);

        R ok = R.ok("查询成功", addressList);
        log.info("AddressServiceImpl.list业务结束，结果:{}",ok);
        return ok;
    }

    /**
     * 新增地址,成功以后,要返回新的数据集合
     * @param address
     * @return
     */
    @Override
    public R save(Address address) {

        int rows = addressMapper.insert(address);

        if (rows == 0){
            log.info("AddressServiceImpl.save业务结束，结果:{}","地址失败!");
            return R.fail("插入地址失败!");
        }
        //复用查询业务
        return list(address.getUserId());
    }

    /**
     * 根据id删除地址
     * @param id
     * @return
     */
    @Override
    public R remove(Integer id) {
        int rows = addressMapper.deleteById(id);

        if (rows == 0){
            log.info("AddressServiceImpl.remove业务结束，结果:{}","地址删除失败");
            return R.fail("删除地址数据失败!");
        }

        log.info("AddressServiceImpl.remove业务结束，结果:{}","地址删除成功!");

        return R.ok("地址删除成功!");
    }
}
