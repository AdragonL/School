package com.l.o2o.dao;

import java.util.List;

import com.l.o2o.entity.ProductImg;

public interface ProductImgDao {
/**
 * 列出某个商品的详情图列表
 * @param productId
 * @return
 */	
List<ProductImg> queryProductImgList(long productId);

/**
 * 批量添加商品图片
 * @param productImgList
 * @return
 */
int batchInsertProductImg(List<ProductImg> productImgList);
/**
 * 删除图片
 * @param productId
 * @return
 */
int deleteProductImgByProductId(long productId);
}
