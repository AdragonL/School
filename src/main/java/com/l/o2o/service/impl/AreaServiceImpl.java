package com.l.o2o.service.impl;

import com.l.o2o.service.AreaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.l.o2o.dao.AreaDao;
import com.l.o2o.entity.Area;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaDao areaDao;
	@Override
	public List<Area> getAreaList(){
		return areaDao.queryArea();
	}
	
}
