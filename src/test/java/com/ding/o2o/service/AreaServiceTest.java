package com.ding.o2o.service;

import com.ding.o2o.BaseTest;
import com.ding.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest{
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        System.out.println(areaList.get(0));
        assertEquals("东苑",areaList.get(0).getAreaName());
    }
}