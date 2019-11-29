package com.l.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l.o2o.dao.ProductCategoryDao;
import com.l.o2o.dao.ProductDao;
import com.l.o2o.dto.ProductCategoryExecution;
import com.l.o2o.entity.ProductCategory;
import com.l.o2o.enums.ProductCategoryStateEnum;
import com.l.o2o.exceptions.ProductCategoryOperationException;
import com.l.o2o.service.ProductCategoryService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.recompile;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductCategory> getProductCategoryList(long shopId) {
		return productCategoryDao.queryProductCategoryList(shopId);
	}

	@Override
	@Transactional
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		if (productCategoryList != null && productCategoryList.size() > 0) {
			try {
				int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
				if (effectedNum <= 0) {
					throw new ProductCategoryOperationException("店铺类别创建失败");

				} else {
					return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);

				}
			} catch (Exception e) {
				throw new ProductCategoryOperationException("batchAddProductCategory error" + e.getMessage());
			}
		} else {
			return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
		}
	}

	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException {
		//解除tb_product里的商品类别的关系
		try {
			int effectedNum=productDao.updateProductCategoryToNull(productCategoryId);
			if (effectedNum<0) {
				throw new ProductCategoryOperationException("商品类别更新失败");
				
			}
		} catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error:"+e.getMessage());
		}
		
		//删除该productcategory的商品类别
		try {
			int effectedNum=productCategoryDao.deleteProductCategory(productCategoryId, shopId);
		
			if (effectedNum<=0) {
				throw new ProductCategoryOperationException("商品类别删除失败");
				
			}else {
				return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
				
			}
		} catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory 商品失败"+e.getMessage());
		}
		
	}
}
