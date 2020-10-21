package com.methodTest.other;

import java.util.Arrays;

/**
 * @author wudeyuan
 * @date 2020/9/14 14:25
 * @description 编码规注意
 */
public class codeStandard {

    /*
     * 數組的拷貝
     */
    public static void copyArray(){
        int[] source = new int[] { 1, 2, 3, 4, 5 };
        int[] targets = new int[source.length];
        System.arraycopy(source, 0, targets, 0, targets.length);

        Arrays.copyOf(source, source.length);
    }
}
