package com.methodtest.entity;

import java.math.BigDecimal;

/**
 * @author wudeyuan
 * @date 2020/10/31 9:19
 * @description
 */
public class WaterMaintenanceRecordCondForm {

    private static final long serialVersionUID = 6584171455893238833L;

    //开始时间
    private String startDate;
    //结束时间
    private String endDate;
    //id
    private String id;
    //类型
    private String type;
    //日期
    private String inspectDate;
    //工程师
    private String engineer;
    //精密过滤器进水压
    private BigDecimal precisioninletpressur;
    //精密过滤器出水压
    private BigDecimal precisionoutletpressure;
    //精密过滤器冲洗
    private String precisionwash;
    //砂滤进水压 -->  砂滤罐压差
    private BigDecimal sandleachinletpressur;
    //砂滤反冲   -->  砂滤罐反冲
    private String sandleachrecoil;
    //碳滤余氯  -->  活性炭罐压差
    private BigDecimal carbonfiltrationchlorine;
    //碳滤反冲  -->  活性炭罐反冲
    private String carbonfiltrationrecoil;
    //软水再生  --> 树脂罐反冲
    private String softwaterreproduce;
    //软水硬度  -- > 树脂罐压差
    private BigDecimal softwaterhardness;
    //软水加盐
    private String softwatersalting;
    //膜前压
    private BigDecimal premembranepressure1;
    //膜后压
    private BigDecimal postmembranepressure1;
    //供水压
    private BigDecimal watersupplypressure1;
    //回水压
    private BigDecimal backwaterpressure1;
    //产水量
    private BigDecimal waterproduction1;
    //回水量
    private BigDecimal backwatervolume1;
    //电导度
    private BigDecimal conductivity1;
    //一级浓水压力
    private BigDecimal premembranepressure2;
    private BigDecimal premembranepressure22;
    //一级产水压力    --> 2级膜进水压力
    private BigDecimal postmembranepressure2;
    private BigDecimal postmembranepressure12;
    //二级浓水压力   --> 2级膜排水压力
    private BigDecimal watersupplypressure2;
    private BigDecimal watersupplypressure12;
    //二级产水压力   --> 2级膜产水压力
    private BigDecimal backwaterpressure2;
    private BigDecimal backwaterpressure12;
    //纯水流量
    private BigDecimal waterproduction2;
    //浓水排量
    private BigDecimal backwatervolume2;
    //一级产水电导
    private BigDecimal conductivity2;
    //二级产水电导  --> 产水电导率
    private BigDecimal gradetwoconductivity;
    private BigDecimal gradetwoconductivity1;
    private BigDecimal gradetwoconductivity2;
    //维护记录
    private String maintenancerecord;
    //编辑标识
    private String editflag;
    //导出选择标识
    private String typechoose;
    //修改时间
    private String modifydate;
    private String filter;
    private String amount;
    private String originalamount;

