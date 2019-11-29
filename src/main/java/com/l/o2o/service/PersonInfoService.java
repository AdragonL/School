package com.l.o2o.service;

import com.l.o2o.entity.PersonInfo;

public interface PersonInfoService {
	/**
	 * 根据用户Id获取personinfo信息
	 * @param userId
	 * @return
	 */
	PersonInfo getPersonInfoById(Long userId);

}
