package com.methodtest.entity;

import java.math.BigDecimal;

/**
 * @author wudeyuan
 * @date 2020/10/31 9:26
 * @description
 */
public class WaterMaintenanceRecordResultForm {
    private static final long serialVersionUID = 1L;

    //id
    private String id;
    //日期
    private String inspectdate;
    //类型
    private String type;
    //精密过滤器进水压
    private BigDecimal precisioninletpressur;
    //精密过滤器出水压
    private BigDecimal precisionoutletpressure;
    //精密过滤器冲洗
    private String precisionwash;
    //砂滤进水压
    private BigDecimal sandleachinletpressur;
    //砂滤反冲
    private String sandleachrecoil;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInspectdate() {
        return inspectdate;
    }

    public void setInspectdate(String inspectdate) {
        this.inspectdate = inspectdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public BigDecimal getBackwatervolume() {
        return backwatervolume;
    }

    public void setBackwatervolume(BigDecimal backwatervolume) {
        this.backwatervolume = backwatervolume;
    }

    public BigDecimal getConductivity() {
        return conductivity;
    }

    public void setConductivity(BigDecimal conductivity) {
        this.conductivity = conductivity;
    }

    public BigDecimal getGradetwoconductivity() {
        return gradetwoconductivity;
    }

    public void setGradetwoconductivity(BigDecimal gradetwoconductivity) {
        this.gradetwoconductivity = gradetwoconductivity;
    }

    public String getMaintenancerecord() {
        return maintenancerecord;
    }

    public void setMaintenancerecord(String maintenancerecord) {
        this.maintenancerecord = maintenancerecord;
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
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

    public BigDecimal getWaterproductionamount() {
        return waterproductionamount;
    }

    public void setWaterproductionamount(BigDecimal waterproductionamount) {
        this.waterproductionamount = waterproductionamount;
    }

    public BigDecimal getWastewateramount() {
        return wastewateramount;
    }

    public void setWastewateramount(BigDecimal wastewateramount) {
        this.wastewateramount = wastewateramount;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getPremembranepressure2() {
        return premembranepressure2;
    }

    public void setPremembranepressure2(BigDecimal premembranepressure2) {
        this.premembranepressure2 = premembranepressure2;
    }

    public BigDecimal getPostmembranepressure2() {
        return postmembranepressure2;
    }

    public void setPostmembranepressure2(BigDecimal postmembranepressure2) {
        this.postmembranepressure2 = postmembranepressure2;
    }

    public BigDecimal getWatersupplypressure2() {
        return watersupplypressure2;
    }

    public void setWatersupplypressure2(BigDecimal watersupplypressure2) {
        this.watersupplypressure2 = watersupplypressure2;
    }

    //碳滤余氯
    private BigDecimal carbonfiltrationchlorine;
    //碳滤反冲
    private String carbonfiltrationrecoil;
    //软水再生
    private String softwaterreproduce;
    //软水硬度
    private BigDecimal softwaterhardness;
    //软水加盐
    private String softwatersalting;
    //单级膜前压/一级浓水压力
    private BigDecimal premembranepressure;
    //单级膜后压/一级产水压力
    private BigDecimal postmembranepressure;
    //单级供水压/二级浓水压力
    private BigDecimal watersupplypressure;
    //单级回水压/二级产水压力
    private BigDecimal backwaterpressure;
    //单级产水量/纯水流量
    private BigDecimal waterproduction;
    //单级回水量/浓水排量
    private BigDecimal backwatervolume;
    //单级电导度/一级产水电导
    private BigDecimal conductivity;
    //双级反渗机二级产水电导
    private BigDecimal gradetwoconductivity;
    //维护记录
    private String maintenancerecord;
    //工程师
    private String engineer;
    //修改时间
    private String modifydate;
    private String filter;
    private String amount;

    // 控制器状态
    private String controllerstate;
    // 残余氯
    private BigDecimal remnantcl;
    // 硬度
    private BigDecimal hardness;
    // 产水量
    private BigDecimal waterproductionamount;
    // 废水量
    private BigDecimal wastewateramount;
    // 水温
    private BigDecimal temperature;

    private BigDecimal premembranepressure2;
    private BigDecimal postmembranepressure2;
    private BigDecimal watersupplypressure2;
}
