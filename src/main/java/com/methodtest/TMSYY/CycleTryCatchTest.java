package com.methodtest.TMSYY;

/**
 * @author wudeyuan
 * @date 2020/8/14 10:00
 * @description
 */
public class CycleTryCatchTest {
    public static void main(String[] args){
        int[] tempArray = new int[]{2,1,0,5};
        for (int i=0;i<tempArray.length;i++){
            try{
                int temp = 2 / tempArray[i];
                System.out.println(i+"~~~~"+temp);
            }catch (Exception e){
                System.out.println(e.getCause()+"-----"+e.getMessage());
            }
        }

    }
}
