package com.hjb.bangbangserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjb.bangbangserver.mapper.CartMapper;
import com.hjb.bangbangserver.mapper.ProductMapper;
import com.hjb.bangbangserver.service.CartService;
import com.hjb.bangbangserver.service.ProductService;
import com.hjb.param.CartSaveParam;
import com.hjb.param.ProductIdParam;
import com.hjb.pojo.Cart;
import com.hjb.pojo.Product;
import com.hjb.utils.R;
import com.hjb.vo.CartVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductService productService;

    /**
     * 购物车数据添加方法
     * @param cartSaveParam
     * @return 001 成功 002 已经存在 003  没有库存
     */
    @Override
    public R save(CartSaveParam cartSaveParam) {
        //查询商品数据

        R r = productService.detail(cartSaveParam.getProductId());
        Product product =(Product) r.getData();

        if (product == null) {
            return R.fail("商品已经被删除,无法添加到购物车!");
        }
        //检查库存
        if (product.getProductNum() == 0){
            R ok = R.ok("没有库存数据!无法购买");
            ok.setCode("003");
            log.info("CartServiceImpl.save业务结束，结果:{}",ok);
            return ok;
        }

        //检查是否添加过
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",cartSaveParam.getUserId());
        queryWrapper.eq("product_id",cartSaveParam.getProductId());
        Cart cart = cartMapper.selectOne(queryWrapper);
        if (cart != null) {
            //证明购物车存在!
            //原有的数量+1
            cart.setNum(cart.getNum()+1);
            cartMapper.updateById(cart);
            //返回002 提示即可
            R ok = R.ok("购物车存在该商品,数量+1");
            ok.setCode("002");
            log.info("CartServiceImpl.save业务结束，结果:{}",ok);
            return ok;
        }
        //添加购物车
        cart = new Cart();
        cart.setNum(1); //第一次添加 1
        cart.setUserId(cartSaveParam.getUserId());
        cart.setProductId(cartSaveParam.getProductId());
        int rows = cartMapper.insert(cart);
        log.info("CartServiceImpl.save业务结束，结果:{}",rows);
        //结果封装和返回
        CartVo cartVo = new CartVo(product,cart);

        return R.ok("购物车数据添加成功!",cartVo);
    }
}
