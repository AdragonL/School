package com.l.o2o.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.l.o2o.dao.HeadLineDao;
import com.l.o2o.entity.HeadLine;
import com.l.o2o.service.HeadLineService;

@Service
public class HeadLineServiceImpl implements HeadLineService {
	@Autowired
	private HeadLineDao headLineDao;


	@Override
	public List<HeadLine> getHeadLinelist(HeadLine headLineCondition) throws IOException {
		return headLineDao.queryHeadLine(headLineCondition);
	}


}
