package com.methodTest.JiuerSi;

import com.entity.DialysisOrderResultForm;
import com.tools.Tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class combineMedicine {

    public void testHome(List<DialysisOrderResultForm> dialysisOrderResultForms){
        Collections.sort(dialysisOrderResultForms, new Comparator<DialysisOrderResultForm>() {
            @Override
            public int compare(DialysisOrderResultForm o1, DialysisOrderResultForm o2) {

                int i = o1.getGroupcode().compareTo(o2.getGroupcode());
                if(i==0){
                    return o2.getMainFlag().compareTo(o1.getMainFlag());
                }
                return 0;
            }
        });

        List<String> twoViewList = new ArrayList<>();
        List<String> moreViewList = new ArrayList<>();
        twoViewList.add("1");
        twoViewList.add("2");

        moreViewList.add("a");
        moreViewList.add("b");

        // 处理两个一组的组合用药
        if(!Tools.listisblank(twoViewList)){
            for(String tempString:twoViewList){
                Integer addCount = 0;
                for(DialysisOrderResultForm dialysisOrderResultForm:dialysisOrderResultForms){
                    if(Tools.equals(tempString,dialysisOrderResultForm.getGroupcode())){
                        if(addCount<1){
                            dialysisOrderResultForm.setMedicinename("{start"+" "+dialysisOrderResultForm.getMedicinename());
                            addCount++;
                        }else{
                            dialysisOrderResultForm.setMedicinename("{end"+" "+dialysisOrderResultForm.getMedicinename());
                            break;
                        }
                    }
                }
            }
        }
        // 处理多个一组的组合用药
        if (!Tools.listisblank(moreViewList)){
            for(String tempString:moreViewList){
                // 获取当前分组下成员的长度
                List<DialysisOrderResultForm> currentCombineList= new ArrayList<>();
                for (DialysisOrderResultForm dialysisOrderResultForm:dialysisOrderResultForms){
                    if (Tools.equals(tempString,dialysisOrderResultForm.getGroupcode())){
                        // 为该条数据添加一个标识符，方便在修改药品名称时找到该条记录
                        dialysisOrderResultForm.setMarkUUID(Tools.getUUID());
                        currentCombineList.add(dialysisOrderResultForm);
                    }
                }
                // 对组合用药进行标识绘制
                for(int i=0;i<currentCombineList.size();i++){
                    if (i==0){
                        for(DialysisOrderResultForm dialysisOrderResultForm:dialysisOrderResultForms){
                            if (Tools.equals(currentCombineList.get(i).getMarkUUID(),dialysisOrderResultForm.getMarkUUID())){
                                dialysisOrderResultForm.setMedicinename("{start"+" "+dialysisOrderResultForm.getMedicinename());
                            }
                        }
                    }
                    else if(i== currentCombineList.size()-1){
                        for(DialysisOrderResultForm dialysisOrderResultForm:dialysisOrderResultForms){
                            if (Tools.equals(currentCombineList.get(i).getMarkUUID(),dialysisOrderResultForm.getMarkUUID())){
                                dialysisOrderResultForm.setMedicinename("{end"+" "+dialysisOrderResultForm.getMedicinename());
                            }
                        }
                    }else{
                        for(DialysisOrderResultForm dialysisOrderResultForm:dialysisOrderResultForms){
                            if (Tools.equals(currentCombineList.get(i).getMarkUUID(),dialysisOrderResultForm.getMarkUUID())){
                                dialysisOrderResultForm.setMedicinename("{mid"+" "+dialysisOrderResultForm.getMedicinename());
                            }
                        }
                    }
                }
            }
        }







    }
}
