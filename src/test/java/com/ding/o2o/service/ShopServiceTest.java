package com.ding.o2o.service;

import com.ding.o2o.BaseTest;
import com.ding.o2o.dto.ShopExecution;
import com.ding.o2o.entity.Area;
import com.ding.o2o.entity.Shop;
import com.ding.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest{
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop(){
        Shop shop = new Shop();
		shop.setOwnerId(8L);
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setAdvice("审核中");
        File shopImg = new File("/Users/ding/projects/image/background.png");
        ShopExecution se = shopService.addShop(shop, shopImg);
		assertEquals("mytest1", se.getShop().getShopName());
    }
}
