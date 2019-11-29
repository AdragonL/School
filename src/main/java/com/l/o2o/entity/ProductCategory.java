package com.l.o2o.entity;

import java.util.Date;

public class ProductCategory {
	private Long ProductCategoryId;
	private Long shopId;
	private String ProductCategoryName;
	private Integer priority;//权重
	private Date createTime;
	
	
	
	public Long getProductCategoryId() {
		return ProductCategoryId;
	}
	public void setProductCategoryId(Long productCategoryId) {
		ProductCategoryId = productCategoryId;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public String getProductCategoryName() {
		return ProductCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		ProductCategoryName = productCategoryName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
