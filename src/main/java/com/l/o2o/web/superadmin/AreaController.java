package com.l.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.l.o2o.entity.Area;
import com.l.o2o.service.AreaService;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
	Logger logger=LoggerFactory.getLogger(AreaController.class);
	@Autowired
	private AreaService areaService;
	
	
	//提示是在主目录superadmin下的哪一个方法 有一个约定有关前端的方法就要全部小写
	@RequestMapping(value="/listarea",method=RequestMethod.GET)
	@ResponseBody //提示将ModelMap自动转换成json返回给前端
	private Map<String,Object>listArea(){
		logger.info("===start===");
		long startTime=System.currentTimeMillis();
		Map<String,Object> modelMap=new HashMap<String,Object>();
		List<Area> list=new ArrayList<Area>();
		try {
			list=areaService.getAreaList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		}
		catch(Exception e){
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg",e.toString());
					
		}
		logger.error("test error!");
		long endTime=System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",endTime-startTime);
		logger.info("===end===");
		return modelMap;
	}
}
