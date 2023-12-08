package com.hjb.bangbangserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjb.bangbangserver.mapper.PictureMapper;
import com.hjb.bangbangserver.mapper.ProductMapper;
import com.hjb.bangbangserver.service.CarouselService;
import com.hjb.bangbangserver.service.CategoryService;
import com.hjb.bangbangserver.service.ProductService;
import com.hjb.param.ProductHotParam;
import com.hjb.param.ProductIdsParam;
import com.hjb.pojo.Category;
import com.hjb.pojo.Picture;
import com.hjb.pojo.Product;

import com.hjb.to.OrderToProduct;
import com.hjb.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements ProductService {


    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据单类别名称查询热门商品
     * @param categoryName
     * @return
     */
    @Cacheable(value = "list.product", key = "#categoryName")
    @Override
    public R promo(String categoryName) {
        R r = categoryService.byName(categoryName);

        if (r.getCode().equals(R.FAIL_CODE)) {
            log.info("ProductServiceImpl.promo业务结束，结果:{}","类别查询失败!");
            return r;
        }

        Category data = (Category)r.getData();
        Integer categoryId = data.getCategoryId();

        //封装查询参数
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id",categoryId);
        queryWrapper.orderByDesc("product_sales");

        IPage<Product> page = new Page<>(1,7);

        //返回的是包装数据! 内部有对应的商品集合,也有分页的参数 例如: 总条数 总页数等等
        page = productMapper.selectPage(page, queryWrapper);

        List<Product> productList = page.getRecords(); //指定页的数据

        log.info("ProductServiceImpl.promo业务结束，结果:{}",productList);

        return R.ok("数据查询成功",productList);
    }

    /**
     * 查询类别商品集合
     *
     * @return
     */
    @Override
    public R clist() {
        R r = categoryService.list();
        log.info("ProductServiceImpl.clist业务结束，结果:{}",r);
        return r;
    }

    /**
     * 通用性的业务!
     * 传入了类别id,根据id查询并且分页
     * 没有传入类别的id! 查询全部!
     * @param productIdsParam
     * @return
     */
    @Cacheable(value = "list.product",key = "#productIdsParam.categoryID+'-'+#productIdsParam.currentPage+'-'+#productIdsParam.pageSize")
    @Override
    public R byCategory(ProductIdsParam productIdsParam) {

        List<Integer> categoryID = productIdsParam.getCategoryID();

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (!categoryID.isEmpty()) {
            queryWrapper.in("category_id",categoryID);
        }

        IPage<Product> page = new Page<>(productIdsParam.getCurrentPage(),productIdsParam.getPageSize());

        page = productMapper.selectPage(page,queryWrapper);

        //结果集封装
        R ok = R.ok("查询成功!", page.getRecords(), page.getTotal());

        log.info("ProductServiceImpl.byCategory业务结束，结果:{}",ok);

        return ok;
    }

    /**
     * 根据商品id,查询商品详情信息
     * @param productID
     * @return
     */
    @Cacheable(value = "product",key = "#productID")
    public R detail(Integer productID) {
        Product product = productMapper.selectById(productID);

        R ok = R.ok(product);
        log.info("ProductServiceImpl.detail业务结束，结果:{}",ok);
        return ok;
    }


    /**
     * 查询商品对应的图片详情集合
     * @param productID
     * @return
     */
    @Override
    @Cacheable(value="picture",key = "#productID")
    public R pictures(Integer productID) {

        QueryWrapper<Picture> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("product_id",productID);

        List<Picture> pictureList = pictureMapper.selectList(queryWrapper);

        R ok = R.ok(pictureList);

        log.info("ProductServiceImpl.pictures业务结束，结果:{}",ok);
        return ok;
    }

    /**
     * 多类别热门商品查询 根据类别名称集合! 至多查询7条!
     *   1. 调用类别服务
     *   2. 类别集合id查询商品
     *   3. 结果集封装即可
     * @param productHotParam 类别名称集合
     * @return r
     */
    @Cacheable(value = "list.product",key = "#productHotParam.categoryName")
    @Override
    public R hots(ProductHotParam productHotParam) {

        R r = categoryService.hotsCategory(productHotParam);

        if(r.getCode().equals(R.FAIL_CODE)){
            log.info("ProductServiceImpl.hots业务结束，结果:{}",r.getMsg());
            return r;
        }

        List<Object> ids = (List<Object>) r.getData();

        //进行商品数据查询
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_id",ids);
        queryWrapper.orderByDesc("product_sales");

        IPage<Product> page = new Page<>(1,7);

        page = productMapper.selectPage(page,queryWrapper);

        List<Product> records = page.getRecords();

        R ok = R.ok("多类别热门商品查询成功!", records);

        log.info("ProductServiceImpl.hots业务结束，结果:{}",ok);

        return ok;
    }

    /**
     * 根据商品id集合查询商品信息
     * @param productIds
     * @return
     */
    @Cacheable(value = "list.product",key = "#productIds")
    @Override
    public R ids(List<Integer> productIds) {

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("product_id",productIds);

        List<Product> productList = productMapper.selectList(queryWrapper);

        R r = R.ok("类别信息查询成功!", productList);
        log.info("ProductServiceImpl.ids业务结束，结果:{}",r);
        return r;
    }

    /**
     * 根据商品ids查询多个商品
     * @param productIds
     * @return
     */
    public List<Product> cartList(List<Integer> productIds) {

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("product_id",productIds);

        List<Product> productList = productMapper.selectList(queryWrapper);
        log.info("ProductServiceImpl.cartList业务结束，结果:{}",productList);
        return productList;
    }

    /**
     * 修改库存和增加销售量
     *
     * @param orderToProducts
     */
    @Override
    public void subNumber(List<OrderToProduct> orderToProducts) {

        //将集合转成map  productId orderToProduct
        Map<Integer, OrderToProduct> map = orderToProducts.stream().collect(Collectors.toMap(OrderToProduct::getProductId, v -> v));
        //获取商品的id集合
        Set<Integer> productIds = map.keySet();
        //查询集合对应的商品信息
        List<Product> productList = productMapper.selectBatchIds(productIds);
        //修改商品信息
        for (Product product : productList) {
            Integer num = map.get(product.getProductId()).getNum();
            product.setProductNum(product.getProductNum() - num); //减库存
            product.setProductSales(product.getProductSales()+num); //添加销售量
        }
        //批量更新
        this.updateBatchById(productList);
        log.info("ProductServiceImpl.subNumber业务结束，结果:库存和销售量的修改完毕");
    }
}