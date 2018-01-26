package com.ding.o2o.service;

import com.ding.o2o.dto.ShopExecution;
import com.ding.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

public interface ShopService {
    /**
     * 创建商铺
     * @param shop
     * @param shopImg
     * @return shopExecution
     */
    ShopExecution addShop(Shop shop, File shopImg) throws RuntimeException;
}
