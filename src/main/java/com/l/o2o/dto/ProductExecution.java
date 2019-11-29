package com.l.o2o.dto;

import java.util.List;

import com.l.o2o.entity.Product;
import com.l.o2o.enums.ProductStateEnum;

public class ProductExecution {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	// 商品数量
	private int count;

	// 操作的product（增删改商品的时候用）
	private Product product;

	// product列表（查询商品列表的时候用）
	private List<Product> productList;

	public ProductExecution() {

	}

	//失败构造器
	public ProductExecution(ProductStateEnum stateEnum) {
		this.state=state;
		this.stateInfo=stateInfo;
	}

	
	//成功的构造器
	public ProductExecution(ProductStateEnum stateEnum,Product product) {
		this.state=state;
		this.stateInfo=stateInfo;
		this.product=product;
		
	}
	//成功的构造器
	public ProductExecution(ProductStateEnum stateEnum,List<Product> productList) {
		this.state=state;
		this.stateInfo=stateInfo;
		this.productList=productList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
	
	
}
