package com.week7i.share.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/23.
 */
public interface CommonDao {
    List<HashMap> queryZeroRowTable();
    List<HashMap> queryAll(HashMap map);
    List<HashMap> wangzhao(HashMap map);
    List<HashMap> etf(HashMap map);
    List<HashMap> csi(HashMap map);
}