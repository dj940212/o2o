package com.ding.o2o.service;

import com.ding.o2o.dto.ShopExecution;
import com.ding.o2o.entity.Shop;

import java.io.File;

public interface ShopService {
    ShopExecution addShop(Shop shop, File shopImg);
}
