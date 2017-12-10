package com.week7i.share.service;

import com.week7i.share.dao.CommonDao;
import com.week7i.share.util.JedisUtils;
import com.week7i.share.util.SpringContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CommonService {
    private CommonDao commonDao = SpringContextHolder.getBean(CommonDao.class);

    public Set zeroRowTables(){
        Set rs=new HashSet();
        HashMap param=new HashMap();
        List<HashMap> zeroRowTables=commonDao.queryZeroRowTable();
        for(int i=0;i<zeroRowTables.size();i++){
            HashMap map=zeroRowTables.get(i);
            String tableName= (String) map.get("table_name");
            rs.add(tableName);
        }
        return rs;
    }


    public List<HashMap> queryAll(String tableName){
        HashMap map=new HashMap();
        map.put("tableName",tableName);
        List<HashMap> rs=commonDao.queryAll(tableName);
        return rs;

    }
}
