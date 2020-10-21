package com.zr.testssm.controller;

import com.zr.testssm.bean.Items;
import com.zr.testssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName : ItemsController  //类名
 * @Description :   //描述
 * @Author : Program_Dog  //作者
 * @Date: 2020-10-14 00:18  //时间
 */
@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/qureyAll")
    public ModelAndView  qureyAll(){
        List<Items> itemsList = itemsService.qureyAll();
        ModelAndView mView = new ModelAndView();
        mView.addObject("itemList",itemsList);
        mView.setViewName("index.jsp");
        System.out.println("================商品集合================");
        System.out.println(itemsList);
        return mView;
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public List<Items> test(){
        System.out.println("这是一个测试用例!!!!");
//        System.out.println(itemsService.qureyAll());
//        return "redirect:/index.jsp";
        return itemsService.qureyAll();
    }
}
