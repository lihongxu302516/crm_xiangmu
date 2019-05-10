package com.crm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
@Component
public class ClassShuXing {
	public List<Map<String,Object>> huoqushuxing(Object o) {
		Field[] fields = o.getClass().getDeclaredFields(); 
		//String[] fieldNames=new String[fields.length];  
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();  
        Map<String,Object> infoMap=null;  
        for(int i=0;i<fields.length;i++){
        	infoMap = new HashMap<String,Object>();
        	infoMap.put("type", fields[i].getType().toString());
        	infoMap.put("name", fields[i].getName());
        	//infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
        	list.add(infoMap);
        }
		return list;
	}
}
