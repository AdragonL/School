package com.l.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.l.o2o.BaseTest;
import com.l.o2o.dao.ShopDao;
import com.l.o2o.dto.ImageHolder;
import com.l.o2o.dto.ShopExecution;
import com.l.o2o.entity.Area;
import com.l.o2o.entity.PersonInfo;
import com.l.o2o.entity.Shop;
import com.l.o2o.entity.ShopCategory;
import com.l.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{
@Autowired
private ShopService shopService;

@Test
public void testGetShoplist() {
	Shop shopConditionShop=new Shop();
	ShopCategory sc=new ShopCategory();
	sc.setShopCategoryId(3L);
	shopConditionShop.setShopCategory(sc);
	ShopExecution se=shopService.getShopList(shopConditionShop,1,2);
	System.out.println(se.getShopList().size());
}



@Test
@Ignore
public void testAddShop() throws FileNotFoundException {
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
	shop.setShopName("te顶阿浦v33");
	shop.setShopDesc("test1");
	shop.setShopAddr("test1");
	shop.setPhone("test1");
	shop.setCreateTime(new Date());
	shop.setEnableStatus(ShopStateEnum.CHECK.getState());
	shop.setAdvice("审核中");
	File shopImg=new File("C:/Users/86505/Desktop/Study/image/0.jpg");
	InputStream is=new FileInputStream(shopImg);
	ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
	ShopExecution se=shopService.addShop(shop,imageHolder);
	assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
}
}