    // 控制器状态
    private String controllerstate;
    // 残余氯
    private BigDecimal remnantcl;
    // 硬度
    private BigDecimal hardness;
    // 水机进水压力
    private BigDecimal premembranepressure;
    // 反渗膜进水压力
    private BigDecimal postmembranepressure;
    // 反渗膜排水压力
    private BigDecimal watersupplypressure;
    // 反渗膜产水压力
    private BigDecimal backwaterpressure;
    // 纯水回水压力
    private BigDecimal waterproduction;
    // 进水电导率
    private BigDecimal conductivity;
    // 产水量
    private BigDecimal waterproductionamount;
    private BigDecimal waterproductionamount1;
    private BigDecimal waterproductionamount2;
    // 回水量
    private BigDecimal backwatervolume;
    // 废水量
    private BigDecimal wastewateramount;
    private BigDecimal wastewateramount1;
    private BigDecimal wastewateramount2;
    // 水温
    private BigDecimal temperature;
    private BigDecimal temperature1;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(String inspectDate) {
        this.inspectDate = inspectDate;
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public BigDecimal getPrecisioninletpressur() {
        return precisioninletpressur;
    }

    public void setPrecisioninletpressur(BigDecimal precisioninletpressur) {
        this.precisioninletpressur = precisioninletpressur;
    }

    public BigDecimal getPrecisionoutletpressure() {
        return precisionoutletpressure;
    }

    public void setPrecisionoutletpressure(BigDecimal precisionoutletpressure) {
        this.precisionoutletpressure = precisionoutletpressure;
    }

    public String getPrecisionwash() {
        return precisionwash;
    }

    public void setPrecisionwash(String precisionwash) {
        this.precisionwash = precisionwash;
    }

    public BigDecimal getSandleachinletpressur() {
        return sandleachinletpressur;
    }

    public void setSandleachinletpressur(BigDecimal sandleachinletpressur) {
        this.sandleachinletpressur = sandleachinletpressur;
    }

    public String getSandleachrecoil() {
        return sandleachrecoil;
    }

    public void setSandleachrecoil(String sandleachrecoil) {
        this.sandleachrecoil = sandleachrecoil;
    }

    public BigDecimal getCarbonfiltrationchlorine() {
        return carbonfiltrationchlorine;
    }

    public void setCarbonfiltrationchlorine(BigDecimal carbonfiltrationchlorine) {
        this.carbonfiltrationchlorine = carbonfiltrationchlorine;
    }

    public String getCarbonfiltrationrecoil() {
        return carbonfiltrationrecoil;
    }

    public void setCarbonfiltrationrecoil(String carbonfiltrationrecoil) {
        this.carbonfiltrationrecoil = carbonfiltrationrecoil;
    }

    public String getSoftwaterreproduce() {
        return softwaterreproduce;
    }

    public void setSoftwaterreproduce(String softwaterreproduce) {
        this.softwaterreproduce = softwaterreproduce;
    }

    public BigDecimal getSoftwaterhardness() {
        return softwaterhardness;
    }

    public void setSoftwaterhardness(BigDecimal softwaterhardness) {
        this.softwaterhardness = softwaterhardness;
    }

    public String getSoftwatersalting() {
        return softwatersalting;
    }

    public void setSoftwatersalting(String softwatersalting) {
        this.softwatersalting = softwatersalting;
    }

    public BigDecimal getPremembranepressure1() {
        return premembranepressure1;
    }

    public void setPremembranepressure1(BigDecimal premembranepressure1) {
        this.premembranepressure1 = premembranepressure1;
    }

    public BigDecimal getPostmembranepressure1() {
        return postmembranepressure1;
    }

    public void setPostmembranepressure1(BigDecimal postmembranepressure1) {
        this.postmembranepressure1 = postmembranepressure1;
    }

    public BigDecimal getWatersupplypressure1() {
        return watersupplypressure1;
    }

    public void setWatersupplypressure1(BigDecimal watersupplypressure1) {
        this.watersupplypressure1 = watersupplypressure1;
    }

    public BigDecimal getBackwaterpressure1() {
        return backwaterpressure1;
    }

    public void setBackwaterpressure1(BigDecimal backwaterpressure1) {
        this.backwaterpressure1 = backwaterpressure1;
    }

    public BigDecimal getWaterproduction1() {
        return waterproduction1;
    }

    public void setWaterproduction1(BigDecimal waterproduction1) {
        this.waterproduction1 = waterproduction1;
    }

    public BigDecimal getBackwatervolume1() {
        return backwatervolume1;
    }

    public void setBackwatervolume1(BigDecimal backwatervolume1) {
        this.backwatervolume1 = backwatervolume1;
    }

    public BigDecimal getConductivity1() {
        return conductivity1;
    }

    public void setConductivity1(BigDecimal conductivity1) {
        this.conductivity1 = conductivity1;
    }

    public BigDecimal getPremembranepressure2() {
        return premembranepressure2;
    }

    public void setPremembranepressure2(BigDecimal premembranepressure2) {
        this.premembranepressure2 = premembranepressure2;
    }

    public BigDecimal getPremembranepressure22() {
        return premembranepressure22;
    }

    public void setPremembranepressure22(BigDecimal premembranepressure22) {
        this.premembranepressure22 = premembranepressure22;
    }

    public BigDecimal getPostmembranepressure2() {
        return postmembranepressure2;
    }

    public void setPostmembranepressure2(BigDecimal postmembranepressure2) {
        this.postmembranepressure2 = postmembranepressure2;
    }

    public BigDecimal getPostmembranepressure12() {
        return postmembranepressure12;
    }

    public void setPostmembranepressure12(BigDecimal postmembranepressure12) {
        this.postmembranepressure12 = postmembranepressure12;
    }

    public BigDecimal getWatersupplypressure2() {
        return watersupplypressure2;
    }

    public void setWatersupplypressure2(BigDecimal watersupplypressure2) {
        this.watersupplypressure2 = watersupplypressure2;
    }

    public BigDecimal getWatersupplypressure12() {
        return watersupplypressure12;
    }

    public void setWatersupplypressure12(BigDecimal watersupplypressure12) {
        this.watersupplypressure12 = watersupplypressure12;
    }

    public BigDecimal getBackwaterpressure2() {
        return backwaterpressure2;
    }

    public void setBackwaterpressure2(BigDecimal backwaterpressure2) {
        this.backwaterpressure2 = backwaterpressure2;
    }

    public BigDecimal getBackwaterpressure12() {
        return backwaterpressure12;
    }

    public void setBackwaterpressure12(BigDecimal backwaterpressure12) {
        this.backwaterpressure12 = backwaterpressure12;
    }

    public BigDecimal getWaterproduction2() {
        return waterproduction2;
    }

    public void setWaterproduction2(BigDecimal waterproduction2) {
        this.waterproduction2 = waterproduction2;
    }

    public BigDecimal getBackwatervolume2() {
        return backwatervolume2;
    }

    public void setBackwatervolume2(BigDecimal backwatervolume2) {
        this.backwatervolume2 = backwatervolume2;
    }

    public BigDecimal getConductivity2() {
        return conductivity2;
    }

    public void setConductivity2(BigDecimal conductivity2) {
        this.conductivity2 = conductivity2;
    }

    public BigDecimal getGradetwoconductivity() {
        return gradetwoconductivity;
    }

    public void setGradetwoconductivity(BigDecimal gradetwoconductivity) {
        this.gradetwoconductivity = gradetwoconductivity;
    }

    public BigDecimal getGradetwoconductivity1() {
        return gradetwoconductivity1;
    }

    public void setGradetwoconductivity1(BigDecimal gradetwoconductivity1) {
        this.gradetwoconductivity1 = gradetwoconductivity1;
    }

    public BigDecimal getGradetwoconductivity2() {
        return gradetwoconductivity2;
    }

    public void setGradetwoconductivity2(BigDecimal gradetwoconductivity2) {
        this.gradetwoconductivity2 = gradetwoconductivity2;
    }

    public String getMaintenancerecord() {
        return maintenancerecord;
    }

    public void setMaintenancerecord(String maintenancerecord) {
        this.maintenancerecord = maintenancerecord;
    }

    public String getEditflag() {
        return editflag;
    }

    public void setEditflag(String editflag) {
        this.editflag = editflag;
    }

    public String getTypechoose() {
        return typechoose;
    }

    public void setTypechoose(String typechoose) {
        this.typechoose = typechoose;
    }

    public String getModifydate() {
        return modifydate;
    }

    public void setModifydate(String modifydate) {
        this.modifydate = modifydate;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOriginalamount() {
        return originalamount;
    }

    public void setOriginalamount(String originalamount) {
        this.originalamount = originalamount;
    }

    public String getControllerstate() {
        return controllerstate;
    }

    public void setControllerstate(String controllerstate) {
        this.controllerstate = controllerstate;
    }

    public BigDecimal getRemnantcl() {
        return remnantcl;
    }

    public void setRemnantcl(BigDecimal remnantcl) {
        this.remnantcl = remnantcl;
    }

    public BigDecimal getHardness() {
        return hardness;
    }

    public void setHardness(BigDecimal hardness) {
        this.hardness = hardness;
    }

    public BigDecimal getPremembranepressure() {
        return premembranepressure;
    }

    public void setPremembranepressure(BigDecimal premembranepressure) {
        this.premembranepressure = premembranepressure;
    }

    public BigDecimal getPostmembranepressure() {
        return postmembranepressure;
    }

    public void setPostmembranepressure(BigDecimal postmembranepressure) {
        this.postmembranepressure = postmembranepressure;
    }

    public BigDecimal getWatersupplypressure() {
        return watersupplypressure;
    }

    public void setWatersupplypressure(BigDecimal watersupplypressure) {
        this.watersupplypressure = watersupplypressure;
    }

    public BigDecimal getBackwaterpressure() {
        return backwaterpressure;
    }

    public void setBackwaterpressure(BigDecimal backwaterpressure) {
        this.backwaterpressure = backwaterpressure;
    }

    public BigDecimal getWaterproduction() {
        return waterproduction;
    }

    public void setWaterproduction(BigDecimal waterproduction) {
        this.waterproduction = waterproduction;
    }

    public BigDecimal getConductivity() {
        return conductivity;
    }

    public void setConductivity(BigDecimal conductivity) {
        this.conductivity = conductivity;
    }

    public BigDecimal getWaterproductionamount() {
        return waterproductionamount;
    }

    public void setWaterproductionamount(BigDecimal waterproductionamount) {
        this.waterproductionamount = waterproductionamount;
    }

    public BigDecimal getWaterproductionamount1() {
        return waterproductionamount1;
    }

    public void setWaterproductionamount1(BigDecimal waterproductionamount1) {
        this.waterproductionamount1 = waterproductionamount1;
    }

    public BigDecimal getWaterproductionamount2() {
        return waterproductionamount2;
    }

    public void setWaterproductionamount2(BigDecimal waterproductionamount2) {
        this.waterproductionamount2 = waterproductionamount2;
    }

    public BigDecimal getBackwatervolume() {
        return backwatervolume;
    }

    public void setBackwatervolume(BigDecimal backwatervolume) {
        this.backwatervolume = backwatervolume;
    }

    public BigDecimal getWastewateramount() {
        return wastewateramount;
    }

    public void setWastewateramount(BigDecimal wastewateramount) {
        this.wastewateramount = wastewateramount;
    }

    public BigDecimal getWastewateramount1() {
        return wastewateramount1;
    }

    public void setWastewateramount1(BigDecimal wastewateramount1) {
        this.wastewateramount1 = wastewateramount1;
    }

    public BigDecimal getWastewateramount2() {
        return wastewateramount2;
    }

    public void setWastewateramount2(BigDecimal wastewateramount2) {
        this.wastewateramount2 = wastewateramount2;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getTemperature1() {
        return temperature1;
    }

    public void setTemperature1(BigDecimal temperature1) {
        this.temperature1 = temperature1;
    }
}
