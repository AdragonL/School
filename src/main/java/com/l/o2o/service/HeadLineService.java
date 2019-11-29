package com.l.o2o.service;

import java.io.IOException;
import java.util.List;

import com.l.o2o.entity.HeadLine;

public interface HeadLineService {
	/**
	 * 根据传入条件返回指定头条列表
	 * 
	 * @param headLineCondition
	 * @return
	 * @throws IOException
	 */
	List<HeadLine> getHeadLinelist(HeadLine headLineCondition) throws IOException;
}
