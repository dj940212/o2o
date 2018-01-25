package com.ding.o2o.dao;

import com.ding.o2o.BaseTest;
import com.ding.o2o.entity.Area;
import com.ding.o2o.entity.PersonInfo;
import com.ding.o2o.entity.Shop;
import com.ding.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest{
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(8L);
        area.setAreaId(4);
        shopCategory.setShopCategoryId(10L);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setOwnerId(owner.getUserId());
        shop.setShopName("测试店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");

        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
    }

}
