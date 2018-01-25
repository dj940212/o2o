package com.ding.o2o.service.impl;

import com.ding.o2o.dao.ShopDao;
import com.ding.o2o.dto.ShopExecution;
import com.ding.o2o.entity.Shop;
import com.ding.o2o.enums.ShopStateEnum;
import com.ding.o2o.service.ShopService;
import com.ding.o2o.util.FileUtil;
import com.ding.o2o.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;

public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, File shopImg) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            //给店铺信息赋值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new RuntimeException("店铺创建失败");
            }else {
                if (shopImg != null){
                    try {
                        //存储图片
                        addShopImg(shop, shopImg);
                    }catch (Exception e) {
                        throw new RuntimeException("addShopImg error:"+e.getMessage());
                    }
                    //更新店铺图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0){
                        throw new RuntimeException("更新店铺图片失败");
                    }

                }
            }
        } catch (Exception e) {
            throw new RuntimeException("addShop error:" + e.getMessage());
        }

        return null;
    }

    private void addShopImg(Shop shop, File shopImg) {
        //获取shop图片目录的相对值路径
        String dest = FileUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
    }
}
