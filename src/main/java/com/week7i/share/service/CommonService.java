package com.week7i.share.service;

import com.week7i.share.dao.CommonDao;
import com.week7i.share.util.JedisUtils;
import com.week7i.share.util.SpringContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CommonService {
    private CommonDao commonDao = SpringContextHolder.getBean(CommonDao.class);

    public String common(){
        List<HashMap> rs=commonDao.queryTbName(null);
        return "1";
    }

}
