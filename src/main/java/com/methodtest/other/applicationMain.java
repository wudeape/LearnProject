package com.methodtest.other;

import cn.hutool.cron.CronUtil;

/**
 * @author wudeyuan
 * @date 2020/10/21 17:04
 * @description 入口测试
 */
public class applicationMain {
    public static void main(String[] args){
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }

    // 动态创建任务
    private static void dynamicGenerate(){

    }
}
