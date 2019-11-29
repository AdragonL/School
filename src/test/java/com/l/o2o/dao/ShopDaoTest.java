package com.l.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.l.o2o.BaseTest;
import com.l.o2o.dto.ImageHolder;
import com.l.o2o.dto.ShopExecution;
import com.l.o2o.entity.Area;
import com.l.o2o.entity.PersonInfo;
import com.l.o2o.entity.Shop;
import com.l.o2o.entity.ShopCategory;
import com.l.o2o.exceptions.ShopOperationException;
import com.l.o2o.service.ShopService;

public class ShopDaoTest extends BaseTest{
@Autowired
private ShopService shopService;	
@Autowired
private ShopDao shopDao;




@Test
@Ignore
public void  testQueryListAndCount() {
	Shop shopCondition =new Shop();
	PersonInfo owner =new PersonInfo();
	owner.setUserId(1L);
	shopCondition.setOwner(owner);
	List<Shop> shopList=shopDao.queryShopList(shopCondition, 0, 5);
	int count =shopDao.queryShopCount(shopCondition);
	System.out.println("店铺列表"+shopList.size());
	System.out.println("店铺列表"+count);
	
}


@Test
@Ignore
public void testModifyShop() throws ShopOperationException,FileNotFoundException{
	Shop shop=new Shop();
	shop.setShopId(1L);
	shop.setShopName("修改鋪名稱");
	File shopImg=new File("C:/Users/86505/Desktop/Study/image/1.jpg");
	InputStream is=new FileInputStream(shopImg);
	ImageHolder imageHolder=new ImageHolder("1.jpg",is);
	ShopExecution shopExecution =shopService.modifyShop(shop, imageHolder);
	System.out.println("ddd"+shopExecution.getShop().getShopImg());
}
@Test
@Ignore
public void testInsertShop() {
	Shop shop =new Shop();
	PersonInfo owner=new PersonInfo();
	Area area=new Area();
	ShopCategory shopCategory=new ShopCategory();
	owner.setUserId(1L);
	area.setAreaId(2);
	shopCategory.setShopCategoryId(1L);
	shop.setOwner(owner);
	shop.setArea(area);
	shop.setShopCategory(shopCategory);
	shop.setShopName("test");
	shop.setShopDesc("test");
	shop.setShopAddr("test");
	shop.setPhone("test");
	shop.setShopImg("test");
	shop.setCreateTime(new Date());
	shop.setEnableStatus(1);
	shop.setAdvice("审核中");
	int effectedNum =shopDao.insertShop(shop);
	assertEquals(1,effectedNum);
	
}
@Test
@Ignore
public void testQueryByShopId() {
	long shopId=1;
	Shop shop=shopDao.queryByShopId(shopId);
	System.out.println("areaId"+shop.getArea().getAreaId());
	System.out.println("areaName"+shop.getArea().getAreaName());
}

@Test
@Ignore
public void testUpdateShop() {
	Shop shop =new Shop();
	shop.setShopId(1L);
	shop.setShopAddr("test234");
	shop.setShopDesc("testwew");
	shop.setLastEditTime(new Date());
	int effectedNum =shopDao.updateShop(shop);
	assertEquals(1,effectedNum);
	
}


}
