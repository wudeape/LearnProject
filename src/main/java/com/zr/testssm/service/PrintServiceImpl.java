package com.zr.testssm.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wudeyuan
 * @date 2020/10/19 14:12
 * @description
 */

@Service
public class PrintServiceImpl implements PrintService {

    @Override
    public String getPrintContent() {
        // 1 读取对应 html 文件  2 进行文字的内容填充
        Map<String, String> resmap = new HashMap<>();
        // 获取打印内容
        String str = "";
        try {
            String tempStr = "";
            String path = "/DiaRecordBillWDRMYY.html";
            // 获取当前路径
            InputStream is = this.getClass().getResourceAsStream(path);// 读取模块文件
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            while ((tempStr = br.readLine()) != null) {
                // 当内容包含para 则为参数 替换为map里对应的值
                if (tempStr.contains("para")) {
                    tempStr = resmap.get(tempStr.trim().replaceAll("\t", ""));
                }
                str = str + tempStr;
            }
            is.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
