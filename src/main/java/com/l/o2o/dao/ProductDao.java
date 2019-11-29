package com.l.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.l.o2o.entity.Product;

public interface ProductDao {

	/**
	 * 插入商品
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);

	
	/**
	 * 通过Id查商品信息
	 * @param productCondition
	 * @return
	 */
	Product queryProductById(long productId);

	/**
	 * 更新商品信息
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);

	
	/**
	 * 咨询列表并分页，可有商品名，状态，店铺Id，商品类别
	 * @param productCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<Product> queryProductList(@Param("productCondition")Product productCondition,@Param("rowIndex") int rowIndex,@Param("pageSize") int pageSize);

	/**
	 * 删除商品
	 * 
	 * @param productId
	 * @return
	 */
	int deleteProduct(@Param("productId") long productId, @Param("shopId") long shopId);
	
	/**
	 * 删除商品类别之前，将商品类别ID为空
	 * @param productCategory
	 * @return
	 */
	int updateProductCategoryToNull(long productCategoryId);
	
	/**
	 * 查询总数
	 * @param productCondition
	 * @return
	 */
	int queryProductCount(@Param("productCondition") Product productCondition);
}
