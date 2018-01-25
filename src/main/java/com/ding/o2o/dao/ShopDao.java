package com.ding.o2o.dao;

import com.ding.o2o.entity.Shop;

public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return int
     */
    int insertShop(Shop shop);
}
