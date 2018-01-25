package com.ding.o2o.dao;

import com.ding.o2o.entity.Shop;

public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return int
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return int
     */
    int updateShop(Shop shop);
}
