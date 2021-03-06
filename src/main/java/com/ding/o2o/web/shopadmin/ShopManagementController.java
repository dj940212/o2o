package com.ding.o2o.web.shopadmin;

import com.ding.o2o.entity.Shop;
import com.ding.o2o.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @RequestMapping(value="/register", method = RequestMethod.POST)
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modeMap = new HashMap<String, Object>();
        //1.接收并转化相应的参数,包括店铺信息以及图片信息
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e){
            modeMap.put("success", false);
            modeMap.put("errMsg", e.getMessage());
            return modeMap;
        }
        //2.注册店铺
        //3.返回结果
        return null;
    }
}
