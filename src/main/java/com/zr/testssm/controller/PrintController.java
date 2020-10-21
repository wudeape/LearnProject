package com.zr.testssm.controller;

import com.zr.testssm.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wudeyuan
 * @date 2020/10/19 14:12
 * @description
 */
@Controller
public class PrintController {

    @Autowired
    PrintService printService;

    @RequestMapping("/printTest")
    public String getPrintContent(){
        // 获取打印的内容
      return   printService.getPrintContent();
    }


}
