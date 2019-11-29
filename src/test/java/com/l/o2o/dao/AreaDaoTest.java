package com.l.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.l.o2o.BaseTest;
import com.l.o2o.entity.Area;

public class AreaDaoTest extends BaseTest{
	@Autowired
	private AreaDao areadao;
	
	
	@Test
	public void testQueryArea() {
		List<Area> areaList =areadao.queryArea();
		assertEquals(2,areaList.size());
	}
}
