package com.l.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.l.o2o.entity.Shop;

public interface ShopDao {
	/**
	 * 新增店鋪
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	/**
	 * 更新店鋪
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
	/**
	 * 通过shioId查询店铺
	 * @param shopId
	 * @return
	 */
	Shop queryByShopId(long shopId);

	/**
	 * 	分页查询店铺条件有：店铺名，店铺状态，店铺类别，區域id，owner
	 * @param shopCondition
	 * @param rowIndex 从第几行开始取数据
	 * @param pageSize 返回的条数
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,
			@Param("rowIndex") int rowIndex,@Param("pageSize") int pageSize);

	/**
	 * 返回queryList总数
	 * @param shopCondition
	 * @return
	 */
	int queryShopCount(@Param("shopCondition") Shop shopCondition);
} 
