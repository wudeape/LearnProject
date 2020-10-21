package com.zr.testssm.dao;

import com.zr.testssm.bean.Items;

import java.util.List;

/**
 * @ClassName : ItemsDao  //类名
 * @Description :   //描述
 * @Author : Program_Dog  //作者
 * @Date: 2020-10-14 00:09  //时间
 */

public interface ItemsDao {

//    查询所有商品
    public List<Items> qureyAll();
}
