package com.l.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.l.o2o.BaseTest;
import com.l.o2o.entity.Area;

public class AreaServiceTest extends BaseTest{
@Autowired
private AreaService areaService;
@Test
public void testGetAreaList() {
	List<Area>areaList =areaService.getAreaList();
	assertEquals("ds",areaList.get(0).getAreaName());
}

}
