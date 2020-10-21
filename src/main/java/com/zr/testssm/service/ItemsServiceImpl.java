package com.zr.testssm.service;

import com.zr.testssm.bean.Items;
import com.zr.testssm.dao.ItemsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : ItemsServiceImpl  //类名
 * @Description :   //描述
 * @Author : Program_Dog  //作者
 * @Date: 2020-10-14 00:17  //时间
 */
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;

    @Override
    public List<Items> qureyAll() {
        return itemsDao.qureyAll();
    }
}
